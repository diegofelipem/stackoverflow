package swing.examples9.test;

import java.util.Date;

public class MatriculaModel {
	
    private boolean selecionado;
    private String nome;
    private Date data;

    public boolean getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


}