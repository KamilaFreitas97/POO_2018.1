package Contato2;

import java.util.Scanner;

public class Controller {
	
	Contato cont;
	
	public Controller() {
		cont = new Contato("");
	}
	/*private float toFloat(String s) {
		return Float.parseFloat(s);
	}*/
	
	
	public String oracle(String line) {
		String ui[] = line.split(" ");
		
		if(ui[0].equals("init"))
			cont.setNome(ui[1]);
		
		else if(ui[0].equals("show"))
			return " " + cont;
		else if(ui[0].equals("addContato")) {
			cont.addFone(new Telefone(ui[1], Integer.parseInt(ui[2])));				
		}		
		else if(ui[0].equals("Rmcontato")) {
			cont.rmFone(ui[1]);
			System.out.println("Contato Removido");
		}
		else 
			return "Comando invalido";
		return "done";
	}
	
	
	public static class IO{
		Contato contato;
		static Scanner scan = new Scanner(System.in);
	
	static private String tab(String text) {
		 return "  " + String.join("\n  ", text.split("\n"));		
	}
	 public static void main(String[] args) {
	        Controller cont = new Controller();
	        System.out.println("Digite um comando: init, show , addContato ou rmContato");
	        while(true){
	        	
	            String line = scan.nextLine();
	            try {
	                //se não der problema, faz a pergunta e mostra a resposta
	                System.out.println(tab(cont.oracle(line)));
	            }catch(Exception e) {
	                //se der problema, mostre o erro que deu
	                System.out.println(tab(e.getMessage()));
	            }
	        }
	        
	 	}
	}
	
}
