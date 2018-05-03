package agiota;

class Cliente {
	public String cli_Id;
	public String nome;
	public String estado = "vivo";
	public float saldo = 0;
	
	//Construtor da Classe Cliente
	public Cliente(String cli_Id, String nome) {
		this.cli_Id = cli_Id;
		this.nome = nome;
		
	}

	@Override
	public String toString() {
		return ""+nome +": "+ cli_Id+ ": " +estado+ "";
	}
	
	public String mostrar_saldo() {
		return " nome: " + nome + " saldo: " + saldo + "";
	}
}
