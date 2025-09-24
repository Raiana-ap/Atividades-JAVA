package exc6;

public record ItemCarrinho(Produto produto, int quantidade) {
    public ItemCarrinho {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
    }

    public Dinheiro getValorTotal() {
        return new Dinheiro(produto.preco().getValor().multiply(
                java.math.BigDecimal.valueOf(quantidade)), produto.preco().getMoeda());
    }
}
