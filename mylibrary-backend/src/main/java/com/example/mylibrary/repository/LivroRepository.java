package com.example.mylibrary.repository;

import com.example.mylibrary.dto.LivroDTO;
import com.example.mylibrary.model.Livro;
import com.example.mylibrary.model.StatusLivro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByCategoriaId(long categoriaId);
    List<Livro> findByStatus(StatusLivro status);
    List<Livro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);
    long countByCategoriaId(Long categoriaId);
    long countByStatus(StatusLivro status);
}
