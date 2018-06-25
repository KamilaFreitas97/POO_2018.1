package AgenciaBancaria;

import java.util.Scanner;

public class Controller {
	Repositorio<Cliente> clientes;
	Repositorio<Conta> contas;
	Scanner sca;
	int numeroConta = 0;
	int contadorContas = 0;
	
	public Controller() {
		sca = new Scanner(System.in);
		clientes = new Repositorio<Cliente>("clientes");
		contas = new Repositorio<Conta>("contas");	
	}
	
	public String query(String line) {
		String[] ui = line.split(" ");
		
		if(ui[0].equals("addCliente"))
			clientes.add(ui[1],new Cliente(ui[1], ui[2]));
		else if(ui[0].equals("showcliente")) {
			String saida = "";
			for(Cliente cli : clientes.getAll()) 
				saida += cli.toString() + "\n";
				return saida;
				}
			//deposito é realizado com numero da conta e o valor
			else if(ui[0].equals("Deposito")) 
				contas.get(ui[1]).Depositar(Float.parseFloat(ui[2]));
			//saque e realizado atraves numero da conta e valor
			else if(ui[0].equals("saque"))
				contas.get(ui[1]).sacar(Float.parseFloat(ui[2]));
			//traferir e realizado atraves numero conta e o valor
			else if(ui[0].equals("Transferir"))
				contas.get(ui[1]).Tranferir(Float.parseFloat(ui[2]));
			else if(ui[0].equals("showContas")) {
				contas.get(""+ contas.toString());
				}
			//adiciona conta com id e o nome
			else if(ui[0].equals("addContas")) {
				if(contadorContas > 1)
					throw new RuntimeException("voce ja possui o numero maximo de contas");
				contas.add(""+ numeroConta, new Conta(numeroConta));
				numeroConta++;
				contadorContas++;
			} 
			else if(ui[0].equals("encerrar")) {
				contas.get(ui[1]).encerrar();
				contadorContas--;
				}
			else if(ui[0].equals("sairDaconta")) {
				
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
			System.out.println("Digite um comando");
			Controller cont = new Controller();
			cont.shell();
		}
	}
	

