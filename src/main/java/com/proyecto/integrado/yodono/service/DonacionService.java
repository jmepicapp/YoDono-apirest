package com.proyecto.integrado.yodono.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.integrado.yodono.model.dto.DonacionDTO;
import com.proyecto.integrado.yodono.model.Donacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Donacion}.
 */
public interface DonacionService {

    /**
     * Save a donacion.
     *
     * @param donacionDTO the entity to save.
     * @return the persisted entity.
     */
    DonacionDTO save(DonacionDTO donacionDTO);

    /**
     * Get all the donacions.
     *
     * @return the list of entities.
     */
    List<DonacionDTO> findAll();

    /**
     * Get all the donaciones by usuario id.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
    List<DonacionDTO> findAllByIdUsuario(Long idUsuario);
    
    /**
     * Get the "id" donacion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DonacionDTO> findOne(Long id);

    /**
     * Delete the "id" donacion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    /**
     * Get the historical of donaciones by usuario id for Donante.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	List<DonacionDTO> findAllByIdDonanteEstadoCanceladoYAceptado(Long idUsuario);

    /**
     * Get the historical of donaciones by usuario id for Empresa.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	List<DonacionDTO> findAllByIdEmpresaEstadoCanceladoYAceptado(Long idUsuario);
	
    /**
     * Get the pendant donaciones by usuario id for Donante.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	List<DonacionDTO> findAllByIdDonanteEstadoPendiente(Long idUsuario);
	
    /**
     * Get the pendant donaciones by usuario id for Empresa.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	List<DonacionDTO> findAllByIdEmpresaEstadoPendiente(Long idUsuario);

    /**
     * Get donaciones by Donante.
     *
     * @param idDonante the usuario id
     * @return the list of entities.
     */
    Page<Donacion> findAllByIdDonante(Long idDonante, Pageable pageable);

    /**
     * Get donaciones by Empresa.
     *
     * @param idEmpresa the usuario id
     * @return the list of entities.
     */
    Page<Donacion> findAllByIdEmpresa(Long idEmpresa, Pageable pageable);
}
