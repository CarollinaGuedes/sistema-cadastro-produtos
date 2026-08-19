package SistemaDeLojaComProdutosVariados;

import java.math.BigDecimal;

public class Livro extends Produto implements Desconto {

    private String titulo;
    private String autor;
    private String editora;
    private String categoria;
    private int faixaEtaria;
    private int totalDePaginas;
    private int ano;

    public Livro(String nome, short quantidade, BigDecimal preco,
                 String titulo, String autor, String editora, String categoria,
                 int faixaEtaria, int totalDePaginas, int ano) {
        super(nome, quantidade, preco);

        if (totalDePaginas <= 0) {
            throw new IllegalArgumentException("O total de paginas deve ser maior que zero.");
        }
        if (ano <= 0) {
            throw new IllegalArgumentException("O ano de publicacao deve ser maior que zero.");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
        this.faixaEtaria = faixaEtaria;
        this.totalDePaginas = totalDePaginas;
        this.ano = ano;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getFaixaEtaria() { return faixaEtaria; }
    public void setFaixaEtaria(int faixaEtaria) { this.faixaEtaria = faixaEtaria; }

    public int getTotalDePaginas() { return totalDePaginas; }

    public void setTotalDePaginas(int totalDePaginas) {
        if (totalDePaginas <= 0) {
            throw new IllegalArgumentException("O total de paginas deve ser maior que zero.");
        }
        this.totalDePaginas = totalDePaginas;
    }

    public int getAno() { return ano; }

    public void setAno(int ano) {
        if (ano <= 0) {
            throw new IllegalArgumentException("O ano de publicacao deve ser maior que zero.");
        }
        this.ano = ano;
    }

    public String descricao() {
        return String.format("Livro: %s | Autor: %s | Editora: %s | Categoria: %s | %d páginas | Ano: %d | Faixa etária: %d+",
                titulo, autor, editora, categoria, totalDePaginas, ano, faixaEtaria);
    }

    @Override
    public void descontoParaPagamentoAVista() {
        BigDecimal percentual = new BigDecimal("0.10");
        BigDecimal desconto = getPreco().multiply(percentual);
        BigDecimal precoFinal = getPreco().subtract(desconto);
        setPreco(precoFinal);
        System.out.println("Desconto de 10% aplicado no Livro. Novo preço: R$ " + precoFinal);
    }
}
