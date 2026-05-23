package com.example.mylibrary.controller;

import com.example.mylibrary.Service.EmprestimoService;
import com.example.mylibrary.model.Emprestimo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
@CrossOrigin(origins = "*")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public List<Emprestimo> findAll() {
        return emprestimoService.findAll();
    }

    @GetMapping("/ativos")
    public List<Emprestimo> findByAtivos() {
        return emprestimoService.findByAtivos();
    }

    @GetMapping("/atrasados")
    public List<Emprestimo> findByAtrasados() {
        return emprestimoService.findByAtrasados();
    }

    @PostMapping("/emprestar")
    public Emprestimo emprestar(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.emprestar(emprestimo);
    }

    @PostMapping("/{id}/devolver")
    public Emprestimo devolver(@PathVariable Long id) {
        return emprestimoService.devolver(id);
    }
}
