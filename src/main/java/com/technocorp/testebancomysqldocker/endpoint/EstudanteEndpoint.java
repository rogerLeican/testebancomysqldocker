package com.technocorp.testebancomysqldocker.endpoint;

import com.technocorp.testebancomysqldocker.error.CustomErrorType;
import com.technocorp.testebancomysqldocker.model.Estudante;
import com.technocorp.testebancomysqldocker.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudantes")
public class EstudanteEndpoint {
//blble
    private final DateUtil dateUtil;
    @Autowired
    public EstudanteEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAll(){
//        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Estudante.estudanteList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEstudanteById(@PathVariable("id") int id){
        Estudante estudante = new Estudante();
        estudante.setId(id);
       int index = Estudante.estudanteList.indexOf(estudante);
       if(index == -1)
            return new ResponseEntity<>(new CustomErrorType("Estudante não encontraddo"), HttpStatus.NOT_FOUND);

       return new ResponseEntity<>(Estudante.estudanteList.get(index), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Estudante estudante){
        Estudante.estudanteList.add(estudante);
        return new ResponseEntity<>(estudante, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Estudante estudante){
        Estudante.estudanteList.remove(estudante);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Estudante estudante){
        Estudante.estudanteList.remove(estudante);
        Estudante.estudanteList.add(estudante);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
