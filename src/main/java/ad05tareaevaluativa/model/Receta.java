package ad05tareaevaluativa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Entidad principal que representa una receta.
 */
@Entity
public class Receta {

    // Identificador generado automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre de la receta
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    // Descripción de la receta
    @NotBlank(message = "La descripción es obligatoria")
    @Column(length = 1000)
    private String descripcion;

    // Categoría de la receta
    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    // Una receta puede tener varios pasos.
    // Al eliminar la receta, también se eliminan sus pasos.
    @OneToMany(mappedBy = "receta",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Paso> pasos = new ArrayList<>();

    // Constructor vacío necesario para JPA
    public Receta() {
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Paso> getPasos() {
        return pasos;
    }

    public void setPasos(List<Paso> pasos) {
        this.pasos = pasos;
    }
}