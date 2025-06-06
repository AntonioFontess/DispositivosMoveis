package com.example.habitos1;

public class Habito {
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

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public String getCategoria() {
        return categoria;
    }
}
