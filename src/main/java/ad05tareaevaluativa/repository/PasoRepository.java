package ad05tareaevaluativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ad05tareaevaluativa.model.Paso;

// Repositorio para gestionar los pasos de las recetas
public interface PasoRepository extends JpaRepository<Paso, Long> {

}