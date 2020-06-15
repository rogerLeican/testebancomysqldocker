package com.technocorp.testebancomysqldocker.endpoint;

import com.technocorp.testebancomysqldocker.error.CustomErrorType;
import com.technocorp.testebancomysqldocker.model.Estudante;
import com.technocorp.testebancomysqldocker.repositoy.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("estudantes")
public class EstudanteEndpoint {

    @Autowired
    private final EstudanteRepository estudanteDao;

    public EstudanteEndpoint(EstudanteRepository estudanteDao) {
        this.estudanteDao = estudanteDao;
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(estudanteDao.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEstudanteById(@PathVariable("id") int id) {

        Optional<Estudante> estudante = estudanteDao.findById((long) id);
        if (estudanteDao.findById((long) id).isPresent()) {
            Estudante student = estudanteDao.findById((long) id).get();
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Estudante estudante) {
        return new ResponseEntity<>(estudanteDao.save(estudante), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        estudanteDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Estudante estudante) {
        estudanteDao.save(estudante);
        //mandar sem o id, esse metodo cria um novo estudante.
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
