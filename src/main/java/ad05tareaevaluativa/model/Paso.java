package ad05tareaevaluativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entidad dependiente que representa un paso de una receta.
 */
@Entity
public class Paso {

    // Identificador generado automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Número que indica el orden del paso
    @NotNull(message = "El número de orden es obligatorio")
    @Min(value = 1, message = "El número debe ser al menos 1")
    private Integer numeroOrden;

    // Instrucciones para realizar el paso
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 1000)
    @Column(length = 1000)
    private String descripcion;

    // Cada paso pertenece a una receta
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receta_id", nullable = false)
    private Receta receta;

    // Constructor vacío necesario para JPA
    public Paso() {
    }

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNumeroOrden() {
        return numeroOrden;
    }
    public void setNumeroOrden(Integer numeroOrden) {
        this.numeroOrden = numeroOrden;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Receta getReceta() {
        return receta;
    }
    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}