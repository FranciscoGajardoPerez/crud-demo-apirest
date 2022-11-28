package com.example.crudbasico.controller;

import com.example.crudbasico.dto.PersonDTO;
import com.example.crudbasico.entity.PersonEntity;
import com.example.crudbasico.service.PersonManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/person")
@RequiredArgsConstructor
public class personController {


    private final PersonManagementService service;


    @PostMapping
    public ResponseEntity<String> save(@RequestBody PersonEntity person){
        return new ResponseEntity(service.save(person), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> listPerson(){
        return new ResponseEntity<>(service.personList(),HttpStatus.OK);
    }
}
