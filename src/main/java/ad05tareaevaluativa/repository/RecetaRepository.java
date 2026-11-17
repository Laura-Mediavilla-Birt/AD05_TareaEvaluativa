package ad05tareaevaluativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ad05tareaevaluativa.model.Receta;

// Repositorio para gestionar las recetas en Oracle
public interface RecetaRepository extends JpaRepository<Receta, Long> {

}