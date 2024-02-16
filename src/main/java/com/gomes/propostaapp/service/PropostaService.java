package com.gomes.propostaapp.service;

import com.gomes.propostaapp.dto.PropostaRequestDto;
import com.gomes.propostaapp.dto.PropostaResponseDto;
import com.gomes.propostaapp.entity.Proposta;
import com.gomes.propostaapp.mapper.PropostaMapper;
import com.gomes.propostaapp.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PropostaService {


    private PropostaRepository propostaRepository;
    public PropostaResponseDto criar(PropostaRequestDto requestDto){
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);

      propostaRepository.save(proposta);
      return PropostaMapper.INSTANCE.convertEntityDto(proposta);

    }
    public List<PropostaResponseDto> obterProposta(){

        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}
