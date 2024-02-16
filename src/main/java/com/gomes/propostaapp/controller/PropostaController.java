package com.gomes.propostaapp.controller;

import com.gomes.propostaapp.dto.PropostaRequestDto;
import com.gomes.propostaapp.dto.PropostaResponseDto;
import com.gomes.propostaapp.mapper.PropostaMapper;
import com.gomes.propostaapp.service.PropostaService;
import jakarta.servlet.Servlet;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private PropostaService propostaService;
    @PostMapping
    public ResponseEntity<PropostaResponseDto> criar(@RequestBody PropostaRequestDto requestDto){
        PropostaResponseDto response = propostaService.criar(requestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.getId()).toUri()).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> obterProposta(){
        List<PropostaResponseDto> response = propostaService.obterProposta();

        return ResponseEntity.ok(response);
    }
}
