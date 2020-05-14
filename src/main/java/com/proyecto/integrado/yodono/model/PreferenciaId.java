package com.proyecto.integrado.yodono.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PreferenciaId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "empresa_id")
    private Long EmpresaId;

    @Column(name = "categoria_producto_id")
    private Long categoriaProductoId;

    public PreferenciaId() {
    }

    public PreferenciaId(Long empresaId, Long categoriaProductoId) {
        this.EmpresaId = empresaId;
        this.categoriaProductoId = categoriaProductoId;
    }

    public Long getEmpresaId() {
        return EmpresaId;
    }

    public void setEmpresaId(Long Empresa) {
        this.EmpresaId = Empresa;
    }

    public Long getCategoriaProductoId() {
        return categoriaProductoId;
    }

    public void setCategoriaProductoId(Long categoriaProducto) {
        this.categoriaProductoId = categoriaProducto;
    }

    @Override
    public String toString() {
        return "PreferenciaId{" +
                "empresa=" + EmpresaId +
                ", categoriaProducto=" + categoriaProductoId +
                '}';
    }
}
