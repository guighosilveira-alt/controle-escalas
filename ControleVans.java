import java.util.Scanner;

public class ControleVans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String rota = "";
        String motorista = "";
        int lotacao = 16;
        int totalPassageiros = 0;

        System.out.println("==== Bem vindo ao controle vans Bourbon Country ===");
        System.out.println("\n* Tecle enter para iniciar ou digite esc para sair *");
        
        String inicio = scanner.nextLine().trim();
        if (inicio.equalsIgnoreCase("esc")) {
            System.out.println("Aplicação encerrada.");
            scanner.close();
            return;
        }

        System.out.println("********* INSIRA OS DADOS ********");

        System.out.print("\ninsira a rota ou digite esc para sair: ");
        rota = scanner.nextLine().trim();
        if (rota.equalsIgnoreCase("esc")) {
            System.out.println("Aplicação encerrada.");
            scanner.close();
            return;
        }
        System.out.println("rota cadastrada: " + rota);

        System.out.print("\nInsira o nome do motorista ou digite esc para sair: ");
        motorista = scanner.nextLine().trim();
        if (motorista.equalsIgnoreCase("esc")) {
            System.out.println("Aplicação encerrada.");
            scanner.close();
            return;
        }
        System.out.println("Motorista: " + motorista);

        System.out.print("\nInsira a lotação: ");
        String entradaLotacao = scanner.nextLine().trim();
        
        if (!entradaLotacao.isEmpty()) {
            try{
                lotacao = Integer.parseInt(entradaLotacao);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Mantendo a lotação padrão de " + lotacao);
            }
            
        }
        System.out.println("Lotação definida: " + lotacao);

        System.out.print("\n********CADASTRO DE PASSAGEIROS********");
        System.out.println("\nDigite o nome do passageiro e tecle enter:");
        
        while (totalPassageiros < lotacao) {
            System.out.println("Passageiro " + (totalPassageiros + 1) + "/" + lotacao + ": ");
            String nomePassageiro = scanner.nextLine().trim();

            if (nomePassageiro.equalsIgnoreCase("esc") || nomePassageiro.isEmpty()) {
                break;
            }

            totalPassageiros++;
            System.out.println("-> Passageiro " + nomePassageiro + " cadastrado com sucesso.");
        }

        System.out.println("\n------------------------------------------------------------");
        System.out.println("Resumo ds viagem:");
        System.out.println("Rota: " + rota);
        System.out.println("Motorista: " + motorista);
        System.out.println("Lotação máxima: " + lotacao);
        System.out.println("Total de passageiros cadastrados: " + totalPassageiros);
        System.out.println("-----------------------------------------------------");

        scanner.close();

    }
}
