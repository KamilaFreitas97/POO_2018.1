package Whats2;

import java.util.Scanner;

public class Controller {
	Scanner sca;
	Repositorio<Chat> grupos;
	Repositorio<User> usuarios;
	int msg_indice = 0;
	
	public Controller() {
		sca = new Scanner(System.in);
		grupos = new Repositorio<Chat>("grupos");
		usuarios = new Repositorio<User>("usuarios");
	}
	
	public String query(String line) {
		String[] ui = line.split(" ");
		
		if(ui[0].equals("help"))
			System.out.println("adduser _user, allusers\n"
					+ "newchat _user _idgrupo, showchats\n"
					+ "invite _iduser _idgrupo _convidado\n"
					+ "leave _iduser _idgrupo\n"
					+ "zap _idgrupo _idusuario _ msg\n"
					+ "chats _iduser, users _idgrupo\n"
					+ "msgchat _idgrupo, notify _iduser\n"
					+ "ler _iduser _idgrupo");
		//Adiciona um novo usuario
		else if(ui[0].equals("adduser"))
			usuarios.add(ui[1], new User(ui[1]));
		
		//Mostra todos os usuarios
		else if(ui[0].equals("allusers")) {
			String saida = "[ ";
			for(User u : usuarios.getAll())
				saida += u.toString() + " ";
			return saida + "]";
		}
		
		
		
		//Criar um novo chat(grupo) parar mandar mensagens
		else if(ui[0].equals("newchat")) {
			usuarios.get(ui[1]).getGrupos().add(ui[2], new Chat(ui[2]));
			grupos.add(ui[2], new Chat(ui[2]));
			grupos.get(ui[2]).userchats.add(ui[1], usuarios.get(ui[1]));
		}
		
		
		//Mostrar todos os grupos
				else if(ui[0].equals("showchats")) {
					String show = "";
					for(Chat c : grupos.getAll())
						show += c.toString();
					return show;
				}
		
		//convidar uma pessoa ao grupo
		else if(ui[0].equals("invite")) {
			usuarios.get(ui[1]).getGrupos().get(ui[2]).adicionarAOgrupo(usuarios.get(ui[3]));
			grupos.get(ui[2]).userchats.add(ui[3], usuarios.get(ui[3]));
		}
		
		//Sair do grupo
		else if(ui[0].equals("leave")) {
			usuarios.get(ui[1]).getGrupos().remove(grupos.get(ui[2]).getChat());
			grupos.get(ui[2]).getUserchats().remove(ui[1]);
			grupos.get(ui[2]).escrever(new Mensagem(""+msg_indice, usuarios.get(ui[1]).getIdUSer(), "saiu"));
		}
		
		//Envia uma nova mensagem para o grupo
		else if(ui[0].equals("zap")) {
			msg_indice++;
			String texto = "";
			for(int i = 3; i < ui.length; i++)
				texto += ui[i] + " ";
			grupos.get(ui[1]).escrever(new Mensagem(""+msg_indice, usuarios.get(ui[2]).getIdUSer(), texto));
		}
		
		//Meus chats
		else if(ui[0].equals("chats"))
			System.out.println(usuarios.get(ui[1]).mostrargrupos());
		
		//Mostra as mensagens que foram mandadas no grupo
		else if(ui[0].equals("msgchat")) {
			String msg = "";
			for(Mensagem m : grupos.get(ui[1]).msg.getAll()) {
				msg += m + "\n";
			}
			return msg;
		}
		
		//Mostrar os usuarios que estão no grupo
		else if(ui[0].equals("users"))
			System.out.println(grupos.get(ui[1]).mostrarusuarios());
		
		
		//Ler as mensagens  enviadas no grupo
		else if(ui[0].equals("ler")) {
			System.out.println(usuarios.get(ui[1]).getGrupos().get(ui[2]).mostrarmsg(usuarios.get(ui[1]).getIdUSer()));
		}
		
		
		//Mostrar a lista de notificações,
		//usuário vê ao lado de cada grupo se ele possui mensagens não lidas
		else if(ui[0].equals("notify")) {
			String saida = "";
			for(Chat c : usuarios.get(ui[1]).getGrupos().getAll()) {
				saida += "Chat: " + c.getChat() + "(" +usuarios.get(ui[1]).contarMensagens(c)+") ";
			}
			return saida;
		}
		else
			return " Comando invalido";
		return "done";
	}
	
	public void shell() {
		while (true) {
			String line = sca.nextLine();
			try {
				System.out.println(query(line));
			} catch (RuntimeException re) {
				System.out.println(re.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Digite um comando: ");
        Controller c = new Controller();
        c.shell();
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

