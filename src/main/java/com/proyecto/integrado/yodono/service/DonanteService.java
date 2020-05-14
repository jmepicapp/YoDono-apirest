package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.Donante;
import com.proyecto.integrado.yodono.model.dto.DonanteDTO;
import com.proyecto.integrado.yodono.model.dto.DonanteFrontDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Donante}.
 */
public interface DonanteService {

    /**
     * Save a donante.
     *
     * @param donanteFrontDTO the entity to save.
     * @return the persisted entity.
     */
    DonanteDTO save(DonanteFrontDTO donanteFrontDTO);

    /**
     * Get all the donantes.
     *
     * @return the list of entities.
     */
    List<DonanteDTO> findAll();

    /**
     * Get the "id" donante.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DonanteDTO> findOne(Long id);

    /**
     * Get the "id" donante.
     *
     * @param email the email of the entity usuario.
     * @return the entity.
     */
    Optional<DonanteDTO> findByEmailUsuario(String email);

    /**
     * Delete the "id" donante.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
