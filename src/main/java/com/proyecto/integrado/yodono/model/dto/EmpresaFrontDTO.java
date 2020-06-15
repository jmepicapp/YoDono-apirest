package com.proyecto.integrado.yodono.model.dto;

public class EmpresaFrontDTO {

	private Long id;
	private String nombre;
	private Integer telefono;
	private String poblacion;
	// private DireccionDTO direccion;
	private String email;
	private String password;

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

	// public DireccionDTO getDireccion() {
	// return direccion;
	// }

	// public void setDireccion(DireccionDTO direccion) {
	// this.direccion = direccion;
	// }

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

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
		return "EmpresaFrontDTO{" + "id=" + id + ", nombre='" + nombre + '\'' + ", telefono=" + telefono +
		// ", direccion=" + direccion +
				", email='" + email + '\'' + ", password='" + password + '\'' + '}';
	}
}
