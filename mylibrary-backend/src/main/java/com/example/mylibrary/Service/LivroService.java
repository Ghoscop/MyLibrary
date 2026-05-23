package com.example.mylibrary.Service;

import com.example.mylibrary.model.Categoria;
import com.example.mylibrary.model.Livro;
import com.example.mylibrary.model.StatusLivro;
import com.example.mylibrary.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import com.example.mylibrary.repository.LivroRepository;

import java.util.List;

@Service
public class LivroService {


    private final LivroRepository repository;
    private final CategoriaRepository categoriaRepository;

    public LivroService(LivroRepository livroRepository, CategoriaRepository categoriaRepository) {
        this.repository = livroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Livro> findAll() {
        return repository.findAll()
                .stream().sorted().toList();
    }

    public Livro buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public List<Livro> buscarPorTexto(String texto) {
        return repository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(texto, texto);
    }

    public List<Livro> filtrarPorCategoria(Long categoriaId) {
        return repository.findByCategoriaId(categoriaId);
    }

    public List<Livro> filtrarPorStatus(StatusLivro status) {
        return repository.findByStatus(String.valueOf(status));
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
        livro.setCategoria(categoria);
        livro.setStatus(StatusLivro.DISPONIVEL);

        return repository.save(livro);
    }

    public void excluir(Long id) {
        Livro livro = buscarPorId(id);

        if(livro.getStatus() == StatusLivro.EMPRESTADO){
            throw new RuntimeException("Não é possível excluir livro emprestado.");
        }
        repository.delete(livro);
    }

}
