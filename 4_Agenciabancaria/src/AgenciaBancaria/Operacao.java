package AgenciaBancaria;

public class Operacao {
	private String descricao;
	private float valor;
	private float saldoParcial = 0;
	
	public Operacao(String descricao, float valor){
		this.descricao = descricao;
		this.valor = valor;
		this.saldoParcial += valor;		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getSaldoParcial() {
		return saldoParcial;
	}

	public void setSaldoParcial(float saldoParcial) {
		this.saldoParcial = saldoParcial;
	}

	@Override
	public String toString() {
		return "descricao = " + descricao + "- valor = " + valor + "- saldoParcial = " + saldoParcial;
	}
	
	
	
	
	
	

}
