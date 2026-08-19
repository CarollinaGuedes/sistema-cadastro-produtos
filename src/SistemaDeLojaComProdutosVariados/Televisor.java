package SistemaDeLojaComProdutosVariados;

import java.math.BigDecimal;

public class Televisor extends Produto implements Desconto {

    private int telaPolegadas;
    private String fabricante;
    private boolean smartTv;
    private int anoFabricacao;

    public Televisor(String nome, short quantidade, BigDecimal preco,
                     int telaPolegadas, String fabricante, boolean smartTv,
                     int anoFabricacao) {
        super(nome, quantidade, preco);

        if (telaPolegadas <= 0) {
            throw new IllegalArgumentException("O tamanho da tela deve ser maior que zero.");
        }
        if (anoFabricacao <= 0) {
            throw new IllegalArgumentException("O ano de fabricacao deve ser maior que zero.");
        }

        this.telaPolegadas = telaPolegadas;
        this.fabricante = fabricante;
        this.smartTv = smartTv;
        this.anoFabricacao = anoFabricacao;
    }

    public int getTelaPolegadas() { return telaPolegadas; }

    public void setTelaPolegadas(int telaPolegadas) {
        if (telaPolegadas <= 0) {
            throw new IllegalArgumentException("O tamanho da tela deve ser maior que zero.");
        }
        this.telaPolegadas = telaPolegadas;
    }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public boolean isSmartTv() { return smartTv; }
    public void setSmartTv(boolean smartTv) { this.smartTv = smartTv; }

    public int getAnoFabricacao() { return anoFabricacao; }

    public void setAnoFabricacao(int anoFabricacao) {
        if (anoFabricacao <= 0) {
            throw new IllegalArgumentException("O ano de fabricacao deve ser maior que zero.");
        }
        this.anoFabricacao = anoFabricacao;
    }

    public String descricao() {
        return String.format("TV %s | %d\" | Smart TV: %s | Ano: %d",
                fabricante, telaPolegadas, smartTv ? "Sim" : "Não", anoFabricacao);
    }

    @Override
    public void descontoParaPagamentoAVista() {
        BigDecimal percentual = new BigDecimal("0.15");
        BigDecimal desconto = getPreco().multiply(percentual);
        BigDecimal precoFinal = getPreco().subtract(desconto);
        setPreco(precoFinal);
        System.out.println("Desconto de 15% aplicado no Televisor. Novo preço: R$ " + precoFinal);
    }
}
