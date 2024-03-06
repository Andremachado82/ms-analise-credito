package com.andre.analisecredito.service.strategy;

import com.andre.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
