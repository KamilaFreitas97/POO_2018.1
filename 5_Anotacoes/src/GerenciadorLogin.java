
public class GerenciadorLogin {

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