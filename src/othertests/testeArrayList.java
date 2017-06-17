package othertests;

import java.util.ArrayList;

public class testeArrayList {



	public static void main(String[] args) {
		ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>(3);
		
		Pessoa p1 = new Pessoa("Diego", 25);
		Pessoa p2 = new Pessoa("Diego", 25);
		Pessoa p3 = new Pessoa("Diego", 25);
		
		pessoa.add(p1);
		pessoa.add(p2);
		pessoa.add(p3);
		
		for(Pessoa p : pessoa){
			p.imprimir();
		}
		

	}

}

class Pessoa {

	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade){
		this.nome = nome;
		this.idade = idade;
	}
	
	public void imprimir(){
		System.out.println(nome + "\n" + idade);
	}
}