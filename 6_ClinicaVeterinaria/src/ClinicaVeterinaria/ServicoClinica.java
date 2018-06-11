package ClinicaVeterinaria;

import java.util.Scanner;

class Controller{
	
	 Repositorio<Cliente> clientes;
	 Repositorio<Servico> servicos;
	 Repositorio<Venda> vendas;
	 Repositorio<Animal> animais;
	
	Scanner sca;
	float dinheiro = 0;
	int nextAnimId = 1;
	int nextVendId = 1;
	
		
	public Controller() {	
		
		sca = new Scanner(System.in);		
		clientes = new Repositorio<Cliente>("clientes");
		servicos = new Repositorio<Servico>("servicos");
		vendas = new Repositorio<Venda>("vendas");
		animais = new Repositorio<Animal>("animais");
	}
	    //nessa funcao oracul recebe uma pergunta e retorna uma resposta
	
	public String oracle(String line){
		String ui[] = line.split(" ");
		//adiciona cliente
		if(ui[0].equals("help"))
			return "addCli _idCliente _nome, showCli\n"
		     + "addAnimal _idCli _nome _especie, showAnimal\n"
		     + "addServ _idServ _preco, showServ\n"
		     + "vendaServ _idCli _idAni _idServ, showVenda\n"
		     + "showLucro";
		
		else if (ui[0].equals("addCli")) {
	    	String nome_ = " ";
	    	for(int i = 2; i < ui.length; i++) 
	    		nome_ += ui[i] + " ";
	    	clientes.add(ui[1], new Cliente(ui[1], nome_));
	    }
	    //mostrar cliente
	    else if(ui[0].equals("showCli")){
	    	String cli = " ";
	    	for(Cliente c : clientes.getAll()) 
	    		cli += c.toString() + "\n";
	    		return cli;
	    }
	    //adiciona animal
	    else if(ui[0].equals("addAnimal")) {
	    	clientes.get(ui[1]).getAnimais().add(ui[2], new Animal(nextAnimId, ui[2], ui[3]));
	    	nextAnimId++;
	    }
	    //mostra animal
	    else if(ui[0].equals("showAnimal")) {
	    	String show = "";
	    	for(Cliente c : clientes.getAll())
	    		show += c.Mostrar();
	    	return show;
	    }
	    //adicionar servicos a serem utilizados
	    else if(ui[0].equals("addServ"))
			servicos.add(ui[1], new Servico(ui[1], Float.parseFloat(ui[2])));
	    	
	    //mostrar servicos adicionados
	    else if(ui[0].equals("showServ")) {
			String serv = "";
			for(Servico s : servicos.getAll())
				serv += s.toString() + "\n";
			return serv;
		}
	    //vender os tipos de servico
	    else if(ui[0].equals("vendaServ")) {
		    clientes.get(ui[1]); 
		    clientes.get(ui[1]).getAnimais().get(ui[2]);
		    servicos.get(ui[3]);
		    vendas.add("" + nextVendId , new Venda(nextVendId ,ui[1],ui[2],ui[3]));
		    dinheiro += servicos.get(ui[3]).getValorServico();
		    nextVendId++;
		}
	    //mostrar a venda
	    else if(ui[0].equals("showVenda")){
		    String total = "";
		    for(Venda v : vendas.getAll())
			    total += v.toString() + "\n";
		    return total;
		}
	    //ver o lucro obtido pela venda
	    else if(ui[0].equals("showLucro"))
	    	System.out.println(dinheiro);
	    else
	    	return " comando invalido";
	    return "done";
	    }
	}

public class ServicoClinica {
	 //cria um objeto scan para ler strings do teclado
    static Scanner scan = new Scanner(System.in);
    
    //aplica um tab e retorna o texto tabulado com dois espaços
    static private String tab(String text){
        return "  " + String.join("\n  ", text.split("\n"));
    }
    
    public static void main(String[] args) {
        Controller cont = new Controller();
        System.out.println("Digite um comando:");
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

