package entities;

public class Fogao extends Aparelho{
    private int bocas;

    public Fogao(String nome, String marca, double preco, int quantidade, int bocas) {
        super(nome, marca, preco, quantidade);
        this.bocas = bocas;
    }
    public int getBocas() {
        return bocas;
    }
    public void setBocas(int bocas) {
        this.bocas = bocas;
    }
    @Override
    public String toString() {
        return super.toString() + ", bocas=" + bocas+ "\n";
    }
}
