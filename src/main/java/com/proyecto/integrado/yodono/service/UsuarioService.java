package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.dto.UsuarioDTO;
import com.proyecto.integrado.yodono.model.Rol;

import java.util.Optional;

/**
 * Service Interface for managing {@link Rol}.
 */
public interface UsuarioService {

    /**
     * Get the "id" rol.
     *
     * @param email the id of the entity.
     * @return the entity.
     */
    Optional<UsuarioDTO> findByUsername(String email);

}
