package exc4;

public class Carro implements IMeioTransporte {
    private int velocidade;
    private final int limiteVelocidade;

    public Carro() {
        this.velocidade = 0;
        this.limiteVelocidade = 80;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidade) {
            velocidade += 10;
            System.out.println("Carro acelerando, velocidade atual: " + this.velocidade);
        } else {
            throw new IllegalArgumentException("Carro atingiu o limiate de velocidade.");
        }
    }

    @Override
    public void frear() {
        if (this.velocidade > 0) {
            velocidade -= 10;
            System.out.println("Carro freando, velocidade atual: " + this.velocidade);
        }else {
            throw new IllegalArgumentException("Carro já está parado.");
        }
    }
}
