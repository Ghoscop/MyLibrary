package com.example.mylibrary.controller;

import com.example.mylibrary.Service.CategoriaService;
import com.example.mylibrary.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {


    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoriaService.criar(categoria);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        categoriaService.deletar(id);
    }
}