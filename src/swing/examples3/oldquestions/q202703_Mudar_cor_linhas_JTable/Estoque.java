package swing.examples3.oldquestions.q202703_Mudar_cor_linhas_JTable;

public class Estoque {
	
    private String nomeProduto;
    private int saldo;

    public Estoque(String nomeProduto, int saldo) {
        this.nomeProduto = nomeProduto;
        this.saldo = saldo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}

