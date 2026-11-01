package VALIDADOR_DE_SENHAS;

import java.util.Scanner;

public class Formulario {
    public static void executar(Scanner scanner) {
            System.out.println("=============================================================================");
            System.out.println("============================ Bem vindo ao formulário=========================");
            System.out.println("=============================================================================");
    
            System.out.print("Digite o seu nome completo: ");
            String nome = scanner.nextLine();
    
            System.out.print("Digite o seu endereço: ");
            String endereco = scanner.nextLine();
    
            System.out.print("Digite o seu e-mail: ");
            String email = scanner.nextLine();
    
            System.out.println("\n *********************** Cadastro concluído com sucesso *********************");
            System.out.println("Usuário: " + nome + "\n" + "Endereço: " + endereco + "\n" + "E-mail: " + email + "\n"); 
            System.out.println("*****************************************************************************" +"\n"); 
           
        
    }
    
}
