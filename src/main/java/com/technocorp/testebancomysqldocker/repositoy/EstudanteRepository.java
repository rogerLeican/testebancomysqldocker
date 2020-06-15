package com.technocorp.testebancomysqldocker.repositoy;

import com.technocorp.testebancomysqldocker.model.Estudante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstudanteRepository extends CrudRepository <Estudante,Long>{
    List<Estudante> findByNameIgnoreCaseContaining(String name);

}
