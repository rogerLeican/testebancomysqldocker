package com.technocorp.testebancomysqldocker.service;

import com.technocorp.testebancomysqldocker.model.Estudante;
import com.technocorp.testebancomysqldocker.repositoy.EstudanteRepository;
import com.technocorp.testebancomysqldocker.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EstudanteService {

    private final Utils utils;
    private final EstudanteRepository repository;

    public Page<Estudante> listAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Estudante findByid(long id) {
        return utils.findEstudanteOrTrhowNotFound(id, repository);
    }

    public List<Estudante> findByNameIgnoreCaseContaining(String name) {
        return repository.findByNameIgnoreCaseContaining(name);
    }

    public Estudante save(Estudante estudante) {
        return repository.save(estudante);
    }

    public void update(Estudante estudante) {
        repository.save(estudante);
    }

    public void delete(Long id) {
        repository.delete(utils.findEstudanteOrTrhowNotFound(id, repository));
    }

    public void updatePatch(Estudante estudante) {
        repository.save(estudante);
    }


}
