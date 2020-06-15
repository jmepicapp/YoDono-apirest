package com.proyecto.integrado.yodono.model.dto;

public class DonanteFrontDTO {

    private String nombre;
    private String apellidos;
    private Integer telefono;
    private String poblacion;
    //private DireccionDTO direccion;
    private String email;
    private String password;

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
    
    public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

    //public DireccionDTO getDireccion() {
    //    return direccion;
    //}

    //public void setDireccion(DireccionDTO direccion) {
    //    this.direccion = direccion;
    //}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DonanteFrontDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                //", direccion=" + direccion +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
