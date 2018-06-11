package ClinicaVeterinaria;

public class Venda {
	String idAni;
	String idCli;
	String idSer;
	int idVenda;
	
	public Venda(int idVenda, String idCli, String idAni, String idSer) {
		this.idVenda = idVenda;
		this.idCli = idCli;
		this.idAni = idAni;
		this.idSer = idSer;		
	}
	
	

	public String getIdAnimal() {
		return idAni;
	}



	public void setIdAnimal(String idAnimal) {
		this.idAni = idAnimal;
	}



	public String getIdCliente() {
		return idCli;
	}



	public void setIdCliente(String idCliente) {
		this.idCli = idCliente;
	}



	public String getIdServico() {
		return idSer;
	}



	public void setIdServico(String idServico) {
		this.idSer = idServico;
	}



	public int getIdVenda() {
		return idVenda;
	}



	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}



	@Override
	public String toString() {
		return  idVenda + ":" + idAni + ":" + idCli + ":" + idSer;
	}
	

}
