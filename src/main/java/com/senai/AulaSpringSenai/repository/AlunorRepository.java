package com.senai.AulaSpringSenai.repository;

import com.senai.AulaSpringSenai.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunorRepository extends JpaRepository<Aluno, Long> {
}
