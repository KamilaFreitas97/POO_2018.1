package Junkfood;

import java.util.ArrayList;
import java.util.Scanner;

class Espiral{
	public String nome;
	public int qtd;
	public float preco;
	
	public Espiral(){
		this.nome = "-";
		this.qtd = 0;
		this.preco = 0f;
		
	}

	@Override
	public String toString() {
		return "[ "+ this.nome + " : " + this.qtd + " U : " + this.preco + " RS]";
	}
	
}

class Maquina{
	
	public ArrayList<Espiral> espirais;
	 float saldo = 0f;
	 float lucro = 0f;
	 float troco = 0f;
	
	public Maquina(int qtdEspirais, int maxProdutos){
		this.espirais = new ArrayList<Espiral>();
		for(int i = 0; i < qtdEspirais; i++)
			this.espirais.add(new Espiral());
	}
	
	public String toString() {
		String saida = "";
		for(int i = 0; i < espirais.size(); i++)
			saida += i + " " + espirais.get(i) + " Saldo: "+saldo+" Lucro total: "+ lucro +" Seu troco: "+ troco +"\n";
		return saida;
		
	}
	public void addEspiral(int indice, String nome, int qtd, float preco) {
		espirais.get(indice).nome = nome;
		espirais.get(indice).qtd = qtd;
		espirais.get(indice).preco = preco;
		
	}
	
	public void Limparspiral(int indice) {
		this.espirais.get(indice).nome = "-";
		this.espirais.get(indice).qtd = 0;
		this.espirais.get(indice).preco = 0f;
	}
	
	public void atualizarespiral(int indice, String nome, int qtd, float preco) {
		this.espirais.get(indice).nome = nome;
		this.espirais.get(indice).qtd = qtd;
		this.espirais.get(indice).preco = preco;
	}
	
	
	public void efetuarCompra(String nome) {
		for(Espiral esp : espirais) {
			if(esp.nome.equals(nome)) 
				if(saldo >= esp.preco) {
					esp.qtd--;
					lucro = esp.preco + lucro;
			        saldo = saldo - esp.preco;
			        troco = saldo;
			        saldo = troco;
				}
			
			else
				throw new RuntimeException("saldo insuficiente");
		}
	}
	
	public void adddinheiro(float valor) {
		saldo += valor;
	}
}

class Controller{
	   Maquina maq;
	    static final int DEFAULT_ESPIRAIS = 2;
	    static final int DEFAULT_MAX = 5;
	    public Controller() {
	        maq = new Maquina(DEFAULT_ESPIRAIS, DEFAULT_MAX);
	    }
	    
	    //recebe uma string e tenta converter em float
	    private float toFloat(String s) {
	        return Float.parseFloat(s);
	    }
	    
	    //nossa funcao oraculo que recebe uma pergunta e retorna uma resposta
	    public String oracle(String line){
	        String ui[] = line.split(" ");

	        if(ui[0].equals("help"))
	            return "show, init _espirais _maximoespirais";
	        else if(ui[0].equals("init"))
	            maq = new Maquina(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
	        else if(ui[0].equals("show"))
	            return "" + maq;
	        else if(ui[0].equals("add"))
	        	maq.addEspiral(Integer.parseInt(ui[1]),ui[2], Integer.parseInt(ui[3]), Float.parseFloat(ui[4]));
	        else if(ui[0].equals("Limpar"))
	        	maq.Limparspiral(Integer.parseInt(ui[1]));
	        else if(ui[0].equals("atualizar"))
	        	maq.atualizarespiral(Integer.parseInt(ui[1]), ui[2], Integer.parseInt(ui[3]), Float.parseFloat(ui[4]));
	        else if(ui[0].equals("dinheiro")) 
	        	maq.adddinheiro(Float.parseFloat(ui[1]));
	        else if(ui[0].equals("comprar"))
				maq.efetuarCompra(ui[1]);
	        else
	            return "comando invalido";
	        return "done";
	    }
	}

public class IO {
	  //cria um objeto scan para ler strings do teclado
    static Scanner scan = new Scanner(System.in);
 
    //aplica um tab e retorna o texto tabulado com dois espaços
    static private String tab(String text){
        return "  " + String.join("\n  ", text.split("\n"));
    }
    
    public static void main(String[] args) {
        Controller cont = new Controller();
        System.out.println("Digite um comando ou help:");
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