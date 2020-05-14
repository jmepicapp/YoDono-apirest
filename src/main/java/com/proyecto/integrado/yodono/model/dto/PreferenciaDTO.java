package com.proyecto.integrado.yodono.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.integrado.yodono.model.PreferenciaId;
import com.proyecto.integrado.yodono.model.Preferencia;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Preferencia} entity.
 */
public class PreferenciaDTO implements Serializable {

    @JsonIgnore
    private PreferenciaId id;
    private EmpresaDTO empresa;
    private CategoriaProductoDTO categoriaProducto;
    private Boolean necesidad;
    private Boolean exclusion;

    public PreferenciaId getId() {
        return id;
    }

    public void setId(PreferenciaId id) {
        this.id = id;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public CategoriaProductoDTO getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProductoDTO categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public Boolean getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(Boolean necesidad) {
        this.necesidad = necesidad;
    }

    public Boolean getExclusion() {
        return exclusion;
    }

    public void setExclusion(Boolean exclusion) {
        this.exclusion = exclusion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PreferenciaDTO preferenciaDTO = (PreferenciaDTO) o;
        if (preferenciaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), preferenciaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PreferenciaDTO{" +
                "id=" + id +
                ", empresa=" + empresa +
                ", categoriaProducto=" + categoriaProducto +
                ", necesidad=" + necesidad +
                ", exclusion=" + exclusion +
                '}';
    }
}
