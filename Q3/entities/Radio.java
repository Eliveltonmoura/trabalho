package entities;

public class Radio extends Aparelho{
    private int potencia;

    public Radio(String nome, String marca, double preco, int quantidade, int potencia) {
        super(nome, marca, preco, quantidade);
        this.potencia = potencia;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    @Override
    public String toString() {
        return super.toString() + ", potencia=" + potencia+ "\n";
    }
}
