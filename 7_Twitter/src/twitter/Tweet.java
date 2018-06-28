package twitter;

import java.util.ArrayList;

public class Tweet {
	
	public int idTweet;
	User user;
	public String mensagem;
	public ArrayList<String> likes;
	private boolean msglida;
	private boolean like;
	private String texto;
	private String titulo;

	public Tweet(int id, User user,  String titulo, String texto) {
		this.idTweet = id;
		this.user = user;
		//this.mensagem = "";
		likes = new ArrayList<String>();
		this.msglida = false;
		this.like = false;
		this.texto = texto;
		this.titulo = titulo;
		
	}
	
	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public boolean isMsglida() {
		return msglida;
	}

	public void setMsglida(boolean msglida) {
		this.msglida = msglida;
	}

	public void addLike(String username) {
		this.likes.add(username);
	}

	public int getIdTweet() {
		return idTweet;
	}

	public void setIdTweet(int idTweet) {
		this.idTweet = idTweet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User username) {
		this.user = username;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public ArrayList<String> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}

	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	//metodo que vai ser usado no controller para mostrar quem deu like
	public String mostrarLikes() {
		int i;
		String mostrar = "";
		mostrar += "Quem Curtiu o tweet:\n";
		
		for(i = 0; i < likes.size(); i++) {
			mostrar += " " + likes.get(i) + "\n";
			
			
		}
		return mostrar;
	}
	
	
	public String toString() {
		return idTweet+ ": " +user.getId()+ ": " +titulo+ ": " +texto;  
	}

}
