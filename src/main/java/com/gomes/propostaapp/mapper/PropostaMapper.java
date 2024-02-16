package com.gomes.propostaapp.mapper;

import com.gomes.propostaapp.dto.PropostaRequestDto;
import com.gomes.propostaapp.dto.PropostaResponseDto;
import com.gomes.propostaapp.entity.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PropostaMapper {

    PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);

    @Mapping(target = "usuario.nome", source = "nome")
    @Mapping(target = "usuario.sobrenome", source = "sobrenome")
    @Mapping(target = "usuario.telefone", source = "telefone")
    @Mapping(target = "usuario.cpf", source = "cpf")
    @Mapping(target = "usuario.renda", source = "renda")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovada", ignore = true)
    @Mapping(target = "integrada", ignore = true)
    @Mapping(target = "observacao", ignore = true)
    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);

@Mapping( target = "nome", source = "usuario.nome" )
@Mapping( target = "sobrenome", source = "usuario.sobrenome" )
@Mapping( target = "telefone", source = "usuario.telefone" )
@Mapping( target = "cpf", source = "usuario.cpf" )
@Mapping(target = "renda", source = "usuario.renda")

    PropostaResponseDto convertEntityDto(Proposta proposta);

List<PropostaResponseDto> convertListEntityToListDto(Iterable<Proposta> propostas);
}