package com.proyecto.integrado.yodono.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Preferencia.
 */
@Entity
@Table(name = "preferencias")
public class Preferencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PreferenciaId id;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "empresa_id")
    @JsonIgnore
    private Empresa empresa;

    @ManyToOne
    @MapsId("categoriaProductoId")
    @JoinColumn(name = "categoria_producto_id")
    private CategoriaProducto categoriaProducto;

    @Column(name = "necesidad")
    private Boolean necesidad;

    @Column(name = "exclusion")
    private Boolean exclusion;

    public PreferenciaId getId() {
        return id;
    }

    public void setId(PreferenciaId id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
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

    public Preferencia exclusion(Boolean exclusion) {
        this.exclusion = exclusion;
        return this;
    }

    public Preferencia empresa(Empresa empresa) {
        this.empresa = empresa;
        return this;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Preferencia)) {
            return false;
        }
        return id != null && id.equals(((Preferencia) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Preferencia{" +
                "id=" + id +
                ", empresa=" + empresa +
                ", categoriaProducto=" + categoriaProducto +
                ", exclusion=" + exclusion +
                '}';
    }
}
