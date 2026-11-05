package EstudoJogo;

import java.util.Scanner;

public class ExemploDoWhile {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner= new Scanner (System.in);
        int opcao;

        System.out.print("Carregando o jogo");
        for (int i = 0; i < 4; i++) {
            System.out.print(".");
            Thread.sleep(400); // Espera 400 milissegundos
        }
        
        // Simula o cursor piscando 3 vezes antes de abrir o menu
        for (int i = 0; i < 3; i++) {
            System.out.print("_");
            Thread.sleep(300);
            System.out.print("\b \b"); // Apaga o caractere
            Thread.sleep(300);
        }
        
        // Pula algumas linhas para limpar a tela antes do menu
        System.out.println("\n\n");



        do {
            System.out.println("=========  Menu =========\n");
            System.out.println("=======  1. Jogar =======\n");
            System.out.println("=======  2. Sair  =======\n");
            System.out.print("=== Escolha uma opção [ ]===\b\b\b\b\b");

            opcao = scanner.nextInt();        
            
        } while (opcao!=2);
        

        System.out.println("\nFim da aplicação\n");
        scanner.close();

        
        
    }

    
}
