package com.example.mylibrary.dto;

import com.example.mylibrary.model.Emprestimo;
import java.util.List;

public class DashboardDTO {

    private long totalLivros;
    private long livrosDisponiveis;
    private long livrosEmprestados;
    private long emprestimosAtivos;
    private List<Emprestimo> ultimosEmprestimos;

    public DashboardDTO(long totalLivros, long livrosDisponiveis, long livrosEmprestados,
                        long emprestimosAtivos, List<Emprestimo> ultimosEmprestimos) {
        this.totalLivros = totalLivros;
        this.livrosDisponiveis = livrosDisponiveis;
        this.livrosEmprestados = livrosEmprestados;
        this.emprestimosAtivos = emprestimosAtivos;
        this.ultimosEmprestimos = ultimosEmprestimos;
    }

    public long getTotalLivros() {
        return totalLivros;
    }

    public long getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public long getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public long getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public List<Emprestimo> getUltimosEmprestimos() {
        return ultimosEmprestimos;
    }
}