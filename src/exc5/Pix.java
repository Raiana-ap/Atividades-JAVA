package exc5;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {
    private final String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void validarPagamento() {
        if (chave == null || chave.isBlank()) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Pagamento de R$ " + valor + " enviado via Pix para chave: " + chave);
    }
}
