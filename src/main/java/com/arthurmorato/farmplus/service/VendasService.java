package com.arthurmorato.farmplus.service;

import com.arthurmorato.farmplus.entity.VendaEntity;
import com.arthurmorato.farmplus.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class VendasService {

    @Autowired
    private VendaRepository vendaRepository;


    public VendaRepository registrarVenda(VendaEntity venda) {
        // validação dos dados da venda
        if (venda.getDataVenda() == null) {
            throw new IllegalArgumentException("Data da venda é obrigatória");
        }
        if (venda.getAnimalVendido() == null) {
            throw new IllegalArgumentException("Animal vendido é obrigatório");
        }
        if (venda.getPeso() <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        }
        if (venda.getValor() <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }

        // cálculo do lucro obtido com a venda
        double custoProducao = venda.getAnimalVendido().getCustoProducao();
        double lucro = venda.getValor() - custoProducao;

        venda.setLucro(lucro);

        // persistência da venda no banco de dados
        return vendaRepository.save(venda);
    }

    public List<Venda> listarVendasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        // busca as vendas no banco de dados por período
        return vendaRepository.findByDataVendaBetween(dataInicial, dataFinal);
    }

}

