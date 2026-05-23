package com.example.mylibrary.controller;

import com.example.mylibrary.Service.LivroService;
import com.example.mylibrary.model.Livro;
import com.example.mylibrary.model.StatusLivro;
import org.springframework.web.bind.annotation.*;
import com.example.mylibrary.dto.LivroDTO;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = "*")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroDTO> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public LivroDTO buscarPorId(@PathVariable Long id){
        return livroService.findById(id);
    }

    @DeleteMapping("/buscar")
    public List<LivroDTO> buscarPorTexto(@RequestParam String texto){
        return livroService.buscarPorTexto(texto);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<LivroDTO> buscarPorCategoria(@PathVariable long categoriaId){
        return livroService.filtrarPorCategoria(categoriaId);
    }

    @GetMapping("/status/{status}")
    public List<LivroDTO> buscarPorStatus(@PathVariable StatusLivro status){
        return livroService.filtrarPorStatus(status);
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro){
        return livroService.criar(livro);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        livroService.excluir(id);
    }
}
