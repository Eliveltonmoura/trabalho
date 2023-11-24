package Projeto_atv3;

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
   
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    public double getPrecoCompra() {
        return precoCompra;
    }
    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public Produto(int id, String nome, String categoria, String marca, String fornecedor,
                   double precoCompra, double precoVenda, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    


}

/*class Transacao {
    private int id;
    private TipoTransacao tipo;
    private int idProduto;
    private int quantidade;
    private Date data;

    // Construtor, getters e setters
}

enum TipoTransacao {
    ENTRADA, SAIDA
}*/

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

     public Venda(int id, int idProduto, int quantidade, double valorTotal, String string) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.data = string;
    }

}

class Compra {
    private int id;
    private int idProduto;
    private int quantidade;
    private double valorTotal;
    private String data;

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

    public void setData(String data) {
        this.data = data;
    }

     public Compra(int id, int idProduto, int quantidade, double valorTotal, String data) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.data = data;
    }

}

class SistemaEstoque {
    private List<Produto> produtos;
    //private List<Transacao> transacoes;
    private List<Venda> vendas;
    private List<Compra> compras;

    public SistemaEstoque() {
        this.produtos = new ArrayList<>();
        //this.transacoes = new ArrayList<>();
        this.vendas = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
          if (!produtos.contains(produto)) {
            // Adicionar o produto à lista de produtos
            produtos.add(produto);
            System.out.println("Produto adicionado com sucesso!");
        } else {
            System.out.println("Produto já existe no estoque.");
        }
    }

    public void registrarVenda(Venda venda) {
       Produto produto = buscarProdutoPorId(venda.getIdProduto());

        if (produto != null && produto.getQuantidadeEstoque() >= venda.getQuantidade()) {
            // Atualizar o estoque
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - venda.getQuantidade());

            // Registrar a venda
            vendas.add(venda);

            System.out.println("Venda registrada com sucesso!");
        } else {
            System.out.println("Produto não encontrado no estoque ou quantidade insuficiente.");

        }

        private Produto buscarProdutoPorId(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getId() == idProduto) {
                return produto;
            }
        }
        return null;
    }
   

    public void registrarCompra(Compra compra) {
        Produto produto = buscarProdutoPorId(compra.getIdProduto());

        if (produto != null) {
            // Atualizar o estoque
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + compra.getQuantidade());

            // Registrar a compra
            compras.add(compra);

            System.out.println("Compra registrada com sucesso!");
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    public void exibirRelatorioEstoque() {
       System.out.println("=== Relatório de Estoque ===");

        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("Marca: " + produto.getMarca());
            System.out.println("Quantidade em Estoque: " + produto.getQuantidadeEstoque());
            System.out.println("===========================");
        }
    }

    
  
}

public class Main {
    public static void main(String[] args) {
        SistemaEstoque sistema = new SistemaEstoque();

        // Exemplo: Adicionar um produto
        Produto produto = new Produto(25,"fugão","cosinha","consul","Magalu",2.000,4,3);
        sistema.adicionarProduto(produto);

        // Exemplo: Registrar uma venda
        Venda venda = new Venda(33,25,1,3.000,"20/11/2023");
        sistema.registrarVenda(venda);

        // Exemplo: Registrar uma compra
        Compra compra = new Compra(33,25,1,3.000,"25/03/2023");
        sistema.registrarCompra(compra);

        // Exemplo: Exibir relatório de estoque
        sistema.exibirRelatorioEstoque();
    }
}
