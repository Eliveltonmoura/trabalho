package entities;

public class Tv extends Aparelho{
    private int polegadas;

    public Tv(String nome, String marca, double preco, int quantidade, int polegadas) {
        super(nome, marca, preco, quantidade);
        this.polegadas = polegadas;
    }

    public int getPolegadas() {
        return polegadas;
    }
    public void setPolegadas(int polegadas) {
        this.polegadas = polegadas;
    }
    @Override
    public String toString() {
        return super.toString() + ", polegadas=" + polegadas+ "\n";
    }
}
