package br.com.estoqueeletro.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Eletrodomesticos")
public class Aparelho{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String tipo;
    private String marca;
    private double preco;
    private int quantidade;
    private int tamanho;
    private int idEstoque;

    
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
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
    public int getTamanho() {
        return tamanho;
    }
    public int getIdEstoque() {
        return idEstoque;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }
}