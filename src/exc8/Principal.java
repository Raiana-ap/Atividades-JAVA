package exc8;
//Padrão Strategy (Cálculo de Frete com Lambdas)
//Modele CalculadoraFrete com calcular(Pedido): BigDecimal. Crie estratégias
//Sedex, Pac e RetiradaNaLoja e permita injeção/troca da estratégia no Pedido.
//Acrescente uma estratégia promocional via lambda (frete grátis acima de X). Valide
//CEP/região e dispare exceções para CEP inválido. Mostre a troca de estratégia em
//tempo de execução.
import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("90000000", new BigDecimal("150.00"), new FreteSedex());
        System.out.println("SEDEX: " + pedido.calcularFrete());

        pedido.setEstrategiaFrete(new FretePac());
        System.out.println("PAC: " + pedido.calcularFrete());

        pedido.setEstrategiaFrete(new RetiradaNaLoja());
        System.out.println("Retirada: " + pedido.calcularFrete());

        CalculadoraFrete fretePromocional = p -> {
            if (p.getValorTotal().compareTo(new BigDecimal("200.00")) > 0) {
                return BigDecimal.ZERO;
            } else {
                return new BigDecimal("15.00");
            }
        };
        pedido.setEstrategiaFrete(fretePromocional);

        System.out.println("Promo (150): " + pedido.calcularFrete());

        Pedido pedido2 = new Pedido("90000000", new BigDecimal("300.00"), fretePromocional);
        System.out.println("Promo (300): " + pedido2.calcularFrete());

        try {
            Pedido pedido3 = new Pedido("fsefwes", new BigDecimal("100.00"), new FretePac());
            System.out.println(pedido3.calcularFrete());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
