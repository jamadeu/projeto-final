package com.example.demo.service;

import com.example.demo.model.Evento;
import com.example.demo.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Void cadastrar(Evento evento) {
        eventoRepository.save(evento);
        return null;
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
}
