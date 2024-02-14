package com.gomes.propostaapp.controller;

import com.gomes.propostaapp.dto.PropostaRequestDto;
import com.gomes.propostaapp.dto.PropostaResponseDto;
import com.gomes.propostaapp.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {
    private PropostaService propostaService;
    @PostMapping
    public ResponseEntity<PropostaResponseDto> criar(@RequestBody PropostaRequestDto RequestDto){
        PropostaResponseDto response = propostaService.criar(RequestDto);
        return ResponseEntity.ok(response);
    }
}
