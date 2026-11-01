import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Lanchonete {
    public static void main(String[] args) {
        // Passo 1: Montar o cardápio
        Map<Object, Object> cardapio = new HashMap<>();
        cardapio.put(101, "Café");
        cardapio.put(205, "Suco");
        cardapio.put(310, "Bolo");
        cardapio.put(420, "Sanduiche");

        // Passo 2: Localizar o produto pelo código
        int codigoInformado = 101;
        String produto = (String) cardapio.get(codigoInformado);

        if (produto == null) {
            System.out.println("Código " + codigoInformado + " inválido.");
        } else {
            System.out.println("Produto localizado: " + produto);

            //Passo 3: Registrar pedido na lista e adicionar á fila de produção
            List<Object> pedidosRegistrados = new ArrayList<>();
            Queue<Object> filaPreparacao = new LinkedList<>();

            pedidosRegistrados.add(produto);
            filaPreparacao.offer(produto);
            
            System.out.println("pedido registrado no histórico: " + pedidosRegistrados);
            System.out.println("Pedido adicionado à fila de preparo: " + filaPreparacao);

        }
    }
}