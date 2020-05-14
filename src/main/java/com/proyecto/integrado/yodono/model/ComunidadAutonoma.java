package com.proyecto.integrado.yodono.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * A Provincia.
 */
@Entity
@Table(name = "comunidades_autonomas")
public class ComunidadAutonoma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public ComunidadAutonoma nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ComunidadAutonoma)) {
            return false;
        }
        return id != null && id.equals(((ComunidadAutonoma) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Provincia{" +
            "id=" + getId() +
            ", nombre='" + getNombre() +
            "'}";
    }
}
