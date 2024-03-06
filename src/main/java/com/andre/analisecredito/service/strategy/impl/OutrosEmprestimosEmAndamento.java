package com.andre.analisecredito.service.strategy.impl;

import com.andre.analisecredito.domain.Proposta;
import com.andre.analisecredito.service.strategy.CalculoPonto;

import java.util.Random;

public class OutrosEmprestimosEmAndamento implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return outroEmprestimosEmAndamento() ? 0 : 80;
    }

    private boolean outroEmprestimosEmAndamento() {
        return new Random().nextBoolean();
    }
}
