package com.arthurmorato.farmplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping("")
    public String listar(Model model) {
        List<DespesaEntity> despesas = despesaService.listarDespesas();
        model.addAttribute("despesas", despesas);
        return "despesas/listar";
    }

    @GetMapping("/nova")
    public String novaDespesa(Model model) {
        DespesaEntity despesa = new DespesaEntity();
        model.addAttribute("despesa", despesa);
        return "despesas/formulario";
    }

    @PostMapping("/salvar")
    public String salvarDespesa(@Valid @ModelAttribute("despesa") DespesaEntity despesa, BindingResult result) {
        if (result.hasErrors()) {
            return "despesas/formulario";
        }
        despesaService.salvarDespesa(despesa);
        return "redirect:/despesas";
    }

}

