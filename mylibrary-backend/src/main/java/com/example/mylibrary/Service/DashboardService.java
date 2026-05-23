package com.example.mylibrary.service;

import com.example.mylibrary.dto.DashboardDTO;
import com.example.mylibrary.model.StatusLivro;
import com.example.mylibrary.repository.EmprestimoRepository;
import com.example.mylibrary.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final LivroRepository livroRepository;
    private final EmprestimoRepository emprestimoRepository;

    public DashboardService(LivroRepository livroRepository, EmprestimoRepository emprestimoRepository) {
        this.livroRepository = livroRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    public DashboardDTO buscarEstatisticas() {
        long totalLivros = livroRepository.count();
        long livrosDisponiveis = livroRepository.countByStatus(StatusLivro.DISPONIVEL);
        long livrosEmprestados = livroRepository.countByStatus(StatusLivro.EMPRESTADO);
        long emprestimosAtivos = emprestimoRepository.findByDataDevolucaoEfetivaIsNull().size();

        return new DashboardDTO(
                totalLivros,
                livrosDisponiveis,
                livrosEmprestados,
                emprestimosAtivos,
                emprestimoRepository.findTop5ByOrderByIdDesc()
        );
    }
}