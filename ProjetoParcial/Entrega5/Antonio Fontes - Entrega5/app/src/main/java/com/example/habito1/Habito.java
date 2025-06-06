package com.example.habito1;

import java.io.Serializable;

public class Habito implements Serializable {
    private String nome;
    private String descricao;
    private String frequencia;
    private String categoria;

    public Habito(String nome, String descricao, String frequencia, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.frequencia = frequencia;
        this.categoria = categoria;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getFrequencia() { return frequencia; }
    public void setFrequencia(String frequencia) { this.frequencia = frequencia; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
