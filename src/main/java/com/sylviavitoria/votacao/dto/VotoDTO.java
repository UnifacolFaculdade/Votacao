package com.sylviavitoria.votacao.dto;

import com.sylviavitoria.votacao.enums.OpcaoVoto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoDTO {
    private Long pautaId;
    private Long associadoId;
    private OpcaoVoto opcao;
}