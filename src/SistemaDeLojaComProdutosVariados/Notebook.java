package SistemaDeLojaComProdutosVariados;

import java.math.BigDecimal;

public class Notebook extends Produto implements Desconto {

    private String marca;
    private String processador;
    private boolean ssd;
    private int memoriaRam;
    private int tela;

    public Notebook(String nome, short quantidade, BigDecimal preco,
                    String marca, String processador, boolean ssd,
                    int memoriaRam, int tela) {
        super(nome, quantidade, preco);

        if (memoriaRam <= 0) {
            throw new IllegalArgumentException("A memoria RAM deve ser maior que zero.");
        }
        if (tela <= 0) {
            throw new IllegalArgumentException("O tamanho da tela deve ser maior que zero.");
        }

        this.marca = marca;
        this.processador = processador;
        this.ssd = ssd;
        this.memoriaRam = memoriaRam;
        this.tela = tela;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getProcessador() { return processador; }
    public void setProcessador(String processador) { this.processador = processador; }

    public boolean isSsd() { return ssd; }
    public void setSsd(boolean ssd) { this.ssd = ssd; }

    public int getMemoriaRam() { return memoriaRam; }

    public void setMemoriaRam(int memoriaRam) {
        if (memoriaRam <= 0) {
            throw new IllegalArgumentException("A memoria RAM deve ser maior que zero.");
        }
        this.memoriaRam = memoriaRam;
    }

    public int getTela() { return tela; }

    public void setTela(int tela) {
        if (tela <= 0) {
            throw new IllegalArgumentException("O tamanho da tela deve ser maior que zero.");
        }
        this.tela = tela;
    }

    public String descricao() {
        return String.format("Notebook %s | Processador: %s | SSD: %s | RAM: %dGB | Tela: %d\"",
                marca, processador, ssd ? "Sim" : "Não", memoriaRam, tela);
    }

    @Override
    public void descontoParaPagamentoAVista() {
        BigDecimal percentual = new BigDecimal("0.10");
        BigDecimal desconto = getPreco().multiply(percentual);
        BigDecimal precoFinal = getPreco().subtract(desconto);
        setPreco(precoFinal);
        System.out.println("Desconto de 10% aplicado no Notebook. Novo preço: R$ " + precoFinal);
    }
}
