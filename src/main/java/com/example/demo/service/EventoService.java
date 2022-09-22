package com.example.demo.service;

import com.example.demo.dto.ComprarIngressoRequest;
import com.example.demo.model.Evento;
import com.example.demo.model.Ingresso;
import com.example.demo.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void cadastrar(Evento evento) {
        eventoRepository.save(evento);
    }

    public List<Evento> findAll() {
        List<Evento> eventos = new ArrayList<>();
        Iterable<Evento> all = eventoRepository.findAll();
        for (Evento evento : all) {
            if (evento.getQtdIngressos() > 0) {
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public void comprarIngresso(ComprarIngressoRequest request, Long idEvento) {
        Optional<Evento> eventoOptional = eventoRepository.findById(idEvento);
        if (eventoOptional.isEmpty()){
            throw new RuntimeException("Evento invalido");
        }
        Evento evento = eventoOptional.get();
        Ingresso ingresso = request.toIngresso(evento);
        evento.registraIngresso(ingresso);
        eventoRepository.save(evento);
    }
}
