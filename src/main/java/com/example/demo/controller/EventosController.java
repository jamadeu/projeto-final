package com.example.demo.controller;

import com.example.demo.dto.CadastrarEventoRequest;
import com.example.demo.model.Evento;
import com.example.demo.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

    @GetMapping("/listar/eventos")
    public ModelAndView listarEventos() {
        List<Evento> eventos = eventoService.findAll();
        ModelAndView mv = new ModelAndView("listaeventos");
        mv.addObject("eventos", eventos);
        return mv;
    }

    @PostMapping("/cadastrar/evento")
    public String cadastrarEvento(@Valid CadastrarEventoRequest request) {
        eventoService.cadastrar(request.toEvento());
        return "redirect:/listar/eventos";
    }
}
