package com.example.mylibrary.Service;

import com.example.mylibrary.model.Categoria;
import org.springframework.stereotype.Service;
import com.example.mylibrary.repository.CategoriaRepository;
import com.example.mylibrary.repository.LivroRepository;

import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    private LivroRepository livroRepository;

    CategoriaService(CategoriaRepository categoriaRepository, LivroRepository livroRepository) {
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria criar(Categoria categoria) {
        if(categoriaRepository.existsByNome(categoria.getNome())){
            throw new RuntimeException("Já existe uma categoria com esse nome");
        }
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        long totalLivros = livroRepository.countByCategoriaId(id);
        if(totalLivros > 0){
            throw new RuntimeException("Existem livros cadastrados nessa categoria");
        }

        categoriaRepository.delete(categoria);
    }
}
