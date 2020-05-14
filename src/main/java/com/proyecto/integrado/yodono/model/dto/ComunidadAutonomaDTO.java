package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.ComunidadAutonoma;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ComunidadAutonoma} entity.
 */
public class ComunidadAutonomaDTO implements Serializable {
    
    private Long id;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ComunidadAutonomaDTO poblacionDTO = (ComunidadAutonomaDTO) o;
        if (poblacionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), poblacionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PoblacionDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() +
            "'}";
    }
}
