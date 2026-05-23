package com.example.mylibrary.Service;

import com.example.mylibrary.model.Emprestimo;
import com.example.mylibrary.model.Livro;
import com.example.mylibrary.model.StatusLivro;
import com.example.mylibrary.repository.EmprestimoRepository;
import com.example.mylibrary.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;
    private final LivroRepository livroRepository;

    public EmprestimoService(EmprestimoRepository repository, LivroRepository livroRepository) {
        this.repository = repository;
        this.livroRepository = livroRepository;
    }

    public List<Emprestimo> findAll(){
        return repository.findAll();
    }

    public List<Emprestimo> findByAtivos(){
        return repository.findByDataDevolucaoEfetivaIsNull();
    }

    public List<Emprestimo> findByAtrasados() {
        return repository
                .findByDataDevolucaoPrevistaBeforeAndDataDevolucaoEfetivaIsNull(LocalDate.now());
    }

    public Emprestimo emprestar(Emprestimo emprestimo) {

        Livro livro = livroRepository.findById(emprestimo.getLivro().getId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado."));

        if (livro.getStatus() == StatusLivro.EMPRESTADO) {
            throw new RuntimeException("Livro já está emprestado.");
        }

        livro.setStatus(StatusLivro.EMPRESTADO);
        livroRepository.save(livro);

        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());

        return repository.save(emprestimo);
    }

    public Emprestimo devolver(Long id) {

        Emprestimo emprestimo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));

        if (emprestimo.getDataDevolucaoEfetiva() != null) {
            throw new RuntimeException("Livro já foi devolvido.");
        }

        emprestimo.setDataDevolucaoEfetiva(LocalDate.now());

        Livro livro = emprestimo.getLivro();
        livro.setStatus(StatusLivro.DISPONIVEL);

        livroRepository.save(livro);

        return repository.save(emprestimo);
    }
}
