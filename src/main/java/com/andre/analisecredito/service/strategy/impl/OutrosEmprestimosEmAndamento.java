package com.andre.analisecredito.service.strategy.impl;

import com.andre.analisecredito.domain.Proposta;
import com.andre.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamento implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return outroEmprestimosEmAndamento() ? 0 : 80;
    }

    private boolean outroEmprestimosEmAndamento() {
        return new Random().nextBoolean();
    }
}
