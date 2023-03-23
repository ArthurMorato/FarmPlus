package com.arthurmorato.farmplus.controller;

import com.arthurmorato.farmplus.entity.VendaEntity;
import com.arthurmorato.farmplus.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.arthurmorato.farmplus.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @GetMapping("/nova")
    public String novaVenda(Model model) {
        model.addAttribute("venda", new VendaEntity());
        return "venda-form";
    }

    @PostMapping("/salvar")
    public String salvarVenda(VendaEntity venda) {
        vendasService.registrarVenda(venda);
        return "redirect:/vendas";
    }

    @GetMapping
    public String listarVendas(@RequestParam(value = "dataInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                               @RequestParam(value = "dataFim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                               Model model) {
        List<VendaEntity> vendas = vendaService.listarVendasPorPeriodo(dataInicio, dataFim);
        model.addAttribute("vendas", vendas);
        return "vendas";
    }
}
