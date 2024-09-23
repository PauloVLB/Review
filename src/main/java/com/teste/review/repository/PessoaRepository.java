package com.teste.review.repository;


import org.springframework.stereotype.Repository;

import com.teste.review.model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
