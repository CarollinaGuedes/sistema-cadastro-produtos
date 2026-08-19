package SistemaDeLojaComProdutosVariados;

import java.math.BigDecimal;

public class Console extends Produto implements Desconto {

    private String nomeFabricante;
    private String modelo;
    private int memoria;
    private boolean consoleDeMesa;

    public Console(String nome, short quantidade, BigDecimal preco,
                   String nomeFabricante, String modelo, int memoria,
                   boolean consoleDeMesa) {
        super(nome, quantidade, preco);

        if (memoria <= 0) {
            throw new IllegalArgumentException("A memoria do console deve ser maior que zero.");
        }

        this.nomeFabricante = nomeFabricante;
        this.modelo = modelo;
        this.memoria = memoria;
        this.consoleDeMesa = consoleDeMesa;
    }

    public String getNomeFabricante() { return nomeFabricante; }
    public void setNomeFabricante(String nomeFabricante) { this.nomeFabricante = nomeFabricante; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getMemoria() { return memoria; }

    public void setMemoria(int memoria) {
        if (memoria <= 0) {
            throw new IllegalArgumentException("A memoria do console deve ser maior que zero.");
        }
        this.memoria = memoria;
    }

    public boolean isConsoleDeMesa() { return consoleDeMesa; }
    public void setConsoleDeMesa(boolean consoleDeMesa) { this.consoleDeMesa = consoleDeMesa; }

    public String descricao() {
        return String.format("Console %s %s | Memória: %dGB | Tipo: %s",
                nomeFabricante, modelo, memoria,
                consoleDeMesa ? "De Mesa" : "Portátil");
    }

    @Override
    public void descontoParaPagamentoAVista() {
        BigDecimal percentual = new BigDecimal("0.10");
        BigDecimal desconto = getPreco().multiply(percentual);
        BigDecimal precoFinal = getPreco().subtract(desconto);
        setPreco(precoFinal);
        System.out.println("Desconto de 10% (Pix) aplicado no Console. Novo preço: R$ " + precoFinal);
    }
}
