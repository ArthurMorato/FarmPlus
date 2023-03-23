package com.arthurmorato.farmplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/rebanho")
public class RebanhoController {

    @Autowired
    private RebanhoService rebanhoService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<AnimalEntity> animais = rebanhoService.listarAnimais();
        model.addAttribute("animais", animais);
        return "listar_animais";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("animal", new AnimalEntity());
        return "cadastrar_animal";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute AnimalEntity animal) {
        rebanhoService.cadastrarAnimal(animal);
        return "redirect:/rebanho/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        AnimalEntity animal = rebanhoService.buscarAnimalPorId(id);
        model.addAttribute("animal", animal);
        return "editar_animal";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute AnimalEntity animal) {
        rebanhoService.editarAnimal(animal);
        return "redirect:/rebanho/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        rebanhoService.excluirAnimal(id);
        return "redirect:/rebanho/listar";
    }

}

