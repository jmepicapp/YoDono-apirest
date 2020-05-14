package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.Rol;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Rol} entity.
 */
public class ProductoDTO implements Serializable {

    private Long id;
    private String nombre;
    private String cantidad;
    private String medida;
    private DonacionDTO donacion;
    private CategoriaProductoDTO categoria;

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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public DonacionDTO getDonacion() {
        return donacion;
    }

    public void setDonacion(DonacionDTO donacion) {
        this.donacion = donacion;
    }

    public CategoriaProductoDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProductoDTO categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductoDTO rolDTO = (ProductoDTO) o;
        if (rolDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rolDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", medida='" + medida + '\'' +
                ", donacion=" + donacion +
                ", categoria=" + categoria +
                '}';
    }
}
