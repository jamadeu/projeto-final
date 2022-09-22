package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Long qtdIngressos;

    @Deprecated
    public Evento() {
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", qtdIngressos=" + qtdIngressos +
                '}';
    }

    public Evento(String nome, String descricao, Long qtdIngressos) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdIngressos = qtdIngressos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQtdIngressos() {
        return qtdIngressos;
    }

    public void setQtdIngressos(Long qtdIngressos) {
        this.qtdIngressos = qtdIngressos;
    }
}
