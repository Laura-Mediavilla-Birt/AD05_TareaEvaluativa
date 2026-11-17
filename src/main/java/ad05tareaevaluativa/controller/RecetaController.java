package ad05tareaevaluativa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ad05tareaevaluativa.model.Receta;
import ad05tareaevaluativa.service.RecetaService;

import jakarta.validation.Valid;

/**
 * Controlador encargado de gestionar las recetas.
 */
@Controller
@RequestMapping("/recetas")
public class RecetaController {

    private final RecetaService recetaService;

    // Inyección del servicio mediante constructor
    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    // Mostrar el listado de recetas
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("recetas", recetaService.listar());
        return "recetas/lista";
    }

    // Mostrar el formulario para crear una receta
    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("receta", new Receta());
        return "recetas/formulario";
    }

    // Guardar una receta nueva o modificada
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("receta") Receta receta,
                          BindingResult resultado) {

        if (resultado.hasErrors()) {
            return "recetas/formulario";
        }

        recetaService.guardar(receta);
        return "redirect:/recetas";
    }

    // Mostrar el formulario de edición
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        Receta receta = recetaService.buscarPorId(id);

        if (receta == null) {
            return "redirect:/recetas";
        }

        model.addAttribute("receta", receta);
        return "recetas/formulario";
    }

    // Mostrar la confirmación antes de eliminar
    @GetMapping("/eliminar/{id}")
    public String confirmarEliminar(@PathVariable Long id, Model model) {

        Receta receta = recetaService.buscarPorId(id);

        if (receta == null) {
            return "redirect:/recetas";
        }

        model.addAttribute("receta", receta);
        return "recetas/confirmar-eliminar";
    }

    // Ejecutar el borrado mediante POST
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        recetaService.eliminar(id);
        return "redirect:/recetas";
    }
}