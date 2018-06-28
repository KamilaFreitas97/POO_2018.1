package Agencia3;

public class Conta {
	
	private float saldo;
	private int numero;
	private Repositorio<Operacao> extrato;
	private boolean ativa;
	int contador_extrato;
	//construtor da conta
	public Conta(int numero) {
		this.numero = numero;
		this.saldo += saldo;
		extrato = new Repositorio<Operacao>("extrato");
		this.ativa = true;

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
	//metodo de realizar deposito
	public boolean depositar(float valor) {
		if (ativa) {
			if (valor <= 0)
				throw new RuntimeException("Fail: valor negativo ou igual a zero.");
			
			this.extrato.add(""+contador_extrato, new Operacao("depositar", valor));
			this.saldo += valor;
			contador_extrato++;
		    return true;
		}
		throw new RuntimeException("Fail: Conta não ativa");
	}
	//metodo de realizar saque
	public void sacar(float valor) {
		if(ativa) {
			if (valor <= 0) {
				throw new RuntimeException("Fail: valor negativo ou igual a zero.");
			}
			if (valor > saldo) {
				throw new RuntimeException("Fail: valor maior que o saldo.");
			}
		     this.saldo -= valor;
		     this.extrato.add( "" + contador_extrato , new Operacao("sacar", valor));
		     contador_extrato++;
		     return;
		}
		throw new RuntimeException("Fail: Conta não ativa");
	}
	//metodo de transferir
	//meu idProcurado e minha conta que vou querer transferir(e minha conta destino)
	public void transferir(float valor, Repositorio<Cliente> clientes, int idProcurado) {
		//other e o meu parametro, ai estou pecorrendo minha conta com outra
		Conta other = null;
		//criei uma variavel aux pra quando pra quando eu pecorrer minhas contas e qndo achar retornar verdadeiro
		boolean achou = false;
		Repositorio<Conta> contas = null;//coloquei o repositorio de conta aqui pra conseguir pecorrer 
		
		for(Cliente cli : clientes.getAll()) {
			contas = cli.getContas();
			for(Conta c : contas.getAll() ) {
				if(c.getNumero() == idProcurado) {
					
					other = c;
					achou = true;
					break;
				}
			}
		}
		if(achou == false) {
			throw new RuntimeException("conta nao encontrada");
		}
		// caso ache a conta transferida, sera realizado a transferencia
		if(this.ativa) {
			if(valor < 0)
				throw new RuntimeException("valor inferior a zero");
			
			this.extrato.add(""+ contador_extrato, new Operacao("tranferir", valor));
			this.saldo -= valor;
			other.setSaldo(other.getSaldo()+ valor) ;
			System.out.println("transferencia realizada com sucesso!");
			contador_extrato++;
			return;
		}
		throw new RuntimeException("conta nao esta ativa");
	}
	
	// encerrar conta
	public void encerrar() {
		this.ativa = false;
	}

	@Override
	public String toString() {
		return "Conta: "+ " saldo = "+ saldo + " : ativa = " + ativa;
				
	}
	
	
}
