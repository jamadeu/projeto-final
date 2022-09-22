package com.example.demo.dto;

import com.example.demo.model.Evento;
import com.example.demo.model.Ingresso;

import javax.validation.constraints.NotBlank;

public class ComprarIngressoRequest {
    @NotBlank
    private String nomeCliente;
    @NotBlank
    private String docCliente;

    public Ingresso toIngresso(Evento evento){
        return new Ingresso(
                this.nomeCliente,
                this.docCliente,
                evento
        );
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDocCliente() {
        return docCliente;
    }

    public void setDocCliente(String docCliente) {
        this.docCliente = docCliente;
    }

    public ComprarIngressoRequest() {
    }

    public ComprarIngressoRequest(String nomeCliente, String docCliente) {
        this.nomeCliente = nomeCliente;
        this.docCliente = docCliente;
    }
}
