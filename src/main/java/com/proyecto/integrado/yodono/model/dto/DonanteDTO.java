package com.proyecto.integrado.yodono.model.dto;

import com.proyecto.integrado.yodono.model.Donante;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Donante} entity.
 */
public class DonanteDTO implements Serializable {
    
    private Long id;
    private String nombre;
    private String apellidos;
    private Integer telefono;
    private DireccionDTO direccion;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DonanteDTO donanteDTO = (DonanteDTO) o;
        if (donanteDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), donanteDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DonanteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                ", direccion=" + direccion +
                ", usuarioDTO=" + usuario +
                '}';
    }
}
