package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.dto.DireccionDTO;
import com.proyecto.integrado.yodono.model.Direccion;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Direccion}.
 */
public interface DireccionService {

    /**
     * Save a direccion.
     *
     * @param direccionDTO the entity to save.
     * @return the persisted entity.
     */
    DireccionDTO save(DireccionDTO direccionDTO);

    /**
     * Get all the direccions.
     *
     * @return the list of entities.
     */
    List<DireccionDTO> findAll();

    /**
     * Get the "id" direccion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DireccionDTO> findOne(Long id);

    /**
     * Delete the "id" direccion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
