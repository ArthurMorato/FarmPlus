package com.arthurmorato.farmplus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "despesas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DespesaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDespesa tipo;

    private Double valor;

    private LocalDate dataDespesa;

    public enum TipoDespesa {
        ALIMENTO,
        MEDICAMENTO,
        EQUIPAMENTO,
        MAO_DE_OBRA
    }

}

