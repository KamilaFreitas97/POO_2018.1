package Contato;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		//Telefone = Classe
		//a = Obejto
		//Telefone a = new Telefone("oi" , 96852348);
		
		
		Contato contato = new Contato("");
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);
		String opcao[];
		
		
		while (true) {
			opcao = leitura.nextLine().split(" ");
			try {
			if( opcao[0].equals("init") ) {
				contato.setNome(opcao[1]);
			}
			if( opcao[0].equals("show")) {
				System.out.println(contato.toString() );
			}
			if( opcao[0].equals("addFone")) {
				contato.addfone(new Telefone(opcao[1], Integer.parseInt(opcao[2]) ));
				System.out.println();
			}
			if( opcao[0].equals("rmFone")) {
				contato.rmFone( opcao[1] );
				System.out.println();
					}			
			 	}
			
			catch(Exception IO) {
				System.out.println("Entrada Invalida! Digite o numero novamente: ");
				}
		  	}						
		}
	}		

