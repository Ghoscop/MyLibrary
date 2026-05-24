package com.example.mylibrary.Service;

import com.example.mylibrary.dto.LivroDTO;
import com.example.mylibrary.model.Categoria;
import com.example.mylibrary.model.Livro;
import com.example.mylibrary.model.StatusLivro;
import com.example.mylibrary.repository.CategoriaRepository;
import com.example.mylibrary.repository.EmprestimoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.mylibrary.repository.LivroRepository;

import java.util.List;

@Service
public class LivroService {


    private final LivroRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final EmprestimoRepository emprestimoRepository;

    public LivroService(LivroRepository repository, CategoriaRepository categoriaRepository, EmprestimoRepository emprestimoRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<LivroDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public LivroDTO findById(Long id) {

        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado."));

        return converterParaDTO(livro);
    }

    public List<LivroDTO> buscarPorTexto(String texto) {
        return repository
                .findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(texto, texto)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public List<LivroDTO> filtrarPorCategoria(Long categoriaId) {
        return repository.findByCategoriaId(categoriaId)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public List<LivroDTO> filtrarPorStatus(StatusLivro status) {
        return repository.findByStatus(status)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public List<Livro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor) {
        return repository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(titulo, autor)
                .stream().sorted().toList();
    }

    public long countByCategoriaId(Long categoriaId) {
        return repository.countByCategoriaId(categoriaId);
    }

    public long countByStatus(StatusLivro status) {
        return repository.countByStatus(status);
    }

    public Livro criar(Livro livro) {
        Categoria categoria = categoriaRepository.findById(livro.getCategoria().getId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        boolean livroJaExiste = repository.existsByTituloIgnoreCaseAndAutorIgnoreCaseAndCategoriaId(
                livro.getTitulo(),
                livro.getAutor(),
                livro.getCategoria().getId()
        );

        if (livroJaExiste) {
            throw new RuntimeException("Já existe um livro com esse título, autor e categoria.");
        }

        livro.setCategoria(categoria);
        livro.setStatus(StatusLivro.DISPONIVEL);

        return repository.save(livro);
    }

    @Transactional
    public void excluir(Long id) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado."));

        if (livro.getStatus() == StatusLivro.EMPRESTADO) {
            throw new RuntimeException("Não é possível excluir livro emprestado.");
        }

        emprestimoRepository.deleteByLivroId(id);
        repository.delete(livro);
    }

    private LivroDTO converterParaDTO(Livro livro) {
        return new LivroDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getStatus(),
                livro.getCategoria().getId(),
                livro.getCategoria().getNome()
        );
    }

}
