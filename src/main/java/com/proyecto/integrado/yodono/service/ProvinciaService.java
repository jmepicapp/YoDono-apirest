package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.dto.ProvinciaDTO;
import com.proyecto.integrado.yodono.model.Provincia;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Provincia}.
 */
public interface ProvinciaService {

    /**
     * Get all the provincias.
     *
     * @return the list of entities.
     */
    List<ProvinciaDTO> findAll();

    /**
     * Get all the provincias by comunidad.
     *
     * @param id the comunidad_id
     * @return the list of entities.
     */
    List<ProvinciaDTO> findAllByComunidad(Long id);

    /**
     * Get the "id" provincia.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProvinciaDTO> findOne(Long id);

}
