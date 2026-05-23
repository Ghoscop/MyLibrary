package com.example.mylibrary.dto;

import com.example.mylibrary.model.StatusLivro;

public class LivroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer ano;
    private StatusLivro status;

    private Long categoriaId;
    private String categoriaNome;

    public LivroDTO() {
    }

    public LivroDTO(Long id, String titulo, String autor,
                    String isbn, Integer ano,
                    StatusLivro status,
                    Long categoriaId,
                    String categoriaNome) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
        this.status = status;
        this.categoriaId = categoriaId;
        this.categoriaNome = categoriaNome;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getAno() {
        return ano;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }
}