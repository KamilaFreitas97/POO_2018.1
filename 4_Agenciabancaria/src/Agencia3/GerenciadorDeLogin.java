package Agencia3;

public class GerenciadorDeLogin {
	private Repositorio<Cliente> clientes;
	private Cliente user;
	
	public GerenciadorDeLogin(Repositorio<Cliente> users) {
		this.clientes = users;
		user = null;		
	}
	
	public void login(String usuario, String passWord) {
		if(user != null)
			throw new RuntimeException("fail: Ja existe alguem logado");
		if(!clientes.get(usuario).matchPassword(passWord)) 
		   throw new RuntimeException("fail: senha invalida ou pessoa nao encontrada");
		this.user = clientes.get(usuario);
		
	}
	
	//metodo de sair da sua conta
		public void Logout() {
			if(user == null)
			    throw new RuntimeException("fail: ninguem logado");
			this.user = null;
		}
		
		public Cliente getUser() {
			if(user == null)
				throw new RuntimeException("fail: ninguem logado");
			return user;
		}

}
