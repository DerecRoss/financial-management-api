package com.gestao_financeira.web.repository;

import com.gestao_financeira.web.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByIsPaid(Boolean payment);
}
