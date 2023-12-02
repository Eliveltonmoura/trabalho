package entities;

import java.util.Arrays;

public class Deposito {
    private Aparelho[] aparelhos;

    public Deposito(Aparelho[] aparelhos) {
        this.aparelhos = aparelhos;
    }

    public Aparelho getAparelhoById(int id) {
        System.out.println(aparelhos.length);
        for (Aparelho aparelho : aparelhos) {
            if (aparelho.getId() == id) {
                return aparelho;
            }
        }
        return null;
    }

    public void addAparelho(Aparelho aparelho) {;
        if(this.aparelhos == null) {
            this.aparelhos = new Aparelho[1];
            this.aparelhos[0] = aparelho;
        }
        else {
            Aparelho[] newAparelhos = Arrays.copyOf(this.aparelhos, this.aparelhos.length + 1);
            newAparelhos[this.aparelhos.length] = aparelho;
            this.aparelhos = newAparelhos;
        }
    }

    public void removeAparelhoById(int id) {
        Aparelho[] newAparelhos = new Aparelho[this.aparelhos.length - 1];
        int index = 0;
        for (Aparelho aparelho : this.aparelhos) {
            if (aparelho.getId() != id) {
                newAparelhos[index] = aparelho;
                index++;
            }
        }
        this.aparelhos = newAparelhos;
    }

    public Aparelho[] getAparelhos() {
        return aparelhos;
    }
    public void setAparelhos(Aparelho[] aparelhos) {
        this.aparelhos = aparelhos;
    }

    @Override
    public String toString() {
        String out = "";
        if(aparelhos != null)
            for (Aparelho aparelho : aparelhos)
                out += aparelho.toString();
        return out;
    }
}
