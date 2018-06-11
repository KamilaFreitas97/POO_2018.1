package ClinicaVeterinaria;

public class Cliente{
	
	private String idCliente;
	private String nomeCliente;
	private Repositorio<Animal> animais;
	
	public Cliente(String idCliente, String nomeCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		animais = new Repositorio<Animal> ("animais");
	}

	
	@Override
	public String toString() {
		return "Cliente ["+ idCliente + ":" + nomeCliente + "]";
	}
	/*public void addAnimal(Animal ani) {
		if(ani == null) {
			throw new RuntimeException("Falha! animal nao encontrado");
		}
	}
*/

	public String getIdCliente () {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente(){
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;;
	}
	public Repositorio<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(Repositorio<Animal> animais){
		this.animais = animais;
	}
	
	public  String Mostrar() {
		String saida = " ";
		for(Animal a : animais.getAll()) 
			saida += a.toString();
			return saida;		
	}
}