package ad05tareaevaluativa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad05tareaevaluativa.model.Receta;
import ad05tareaevaluativa.repository.RecetaRepository;

@Service
public class RecetaService {

    private final RecetaRepository recetaRepository;

    // Inyección del repositorio mediante constructor
    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    // Obtener todas las recetas
    public List<Receta> listar() {
        return recetaRepository.findAll();
    }

    // Buscar una receta por su identificador
    public Receta buscarPorId(Long id) {
        return recetaRepository.findById(id).orElse(null);
    }

    // Guardar una receta nueva o actualizar una existente
    public Receta guardar(Receta receta) {
        return recetaRepository.save(receta);
    }

    // Eliminar una receta y sus pasos asociados mediante cascada
    @Transactional
    public void eliminar(Long id) {
        Receta receta = buscarPorId(id);

        if (receta != null) {
            recetaRepository.delete(receta);
        }
    }
}