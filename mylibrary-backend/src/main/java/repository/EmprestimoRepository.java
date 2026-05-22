package repository;

import model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByLivroId(Long livroId);
    List<Emprestimo> findByDataDevolucaoEfetivaIsNull();
    List<Emprestimo> findByDataDevolucaoPrevistaBeforeAndDataDevolucaoEfetivaIsNull(java.time.LocalDate dataDevolucaoPrevista);
}
