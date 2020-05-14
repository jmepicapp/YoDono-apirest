package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.Donacion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link Donacion} entity.
 */
public class DonacionDTO implements Serializable {
    
    private Long id;
    private String descripcionEmpresa;
    private LocalDateTime fechaCreacion;
    private DonanteDTO donante;
    private EmpresaDTO empresa;
    private String estado;
    private List<ProductoDTO> productos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DonanteDTO getDonante() {
        return donante;
    }

    public void setDonante(DonanteDTO donante) {
        this.donante = donante;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DonacionDTO donacionDTO = (DonacionDTO) o;
        if (donacionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), donacionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DonacionDTO{" +
                "id=" + id +
                ", descripcionEmpresa='" + descripcionEmpresa + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", donante=" + donante +
                ", empresa=" + empresa +
                ", estado='" + estado + '\'' +
                ", productos=" + productos +
                '}';
    }
}