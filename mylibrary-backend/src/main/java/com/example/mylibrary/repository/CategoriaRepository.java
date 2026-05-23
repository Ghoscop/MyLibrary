package com.example.mylibrary.repository;

import com.example.mylibrary.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByNome(String nome);
}
