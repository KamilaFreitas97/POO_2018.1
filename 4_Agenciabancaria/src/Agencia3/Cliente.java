package Agencia3;

public class Cliente implements Comparable <Cliente>{
	
	private String Cliente_id;
	private String passWord;
	Repositorio<Conta> contas;
	Repositorio<Operacao> operacoes;
	int qtd_contas = 0;
	
	public Cliente(String Cliente_id, String passWord, int numero_conta) {
		this.Cliente_id = Cliente_id;
		this.passWord = passWord;
		this.operacoes = new Repositorio<Operacao>("operacoes");
		this.contas = new Repositorio<Conta>("contas") ;
		addConta(numero_conta);
		
	}

	public String getCliente_id() {
		return Cliente_id;
	}

	public void setCliente_id(String cliente_id) {
		Cliente_id = cliente_id;
	}

	public Repositorio<Conta> getContas() {
		return contas;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public boolean matchPassword(String passWord) {
		return this.passWord.equals(passWord);		
	}
	
	
	public int getQtd_contas() {
		return qtd_contas;
	}
	//metodo de adicionar conta
	public void addConta(int numero) {
		this.contas.add(""+numero, new Conta(numero));
		qtd_contas++;
	}

	public int compareTo(Cliente other) {
		
		return this.Cliente_id.compareTo(other.Cliente_id);
	}

	@Override
	public String toString() {
		return "Cliente: " + Cliente_id ;
	}

	
	
	
}
