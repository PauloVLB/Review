package com.teste.review.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.review.model.Pessoa;
import com.teste.review.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa getByIdOrError(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Pessoa não encontrada"));
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}
