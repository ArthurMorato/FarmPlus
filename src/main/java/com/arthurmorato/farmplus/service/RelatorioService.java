package com.arthurmorato.farmplus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RelatorioService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    @Transactional(readOnly = true)
    public List<AnimalEntity> listarAnimais() {
        return animalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<VendaEntity> listarVendas() {
        return vendaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<DespesaEntity> listarDespesas() {
        return despesaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public double calcularGanhoPesoMedioDiario() {
        List<AnimalEntity> animais = animalRepository.findAll();
        double totalGanhoPeso = 0;
        int totalDias = 0;
        for (AnimalEntity animal : animais) {
            List<PesoEntity> pesos = animal.getPesos();
            if (pesos.size() > 1) {
                for (int i = 1; i < pesos.size(); i++) {
                    PesoEntity pesoAtual = pesos.get(i);
                    PesoEntity pesoAnterior = pesos.get(i - 1);
                    totalGanhoPeso += pesoAtual.getPeso() - pesoAnterior.getPeso();
                    totalDias += (int) ChronoUnit.DAYS.between(pesoAnterior.getData(), pesoAtual.getData());
                }
            }
        }
        if (totalDias > 0) {
            return totalGanhoPeso / totalDias;
        } else {
            return 0;
        }
    }

    @Transactional(readOnly = true)
    public double calcularCustoTotalProducao() {
        List<DespesaEntity> despesas = despesaRepository.findAll();
        double custoTotal = 0;
        for (DespesaEntity despesa : despesas) {
            custoTotal += despesa.getValor();
        }
        return custoTotal;
    }

    @Transactional(readOnly = true)
    public double calcularLucroObtido() {
        List<VendaEntity> vendas = vendaRepository.findAll();
        double lucroTotal = 0;
        for (VendaEntity venda : vendas) {
            lucroTotal += venda.getValor() - venda.getAnimalVendido().getCustoProducao();
        }
        return lucroTotal;
    }

    @Transactional(readOnly = true)
    public List<RelatorioEntity> gerarRelatorios() {
        List<RelatorioEntity> relatorios = new ArrayList<>();

        double ganhoPesoMedioDiario = calcularGanhoPesoMedioDiario();
        double custoTotalProducao = calcularCustoTotalProducao();
        double lucroObtido = calcularLucroObtido();

        String conteudo = "Ganho de peso médio diário: " + ganhoPesoMedioDiario + "\n";
        conteudo += "Custo total de produção: " + custoTotalProducao + "\n";
        conteudo += "Lucro obtido: " + lucroObtido + "\n";

        RelatorioEntity relatorio = new RelatorioEntity();
        relatorio.setTipo("Relatório de produção");
        relatorio.setDataGeracao(new Date());
        relatorio.setConteudo(conteudo);
        relatorios.add(relatorio);

        return relatorios;
    }

}

