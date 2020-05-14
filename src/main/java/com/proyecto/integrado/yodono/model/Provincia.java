package com.proyecto.integrado.yodono.model;


import javax.persistence.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Provincia.
 */
@Entity
@Table(name = "provincias")
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "comunidad_autonoma_id")
    @JsonIgnoreProperties("comunidadAutonomas")
    private ComunidadAutonoma comunidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Provincia nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ComunidadAutonoma getComunidad() {
        return comunidad;
    }

    public Provincia comunidad(ComunidadAutonoma comunidad) {
        this.comunidad = comunidad;
        return this;
    }

    public void setComunidad(ComunidadAutonoma comunidad) {
        this.comunidad = comunidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Provincia)) {
            return false;
        }
        return id != null && id.equals(((Provincia) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Provincia{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", comunidad='" + getComunidad() + "'" +
            "}";
    }
}
