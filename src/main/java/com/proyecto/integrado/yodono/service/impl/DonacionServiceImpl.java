package com.proyecto.integrado.yodono.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.proyecto.integrado.yodono.controller.error.BadRequestAlertException;
import com.proyecto.integrado.yodono.model.Donacion;
import com.proyecto.integrado.yodono.model.dto.DonacionDTO;
import com.proyecto.integrado.yodono.repository.DonacionRepository;
import com.proyecto.integrado.yodono.util.ModelMapperUtils;
import com.proyecto.integrado.yodono.model.type.EstadoDonacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.integrado.yodono.service.DonacionService;

/**
 * Service Implementation for managing {@link Donacion}.
 */
@Service
@Transactional
public class DonacionServiceImpl implements DonacionService {

    private final Logger log = LoggerFactory.getLogger(DonacionServiceImpl.class);

    @Autowired
    private final DonacionRepository donacionRepository;

    public DonacionServiceImpl(DonacionRepository donacionRepository) {
        this.donacionRepository = donacionRepository;
    }

    /**
     * Save a donacion.
     *
     * @param donacionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DonacionDTO save(DonacionDTO donacionDTO) {
        log.debug("Request to save Donacion : {}", donacionDTO);
        Map<String, Object> response = new HashMap<>();

        if(validarDonacion(donacionDTO)){
            return null;
        }
        Donacion donacion = ModelMapperUtils.map(donacionDTO, Donacion.class);
        donacion.setEstado(EstadoDonacion.PENDIENTE.name());
        donacion = donacionRepository.save(donacion);
        return ModelMapperUtils.map(donacion, DonacionDTO.class);
    }

    private boolean validarDonacion(DonacionDTO donacionDTO) {
       Long numeroDonacion = donacionRepository.findAll()
                .stream()
                .filter(donacion -> donacion.getDonante().getId().equals(donacionDTO.getDonante().getId()))
                .filter(donacion -> donacion.getEmpresa().getId().equals(donacionDTO.getEmpresa().getId()))
                .filter(donacion -> EstadoDonacion.PENDIENTE.name().equals(donacion.getEstado()))
                .count();
        return numeroDonacion >= 1;
    }

    /**
     * Get all the donacions.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<DonacionDTO> findAll() {
        log.debug("Request to get all donacions");
        return ModelMapperUtils.mapAll(donacionRepository.findAll(), DonacionDTO.class);

    }
    
    /**
     * Get all the donaciones by usuario id.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
    public List<DonacionDTO> findAllByIdUsuario(Long idUsuario){
        return ModelMapperUtils.mapAll(this.donacionRepository.findAllByIdUsuario(idUsuario), DonacionDTO.class);

    }

    /**
     * Get one donacion by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DonacionDTO> findOne(Long id) {
        log.debug("Request to get Donacion : {}", id);
        return Optional.of(ModelMapperUtils.map(donacionRepository.findById(id).get(), DonacionDTO.class));

    }

    /**
     * Delete the donacion by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Donacion : {}", id);
        donacionRepository.deleteById(id);
    }

    /**
     * Get the historical of donaciones by usuario id for Donante.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	@Override
	public List<DonacionDTO> findAllByIdDonanteEstadoCanceladoYAceptado(Long idUsuario) {
        return ModelMapperUtils.mapAll(this.donacionRepository.findAllByIdDonanteEstadoCanceladoYAceptado(idUsuario), DonacionDTO.class);
	}

	 /**
     * Get the historical of donaciones by usuario id for Empresa.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	@Override
	public List<DonacionDTO> findAllByIdEmpresaEstadoCanceladoYAceptado(Long idUsuario) {
        return ModelMapperUtils.mapAll(this.donacionRepository.findAllByIdEmpresaEstadoCanceladoYAceptado(idUsuario), DonacionDTO.class);
	}

	   /**
     * Get the pendant donaciones by usuario id for Donante.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	@Override
	public List<DonacionDTO> findAllByIdDonanteEstadoPendiente(Long idUsuario) {
        return ModelMapperUtils.mapAll(this.donacionRepository.findAllByIdDonanteEstadoPendiente(idUsuario), DonacionDTO.class);
	}

	   /**
     * Get the pendant donaciones by usuario id for Empresa.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	@Override
	public List<DonacionDTO> findAllByIdEmpresaEstadoPendiente(Long idUsuario) {
        return ModelMapperUtils.mapAll(this.donacionRepository.findAllByIdDonanteEstadoPendiente(idUsuario), DonacionDTO.class);
	}

}
