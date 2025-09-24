package exc5;

import java.math.BigDecimal;
import java.util.List;

// Implemente a classe abstrata FormaPagamento com validarPagamento() e
//processarPagamento(BigDecimal valor). Crie CartaoCredito, Boleto e Pix com
//validações específicas (ex.: número do cartão, formato de boleto, chave Pix). Simule
//o uso de cada forma por polimorfismo e trate erros de validação com exceções
//específicas (ex.: PagamentoInvalidoException).

public class Principal {
    public static void main(String[] args) {
        List<FormaPagamento> pagamentos = List.of(
                new CartaoCredito("1234567890123456"),
                new Boleto("2379338128600000000000000000000000000000000000"),
                new Pix("email@teste.com")
        );

        for (FormaPagamento pagamento : pagamentos) {
            try {
                pagamento.processarPagamento(new BigDecimal("100.00"));
            } catch (PagamentoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
