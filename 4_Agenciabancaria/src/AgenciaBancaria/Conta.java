package AgenciaBancaria;

public class Conta {
	
	private float saldo;
	private int numero;
	private Repositorio<Operacao> extrato;
	private boolean ativa;
	int contador_extrato;
	
	public Conta(int numero) {
		this.numero = numero;
		this.saldo += saldo;
		this.extrato = new Repositorio<Operacao>("extratos");
		this.ativa = true;
	}

	public boolean Depositar(float valor) {
		if(ativa) {
			if(valor <= 0)
				throw new RuntimeException("valor é negativo ou inferior a zero");
			
		
		this.extrato.add(""+contador_extrato, new Operacao("Depositar", valor));
		this.saldo += valor;
		contador_extrato++;
		return true;
		}
		throw new RuntimeException("Essa conta nao esta ativa!");
	}
	
	public boolean sacar(float valor) {
		if(ativa) {
			if(valor <= 0) {
				throw new RuntimeException(" Valor esta igual ou inferior a zero");
			}
			else if(valor > saldo) {
				throw new RuntimeException("saldo insuficiente para saque");
			}
			this.saldo -= valor;
			this.extrato.add(""+ contador_extrato, new Operacao("sacar", valor));
			contador_extrato++;
			return true;
			}
		throw new RuntimeException("Conta nao esta ativa");
		
	}
	
	
	public void Tranferir(float valor) {
		if(this.ativa) {
			if(valor < 0)
				throw new RuntimeException("valor e inferior ou igual a zero");
				
			this.extrato.add(""+contador_extrato, new Operacao("transferir", valor));
			this.saldo -= valor;
			contador_extrato++;
			return;
		}
		throw new RuntimeException("conta nao encontra-se ativa");		
	}
	
	public void encerrar() {
		this.ativa = false;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public int getNumero() {
		return numero;
	}

	public Repositorio<Operacao> getExtrato() {
		return extrato;
	}
	
	

	@Override
	public String toString() {
		return "Conta: " + " - numero: " + numero + " - saldo: "+ saldo +" - status: " + ativa;
	}
	
	
	
	
	
}
