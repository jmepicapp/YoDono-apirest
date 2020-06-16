package com.proyecto.integrado.yodono.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * A Empresa.
 */
@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private Integer telefono;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "direccion_id")
    //private Direccion direccion;
    
    @Column(name = "poblacion")
    private String poblacion;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "empresa", orphanRemoval = true)
    private List<Preferencia> preferenciasCategoriaProductos = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "donacionesEmpresas"})
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa", orphanRemoval = true)
    private List<Donacion> donacionesEmpresas = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Empresa nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public Empresa telefono(Integer telefono) {
        this.telefono = telefono;
        return this;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    //public Direccion getDireccion() {
    //    return direccion;
    //}

    //public Empresa direccion(Direccion direccion) {
    //    this.direccion = direccion;
    //    return this;
    //}

    //public void setDireccion(Direccion direccion) {
    //    this.direccion = direccion;
    //}

    public List<Preferencia> getPreferenciasCategoriaProductos() {
        return preferenciasCategoriaProductos;
    }

    public Empresa preferenciasCategoriaProductos(List<Preferencia> preferencias) {
        this.preferenciasCategoriaProductos = preferencias;
        return this;
    }

    public Empresa addPreferenciasCategoriaProductos(Preferencia preferencia) {
        this.preferenciasCategoriaProductos.add(preferencia);
        preferencia.setEmpresa(this);
        return this;
    }

    public Empresa removePreferenciasCategoriaProductos(Preferencia preferencia) {
        this.preferenciasCategoriaProductos.remove(preferencia);
        preferencia.setEmpresa(null);
        return this;
    }

    public void setPreferenciasCategoriaProductos(List<Preferencia> preferencias) {
        this.preferenciasCategoriaProductos = preferencias;
    }

    public List<Donacion> getDonacionesEmpresas() {
        return donacionesEmpresas;
    }

    public Empresa donacionesEmpresas(List<Donacion> donacions) {
        this.donacionesEmpresas = donacions;
        return this;
    }

    public Empresa addDonacionesEmpresas(Donacion donacion) {
        this.donacionesEmpresas.add(donacion);
        donacion.setEmpresa(this);
        return this;
    }

    public Empresa removeDonacionesEmpresas(Donacion donacion) {
        this.donacionesEmpresas.remove(donacion);
        donacion.setEmpresa(null);
        return this;
    }

    public void setDonacionesEmpresas(List<Donacion> donacionesEmpresas) {
        this.donacionesEmpresas = donacionesEmpresas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Empresa)) {
            return false;
        }
        return id != null && id.equals(((Empresa) o).id);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                //", direccion=" + direccion +
                ", preferenciasCategoriaProductos=" + preferenciasCategoriaProductos +
                ", usuario=" + usuario +
                '}';
    }

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
    
    
}
