package othertests;

import java.util.Scanner;

public class TesteRelogio {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Relogio rel = new Relogio();

		int op;

		while (true) {

			System.out.print("Formato de horas: ");
			op = input.nextInt();

			switch (op) {

			case 12:
				rel.metodo12hs();
				break;

			case 24:
				rel.metodo24hs();
				break;

			}// end of switch(op)

		} // end of while(true)

		// rel.metodo12hs();

	}// end of main method

}// end of class

/**
 * ============================================================================================
 **/

class Relogio {

	// Campos da classe
	private Contador minutos;
	private Contador horas;

	// Constrio Objeto a partir da classe relogio relogio usando 2 objetos do tipo
	// contador
	public Relogio() {

		this.horas = new Contador();
		this.minutos = new Contador();

	}

	// Metodos pra contar horas e minutos.
	public void contarHoras() {

		int limitar;

		this.horas.contar();

		limitar = horas.getContar();

		limitar = (limitar % 25);

		this.horas.setContar(limitar);
	}

	public void contarMinutos() {

		int limitar;

		this.minutos.contar();

		limitar = minutos.getContar();

		limitar = (limitar % 61);

		this.minutos.setContar(limitar);
	}

	// Metodos get e set dos campos da classe:

	public void setHoras(int hs) {

		this.horas.setContar(hs);

	}// fim do SetHoras

	public int getHoras() {

		return this.horas.getContar();
	}// fim do getHoras

	public void setMinuto(int m) {

		this.minutos.setContar(m);

	}// fim do SetMinuto

	public int getMinutos() {

		return this.minutos.getContar();
	}// fim do getMinutos

	// Metodos para printar em formato 12 hs ou em formato 24 hs

	public void metodo12hs() {

		int contador = 0;

		while (contador < 24) {

			if (contador <= 12) {

				System.out.print(getHoras() + ":" + getMinutos() + "a.m");

			} // end of if(contador <= 12)

			else {

				setHoras(1);// reiniciar o contador
				System.out.print(getHoras() + ":" + getMinutos() + "p.m");

			} // end of else

			contador++;
			contarHoras();
			contarMinutos();

		} // end of while(contador < 24)
	}

	public void metodo24hs() {

		// metodo a ser implementado, quero fazer o metodo12hs funcionar primeiro

	}

}// fim da Classe Relogio

/**
 * ============================================================================================
 **/

class Contador {

	private int contar;

	// Metodo construtor
	public void Contador() {
		this.contar = 0;
	}

	// add 1
	public void contar() {

		this.contar = (contar + 1) % 100;
	}

	// set
	public void setContar(int num) {

		this.contar = num;
	}

	// get
	public int getContar() {

		return this.contar;
	}

}// end of class