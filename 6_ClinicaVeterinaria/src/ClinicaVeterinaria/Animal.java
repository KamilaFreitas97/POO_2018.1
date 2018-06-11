package ClinicaVeterinaria;


public class Animal {
	
	int idAni;
	String nome;
	String especie;
	
	public Animal(int idAni, String nome, String especie) {
		
		this.idAni = idAni;
		this.nome = nome;
		this.especie = especie;
		
	}
		public int getIdAnimal() {
		return idAni;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAni = idAnimal;
	}

	public String getNomeAnimal() {
		return nome;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nome = nomeAnimal;
	}

	public String getEspecieAnimal() {
		return especie;
	}
	public void setEspecieAnimal(String especieAnimal) {
		this.especie = especieAnimal;
	}
	
	@Override
	public String toString() {
		return "Animal  [" + idAni + ":" + nome + ":" + especie + "]";
	}	
}

