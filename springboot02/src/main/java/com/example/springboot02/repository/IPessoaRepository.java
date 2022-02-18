package com.example.springboot02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot02.model.Pessoa;

@Repository
@Transactional
public interface IPessoaRepository extends CrudRepository<Pessoa, Long>{

}
