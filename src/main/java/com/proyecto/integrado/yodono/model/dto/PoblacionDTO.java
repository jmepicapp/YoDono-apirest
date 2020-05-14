package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.Poblacion;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Poblacion} entity.
 */
public class PoblacionDTO implements Serializable {
    
    private Long id;
    private String nombre;
    private ProvinciaDTO provincia;
    
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

    public ProvinciaDTO getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaDTO provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PoblacionDTO poblacionDTO = (PoblacionDTO) o;
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
            ", nombre='" + getNombre() + "'" +
            ", provincia=" + getProvincia() +
            "}";
    }
}
