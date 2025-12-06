package com.example.meu_primeiro_spring_boot.services;

import com.example.meu_primeiro_spring_boot.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository){
        this.mensagemRepository = mensagemRepository;
    }

    public String getMessage(){
        return this.mensagemRepository.getMesage();
    }

}
