package Anotacoes;

import java.util.Scanner;

class Nota {

	private String titulo;
	private String texto;
	
	public Nota(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String toString() {
		return texto;
	}
}

class Usuarios implements Comparable<Usuarios>{

	private String username;
	private String password;
	public Repositorio<Nota> notas;
	
	
	public Usuarios(String username, String password) {
		this.username = username;
		this.password = password;
		notas = new Repositorio<Nota>(username);
	}

	public Repositorio<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Repositorio<Nota> notas) {
		this.notas = notas;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	public String toString() {
		return username + ":" + password;
	}

	
	public int compareTo(Usuarios other) {
		return this.username.compareTo(other.username);
	}
}

class GerenciadorLogin {

	private Repositorio<Usuarios> usuarios;
	private Usuarios user;
	
	public GerenciadorLogin(Repositorio<Usuarios> usuarios) {
		this.usuarios = usuarios;
		user = null;
	}
	
	public void Login(String usuario, String password) {
		if(user != null)
			throw new RuntimeException("Ja existe alguem logado");
		if(!usuarios.get(usuario).matchPassword(password)) 
		   throw new RuntimeException("Senha invalida ou pessoa nao encontrada");
		this.user = usuarios.get(usuario);
	}

	public void Logout() {
		if(user == null)
		    throw new RuntimeException("Não está ninguem logado");
		this.user = null;
	}
	
	public Usuarios getUser() {
		if(user == null)
			throw new RuntimeException("Não está ninguem logado");
		return user;
	}
	
}

class Controller{
	Repositorio<Usuarios> usuario;
	Repositorio<Nota> notas;
	Scanner sca;
	GerenciadorLogin ger;
		
	public Controller() {
		
		sca = new Scanner(System.in);
		usuario = new Repositorio<Usuarios>("username");
		ger = new GerenciadorLogin(usuario);
		notas = new Repositorio<Nota>("notas");
		usuario.add("admin", new Usuarios("admin", "admin"));
		usuario.get("admin").notas.add("Lembrar",new Nota("Lembrar", "i see dead people"));
	}

	    //nossa funcao oraculo que recebe uma pergunta e retorna uma resposta
	public String oracle(String line){
		String ui[] = line.split(" ");

	    if (ui[0].equals("addUser"))
			usuario.add(ui[1], new Usuarios(ui[1], ui[2]));
	    else if (ui[0].equals("showUser")) {
			String saida = "";
			for(Usuarios us : usuario.getAll()) {
				saida += us.getUsername() + "\n";
			return saida;
			}
		}
	    else if(ui[0].equals("login"))
	    	ger.Login(ui[1], ui[2]);
	    else if(ui[0].equals("logout"))
	    	ger.Logout();
	    else if (ui[0].equals("ChangePass")) {
			if (ger.getUser().matchPassword(ui[1]))
					ger.getUser().setPassword(ui[2]);
		}
		else if(ui[0].equals("addNote")) {
		    String texto = "";
		    for(int i = 2 ; i<ui.length; i++)
		    	  texto += ui[i] + "";
		    ger.getUser().notas.add(ui[1],new Nota(ui[1], texto));
		}
		else if(ui[0].equals("rmNote"))
			ger.getUser().notas.remove(ui[1]);
		else if(ui[0].equals("showNotes")){
			String saida ="";
		for(Usuarios u : usuario.getAll())
			saida += u.getNotas() + "\n";
		return saida;
		}
	    else
	    	return " comando invalido";
	    return "done";
	    }
	}

public class IO {
	 //cria um objeto scan para ler strings do teclado
    static Scanner scan = new Scanner(System.in);
    
    //aplica um tab e retorna o texto tabulado com dois espaços
    static private String tab(String text){
        return "  " + String.join("\n  ", text.split("\n"));
    }
    
    public static void main(String[] args) {
        Controller cont = new Controller();
        System.out.println("Digite um comando:");
        while(true){
            String line = scan.nextLine();
            try {
                //se não der problema, faz a pergunta e mostra a resposta
                System.out.println(tab(cont.oracle(line)));
            }catch(Exception e) {
                //se der problema, mostre o erro que deu
                System.out.println(tab(e.getMessage()));
            	}
        	}
    	}
}