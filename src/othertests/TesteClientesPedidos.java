package othertests;

import java.io.IOException;
import java.util.Scanner;

public class TesteClientesPedidos {

	static Scanner lerVendedor = new Scanner(System.in);

	public static void cadastrarVendedor() {

		Vendedor ve = new Vendedor();

		System.out.println("CADASTRAR VENDEDOR\n");
		System.out.println("Nome:........:");
		ve.nome = lerVendedor.nextLine();

		System.out.println("Matricula:...:");
		ve.matricula = lerVendedor.nextInt();

		System.out.println("Telefone:....:");
		ve.telefone = lerVendedor.next();

		System.out.println("Cidade:......:");
		ve.cidade = lerVendedor.next();

		System.out.println("E-mail:......:");
		ve.email = lerVendedor.next();

		System.out.println("Salário:.....:");
		ve.salario = lerVendedor.nextDouble();

		System.out.println("Estado:......:");
		ve.estado = lerVendedor.next();

		try {
			System.out.println("Comissão:..:");
			ve.setComissao(lerVendedor.nextDouble());

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}

class Vendedor extends Funcionario {

	private double comissao;

	@Override
	public double calcularSalario() {
		return (this.salario + comissao);
	}

	public Vendedor(String nome, int matricula, String telefone, String email, String cidade, String estado,
			double salario, double comissao) {
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
		this.email = email;
		this.cidade = cidade;
		this.estado = estado;
		this.salario = salario;
		this.comissao = comissao;

	}

	public Vendedor() {
		// TODO Auto-generated constructor stub
	}

	public void mostrarDadosVendedor() {
		System.out.println("DADOS DO VENDEDOR\n");
		System.out.println("Nome.....:" + nome + "\n");
		System.out.println("Matricula:" + matricula + "\n");
		System.out.println("Telefone.:" + telefone + "\n");
		System.out.println("Cidade...:" + cidade + "\n");
		System.out.println("Estado...:" + estado + "\n");
		System.out.println("Salario..:" + salario + "\n");
		System.out.println("Comissão.:" + comissao + "\n");
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
}

abstract class Funcionario {

	public String estado;
	public double salario;
	public String email;
	public String cidade;
	public String telefone;
	public int matricula;
	public String nome;

	abstract double calcularSalario();

}