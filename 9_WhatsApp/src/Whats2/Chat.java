package Whats;


public class Chat {
	
	private String chat;
	Repositorio<Usuario> users;
	private Repositorio<Mensagem> mensagens;
	
	int qtdMensagens = 0;
	
	public Chat(String chat) {
		this.chat = chat;
		users = new Repositorio<Usuario>("usuarios");
		mensagens = new Repositorio<Mensagem>("mensagens");			
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public Repositorio<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Repositorio<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	
	public Repositorio<Usuario> getUsers() {
		return users;
	}

	public void setUsers(Repositorio<Usuario> users) {
		this.users = users;
	}

	//metodo que vai mostrar os usuarios do grupo
	public String MostrarUsuarios() {
		String mostrar = " [";
		for(Usuario usu : users.getAll())
			mostrar += usu.toString() + "] \n"+ "\n";
		return mostrar + " ";
	}
	//metodo de escrever mensagens
	public void escreverMensagem(Mensagem men) {
		//mensagens.add("",men);
		for(Usuario us : this.users.getAll()) {
			us.getMensagens().add(""+getMensagens(), men);
			//return;
			}
			mensagens.add(men.getIndice(), men);
	
		}
	//metodo que mostra as mensagens no grupo
	public String MostrarMensagem(String usu) {
		String mostrar = " ";
		for(Mensagem m : mensagens.getAll()) {
			if(!usu.equals(m.getUser()))
				mostrar += m + " ";
			}
		
		return mostrar;
	}
	
	public void addusuarionogrupo(Usuario use) {
		users.add(use.getIdUsuario(), use);
	}
	
	
	public String toString() {
		return chat;
	}
}
