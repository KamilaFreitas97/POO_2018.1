package Contato;

public class Telefone {
	private String foneid;
	private int numero;
	
	
	public Telefone(String foneid, int numero) {
		this.foneid = foneid;
		this.numero = numero;
	}
	
	public String getFoneid() {
		return foneid;
	}

	@Override
	public String toString() {
		return "[" + foneid + ":" + numero + "]";
	}
}

