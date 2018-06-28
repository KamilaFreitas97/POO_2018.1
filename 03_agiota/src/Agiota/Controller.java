package Agiota;

import java.util.Scanner;

public class Controller {
	Transacao transacao;
	Scanner sca;
	    
	    
	public Controller() {
		sca = new Scanner(System.in);
		transacao = new Transacao(0);
	}

	public String query(String line) {
		String[] ui = line.split(" ");
		//valor que eu vou iniciar 
	    if (ui[0].equals("init"))
			transacao = new Transacao(Float.parseFloat(ui[1]));
	    
	    //mostra o sistema o meu saldo, o meu apelido, meu nome e se estou vivo ou morto
	    else if (ui[0].equals("show"))
			return " " + transacao ;
	    
	    //adiciono cliente com apelido e nome
	    else if(ui[0].equals("addCliente"))
	    	transacao.cadastrar_Clientes(ui[1],ui[2]);
	    
	    //mostra o que o cliente ta devendo
	    else if(ui[0].equals("mostrarDividas"))
	    	return "" + transacao.mostrarDividas() ;
	    
	    //emprestar atraves do apelido e o valor
	    else if(ui[0].equals("emprestimo"))
	    	transacao.emprestar_Dinheiro(ui[1],Float.parseFloat(ui[2]));
	    //mostra os clientes cadastrados	    
	    else if(ui[0].equals("mostrarClientes"))
	    	return ""+ transacao.mostrarClientes();
	    
	    //mostra o cliente especifico atraves do apelido e sua divida
	    else if(ui[0].equals("mostrarClienteEspecifico"))
	    	transacao.mostrarClienteespecifico(ui[1]);
	    //paga pelo apelido e valor
	    else if(ui[0].equals("pagarDebito"))
	    	transacao.realizarPagamento(ui[1],Float.parseFloat(ui[2]));
	    else if(ui[0].equals("matarCliente"))
	    	transacao.matar_Cliente(ui[1]);
	    else
	    	return " Comando invalido";
		return "done";
	}




	public void shell() {
			while (true) {
				String line = sca.nextLine();
				try {
					System.out.println(query(line));
				} catch (RuntimeException re) {
					System.out.println(re.getMessage());
				}
			}
		}
	public static void main(String[] args) {
		System.out.println("Digite um comando:"); 
		Controller c = new Controller();
        c.shell();
    }
  
}
