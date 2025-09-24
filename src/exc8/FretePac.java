package exc8;

import java.math.BigDecimal;

public class FretePac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return new BigDecimal("20.00");
    }
}
