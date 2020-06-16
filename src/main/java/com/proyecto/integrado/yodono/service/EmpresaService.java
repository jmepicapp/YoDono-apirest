package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.Empresa;
import com.proyecto.integrado.yodono.model.dto.EmpresaDTO;

import com.proyecto.integrado.yodono.model.dto.EmpresaFrontDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * Update a empresa.
     *
     * @param empresaDTO the entity to save.
     * @return the persisted entity.
     */
    EmpresaDTO update(EmpresaDTO empresaDTO);

    /**
     * Get all the empresas.
     *
     * @return the list of entities.
     */
    Page<Empresa> findAll(Pageable pageable);
    
    /**
     * Get all the empresas by poblacion.
     *
     * @return the list of entities.
     */
	Page<Empresa> findAllByPoblacion(String poblacion, Pageable pageable);

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
