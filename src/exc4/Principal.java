package exc4;

import java.util.ArrayList;
import java.util.List;

// Defina a interface IMeioTransporte com acelerar() e frear(). Implemente Carro,
//Bicicleta e Trem, cada um com lógica própria de variação de velocidade e limites.
//No metodo principal, crie uma lista de IMeioTransporte, percorra e invoque
//acelerar()/frear() demonstrando polimorfismo. Trate operações inválidas com
//exceções apropriadas.

public class Principal {
    public static void main(String[] args) {
        List<IMeioTransporte> meiosDeTransporte = new ArrayList<IMeioTransporte>();
        meiosDeTransporte.add(new Carro());
        meiosDeTransporte.add(new Trem());
        meiosDeTransporte.add(new Bicicleta());

        for (IMeioTransporte transporte : meiosDeTransporte) {
            System.out.println("=== " + transporte.getClass().getSimpleName() + " ===");

            try {
                transporte.acelerar();
                transporte.acelerar();
                transporte.frear();
                transporte.frear();
                transporte.frear();
                transporte.frear();
                transporte.frear();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.println();
        }
    }
}
