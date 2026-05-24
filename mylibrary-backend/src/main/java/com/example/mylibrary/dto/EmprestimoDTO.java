package com.example.mylibrary.dto;

import java.time.LocalDate;

public class EmprestimoDTO {

    private Long id;

    private Long livroId;
    private String tituloLivro;

    private String nomePessoa;
    private String telefone;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoEfetiva;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(Long id,
                         Long livroId,
                         String tituloLivro,
                         String nomePessoa,
                         String telefone,
                         LocalDate dataEmprestimo,
                         LocalDate dataDevolucaoPrevista,
                         LocalDate dataDevolucaoEfetiva) {

        this.id = id;
        this.livroId = livroId;
        this.tituloLivro = tituloLivro;
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }

    public Long getId() {
        return id;
    }

    public Long getLivroId() {
        return livroId;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public void setDataDevolucaoEfetiva(LocalDate dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }
}