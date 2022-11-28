package com.example.crudbasico.service.impl;

import com.example.crudbasico.dto.PersonDTO;
import com.example.crudbasico.entity.PersonEntity;

import java.util.List;

public interface PersonManagementServiceImpl {

    String save(PersonEntity person);

    List<PersonDTO> personList();
}
