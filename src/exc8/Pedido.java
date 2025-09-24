package exc8;

import java.math.BigDecimal;

public class Pedido {
    private String cep;
    private BigDecimal valorTotal;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(String cep, BigDecimal valorTotal, CalculadoraFrete estrategiaFrete) {
        this.cep = cep;
        this.valorTotal = valorTotal;
        this.estrategiaFrete = estrategiaFrete;
    }

    public String getCep() {
        return cep;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal calcularFrete() {
        validarCep();
        return estrategiaFrete.calcular(this);
    }

    public void setEstrategiaFrete(CalculadoraFrete novaEstrategia) {
        this.estrategiaFrete = novaEstrategia;
    }

    private void validarCep() {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido: " + cep);
        }
    }
}
