package com.example.crudbasico.service;

import com.example.crudbasico.dto.PersonDTO;
import com.example.crudbasico.entity.PersonEntity;
import com.example.crudbasico.service.impl.PersonManagementServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonManagementService implements PersonManagementServiceImpl {

    ArrayList<PersonEntity> personList = new ArrayList<>();

    @Override
    public String save(PersonEntity person) {
        try {
            personList.add(person);
            return "Guardado existo";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<PersonDTO> personList() {
        return listPerson(personList);
    }


    private List<PersonDTO> listPerson(ArrayList<PersonEntity> personList){
        return personList.stream().map(person ->
                new PersonDTO(person.getName(),person.getLastName())
                ).collect(Collectors.toList());
    }
}
