package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.Empresa;
import com.proyecto.integrado.yodono.model.dto.EmpresaDTO;

import com.proyecto.integrado.yodono.model.dto.EmpresaFrontDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Empresa}.
 */
public interface EmpresaService {

    /**
     * Save a empresa.
     *
     * @param empresaFrontDTO the entity to save.
     * @return the persisted entity.
     */
    EmpresaDTO save(EmpresaFrontDTO empresaFrontDTO);

    /**
     * Get all the empresas.
     *
     * @return the list of entities.
     */
    List<EmpresaDTO> findAll();

    /**
     * Get the "id" empresa.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EmpresaDTO> findOne(Long id);

    /**
     * Get the "id" empresa.
     *
     * @param email the email of the entity usuario.
     * @return the entity.
     */
    Optional<EmpresaDTO> findByEmailUsuario(String email);

    /**
     * Delete the "id" empresa.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
