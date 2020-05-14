package com.proyecto.integrado.yodono.model.dto;


import java.io.Serializable;

/**
 * A DTO for the {@link Coordenada} entity.
 */
public class CoordenadaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String latitud;
    private String longitud;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CoordenadaDTO)) {
            return false;
        }
        return id != null && id.equals(((CoordenadaDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Coordenada{" +
                "id=" + id +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }
}
