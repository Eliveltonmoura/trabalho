package Projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Produto {
    private int id;
    private String nome;
    private String categoria;
    private String marca;
    private String fornecedor;
    private double precoCompra;
    private double precoVenda;
    private int quantidadeEstoque;

    // Construtor, getters e setters
}

class Transacao {
    private int id;
    private TipoTransacao tipo;
    private int idProduto;
    private int quantidade;
    private Date data;

    // Construtor, getters e setters
}

enum TipoTransacao {
    ENTRADA, SAIDA
}

class Venda {
    private int id;
    private int idProduto;
    private int quantidade;
    private double valorTotal;
    private Date data;

    // Construtor, getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}

class Compra {
    private int id;
    private int idProduto;
    private int quantidade;
    private double valorTotal;
    private Date data;

    // Construtor, getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}

class SistemaEstoque {
    private List<Produto> produtos;
    private List<Transacao> transacoes;
    private List<Venda> vendas;
    private List<Compra> compras;

    public SistemaEstoque() {
        this.produtos = new ArrayList<>();
        this.transacoes = new ArrayList<>();
        this.vendas = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        // Lógica para adicionar um produto
    }

    public void registrarVenda(Venda venda) {
        // Lógica para registrar uma venda
    }

    public void registrarCompra(Compra compra) {
        // Lógica para registrar uma compra
    }

    public void exibirRelatorioEstoque() {
        // Lógica para exibir o relatório de estoque
    }

    // Outras funcionalidades...

    // Métodos getters e setters
}

public class Main {
    public static void main(String[] args) {
        SistemaEstoque sistema = new SistemaEstoque();

        // Exemplo: Adicionar um produto
        Produto produto = new Produto(/* dados do produto */);
        sistema.adicionarProduto(produto);

        // Exemplo: Registrar uma venda
        Venda venda = new Venda(/* dados da venda */);
        sistema.registrarVenda(venda);

        // Exemplo: Registrar uma compra
        Compra compra = new Compra(/* dados da compra */);
        sistema.registrarCompra(compra);

        // Exemplo: Exibir relatório de estoque
        sistema.exibirRelatorioEstoque();
    }
}
