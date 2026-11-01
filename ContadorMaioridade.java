import java.util.Scanner;

public class ContadorMaioridade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maioresDeIdade = 0;
        int idade = 0;

        System.out.println("=== CONTADOR DE MAIORIDADE ===");
        System.out.println("Digite as idades (informe um número negativo para encerrar):");

        while (true) {
            System.out.print("Digite a idade: ");
            if (scanner.hasNextInt()) {
                idade = scanner.nextInt();
                if (idade < 0) {
                    break;
                }
                if (idade >= 18) {
                    maioresDeIdade++;
                }
            } else {
                System.out.println("Erro: Digite um número inteiro válido.");
                scanner.next();
            }
        }

        System.out.println("\nTotal de pessoas maiores de idade: " + maioresDeIdade);
        scanner.close();
    }
}