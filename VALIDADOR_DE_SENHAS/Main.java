package VALIDADOR_DE_SENHAS;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Lê o conteùdo digitado até senha válida
        Scanner scanner = new Scanner(System.in);
        boolean senhaValida = false;

        System.out.print("=======================================================================" + "\n");
        System.out.print("======================     SISTEMA DE VALIDAÇÃO     ===================" + "\n");
        System.out.print("=======================================================================" +"\n");
        System.out.print("===== DIGITE UMA SENHA OU DIGITE 'SAIR' PARA ENCERRAR A APLICAÇÃO =====" +"\n");
        System.out.print("=======================================================================" + "\n");
        //Enquanto senha inválida
        while(!senhaValida){
            System.out.print("Digite a sua senha: ");
            String senha = scanner.nextLine();

            if(senha.equalsIgnoreCase("sair")){
                System.out.println("\nPrograma encerrado pelo usuário. Até logo!");
                scanner.close();
                return;
            }         
        
            //Se senha válida
            if (validarSenha(senha)) {
                System.out.println("Senha aceita! Redirecionando para o sistema...");
                senhaValida = true;
            
            Formulario.executar(scanner);
            //Senão
            } else {
                System.out.println("\nSenha negada! Verifique se a senha contém:");
                System.out.println("No mínimo 8 caracteres");
                System.out.println("Pelo menos uma letra maiúscula");
                System.out.println("Pelo menos uma letra minuscula");
                System.out.println("Pelo menos um número");
                System.out.println("Pelo menos um caractere especial\n");
                System.out.println("Tente novamente ou digite 'sair'.\n");
            }
        }
        
        scanner.close();
    }
    //Método para senha com no mínimo 8 caracteres(maiúsculo, minúsculo, especial, dígito)
    public static boolean validarSenha(String senha){
        if (senha.length() < 8){
            return false;
        }

        boolean letraMaiuscula = false;
        boolean letraMinuscula = false;
        boolean caracterEspecial = false;
        boolean digito = false;

        for(char c : senha.toCharArray()){
            if(Character.isUpperCase(c)){
                letraMaiuscula = true;
            }else if (Character.isLowerCase(c)){
                letraMinuscula = true;
            }else if (Character.isDigit(c)){
                digito = true;
            }else if (!Character.isLetterOrDigit(c)){
                caracterEspecial = true;
            }
        }

        return letraMaiuscula && letraMinuscula && digito && caracterEspecial;

    }

    
}
