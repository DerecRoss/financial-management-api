package com.gestao_financeira.web.service;

import com.gestao_financeira.web.dto.PersonCreateRequest;
import com.gestao_financeira.web.dto.PersonPaymentResponse;
import com.gestao_financeira.web.dto.PersonResponse;
import com.gestao_financeira.web.dto.PersonUpdateRequest;
import com.gestao_financeira.web.model.Payment;
import com.gestao_financeira.web.model.Person;
import com.gestao_financeira.web.repository.PaymentRepository;
import com.gestao_financeira.web.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.gestao_financeira.web.util.mapper.ObjectMapper.parseListObjects;
import static com.gestao_financeira.web.util.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public Person save(PersonCreateRequest request) {

        Person person = new Person();

        person.setName(request.getName());
        person.setNumber(request.getNumber());
        person.setDayOfPayment(request.getDayOfPayment());
        person.setMonthlyPayment(request.getMonthlyPayment());

        Person savedPerson = personRepository.save(person);

        LocalDate today = LocalDate.now();

        Payment payment = new Payment();

        payment.setPerson(savedPerson);
        payment.setMonth(today.getMonthValue());
        payment.setYear(today.getYear());
        payment.setAmount(savedPerson.getMonthlyPayment());
        payment.setPaid(false);

        paymentRepository.save(payment);

        return savedPerson;
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

    public List<PersonPaymentResponse> findByIsPaid(Boolean payment){
        List<Person> entityList = personRepository.findByIsPaid(payment);

        return parseListObjects(entityList, PersonPaymentResponse.class);
    }

    public void delete(Long id){
        var entity = personRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        personRepository.delete(entity);
    }
}
