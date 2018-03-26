package Contato;

import java.util.ArrayList;

public class Contato {
	
	private String nome;
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	
	
	public Contato(String nome) {
		super();
		this.nome = nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean addfone(Telefone novoTelefone) {
		
		int i;
		
		//Vai retornar o tamanho de uma lista .size
		for(i = 0; i < telefones.size(); i++) {
			if(novoTelefone.getFoneid().equals(telefones.get(i).getFoneid())) {
				System.out.println("fone "+novoTelefone.getFoneid()+" ja existe");
				return false;
			}
		}
		
		telefones.add(novoTelefone);
		return true;
	}
	
	public boolean rmFone(String deletaTelefone) {
		int i;
		//Vai retornar o tamanho de uma lista .size
		for(i = 0; i < telefones.size(); i++) {
			if(deletaTelefone.equals(telefones.get(i).getFoneid())) {
				telefones.remove(i);
				return true;
			}
		}
	
		System.out.println("idfone nao existe");
		return false;
		
	}


	
	
		
	@Override
	public String toString() {
		int i;
		String resultado = "";
		resultado = resultado + nome + " ";
		
		for(i = 0; i < telefones.size(); i++) {
				resultado += telefones.get(i).toString() + " ";
		}
		
		return resultado;
	}
	
}

