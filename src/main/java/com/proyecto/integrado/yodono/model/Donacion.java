package com.proyecto.integrado.yodono.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Donacion.
 */
@Entity
@Table(name = "donaciones")
public class Donacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion_empresa")
    private String descripcionEmpresa;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "donante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "donacionesDonantes"})
    private Donante donante;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "donacionesEmpresas"})
    private Empresa empresa;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "donacion", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Producto> listaProducto = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public Donacion descripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
        return this;
    }
    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Donacion fechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    @PrePersist
    public void setFechaCreacion() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Donante getDonante() {
        return donante;
    }

    public Donacion donante(Donante donante) {
        this.donante = donante;
        return this;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Donacion Empresa(Empresa empresa) {
        this.empresa = empresa;
        return this;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Donacion)) {
            return false;
        }
        return id != null && id.equals(((Donacion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Donacion{" +
                "id=" + id +
                ", descripcionEmpresa='" + descripcionEmpresa + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                ", donante=" + donante +
                ", empresa=" + empresa +
                ", listaProducto=" + listaProducto +
                '}';
    }
}