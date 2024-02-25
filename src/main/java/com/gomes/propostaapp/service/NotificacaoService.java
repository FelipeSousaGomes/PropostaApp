package com.gomes.propostaapp.service;

import com.gomes.propostaapp.dto.PropostaResponseDto;
import com.gomes.propostaapp.entity.Proposta;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class NotificacaoService {

    private RabbitTemplate rabbitTemplate;

    public void Notifica(Proposta proposta,String exchange){
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }

}
