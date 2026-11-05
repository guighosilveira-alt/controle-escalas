import java.util.InputMismatchException;
import java.util.Scanner;

public class CodeMarket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] nomes = new String[5];
        int[] quantidades = new int[5];

        System.out.println("=== Bem-vindo ao Sistema CodeMarket ===");
        
        // Passo 2: Cadastro dos produtos
        cadastrarProdutos(nomes, quantidades, scanner);

        // Passo 5: Apresentação do relatório completo
        exibirRelatorio(nomes, quantidades);

        scanner.close();
    }

    // Método para cadastrar os produtos com todas as validações exigidas
    public static void cadastrarProdutos(String[] nomes, int[] quantidades, Scanner scanner) {
        for (int i = 0; i < 5; i++) {
            System.out.println("\n--- Cadastro do " + (i + 1) + "º produto ---");
            
            // Validação de nome vazio
            while (true) {
                System.out.print("Digite o nome do produto: ");
                nomes[i] = scanner.nextLine();
                
                if (nomes[i].trim().isEmpty()) {
                    System.out.println("Erro: O nome do produto não pode ser vazio. Tente novamente.");
                } else {
                    break;
                }
            }

            // Validação de quantidade (número inteiro e não negativa)
            while (true) {
                System.out.print("Digite a quantidade em estoque: ");
                try {
                    quantidades[i] = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado

                    if (quantidades[i] < 0) {
                        System.out.println("Erro: A quantidade não pode ser negativa. Tente novamente.");
                    } else {
                        break; // Entrada válida, sai do loop
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite apenas números inteiros válidos.");
                    scanner.nextLine(); // Limpa a entrada inválida do scanner
                }
            }
        }
    }

    // Método para calcular o total de itens no estoque
    public static int calcularTotalItens(int[] quantidades) {
        int total = 0;
        for (int qtd : quantidades) {
            total += qtd;
        }
        return total;
    }

    // Método para identificar e exibir produtos com menos de 5 unidades
    public static void verificarProdutosCriticos(String[] nomes, int[] quantidades) {
        System.out.println("\n--- Alerta de Estoque Baixo (< 5 unidades) ---");
        boolean encontrouCritico = false;
        
        for (int i = 0; i < nomes.length; i++) {
            if (quantidades[i] < 5) {
                System.out.println("-> " + nomes[i] + " (Apenas " + quantidades[i] + " unidades)");
                encontrouCritico = true;
            }
        }
        
        if (!encontrouCritico) {
            System.out.println("Nenhum produto com estoque crítico no momento.");
        }
    }

    // Método para organizar e apresentar o relatório final
    public static void exibirRelatorio(String[] nomes, int[] quantidades) {
        System.out.println("\n========================================");
        System.out.println("          RELATÓRIO CODEMARKET          ");
        System.out.println("========================================");
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Produto: " + nomes[i] + " | Quantidade: " + quantidades[i]);
        }
        
        System.out.println("----------------------------------------");
        int totalGeral = calcularTotalItens(quantidades);
        System.out.println("Total geral de itens no estoque: " + totalGeral);
        
        verificarProdutosCriticos(nomes, quantidades);
        System.out.println("========================================");
    }
}