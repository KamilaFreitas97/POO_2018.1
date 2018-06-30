package Whats;

public class Usuario {
	private String idUsuario;
	private Repositorio<Chat> grupos;
	private Repositorio<Mensagem> mensagens;
	int qtdMensagens = 0;
	
	public Usuario(String idUsuario) {
		this.idUsuario = idUsuario;
		grupos = new Repositorio<Chat> ("grupos");
		mensagens = new Repositorio<Mensagem>("mensagens");
		
	}

	public Repositorio<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Repositorio<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Repositorio<Chat> getChats() {
		return grupos;
	}

	public void setChats(Repositorio<Chat> chats, Repositorio<Chat> grupos) {
		this.grupos = grupos;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Repositorio<Chat> getGrupos() {
		return grupos;
	}

	public void setGrupos(Repositorio<Chat> grupos) {
		this.grupos = grupos;
	}

	public int getQtdMensagens() {
		return qtdMensagens;
	}

	public void setQtdMensagens(int qtdMensagens) {
		this.qtdMensagens = qtdMensagens;
	}
	
	//metodo que ira verificar se a pessoa esta no grupo e assim retorna a mensagem
	public Chat RetornaChat(Chat c) {
		for(Chat chat : grupos.getAll()) 
			if(chat.getChat().equals(c.getChat()))
				return c;
		
		
		throw new RuntimeException("Voce nao esta nesse grupo");
		
	}
	
	public void addChat(Chat novoGrupo) {
		grupos.add(novoGrupo.toString(), novoGrupo);	
	}


	//metodo de mostrar mensagem
	public void mostrarMensagem(Chat chat) {
		if(this.RetornaChat(chat) != null)
			System.out.println(chat.MostrarMensagem(getIdUsuario()));
		
	}
	//
	public String contagem(Chat ch) {
		String saida = " ";
		for(Mensagem men : ch.getMensagens().getAll())
			if(!men.isMensagemLida()) {
				qtdMensagens++;
				men.setMensagemLida(true);
			}
		
		saida += qtdMensagens;
		qtdMensagens = 0;
		return saida;
	}
	//metodo de mostrar mensagens no grupo
	public String MostrarGrupos() {
		String mostrar = "";
		for(Chat usu : grupos.getAll())
			mostrar += usu.toString() + "\n";
		return mostrar;
	}

	@Override
	public String toString() {
		return " NomeUsuario: " + idUsuario ;
	}
	
	
}
