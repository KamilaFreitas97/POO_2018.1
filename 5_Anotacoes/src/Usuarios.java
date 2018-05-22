

public class Usuarios implements Comparable<Usuarios>{

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



