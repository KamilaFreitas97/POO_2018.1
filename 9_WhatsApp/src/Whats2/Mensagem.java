package Whats;



public class Mensagem {
	private String indice;
	private String user;
	private String texto;
	private boolean mensagemLida;
	
	
	public Mensagem(String indice, String user, String texto) {
		this.indice = indice;
		this.user = user;
		this.texto = texto;
		this.mensagemLida = false;		
	}
	


	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isMensagemLida() {
		return mensagemLida;
	}

	public void setMensagemLida(boolean mensagemLida) {
		this.mensagemLida = mensagemLida;
	}


	@Override
	public String toString() {
		return "Mensagem [ userId = " + user + ":" + texto + "]" + "\n";
	}
	
	

}
