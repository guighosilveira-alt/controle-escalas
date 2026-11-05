import java.util.Scanner;

public class MaiorNoArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[5];

        System.out.println("=== MAIOR VALOR NO ARRAY ===");
        System.out.println("Digite 5 números inteiros:");

        for (int i = 0; i < valores.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            valores[i] = scanner.nextInt();
        }

        // Assume inicialmente que o primeiro elemento é o maior
        int maior = valores[0];

        // Percorre o array a partir do segundo elemento
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] > maior) {
                maior = valores[i];
            }
        }

        System.out.println("\nO maior valor informado foi: " + maior);
        scanner.close();
    }
}
