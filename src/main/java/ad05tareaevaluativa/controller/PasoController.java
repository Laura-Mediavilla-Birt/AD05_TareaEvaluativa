package ad05tareaevaluativa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ad05tareaevaluativa.model.Paso;
import ad05tareaevaluativa.model.Receta;
import ad05tareaevaluativa.service.PasoService;
import ad05tareaevaluativa.service.RecetaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pasos")
public class PasoController {

    private final PasoService pasoService;
    private final RecetaService recetaService;

    public PasoController(PasoService pasoService, RecetaService recetaService) {
        this.pasoService = pasoService;
        this.recetaService = recetaService;
    }

    // Mostrar todos los pasos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pasos", pasoService.listar());
        return "pasos/lista";
    }

    // Mostrar el formulario para crear un paso
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("paso", new Paso());
        model.addAttribute("recetas", recetaService.listar());
        return "pasos/formulario";
    }

    // Guardar un paso nuevo o actualizar uno existente
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("paso") Paso paso,
                          BindingResult resultado,
                          @RequestParam(value = "recetaId", required = false) Long recetaId,
                          Model model) {

        Receta receta = recetaId == null ? null : recetaService.buscarPorId(recetaId);

        if (receta == null) {
            resultado.rejectValue("receta", "receta.invalida",
                    "Debes seleccionar una receta válida");
        }

        if (resultado.hasErrors()) {
            model.addAttribute("recetas", recetaService.listar());
            model.addAttribute("recetaId", recetaId);
            return "pasos/formulario";
        }

        paso.setReceta(receta);
        pasoService.guardar(paso);

        return "redirect:/pasos";
    }

    // Mostrar el formulario para editar un paso
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Paso paso = pasoService.buscarPorId(id);

        if (paso == null) {
            return "redirect:/pasos";
        }

        model.addAttribute("paso", paso);
        model.addAttribute("recetas", recetaService.listar());
        model.addAttribute("recetaId", paso.getReceta().getId());

        return "pasos/formulario";
    }

    // Mostrar la confirmación antes de eliminar
    @GetMapping("/eliminar/{id}")
    public String confirmarEliminar(@PathVariable Long id, Model model) {
        Paso paso = pasoService.buscarPorId(id);

        if (paso == null) {
            return "redirect:/pasos";
        }

        model.addAttribute("paso", paso);
        return "pasos/confirmar-eliminar";
    }

    // Ejecutar el borrado mediante POST
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        pasoService.eliminar(id);
        return "redirect:/pasos";
    }
}
