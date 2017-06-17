package questions.q_159314;

class Produto {

    private String produto;
    private Double valor;
    private Integer qnt;

    public Produto() {
    }

    public Produto(String produto, Double valor, Integer qnt) {
        this.produto = produto;
        this.valor = valor;
        this.qnt = qnt;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
