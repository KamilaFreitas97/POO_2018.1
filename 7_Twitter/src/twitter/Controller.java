package twitter;

import java.util.Scanner;

public class Controller {
	public Repositorio<User> usuarios;
	Scanner sca;
	public int numeroDetweet = 1;
	//public int contadorDetweets = 0;
	GerenciadorDeTweet gerenciador;
	
	public Controller() {
		sca = new Scanner(System.in);
		usuarios = new Repositorio<User>("usuarios");
		gerenciador = new GerenciadorDeTweet();
	}
	
	public String query(String line) {
		String[] ui = line.split(" ");
		
		//adicia usuario com nome
		if(ui[0].equals("addUsuario"))
			usuarios.add(ui[1], new User(ui[1]));
		//mostra usuario 
		else if(ui[0].equals("mostrarUsuarios")) {
			String mostrar = " ";
			for(User us : usuarios.getAll()) {
				mostrar += us.tostring()+ "  seguidores: [" + us.mostrarseguidores()+ "]  seguidos: [" + us.mostrarseguidos()  + "] \n" ;
			}
			return mostrar;
		}
		
		//seguir usuario nome e o nome de quem vai seguir
		else if(ui[0].equals("seguir"))
			usuarios.get(ui[1]).seguir(usuarios.get(ui[2]));
		
		/*else if(ui[0].equals("mostrarSeguidos"))
			System.out.println(usuarios.get(ui[1]).mostrarseguidos());
		*/
		//criar mensagem nome usuario, titulo, texto
		else if(ui[0].equals("criartweet")) {
			String tweet = " ";
			for(int i = 3; i < ui.length; i++) 
				tweet += ui[i] + " ";
			//criamos um Tweet auxiliar
			Tweet aux = new Tweet(numeroDetweet, usuarios.get(ui[1]), ui[2], tweet);
			for(User us :  usuarios.get(ui[1]).getSeguidores().getAll()) 
				us.addTimeline(aux);
			
			usuarios.get(ui[1]).CriarTweet(aux);
			gerenciador.GeradorDeTweet(aux);
			numeroDetweet++;
			
		}
		//mostra com o nome usuario
		else if(ui[0].equals("mostrarmytweet"))
			System.out.println(usuarios.get(ui[1]).MostrarmyTweet());
			
		//mostra atraves do nome
		else if(ui[0].equals("MostrarTimeLine"))
			System.out.println(usuarios.get(ui[1]).MostrarTimeline());
		//curti pelo nome e o id do tweet
		else if(ui[0].equals("CurtiTweet")) {
			usuarios.get(ui[1]).darLike(Integer.parseInt(ui[2]));			
			//gerenciador.getTweets().get(ui[2]).darLike(Integer.parseInt(usuarios.get(ui[1]).getUsername()));
			
			gerenciador.getTweets().get(ui[2]).addLike(ui[1]);//adicionar like pelo nome 
		}
		//mostra curtidas atraves indice do tweet
		else if(ui[0].equals("mostrarCurtidas"))
			System.out.println(" "+ gerenciador.getTweets().get(ui[1]).mostrarLikes());
			
	
	
		else 
			return "comando invalido";
		return "done";
	
	}

	//a funcao que roda o controller
	public void shell() {
		while(true) {
			String line = sca.nextLine();
			try {
				System.out.println(query(line));
			}catch(RuntimeException re) {
				System.out.println(re.getMessage());
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Digite um comando:");
		Controller cont = new Controller();
		cont.shell();
	}
}
