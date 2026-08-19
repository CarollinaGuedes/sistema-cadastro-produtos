package SistemaDeLojaComProdutosVariados;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Produto> produtos = new ArrayList<>();

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }


    public void cadastroDeNotebook() {
        String nome = lerTexto("Qual o nome do produto: ");
        short quantidade = lerQuantidade("Quantidade de Notebooks: ");
        BigDecimal preco = lerPreco("Qual o preço do notebook R$: ");
        String marca = lerTexto("Qual a marca do notebook: ");
        String processador = lerTexto("Qual o tipo de processador: ");
        boolean ssd = lerBooleano("A memória é do tipo SSD? (true/false): ");
        int memoriaRam = lerInteiro("Qual é a memória RAM (GB): ");
        int polegadas = lerInteiro("Qual o tamanho da tela (polegadas): ");

        Notebook notebook = new Notebook(nome, quantidade, preco, marca,
                processador, ssd, memoriaRam, polegadas);
        produtos.add(notebook);
    }

    public void cadastroDeBicicleta() {
        String nome = lerTexto("Qual o nome da bicicleta: ");
        short quantidade = lerQuantidade("Quantidade de Bicicletas: ");
        BigDecimal preco = lerPreco("Qual o preço da Bicicleta R$: ");
        String fabricante = lerTexto("Qual o nome do Fabricante: ");
        String cor = lerTexto("Qual a cor escolhida: ");
        String tipoFreio = lerTexto("Qual o tipo de freio: ");
        String tipoQuadro = lerTexto("Qual o tipo do quadro: ");
        int tamanhoAro = lerInteiro("Qual o aro: ");
        int quantidadeMarchas = lerInteiro("Qual a quantidade de marchas: ");

        Bicicleta bicicleta = new Bicicleta(nome, quantidade, preco, fabricante, cor,
                tipoFreio, tipoQuadro, tamanhoAro, quantidadeMarchas);
        produtos.add(bicicleta);
    }

    public void cadastrarConsole() {
        String nome = lerTexto("Qual o nome do console: ");
        short quantidade = lerQuantidade("Quantidade de Video Games: ");
        BigDecimal preco = lerPreco("Qual o preço do Video Game R$: ");
        String fabricante = lerTexto("Qual o nome do Fabricante: ");
        String modelo = lerTexto("Qual o modelo do Video Game: ");
        int memoria = lerInteiro("Qual a memória do console (GB): ");
        boolean tipoConsole = lerBooleano("É um console de mesa? (true/false): ");

        Console console = new Console(nome, quantidade, preco, fabricante,
                modelo, memoria, tipoConsole);
        produtos.add(console);
    }

    public void cadastrarLivro() {
        String nome = lerTexto("Qual o nome do produto (Livro): ");
        short quantidade = lerQuantidade("Quantidade de livros: ");
        BigDecimal preco = lerPreco("Qual o preço do livro R$: ");
        String titulo = lerTexto("Qual o título do livro: ");
        String autor = lerTexto("Qual o nome do Autor: ");
        String editora = lerTexto("Qual o nome da editora: ");
        String categoria = lerTexto("Qual a categoria: ");
        int faixaEtaria = lerInteiro("Qual a faixa etária: ");
        int quantidadePaginas = lerInteiro("Quantas páginas esse livro possui: ");
        int anoLancamento = lerInteiro("Qual o ano de lançamento: ");

        Livro livro = new Livro(nome, quantidade, preco, titulo, autor,
                editora, categoria, faixaEtaria, quantidadePaginas, anoLancamento);
        produtos.add(livro);
    }

    public void cadastrarTelevisor() {
        String nome = lerTexto("Qual o nome da Televisão: ");
        short quantidade = lerQuantidade("Quantidade de Tvs: ");
        BigDecimal preco = lerPreco("Qual o preço da Televisão R$: ");
        int polegadas = lerInteiro("Quantas polegadas possui o televisor: ");
        String fabricante = lerTexto("Qual o nome do Fabricante: ");
        boolean tipoTv = lerBooleano("É uma Smart TV? (true/false): ");
        int anoFabricacao = lerInteiro("Qual o ano de fabricação: ");

        Televisor tv = new Televisor(nome, quantidade, preco, polegadas,
                fabricante, tipoTv, anoFabricacao);
        produtos.add(tv);
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private short lerQuantidade(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                short quantidade = scanner.nextShort();
                scanner.nextLine();
                return quantidade;
            } catch (java.util.InputMismatchException e) {
                System.out.println(" Erro: Digite apenas números inteiros para a quantidade!");
                scanner.nextLine();
            }
        }
    }

    private BigDecimal lerPreco(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = scanner.nextLine();
                entrada = entrada.replace(",", ".");
                return new BigDecimal(entrada);
            } catch (NumberFormatException e) {
                System.out.println(" Erro: Formato de preço inválido! Use apenas números (Ex: 1500.50 ou 1500,50)");
            }
        }
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (java.util.InputMismatchException e) {
                System.out.println(" Erro: Digite apenas números inteiros válidos!");
                scanner.nextLine();
            }
        }
    }

    private boolean lerBooleano(String message) {
        while (true) {
            System.out.print(message);
            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.equals("true") || entrada.equals("sim") || entrada.equals("s")) {
                return true;
            } else if (entrada.equals("false") || entrada.equals("não") || entrada.equals("nao") || entrada.equals("n")) {
                return false;
            } else {
                System.out.println(" Erro: Digite apenas true (sim) ou false (não)!");
            }
        }
    }


}