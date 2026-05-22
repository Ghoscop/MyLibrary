package repository;

import model.Livro;
import model.StatusLivro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivroRepository extends CrudRepository<Livro, Long> {
    List<Livro> findByCategoria(String categoria);
    List<Livro> findByStatus(String status);
    List<Livro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);
    long countByCategoriaId(Long categoriaId);
    long countByStatus(StatusLivro status);
}
