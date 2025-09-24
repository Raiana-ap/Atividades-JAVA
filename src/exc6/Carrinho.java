package exc6;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Carrinho adicionarItem(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.add(item);
        return new Carrinho(novaLista);
    }

    public Carrinho removerItem(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.remove(item);
        return new Carrinho(novaLista);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagem) {
        List<ItemCarrinho> novaLista = new ArrayList<>();
        for (ItemCarrinho item : itens) {
            Dinheiro precoComDesconto = item.produto().preco().aplicarDesconto(porcentagem);
            Produto novoProduto = new Produto(item.produto().nome(), precoComDesconto);
            novaLista.add(new ItemCarrinho(novoProduto, item.quantidade()));
        }
        return new Carrinho(novaLista);
    }

    public Dinheiro calcularTotal() {
        return itens.stream()
                .map(ItemCarrinho::getValorTotal)
                .reduce((a, b) -> new Dinheiro(a.getValor().add(b.getValor()), a.getMoeda()))
                .orElse(new Dinheiro(BigDecimal.ZERO, Moeda.BRL));
    }
}
