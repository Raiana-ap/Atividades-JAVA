package exc3;


/*Crie a classe base Funcionario com protected String nome e protected
BigDecimal salario (com getters). Crie Gerente e Desenvolvedor que
sobrescrevem calcularBonus(): 20% do salário para gerente e 10% para
desenvolvedor. Garanta que salários sejam positivos. Em um programa, coloque
diferentes funcionários em uma coleção do tipo List<Funcionario> e exiba o bônus
de cada um.*/

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Funcionario gerente = new Gerente ("Cleber", new BigDecimal("8000"));
        Funcionario desenvolvedor = new Desenvolvedor ("Weber", new BigDecimal("3000"));

        List<Funcionario> funcionario = new ArrayList<>();
        funcionario.add(gerente);
        funcionario.add(desenvolvedor);

        for (Funcionario f : funcionario) {
            System.out.println("Funcionário: " + f.getNome());
            System.out.println("Salário: " + f.getSalario());
            System.out.println("Bônus: " + f.calcularBonus());
            System.out.println("----------------------------");
        }
    }
}
