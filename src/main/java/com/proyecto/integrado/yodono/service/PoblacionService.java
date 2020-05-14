package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.dto.PoblacionDTO;
import com.proyecto.integrado.yodono.model.Poblacion;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Poblacion}.
 */
public interface PoblacionService {

    /**
     * Get all the poblacions.
     *
     * @return the list of entities.
     */
    List<PoblacionDTO> findAll();

    /**
     * Get all the provincias by comunidad.
     *
     * @param id the provincia_id
     * @return the list of entities.
     */
    List<PoblacionDTO> findAllByProvincia(Long id);

    /**
     * Get the "id" poblacion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PoblacionDTO> findOne(Long id);

}
