package Exercicios_Imc;

import java.util.Scanner;

public class ExerciciosImc {
    /**
     * @param args
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("=== CALCULADORA DE IMC ===");
        System.out.println("Digite 0 no peso a qualquer momento para sair.\n");

        // O laço while continuará rodando enquanto o peso for diferente de 0
        System.out.print("Digite o seu peso (kg) [0 para sair]: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Erro: Digite apenas números válidos!");
            scanner.next(); // Descarta a entrada inválida
            System.out.print("Digite o seu peso (kg) [0 para sair]: ");
        }        
        
        double peso = scanner.nextDouble();
    
        while (peso != 0) {                                         
            System.out.print("Digite sua altura (m): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Erro: Digite apenas números válidos para a altura!");
                scanner.next();
                System.out.print("Digite sua altura (m): ");
            }
            final double altura = scanner.nextDouble();

            final double imc = peso / (altura * altura) ;

            System.out.printf("Seu IMC é: %.2f\n",imc);

            if (imc < 18.5) {
                System.out.println("Classificação: abaixo do peso\n");            
            } else if (imc <= 24.9) {
                System.out.println("Classificação: peso normal\n");            
            } else if (imc <=29.9) {
                System.out.println("Classificação: sobrepeso\n");                        
            } else
                System.out.println("Classificação: obesidade.\n");
            

            System.out.print("Digite o seu peso (kg) [0 para sair]: ");
            peso = scanner.nextDouble();        
        }
        
        System.out.println("Programa encerrado. Até mais!");
        scanner.close();   
    }
    
}
