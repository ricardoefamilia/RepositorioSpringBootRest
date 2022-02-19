package com.springbootricardo03.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootricardo03.model.Pessoa;

@Repository
@Transactional
public interface IPessoaRepository extends CrudRepository<Pessoa, Long>{

}
