package agiota;

import java.util.Scanner;

public class Controller {
	Transacao transacao;
	Scanner sca;
	    
	    
	public Controller() {
		sca = new Scanner(System.in);
		
	}

	public String query(String line) {
		String[] ui = line.split(" ");
		
	    if (ui[0].equals("init"))
			transacao = new Transacao(Float.parseFloat(ui[1]));
	    else if (ui[0].equals("show"))
			return " " + transacao ;
	    else if(ui[0].equals("addCliente"))
	    	transacao.cadastrar_Clientes(ui[1],ui[2]);
	    else if(ui[0].equals("mostrarDividas"))
	    	return "" + transacao.mostrarDividas() ;
	    else if(ui[0].equals("emprestimo"))
	    	transacao.emprestar_Dinheiro(ui[1],Float.parseFloat(ui[2]));
	    else if(ui[0].equals("mostrarClientes"))
	    	return ""+ transacao.mostrarClientes();
	    else if(ui[0].equals("mostrarClienteEspecifico"))
	    	transacao.mostrarClienteespecifico(ui[1]);
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
        Controller c = new Controller();
        c.shell();
    }
  
}

