package com.gestao_financeira.web.service;

import com.gestao_financeira.web.dto.PersonCreateRequest;
import com.gestao_financeira.web.dto.PersonResponse;
import com.gestao_financeira.web.dto.PersonUpdateRequest;
import com.gestao_financeira.web.model.Person;
import com.gestao_financeira.web.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gestao_financeira.web.util.mapper.ObjectMapper.parseListObjects;
import static com.gestao_financeira.web.util.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonResponse save(PersonCreateRequest personCreateRequest){
        var entity = parseObject(personCreateRequest, Person.class);

        entity.setPaid(false);

        return parseObject(personRepository.save(entity), PersonResponse.class);
    }


    public PersonResponse update(Long id, PersonUpdateRequest personUpdateRequest){
        var entity = personRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        entity.setName(personUpdateRequest.getName());
        entity.setDayOfPayment(personUpdateRequest.getDayOfPayment());
        entity.setMonthlyPayment(personUpdateRequest.getMonthlyPayment());
        entity.setNumber(personUpdateRequest.getNumber());

        personRepository.save(entity);

        return parseObject(entity, PersonResponse.class);
    }

    public PersonResponse findById(Long id){
        var entity = personRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return parseObject(entity, PersonResponse.class);
    }

    public List<PersonResponse> findAll(){
        List<Person> entityList = personRepository.findAll();

        return parseListObjects(entityList, PersonResponse.class);
    }

    public void delete(Long id){
        var entity = personRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        personRepository.delete(entity);
    }
}
