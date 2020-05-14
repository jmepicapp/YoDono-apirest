package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.dto.ComunidadAutonomaDTO;
import com.proyecto.integrado.yodono.model.ComunidadAutonoma;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link ComunidadAutonoma}.
 */
public interface ComunidadAutonomaService {

    /**
     * Get all the comunidades autonomas.
     *
     * @return the list of entities.
     */
    List<ComunidadAutonomaDTO> findAll();

    /**
     * Get the "id" comunidad autonoma.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ComunidadAutonomaDTO> findOne(Long id);

}
