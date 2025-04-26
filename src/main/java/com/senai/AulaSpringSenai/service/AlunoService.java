package com.senai.AulaSpringSenai.service;

import com.senai.AulaSpringSenai.model.Aluno;
import com.senai.AulaSpringSenai.repository.AlunorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

@Autowired
    private AlunorRepository alunorRepository;

    public Aluno salva (Aluno aluno){
        return alunorRepository.save(aluno);
    }

    public List<Aluno> listaAlunos (){
        return alunorRepository.findAll();
    }

    public Optional<Aluno> buscarPorId (Long id){
        return alunorRepository.findById(id);
    }
    public void deletarAluno(Long id){
        alunorRepository.deleteById(id);
    }

}
