package com.technocorp.testebancomysqldocker.util;

import com.technocorp.testebancomysqldocker.exception.ResourceNotFoundException;
import com.technocorp.testebancomysqldocker.model.Estudante;
import com.technocorp.testebancomysqldocker.repositoy.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Utils {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }


    public Estudante findEstudanteOrTrhowNotFound(long id, EstudanteRepository estudanteRepository){
        return estudanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudante não encontrado"));
    }
}
