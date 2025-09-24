package exc6;
//Imutabilidade e Objetos de Valor (Carrinho de Compras)
//Crie o objeto de valor imutável Dinheiro (valor BigDecimal e enum Moeda)
//com equals/hashCode coerentes. Modele Produto, ItemCarrinho e um Carrinho
//cuja lista de itens seja imutável: operações de adicionar/remover/aplicar
//cupom retornam um novo carrinho. Valide quantidades > 0, proiba valores negativos e
//limite cupons a 30% com arredondamento bancario. Demonstre o fluxo completo em testes.
import java.math.BigDecimal;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Produto p1 = new Produto("Notebook", new Dinheiro(new BigDecimal("3500"), Moeda.BRL));
        Produto p2 = new Produto("Mouse", new Dinheiro(new BigDecimal("150"), Moeda.BRL));

        Carrinho carrinho = new Carrinho(List.of());
        carrinho = carrinho.adicionarItem(new ItemCarrinho(p1, 1));
        carrinho = carrinho.adicionarItem(new ItemCarrinho(p2, 2));

        System.out.println("Total sem desconto: " + carrinho.calcularTotal());

        carrinho = carrinho.aplicarCupom(new BigDecimal("10"));
        System.out.println("Total com 10% de desconto: " + carrinho.calcularTotal());

        try {
            carrinho = carrinho.aplicarCupom(new BigDecimal("50"));
        } catch (Exception e) {
            System.out.println("Erro ao aplicar cupom: " + e.getMessage());
        }
    }
}
