package com.andre.analisecredito.service;

import com.andre.analisecredito.constantes.MensagemConstante;
import com.andre.analisecredito.domain.Proposta;
import com.andre.analisecredito.exceptions.StrategyException;
import com.andre.analisecredito.service.strategy.CalculoPonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    @Autowired
    private List<CalculoPonto> calculoPontoList;

    @Autowired
    private NotificacaoRabbitMQService notificacaoRabbitMQService;

    @Value("${rabbitmq.propostaconcluida.exchange}")
    private String propostaConcluidaExchange;

    public void analisar(Proposta proposta) {
        try {
            boolean propostaAprovada = calculoPontoList.stream().mapToInt(
                    impl -> impl.calcular(proposta)).sum() > 350;
            proposta.setAprovada(propostaAprovada);
        } catch (StrategyException ex) {
            proposta.setAprovada(false);
            proposta.setObservacao(MensagemConstante.PONTUACAO_SERASA_BAIXA);
        }
        notificacaoRabbitMQService.notificar(propostaConcluidaExchange, proposta);


    }
}
