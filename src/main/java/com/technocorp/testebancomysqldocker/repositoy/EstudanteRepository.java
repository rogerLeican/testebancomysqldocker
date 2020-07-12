package com.technocorp.testebancomysqldocker.repositoy;

import com.technocorp.testebancomysqldocker.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EstudanteRepository extends JpaRepository<Estudante,Long> {
    List<Estudante> findByNameIgnoreCaseContaining(String name);


}
