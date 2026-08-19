package SistemaDeLojaComProdutosVariados;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========== LOJA DE PRODUTOS VARIADOS ==========");
            System.out.println("1 - Cadastrar Notebook");
            System.out.println("2 - Cadastrar Bicicleta");
            System.out.println("3 - Cadastrar Console");
            System.out.println("4 - Cadastrar Livro");
            System.out.println("5 - Cadastrar Televisor");
            System.out.println("6 - Listar todos os produtos");
            System.out.println("7 - Aplicar desconto à vista em todos");
            System.out.println("8 - Ver descrição detalhada dos produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        service.cadastroDeNotebook();
                        System.out.println("✓ Notebook cadastrado com sucesso!");
                        break;
                    case 2:
                        service.cadastroDeBicicleta();
                        System.out.println("✓ Bicicleta cadastrada com sucesso!");
                        break;
                    case 3:
                        service.cadastrarConsole();
                        System.out.println("✓ Console cadastrado com sucesso!");
                        break;
                    case 4:
                        service.cadastrarLivro();
                        System.out.println("✓ Livro cadastrado com sucesso!");
                        break;
                    case 5:
                        service.cadastrarTelevisor();
                        System.out.println("✓ Televisor cadastrado com sucesso!");
                        break;
                    case 6:
                        listarProdutos(service);
                        break;
                    case 7:
                        aplicarDescontoEmTodos(service);
                        break;
                    case 8:
                        mostrarDescricoes(service);
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema... Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nERRO DE VALIDAÇÃO: " + e.getMessage());
                System.out.println("O produto não foi cadastrado. Tente novamente com dados corretos.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void listarProdutos(Service service) {
        if (service.getProdutos().isEmpty()) {
            System.out.println("\nNenhum produto cadastrado ainda.");
            return;
        }

        System.out.println("\n========== LISTA DE PRODUTOS ==========");
        int contador = 1;
        for (Produto produto : service.getProdutos()) {
            System.out.println("-------------------------------------");
            System.out.println("Produto #" + contador++);
            System.out.println(produto.toString());
            System.out.println("Tipo: " + produto.getClass().getSimpleName());
        }
        System.out.println("-------------------------------------");
    }

    private static void aplicarDescontoEmTodos(Service service) {
        if (service.getProdutos().isEmpty()) {
            System.out.println("\nNenhum produto cadastrado para aplicar desconto.");
            return;
        }

        System.out.println("\nAplicando descontos...");
        for (Produto produto : service.getProdutos()) {
            System.out.println("\n→ " + produto.getNome());
            produto.descontoParaPagamentoAVista();
        }
        System.out.println("\nDescontos applied com sucesso!");
    }

    private static void mostrarDescricoes(Service service) {
        if (service.getProdutos().isEmpty()) {
            System.out.println("\nNenhum produto cadastrado.");
            return;
        }

        System.out.println("\n========== DESCRIÇÕES DETALHADAS ==========");
        for (Produto produto : service.getProdutos()) {
            System.out.println("-------------------------------------");
            System.out.println(produto.descricao());
            System.out.println("Preço atual: R$ " + produto.getPreco());
        }
        System.out.println("-------------------------------------");
    }
}
