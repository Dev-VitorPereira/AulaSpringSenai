package com.senai.AulaSpringSenai.controller;

import com.senai.AulaSpringSenai.model.Aluno;
import com.senai.AulaSpringSenai.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    public List<Aluno> lista(){
        return alunoService.listaAlunos();
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno){
        return alunoService.salva(aluno);
    }

    @GetMapping ("/{id}")
    public Optional<Aluno> buscarPorId(@PathVariable Long id){
        return alunoService.buscarPorId(id);
    }

    @DeleteMapping ("/{id}")
    public void deletar (@PathVariable Long id){
        alunoService.deletarAluno(id);
    }

    @PutMapping ("/{id}")
    public Aluno atualizar (@PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        Aluno alunoExistente = alunoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        alunoExistente.setNomeAluno(alunoAtualizado.getNomeAluno());
        alunoExistente.setEmailAluno(alunoAtualizado.getEmailAluno());
        alunoExistente.setTelefoneAluno(alunoAtualizado.getTelefoneAluno());

        return alunoService.salva(alunoExistente);
    }
}
