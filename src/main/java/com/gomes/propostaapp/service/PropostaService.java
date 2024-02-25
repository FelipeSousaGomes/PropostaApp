package com.gomes.propostaapp.service;

import com.gomes.propostaapp.dto.PropostaRequestDto;
import com.gomes.propostaapp.dto.PropostaResponseDto;
import com.gomes.propostaapp.entity.Proposta;
import com.gomes.propostaapp.mapper.PropostaMapper;
import com.gomes.propostaapp.repository.PropostaRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropostaService {


    private String exchange;

    public PropostaService(@Value("${rabbitmq.propostapendente.exchange}")String exchange, PropostaRepository propostaRepository, NotificacaoService notificacaoService) {
        this.exchange = exchange;
        this.propostaRepository = propostaRepository;
        this.notificacaoService = notificacaoService;
    }

    private PropostaRepository propostaRepository;
    private NotificacaoService notificacaoService;
    public PropostaResponseDto criar(PropostaRequestDto requestDto){
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);

        notificarRabbitMQ(proposta);
      propostaRepository.save(proposta);
         PropostaMapper.INSTANCE.convertEntityDto(proposta);

        return   PropostaMapper.INSTANCE.convertEntityDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta){
        try{
            notificacaoService.Notifica(proposta, exchange);
        }catch (RuntimeException e){
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }
    public List<PropostaResponseDto> obterProposta(){

        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}
