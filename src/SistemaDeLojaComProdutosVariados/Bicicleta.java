package SistemaDeLojaComProdutosVariados;

import java.math.BigDecimal;

public class Bicicleta extends Produto implements Desconto {

    private String fabricante;
    private String cor;
    private String tipoDeFreio;
    private String quadro;
    private int aro;
    private int quantidadeDeMarchas;

    public Bicicleta(String nome, short quantidade, BigDecimal preco,
                     String fabricante, String cor, String tipoDeFreio,
                     String quadro, int aro, int quantidadeDeMarchas) {
        super(nome, quantidade, preco);

        if (aro <= 0) {
            throw new IllegalArgumentException("O tamanho do aro deve ser maior que zero.");
        }
        if (quantidadeDeMarchas <= 0) {
            throw new IllegalArgumentException("A quantidade de marchas deve ser maior que zero.");
        }

        this.fabricante = fabricante;
        this.cor = cor;
        this.tipoDeFreio = tipoDeFreio;
        this.quadro = quadro;
        this.aro = aro;
        this.quantidadeDeMarchas = quantidadeDeMarchas;
    }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getTipoDeFreio() { return tipoDeFreio; }
    public void setTipoDeFreio(String tipoDeFreio) { this.tipoDeFreio = tipoDeFreio; }

    public String getQuadro() { return quadro; }
    public void setQuadro(String quadro) { this.quadro = quadro; }

    public int getAro() { return aro; }

    public void setAro(int aro) {
        if (aro <= 0) {
            throw new IllegalArgumentException("O tamanho do aro deve ser maior que zero.");
        }
        this.aro = aro;
    }

    public int getQuantidadeDeMarchas() { return quantidadeDeMarchas; }

    public void setQuantidadeDeMarchas(int quantidadeDeMarchas) {
        if (quantidadeDeMarchas <= 0) {
            throw new IllegalArgumentException("A quantidade de marchas deve ser maior que zero.");
        }
        this.quantidadeDeMarchas = quantidadeDeMarchas;
    }

    public String descricao() {
        return String.format("Bicicleta %s | Cor: %s | Freio: %s | Quadro: %s | Aro: %d | Marchas: %d",
                fabricante, cor, tipoDeFreio, quadro, aro, quantidadeDeMarchas);
    }

    @Override
    public void descontoParaPagamentoAVista() {
        BigDecimal percentual = new BigDecimal("0.15");
        BigDecimal desconto = getPreco().multiply(percentual);
        BigDecimal precoFinal = getPreco().subtract(desconto);
        setPreco(precoFinal);
        System.out.println("Desconto de 15% aplicado na Bicicleta. Novo preço: R$ " + precoFinal);
    }
}
