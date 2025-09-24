package exc3;

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
