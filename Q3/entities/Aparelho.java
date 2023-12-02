package entities;

public abstract class Aparelho implements Transferivel{
    public static int idAparelhos;
    private int id;
    private String nome;
    private String marca;
    private double preco;
    private int quantidade;

    protected Aparelho(String nome, String marca, double preco, int quantidade) {
        this.id = Aparelho.idAparelhos+1;
        Aparelho.idAparelhos++;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void transferir(Deposito depositoDestino, int quantidade) {
        if (this.quantidade < quantidade)
            quantidade = this.quantidade;
        if(depositoDestino.getAparelhoById(this.id) == null)
            depositoDestino.addAparelho(this);
        else
            depositoDestino.getAparelhoById(this.id).setQuantidade(depositoDestino.getAparelhoById(this.id).getQuantidade() + quantidade);
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getMarca() {
        return marca;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    @Override
    public String toString() {
        String tipo = "";
        if (this instanceof Tv)
            tipo = "    TV";
        else if (this instanceof Fogao)
            tipo = "    Fogao";
        else if (this instanceof Radio)
            tipo = "    Radio";
        return tipo+": " +
                "id=" + id +
                ", nome=" + nome +
                ", marca=" + marca +
                ", preco=" + preco +
                ", quantidade=" + quantidade;
    }
}
