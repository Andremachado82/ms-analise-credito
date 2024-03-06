package com.andre.analisecredito.service.strategy.impl;

import com.andre.analisecredito.domain.Proposta;
import com.andre.analisecredito.service.strategy.CalculoPonto;

public class PrazoPagamentoInferior10Anos implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }
}
