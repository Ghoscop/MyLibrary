package com.example.mylibrary.dto;

import com.example.mylibrary.model.StatusLivro;

public class LivroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private StatusLivro status;

    private Long categoriaId;
    private String categoriaNome;

    public LivroDTO() {
    }

    public LivroDTO(Long id, String titulo, String autor,
                    StatusLivro status,
                    Long categoriaId,
                    String categoriaNome) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
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