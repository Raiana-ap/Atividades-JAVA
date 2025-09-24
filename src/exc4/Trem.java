package exc4;

public class Trem implements IMeioTransporte{
    private int velocidade;
    private final int limiteVelocidade;

    public Trem() {
        this.velocidade = 0;
        this.limiteVelocidade = 180;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidade) {
            velocidade += 15;
            System.out.println("Trem acelerando, velocidade atual: " + this.velocidade);
        } else {
            throw new IllegalArgumentException("Trem atingiu o limiate de velocidade.");
        }
    }

    @Override
    public void frear() {
        if (this.velocidade > 0) {
            velocidade -= 10;
            System.out.println("Trem freando, velocidade atual: " + this.velocidade);
        }else {
            throw new IllegalArgumentException("Trem já está parado.");
        }
    }
}
