package com.example.habito1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity
public class Habito implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String frequencia;

    public Habito(String nome, String frequencia) {
        this.nome = nome;
        this.frequencia = frequencia;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getFrequencia() { return frequencia; }

    public void setFrequencia(String frequencia) { this.frequencia = frequencia; }

    @Override
    public String toString() {
        return nome; // usado no Spinner
    }
}
