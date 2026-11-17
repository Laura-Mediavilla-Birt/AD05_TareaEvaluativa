package ad05tareaevaluativa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad05tareaevaluativa.model.Paso;
import ad05tareaevaluativa.repository.PasoRepository;

@Service
public class PasoService {

    private final PasoRepository pasoRepository;

    // Inyección del repositorio mediante constructor
    public PasoService(PasoRepository pasoRepository) {
        this.pasoRepository = pasoRepository;
    }

    // Obtener todos los pasos
    public List<Paso> listar() {
        return pasoRepository.findAll();
    }

    // Buscar un paso por su identificador
    public Paso buscarPorId(Long id) {
        return pasoRepository.findById(id).orElse(null);
    }

    // Guardar un paso nuevo o actualizar uno existente
    public Paso guardar(Paso paso) {
        return pasoRepository.save(paso);
    }

    // Eliminar únicamente el paso seleccionado
    @Transactional
    public void eliminar(Long id) {
        Paso paso = buscarPorId(id);

        if (paso != null) {
            pasoRepository.delete(paso);
        }
    }
}

