package com.example.demo.dto;

import com.example.demo.model.Evento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastrarEventoRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Long qtdIngressos;

    @Override
    public String toString() {
        return "CadastrarEventoRequest{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", qtdIngressos=" + qtdIngressos +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQtdIngressos(Long qtdIngressos) {
        this.qtdIngressos = qtdIngressos;
    }

    public Evento toEvento() {
        return new Evento(this.nome, this.descricao, this.qtdIngressos);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getQtdIngressos() {
        return qtdIngressos;
    }

    public CadastrarEventoRequest() {
    }

    public CadastrarEventoRequest(String nome, String descricao, Long qtdIngressos) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdIngressos = qtdIngressos;
    }
}
