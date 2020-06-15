package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.Empresa;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

/**
 * A DTO for the {@link Empresa} entity.
 */
public class EmpresaDTO implements Serializable {

    private Long id;
    private String nombre;
    private Integer telefono;
    private String poblacion;
    //private DireccionDTO direccion;
    private UsuarioDTO usuario;

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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    //public DireccionDTO getDireccion() {
    //    return direccion;
    //}

    //public void setDireccion(DireccionDTO direccion) {
    //    this.direccion = direccion;
    //}

    public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmpresaDTO empresaDTO = (EmpresaDTO) o;
        if (empresaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), empresaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmpresaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                //", direccion=" + direccion +
                ", usuario=" + usuario +
                '}';
    }
}
