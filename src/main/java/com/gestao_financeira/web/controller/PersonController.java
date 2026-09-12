package com.gestao_financeira.web.controller;

import com.gestao_financeira.web.dto.PersonCreateRequest;
import com.gestao_financeira.web.dto.PersonPaymentResponse;
import com.gestao_financeira.web.dto.PersonResponse;
import com.gestao_financeira.web.dto.PersonUpdateRequest;
import com.gestao_financeira.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id) {
        PersonResponse entity = service.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonResponse>> findAll(){
        List<PersonResponse> entityList = service.findAll();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @GetMapping("/payments/{payment}")
    public ResponseEntity<List<PersonPaymentResponse>> findByisPaid(@PathVariable Boolean payment){
        List<PersonPaymentResponse> entityList = service.findByIsPaid(payment);

        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PersonResponse> save(@RequestBody PersonCreateRequest personCreateRequest){
        PersonResponse entity = service.save(personCreateRequest);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable Long id, @RequestBody PersonUpdateRequest personUpdateRequest){
        PersonResponse entity = service.update(id, personUpdateRequest);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
