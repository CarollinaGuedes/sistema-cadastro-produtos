package SistemaDeLojaComProdutosVariados;

import java.math.BigDecimal;

public abstract class Produto {

    private String nome;
    private short quantidade;
    private BigDecimal preco;
    private StatusProduto status;

    public Produto(String nome, short quantidade, BigDecimal preco) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade nao pode ser negativa.");
        }
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preco nao pode ser nulo ou negativo.");
        }
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;

        atualizarStatusPorQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade nao pode ser negativa.");
        }
        this.quantidade = quantidade;

        atualizarStatusPorQuantidade(quantidade);
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preco nao pode ser nulo ou negativo.");
        }
        this.preco = preco;
    }

    public StatusProduto getStatus() {
        return status;
    }

    private void atualizarStatusPorQuantidade(short quantidade) {
        if (quantidade == 0) {
            this.status = StatusProduto.SEM_PREVISAO;
        } else {
            this.status = StatusProduto.ESTOQUE;
        }


    }

    public abstract String descricao();

    public abstract void descontoParaPagamentoAVista();
}
