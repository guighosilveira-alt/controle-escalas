package ComunidadeAtiva;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// --- CLASSE DE MODELO (Minimização de dados e encapsulamento) ---
class Solicitacao {
    private static int contadorId = 1;
    
    private int id;
    private String cidadaoNome;
    private String categoria; // Ex: Iluminação, Buracos, etc.
    private String bairro;
    private String descricao;
    private String status;
    private String dataCriacao;

    public Solicitacao(String cidadaoNome, String categoria, String bairro, String descricao) {
        this.id = contadorId++;
        this.cidadaoNome = cidadaoNome;
        this.categoria = categoria;
        this.bairro = bairro;
        this.descricao = descricao;
        this.status = "Registrada";
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataCriacao = dtf.format(LocalDateTime.now());
    }

    public int getId() { return id; }
    public String getCategoria() { return categoria; }
    public String getBairro() { return bairro; }
    public String getStatus() { return status; }
    
    public void setStatus(String status) { 
        this.status = status; 
    }

    @Override
    public String toString() {
        return String.format("[%d] Categoria: %s | Bairro: %s | Status: %s | Data: %s\nDescrição: %s (Por: %s)",
                id, categoria, bairro, status, dataCriacao, descricao, cidadaoNome);
    }
}

// --- CLASSE PRINCIPAL DO SISTEMA ---
public class ComunidadeAtivaApp {
    private static ArrayList<Object> bancoDeDados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        do {
            exibirMenu();
            try {
                String entrada = scanner.nextLine();
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1:
                        cadastrarSolicitacao();
                        break;
                    case 2:
                        consultarSolicitacoes();
                        break;
                    case 3:
                        atualizarStatus();
                        break;
                    case 4:
                        System.out.println("\n Encerrando o Comunidade Ativa. Obrigado por contribuir com a cidadania digital!");
                        break;
                    default:
                        System.out.println("\n Opção inválida. Escolha um número entre 1 e 4.");
                }
            } catch (NumberFormatException e) {
                opcao = 0;
                // Tratamento de exceção: garante mensagens compreensíveis para o usuário
                System.out.println("\n Erro: Por favor, digite apenas números válidos correspondentes ao menu.");
            }
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        } while (opcao != 4);
    }

    private static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("        SISTEMA COMUNIDADE ATIVA      ");
        System.out.println("========================================");
        System.out.println("1. Cadastrar nova solicitação");
        System.out.println("2. Consultar registros");
        System.out.println("3. Alterar status de uma solicitação");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarSolicitacao() {
    System.out.println("\n--- CADASTRO DE SOLICITAÇÃO ---");

    // Nome com validação iterativa
    String nome = "";
    while (true) {
        System.out.print("Nome do Morador: ");
        nome = scanner.nextLine().trim();
        try {
            validarCampoObrigatorio(nome, "Nome");
            break;
        } catch (IllegalArgumentException e) {
            System.out.println("\n[Erro] " + e.getMessage() + " Tente novamente.");
        }
    }

    // Menu selecionável para Categoria (já tratado anteriormente)
    String categoria = "";
    boolean categoriaValida = false;
    while (!categoriaValida) {
        System.out.println("\nSelecione a Categoria:");
        System.out.println("1. Iluminação");
        System.out.println("2. Buracos");
        System.out.println("3. Resíduos");
        System.out.println("4. Vazamentos");
        System.out.print("Digite o número da categoria (1-4): ");

        String opcaoCat = scanner.nextLine().trim();
        switch (opcaoCat) {
            case "1": categoria = "Iluminação"; categoriaValida = true; break;
            case "2": categoria = "Buracos"; categoriaValida = true; break;
            case "3": categoria = "Resíduos"; categoriaValida = true; break;
            case "4": categoria = "Vazamentos"; categoriaValida = true; break;
            default: System.out.println("\n[Erro] Opção inválida! Escolha um número entre 1 e 4.");
        }
    }

    // Bairro com validação iterativa
    String bairro = "";
    while (true) {
        System.out.print("Bairro: ");
        bairro = scanner.nextLine().trim();
        try {
            validarCampoObrigatorio(bairro, "Bairro");
            break;
        } catch (IllegalArgumentException e) {
            System.out.println("\n[Erro] " + e.getMessage() + " Tente novamente.");
        }
    }

    // Descrição com validação iterativa
    String descricao = "";
    while (true) {
        System.out.print("Descrição detalhada do problema: ");
        descricao = scanner.nextLine().trim();
        try {
            validarCampoObrigatorio(descricao, "Descrição");
            break;
        } catch (IllegalArgumentException e) {
            System.out.println("\n[Erro] " + e.getMessage() + " Tente novamente.");
        }
    }

    // Criando o registro no sistema
    Solicitacao nova = new Solicitacao(nome, categoria, bairro, descricao);
    bancoDeDados.add(nova);

    System.out.println("\n Sucesso! Solicitação gerada com o código ID: " + nova.getId());
}

    private static void consultarSolicitacoes() {
        System.out.println("\n--- CONSULTA DE REGISTROS ---");
        if (bancoDeDados.isEmpty()) {
            System.out.println(" Nenhuma solicitação cadastrada no momento.");
            return;
        }

        for (Object s : bancoDeDados) {
            System.out.println("----------------------------------------");
            System.out.println(s);
        }
        System.out.println("----------------------------------------");
    }

    private static void atualizarStatus() {
        System.out.println("\n--- ATUALIZAR STATUS ---");
        consultarSolicitacoes();
        
        if (bancoDeDados.isEmpty()) return;

        System.out.print("Digite o ID da solicitação que deseja atualizar: ");
        try {
            int idBusca = Integer.parseInt(scanner.nextLine());
            Solicitacao encontrada = null;

            for (Object s : bancoDeDados) {
                if (((Solicitacao) s).getId() == idBusca) {
                    encontrada = (Solicitacao) s;
                    break;
                }
            }

            if (encontrada == null) {
                System.out.println(" Atenção: Nenhuma solicitação foi encontrada com o ID informado.");
                return;
            }

            System.out.println("\nStatus disponíveis:");
            System.out.println("1. Registrada | 2. Em análise | 3. Encaminhada | 4. Concluída | 5. Cancelada");
            System.out.print("Escolha o novo status (1-5): ");
            int escolhaStatus = Integer.parseInt(scanner.nextLine());

            String novoStatus = switch (escolhaStatus) {
                case 1 -> "Registrada";
                case 2 -> "Em análise";
                case 3 -> "Encaminhada";
                case 4 -> "Concluída";
                case 5 -> "Cancelada";
                default -> throw new IllegalArgumentException("Opção de status inválida.");
            };

            encontrada.setStatus(novoStatus);
            System.out.println(" Status atualizado com sucesso para: " + novoStatus);

        } catch (Exception e) {
            System.out.println(" Erro ao atualizar status. Revise o valor informado.");
        }
    }

    private static void validarCampoObrigatorio(String valor, String nomeCampo) {
        if (valor == null || valor.isEmpty()) {
            throw new IllegalArgumentException("O campo '" + nomeCampo + "' é obrigatório e não pode estar vazio.");
        }
    }
}
