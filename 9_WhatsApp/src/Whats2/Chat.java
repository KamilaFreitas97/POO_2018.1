package Whats2;

public class Chat {
	private String chat;
	public Repositorio<User> userchats;
	public Repositorio<Mensagem> msg;
	int qtdmsg = 0;
	
	public Chat(String chat) {
		this.chat = chat;
		userchats = new Repositorio<User>("usuarios");
		msg = new Repositorio<Mensagem>("mensagens");
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public Repositorio<User> getUserchats() {
		return userchats;
	}

	public void setUserchats(Repositorio<User> userchats) {
		this.userchats = userchats;
	}

	public Repositorio<Mensagem> getMsg() {
		return msg;
	}

	public void setMsg(Repositorio<Mensagem> msg) {
		this.msg = msg;
	}
	//ESCREVER MENSAGENS
	public void escrever(Mensagem m) {
		for(User u : userchats.getAll()) {
			u.getGrupos().get(getChat()).getMsg().add(m.getIndice(), m);
		}
		msg.add(m.getIndice(),  m);
	}
	//MOSTRAR OS USUARIOS QUE ESTÃO NO GRUPO
	public String mostrarusuarios() {
		String saida = "[";
		for(User u : userchats.getAll())
			saida += u.toString() + " ";
		return saida + "]";
	}
	
	//ADICIONAR USUARIOS AO GRUPO
	public void adicionarAOgrupo(User usuario) {
		userchats.add(usuario.getIdUSer(), usuario);
		usuario.getGrupos().add(getChat(), new Chat(getChat()));
	} 
	
	//MOSTRAR MENSAGENS
	public String mostrarmsg(String user) {
		String saida = "";
		for(Mensagem m : msg.getAll()) {
			if(!user.equals(m.getUser())) {
				saida += m +" ";
			}
		}
		return saida;
	}
	
	
	
	
	public String toString() {
		return " "+chat;
	}
	
	
}
