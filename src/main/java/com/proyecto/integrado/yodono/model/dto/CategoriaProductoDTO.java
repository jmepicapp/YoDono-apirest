package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.CategoriaProducto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link CategoriaProducto} entity.
 */
public class CategoriaProductoDTO implements Serializable {
    
    private Long id;
    private String nombre;
    private String descripcion;
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CategoriaProductoDTO categoriaProductoDTO = (CategoriaProductoDTO) o;
        if (categoriaProductoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), categoriaProductoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CategoriaProductoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
