package Whats2;

import java.util.Scanner;

public class Controller {
	Scanner scan;
	Repositorio<Usuario> user;
	Repositorio<Chat> grupos;
	int idicemsg = 0;
	
	public Controller() {
		scan = new Scanner(System.in);
		user = new Repositorio<Usuario>("usuarios");
		grupos = new Repositorio<Chat>("grupos");
		
	}
	
	public String query(String line) {
		String [] ui = line.split(" ");
		
		//adiciona usuario pelo nome
		if(ui[0].equals("addusuario"))
			user.add(ui[1], new Usuario(ui[1]));
		//mostra usuarios que foram adicionado
		else if(ui[0].equals("mostrar")) {
			String mostrar = " [ ";
			for(Usuario us : user.getAll()) {
				mostrar += us.toString();
				
			}
			return mostrar + " ] ";
		}
		
		//cria grupo com o nome do usario e o nome do grupo
		else if(ui[0].equals("criargrupo")) {
			//criei uma variavel auxiliar pra pegar meu objeto e assim nao criar dois objetos apenas um
			Chat novoGrupo = new Chat(ui[2]);
			user.get(ui[1]).addChat(novoGrupo);
			
			grupos.add(ui[2], novoGrupo);
			novoGrupo.addusuarionogrupo(user.get(ui[1]));
			
		}
		
		//diz os grupos que o usuario tem pelo nome
		else if(ui[0].equals("meusgrupos")) {
			System.out.println(user.get(ui[1]).MostrarGrupos());
		}
		
		//envia mensagem pelo nome do grupo, nome do usuario e o texto
		else if(ui[0].equals("enviarmensagem")) {
			
			idicemsg ++;
			
			String texto = " ";
			for(int i = 3; i < ui.length; i++) {
				texto += ui[i] + " ";
			grupos.get(ui[1]).escreverMensagem(new Mensagem(""+idicemsg, user.get(ui[2]).getIdUsuario(), texto));
			idicemsg++;				
			}
			
		}
		//nome do usuario e grupo
		else if(ui[0].equals("lergrupo")) {
			System.out.println(user.get(ui[1]).getGrupos().get(ui[2]).MostrarMensagem(user.get(ui[1]).getIdUsuario()));
		}
		//adicona no grupo pelo no do usuario que criou o grupo, o nome do grupo e a pessoa que qur adicionar
		else if(ui[0].equals("addnoGrupo")) {
			user.get(ui[1]).getGrupos().get(ui[2]).addusuarionogrupo(user.get(ui[3]));
			
			user.get(ui[3]).addChat( grupos.get(ui[2]) );
		}
		//usuario saiu do grupo pelo nome e o grupo
		else if(ui[0].equals("sairdogrupo")) {
			Chat grupoProc = grupos.get(ui[2]);
			Usuario user_remover = user.get(ui[1]);
			
			user_remover.getGrupos().remove(grupoProc.toString()); //remove grupo da lista de grupos do usuario
			grupoProc.getUsers().remove(user_remover.getIdUsuario()); //vai remover o usuario da lista do usuario do grupo
			
			idicemsg++;
			grupoProc.escreverMensagem(new Mensagem(""+idicemsg, user_remover.getIdUsuario(), "saiu"));
			
		}
		
	
		//olha usuarios pelo nome do grupo
		else if(ui[0].equals("meususuarios")) {
			System.out.println(grupos.get(ui[1]).MostrarUsuarios());
			
		}
		//mostra grupos que tem
		else if(ui[0].equals("mostrargrupos")){
			String mostrar = " ";
			for(Chat ch : grupos.getAll()) {
				mostrar += ch.toString();
			}
			return mostrar;
		}
		//mostra mensagem enviada atraves do nome do grupo
		else if(ui[0].equals("mensagemdogrupo")) {
			String mensa = " ";
			for(Mensagem ch : grupos.get(ui[1]).getMensagens().getAll()) {
				mensa += ch.toString() + " ";				
			}
			
			return mensa;
		}	
		// mostra notificacao pelo nome do usuario
		else if(ui[0].equals("mostrarnotificacao")) {
			String mostrar = " ";
			for(Chat ch : user.get(ui[1]).getGrupos().getAll()) {
				mostrar += ch.getChat()+"[ " + user.get(ui[1]).contagem(ch)+" ]";
			}
			return mostrar;
		}
		
		
		
		else
			return "comando invalido";
		return "done";
		
	}
	
	public void shell() {
		while(true) {
			String line = scan.nextLine();
			try {
				System.out.println(query(line));
			}catch(RuntimeException re) {
				System.out.println(re.getMessage());
			}
		}

	}
	
	public static void main(String[] args) {
		System.out.println("Digite um dos comando: ");
		Controller cont = new Controller();
		cont.shell();
	}

}

/*
adduser goku
done
adduser sara
done
adduser tina
done
allusers
[ goku sara tina ]
newchat goku guerreiros
done
new chat goku homens
 Comando invalido
newchat goku homens
done
newchat sara familia
done
 * */

