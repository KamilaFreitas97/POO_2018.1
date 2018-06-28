package Agencia3;

import java.util.Scanner;

public class Controller {
	Scanner sca;
	Repositorio<Cliente> clientes;
	//Repositorio<Conta> contas;
	GerenciadorDeLogin gerenciador;
	int numero_conta = 0;
	int contador_contas = 0;
	
	public Controller() {
		sca = new Scanner(System.in);
		clientes = new Repositorio<Cliente>("");
		gerenciador = new GerenciadorDeLogin(clientes);
		//contas = new Repositorio<Conta>("contas");
		
	}
	
	
	public String query(String line) {
		
		String[] ui = line.split(" ");
		
		//adiciona com nome e senha
		if(ui[0].equals("addCliente")) {
			clientes.add(ui[1], new Cliente(ui[1], ui[2], numero_conta));
			numero_conta++;
		}
		//mostra os clientes adicionados
		else if(ui[0].equals("MostrarClientes")) {
			String mostrar = " ";
			for(Cliente cli : clientes.getAll())
				mostrar += cli.toString() + "\n";
			return mostrar;
		}	
		
		//loga com o nome do cliente e a senha
		else if(ui[0].equals("Login")) {
			gerenciador.login(ui[1], ui[2]);
			contador_contas++;////////ver se e utlixado ***
		}
		// deposita com o numero da conta do cliente que esta logado
		else if(ui[0].equals("Deposito")) {
			gerenciador.getUser().contas.get(ui[1]).depositar(Float.parseFloat(ui[2]));
			}
		//saque e realizado com o numero da conta e o valor
		else if(ui[0].equals("saque"))
			gerenciador.getUser().contas.get(ui[1]).sacar(Float.parseFloat(ui[2]));
		//
		else if(ui[0].equals("encerrar")) {
			gerenciador.getUser().contas.get(ui[1]).encerrar();
			contador_contas--;
		}
		//saldo pelo o id conta
		else if(ui[0].equals("saldo")) {
			System.out.println("seu saldo e:");
			System.out.println(""+gerenciador.getUser().contas.get(ui[1]).getSaldo());
			}
		
		//adiciona conta com nome e senha
		else if(ui[0].equals("addConta")) {
			
			if(gerenciador.getUser().getQtd_contas() > 1)
				throw new RuntimeException("você ja possui o numero maximo de contas ativa");
			
			gerenciador.getUser().addConta(numero_conta);
			numero_conta++;
			
			
		}
		
		//transfere da conta que esta logada, valor e para a outra conta pode ser internet ou externa
		else if(ui[0].equals("transferir")) {
			
			gerenciador.getUser().contas.get(ui[1]).transferir(Float.parseFloat(ui[2]), clientes, Integer.parseInt(ui[3]));
			// transferir (conta logada) (valor) (repos cliente) (conta destino) 
		}
			
		//sai da conta
		else if(ui[0].equals("logout"))
			gerenciador.Logout();
		//mostra as contas que existem
		else if(ui[0].equals("showcontas")) {
			System.out.println(gerenciador.getUser().getCliente_id());
			System.out.println(gerenciador.getUser().getContas().toString());
			
		}
			
		else
			return "comando invalido";
		return "done";
		
	}
	
	public void shell() {
		while(true) {
			String line = sca.nextLine();
			try {
				System.out.println(query(line));
			}catch(RuntimeException re) {
				System.out.println(re.getMessage());
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Digite um comando: ");
		Controller cont = new Controller();
		cont.shell();
		
	}
		
}
