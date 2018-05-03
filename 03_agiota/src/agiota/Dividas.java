package agiota;

public class Dividas {
	
	public String nome;
	public float valorDebito;
	public int id = 0;
	public float valor_total = 0;
	
	//Construtor da classe dividas
	public Dividas(String nome, float valor, int id) {
		this.nome = nome;
		this.valorDebito = valor;
		this.id = id;
		this.valor_total = valorDebito + valor_total;
	}
	//metodo tostring que faz a interação com o usuario
	public String toString() {
		return  " id: " +id+ " nome: " +nome+ " valor: " +valorDebito+ "";
	}
	
}
