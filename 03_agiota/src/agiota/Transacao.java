package agiota;

import java.util.ArrayList;

class Transacao {
	public float saldo = 0;
	public float dinheiro;
	public int id_transacao = 0;
	public int id = 0;
	
	// Lista de clientes do tipo Cliente e lista de dividas do tipo Dividas
	ArrayList<Cliente> clientes;
	ArrayList<Dividas> dividas;
	
	//Construtor da classe Transacao
	public Transacao(float dinheiro) {
		this.dinheiro = dinheiro;
		clientes = new ArrayList<Cliente>();
		dividas =  new ArrayList<Dividas>();
		saldo = saldo + dinheiro;
	}
	
	//tostring da classe transacao
	public String toString() {
		return"Sistema iniciado com: " + saldo + " " + clientes.toString() + "\n";
	}
	
	//metodo que adiciona clientes caso não esteja cadastrado
	public void cadastrar_Clientes(String nome, String clienteid) {
		for (Cliente cli : clientes)
			if (cli.nome.equals(nome))
				throw new RuntimeException("Pessoa já cadastrada!");
			else if(cli.cli_Id.equals(clienteid))
				throw new RuntimeException("Pessoa já cadastrada com esse id!");
		clientes.add(new Cliente(clienteid, nome));
	}
	
	
	//metodo que empreta dinheiro se a pessoa estiver  cadastrada no sistema, isso so se o saldo for valido
	public void emprestar_Dinheiro(String nome, float valor) {
		for (Cliente cli : clientes)
			if (cli.nome.equals(nome) ) { 
				cli.saldo = cli.saldo + valor;
				this.cadastrar_Divida(nome, valor);
		        return;
	        }
		
		throw new RuntimeException("Pessoa ou saldo invalido!");
	}
	
	//metodo que cadastra divida se o saldo não for inferior ao valor pedido
	public void cadastrar_Divida(String nome, float valor) {
		if(valor <= saldo) {
			saldo = saldo + valor;
			this.dividas.add(new Dividas(nome, valor, id));
			id++;
			return;
		}
		else
			throw new RuntimeException ("O Saldo é inferior ao valor pedido!");
			   
	}
	
	public String mostrarDividas() {
			return "" + dividas.toString();
	}
	
	public String mostrarClientes() {
	    	String saida =  "";
	    	for(int i = 0; i < clientes.size(); i++)
	    	   saida += ""+ this.clientes.get(i).mostrar_saldo();
	    	return saida;
	}
	
	public void mostrarClienteespecifico(String nome) {
		int i = 0;
		for (Cliente cli : clientes) {
			if (cli.nome.equals(nome)) {
				System.out.println(cli.mostrar_saldo());
				while( dividas.get(i).nome.equals(nome)) {
					       System.out.println(dividas.get(i).toString());
		                   i++;       
				}
			}
		return;
		}
	    throw new RuntimeException("O Cliente não foi encontrado!");
	}
	
	
	//recebe dinheiro se o cliente estiver cadastrado
	public void realizarPagamento(String nome, float valor) {
		for (Cliente cli : clientes)
			if (cli.nome.equals(nome)) {
					if (cli.saldo > 0) {
						cli.saldo = cli.saldo + valor;
						dinheiro = dinheiro + valor;
						this.dividas.add(new Dividas(nome, valor, id));
						id++;
						return;
					}
			}
		
			throw new RuntimeException("Cliente não encontrado!");
		
	}
	
	//Matar os Clientes
	public void matar_Cliente(String nome) {
		for( int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).nome.equals(nome)){
				apagar_Dividas(nome);
		        return;
			}
		}
		
		throw new RuntimeException("O Cliente não foi encontrado!");
	}
	
	//Apagar as dividas
	public void apagar_Dividas( String nome) {
		for(int i = 0 ; i<dividas.size(); i++) {
			if(dividas.get(i).nome.equals(nome))
				this.dividas.remove(dividas.get(i));
			    i--;
		}
	}
		
}