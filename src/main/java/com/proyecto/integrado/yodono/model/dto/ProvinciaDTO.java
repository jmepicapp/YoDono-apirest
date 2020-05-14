package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.Provincia;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Provincia} entity.
 */
public class ProvinciaDTO implements Serializable {
    
    private Long id;
    private String nombre;
    private ComunidadAutonomaDTO comunidad;
    
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

    public ComunidadAutonomaDTO getComunidad() {
        return comunidad;
    }

    public void setComunidad(ComunidadAutonomaDTO comunidad) {
        this.comunidad = comunidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProvinciaDTO provinciaDTO = (ProvinciaDTO) o;
        if (provinciaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), provinciaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProvinciaDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", comunidad='" + getComunidad() + "'" +
            "}";
    }
}
