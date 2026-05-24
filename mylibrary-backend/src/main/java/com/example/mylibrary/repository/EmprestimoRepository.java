package com.example.mylibrary.repository;

import com.example.mylibrary.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findByLivroId(Long livroId);

    List<Emprestimo> findByDataDevolucaoEfetivaIsNull();

    List<Emprestimo> findByDataDevolucaoPrevistaBeforeAndDataDevolucaoEfetivaIsNull(LocalDate hoje);

    void deleteByLivroId(Long livroId);

    List<Emprestimo> findTop5ByOrderByIdDesc();

}