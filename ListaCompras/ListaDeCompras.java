package ListaCompras;

import java.util.ArrayList;

abstract class Produto {
    protected String nome;
    protected double preco;

    public Produto (String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }

    public abstract String getDetalhes();

}
 
interface Validade {
    String verificarValidade();
}

class ProdutoAlimenticio extends Produto implements Validade {
    private String dataValidade;

    public ProdutoAlimenticio(String nome, double preco, String dataValidade) {
        super(nome, preco);
        this.dataValidade = dataValidade;
    }

    @Override 
    public String getDetalhes() {
        return "Alimentício: " + nome + " - R$ " + preco + " (Validade: " + dataValidade + ")";

    }

    @Override 
    public String verificarValidade() {
        return "Produto perecível. Consumir até " + dataValidade + "\n";
    }

}

class ProdutoLimpeza extends Produto {
    private String setor;

    public ProdutoLimpeza(String nome, double preco, String setor) {
        super(nome, preco);
        this.setor = setor;
    }

    @Override 
    public String getDetalhes() {
        return "LImpeza: " + nome + " -R$ " + preco + " (Setor: " + setor + ")";

    }

}

public class ListaDeCompras {
    public static void main(String[] args) {        

        ArrayList<Produto> carrinho = new ArrayList<>();

        System.out.println("\n============= Suas compras aqui ===========\n\n");
        
        carrinho.add(new ProdutoAlimenticio ("Arroz", 25.90, "10/12/2027"));
        carrinho.add(new ProdutoAlimenticio ("Feijão", 8.90, "15/08/2027"));
        carrinho.add(new ProdutoLimpeza("Desinfetante", 6.50, "Casa e Banheiro"));
        carrinho.add(new ProdutoAlimenticio ("Sal", 1.90, "10/10/2027"));
        carrinho.add(new ProdutoAlimenticio ("Refrigerante", 4.90, "05/08/2027"));
        carrinho.add(new ProdutoLimpeza("Detergente", 1.50, "Casa e Banheiro"));

        System.out.println("===== Carrinho de Compras Inteligente =====\n\n");

        for (Produto p : carrinho) {
            System.out.println("- " + p.getDetalhes());

            if(p instanceof Validade) {
                Validade v = (Validade) p;
                System.out.println(" -> " + v.verificarValidade());

            }
        }

        System.out.println("\nTotal de ítens no carrinho: " + carrinho.size() + "\n");

        System.out.println("\n=============================================\n");
        
    }
}
        
        
        