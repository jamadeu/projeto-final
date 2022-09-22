package com.example.demo.controller;

import com.example.demo.dto.CadastrarEventoRequest;
import com.example.demo.dto.ComprarIngressoRequest;
import com.example.demo.model.Evento;
import com.example.demo.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventosController {

    private final EventoService eventoService;

    public EventosController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/form/cadastrar")
    public ModelAndView formCadastrarEvento() {
        return new ModelAndView("formcadastrar");
    }

    @GetMapping("/form/comprar-ingresso")
    public ModelAndView formComprarIngresso() {
        return new ModelAndView("formcadastrar");
    }

    @GetMapping("/listar/eventos")
    public ModelAndView listarEventos() {
        List<Evento> eventos = eventoService.findAll();
        ModelAndView mv = new ModelAndView("listaeventos");
        mv.addObject("eventos", eventos);
        return mv;
    }

    @PostMapping("/cadastrar/evento")
    public String cadastrarEvento(CadastrarEventoRequest request) {
        eventoService.cadastrar(request.toEvento());
        return "redirect:/listar/eventos";
    }

    @PostMapping("/evento/{id}/comprar-ingresso")
    public String comprarIngresso(ComprarIngressoRequest request, @PathVariable("id") Long idEvento) {
        eventoService.comprarIngresso(request, idEvento);
        return "redirect:/listar/eventos";
    }
}
