package com.faculdade.votacao.interfaces;

import com.faculdade.votacao.service.CpfValidatorService.CpfStatus;

public interface CpfValidatorInterface {
    CpfStatus validarCpf(String cpf);
}