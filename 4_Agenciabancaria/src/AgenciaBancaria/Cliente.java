package AgenciaBancaria;

public class Cliente {
	
	private String Idcli;
	private String nomeCli;
	private Repositorio<Conta>contas;
	static int numero = 1;
	
	public Cliente(String Idcli, String nomeCli) {
		this.Idcli = Idcli;
		this.nomeCli = nomeCli;
		this.contas = new Repositorio<Conta>("");
		}

	public String getIdcli() {
		return Idcli;
	}

	public void setIdcli(String idcli) {
		Idcli = idcli;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	public Repositorio<Conta> getContas() {
		return contas;
	}

	@Override
	public String toString() {
		return "Cliente [Idcli = " + Idcli + " - nomeCli = " + nomeCli + "]";
	}

	public void addConta() {
		this.contas.add("numero", new Conta(numero));
	}
	
	
}
