package com.example.crudbasico.service;

import com.example.crudbasico.dto.PersonDTO;
import com.example.crudbasico.entity.PersonEntity;
import com.example.crudbasico.service.impl.PersonManagementServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PersonManagementService implements PersonManagementServiceImpl {

    ArrayList<PersonEntity> personList = new ArrayList<>();
    int contador = 0;

    @Override
    public String save(PersonEntity person) {
        try {
            person.setId(String.valueOf(contador++));
            personList.add(person);
            return "save";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<PersonDTO> personList() {
        return listPerson(personList);
    }

    @Override
    public String delete(String id) {
        try {
            personList.removeIf(p -> (p.getId().equals(id)));
            return "delete";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String update(String id, PersonEntity person) {
        try {
            personList.set(Integer.parseInt(id),person);
            return "update";
        }catch (Exception e){
            return e.getMessage();
        }    }


    private List<PersonDTO> listPerson(ArrayList<PersonEntity> personList){
        return personList.stream().map(person ->
                new PersonDTO(person.getName(),person.getLastName())
                ).collect(Collectors.toList());
    }
}
