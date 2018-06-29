package Whats2;



public class User {
	private String idUSer;
	private Repositorio<Chat> grupos;
	private Repositorio<Mensagem> mensagens;
	int qtdmsg = 0;
	
	public User(String id) {
		this.idUSer = id;
		grupos = new Repositorio<Chat>("grupos");
		mensagens = new Repositorio<Mensagem>("mensagens");
	}

	public String getIdUSer() {
		return idUSer;
	}

	public void setIdUSer(String idUSer) {
		this.idUSer = idUSer;
	}

	public Repositorio<Chat> getGrupos() {
		return grupos;
	}

	public void setGrupos(Repositorio<Chat> grupos) {
		this.grupos = grupos;
	}

	public Repositorio<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Repositorio<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	public String toString() {
		return idUSer;
	}
	
	
	//Verifica se a pessoa está no grupo se estiver, retorna a mensagem
	public Chat retornarChat(Chat c) {
		for(Chat chat : grupos.getAll())
			if(chat.getChat().equals(c.getChat()))
				return c;
		
		throw new RuntimeException("fail: voce não esta neste grupo");
	}
	
	public void mostrarmensagens(Chat c) {
		if(retornarChat(c) != null) {
			System.out.println(c.mostrarmsg(getIdUSer()));
		}
	}
	
	public String contarMensagens(Chat c) {
		String saida = "";
		for(Mensagem m : c.getMsg().getAll()) {
			if(!m.getUser().equals(idUSer)) {
				if(!m.isLido()) {
					qtdmsg++;
					m.setLido(true);
				}
			}
		}
		saida += qtdmsg;
		qtdmsg = 0;
		return saida;
	}
	
	public String mostrargrupos() {
		String saida = "[ ";
		for(Chat c : grupos.getAll())
			saida += c.toString() + " ";
		return saida + " ]";
	}
}
