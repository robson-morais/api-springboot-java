package com.example.meu_primeiro_spring_boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indica que o id será uma chave primaria gerada automaticamente
    private Long id;
    private String nome;
    private double preco;

    public Produto(){} // por que precisa deixar um construtor vazio em todos os models?

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    }
