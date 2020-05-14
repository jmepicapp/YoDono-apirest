package com.proyecto.integrado.yodono.service;

import com.proyecto.integrado.yodono.model.dto.PreferenciaDTO;
import com.proyecto.integrado.yodono.model.dto.EmpresaDTO;
import com.proyecto.integrado.yodono.model.Preferencia;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Preferencia}.
 */
public interface PreferenciaService {

    /**
     * Save a preferencia.
     *
     * @param preferenciaDTO the entity to save.
     * @return the persisted entity.
     */
    PreferenciaDTO save(PreferenciaDTO preferenciaDTO);

    /**
     * Get all the preferencias.
     *
     * @return the list of entities.
     */
    List<PreferenciaDTO> findAll();

    /**
     * Get all the preferencias.
     *
     * @param id the categoriaProducto id
     * @return the list of entities.
     */
    List<EmpresaDTO> findAllByCategoriaProducto(List<Long> id);

    /**
     * Get all the preferencias by usuario empresa email.
     *
     * @param email the usuario empresa email
     * @return the list of entities.
     */
    List<PreferenciaDTO> findAllByEmailEmpresa(String email);

    /**
     * Get all the preferencias.
     *
     * @param idEmpresa the usuario empresa id
     * @return the list of entities.
     */
    List<PreferenciaDTO> findAllByEmpresa(Long idEmpresa);

    /**
     * Get the "id" preferencia.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PreferenciaDTO> findOne(Long id);

    /**
     * Delete the "id" preferencia.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
