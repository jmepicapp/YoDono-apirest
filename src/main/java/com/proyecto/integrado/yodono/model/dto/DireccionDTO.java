package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.Direccion;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Direccion} entity.
 */
public class DireccionDTO implements Serializable {
    
    private Long id;
    private String calle;
    private Integer codigoPostal;
    private PoblacionDTO poblacion;
    private CoordenadaDTO coordenada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public PoblacionDTO getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(PoblacionDTO poblacion) {
        this.poblacion = poblacion;
    }

    public CoordenadaDTO getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(CoordenadaDTO coordenada) {
        this.coordenada = coordenada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DireccionDTO direccionDTO = (DireccionDTO) o;
        if (direccionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), direccionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DireccionDTO{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", poblacion=" + poblacion +
                ", coordenada=" + coordenada +
                '}';
    }
}
