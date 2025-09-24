package exc5;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {
    private final String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() {
        if (codigoBarras == null || !codigoBarras.matches("\\d{47}")) {
            throw new PagamentoInvalidoException("Código de barras inválido para boleto.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Boleto de R$ " + valor + " gerado. Código: " + codigoBarras);
    }
}
