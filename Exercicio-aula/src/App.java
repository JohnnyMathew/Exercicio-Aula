import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Gerenciador de Produtos!");

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    removerProdutoPorNome();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Remover Produto por Nome");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarProduto() {
        System.out.println("\n--- ADICIONAR PRODUTO ---");
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        Produto novoProduto = new Produto(nome, quantidade, categoria);
        listaProdutos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void listarProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }

    private static void removerProdutoPorNome() {
        System.out.println("\n--- REMOVER PRODUTO ---");
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado para remover.");
            return;
        }

        System.out.print("Digite o nome do produto a ser removido: ");
        String nome = scanner.nextLine();

        boolean removido = false;
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
                listaProdutos.remove(i);
                removido = true;
                System.out.println("Produto removido com sucesso!");
                break;
            }
        }

        if (!removido) {
            System.out.println("Produto não encontrado com o nome: " + nome);
        }
    }
}