package com.technocorp.testebancomysqldocker.endpoint;

import com.technocorp.testebancomysqldocker.model.Estudante;
import com.technocorp.testebancomysqldocker.service.EstudanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("estudantes")
public class EstudanteEndpoint {

    @Autowired
    private final EstudanteService service;

    @GetMapping()
    public ResponseEntity<Page<Estudante>> listAll(Pageable pageable) {
        return ResponseEntity.ok(service.listAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEstudanteById(@PathVariable long id) {
        return ResponseEntity.ok(service.findByid(id));

    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Estudante>> findByNameIgnoreCaseContaining(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(service.findByNameIgnoreCaseContaining(name));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Estudante estudante) {
        return new ResponseEntity<>(service.save(estudante), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Estudante estudante) {
        service.update(estudante);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    public ResponseEntity<Void> updatePatch(@RequestBody Estudante estudante) {
        service.updatePatch(estudante);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
