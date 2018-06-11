package ClinicaVeterinaria;

public class Servico {
	
	String idServico;
	float valorServico;
	
	public Servico(String idServico, float ValorServico) {
		this.idServico = idServico;
		this.valorServico = ValorServico;		
	}

	@Override
	public String toString() {
		return "Servico [" + idServico + ":" + valorServico+ "]";
	}

	public String getIdServico() {
		return idServico;
	}

	public void setIdServico(String idServico) {
		this.idServico = idServico;
	}

	public float getValorServico() {
		return valorServico;
	}

	public void setValorServico(float valorServico) {
		this.valorServico = valorServico;
	}

		
}
