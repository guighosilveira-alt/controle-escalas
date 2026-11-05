package Projeto_comunidade_ativa;
import java.util.Scanner;

// ==========================================
// PASSO 1: CLASSE DE DOMÍNIO DO USUÁRIO
// ==========================================
class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String bairro;

    public Usuario(String nome, String email, String telefone, String bairro) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.bairro = bairro;
    }

    // Métodos Getters para acessar os dados com segurança
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getBairro() { return bairro; }

    @Override
    public String toString() {
        return "----------------------------------------\n" +
               "Nome: " + nome + "\n" +
               "E-mail: " + email + "\n" +
               "Telefone: " + telefone + "\n" +
               "Bairro: " + bairro + "\n" +
               "----------------------------------------";
    }
}

// ==========================================
// PASSO 1: CLASSE PRINCIPAL (Ponto de Partida)
// ==========================================
public class SistemaSolicitacoes {
    private static Usuario usuarioLogado;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   BEM-VINDO AO PROJETO COMUNIDADE ATIVA");
        System.out.println("========================================");
        
        // Executa o cadastro obrigatório do usuário ao iniciar
        cadastrarUsuario();
        
        // Testando se o usuário foi cadastrado com sucesso exibindo o perfil dele
        System.out.println("\n[Teste] Dados cadastrados com sucesso:");
        System.out.println(usuarioLogado);
        
        scanner.close();
    }

    private static void cadastrarUsuario() {
        System.out.println("\n--- ETAPA 1: CADASTRO DO CIDADÃO ---");
        
        String nome = lerTextoObrigatorio("Informe seu nome completo: ");
        String email = lerTextoObrigatorio("Informe seu e-mail: ");
        String telefone = lerTextoObrigatorio("Informe seu telefone: ");
        String bairro = lerTextoObrigatorio("Informe seu bairro: ");

        // Cria o objeto usuário com os dados informados
        usuarioLogado = new Usuario(nome, email, telefone, bairro);
        
        System.out.println("\n[Sucesso] Seja bem-vindo(a), " + usuarioLogado.getNome() + "!");
    }

    // Método auxiliar para garantir que o usuário não deixe campos em branco (Requisito)
    private static String lerTextoObrigatorio(String mensagem) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.print(mensagem);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("[Campo Obrigatório] Este campo não pode ficar vazio. Tente novamente.");
            }
        }
        return texto;
    }
}
