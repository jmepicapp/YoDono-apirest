package com.proyecto.integrado.yodono.service.impl;

import com.proyecto.integrado.yodono.model.ComunidadAutonoma;
import com.proyecto.integrado.yodono.model.dto.ComunidadAutonomaDTO;
import com.proyecto.integrado.yodono.repository.ComunidadAutonomaRepository;
import com.proyecto.integrado.yodono.service.ComunidadAutonomaService;
import com.proyecto.integrado.yodono.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link ComunidadAutonoma}.
 */
@Service
@Transactional
public class ComunidadAutonomaServiceImpl implements ComunidadAutonomaService {

    private final Logger log = LoggerFactory.getLogger(ComunidadAutonomaServiceImpl.class);

    @Autowired
    private final ComunidadAutonomaRepository comunidadAutonomaRepository;

    public ComunidadAutonomaServiceImpl(ComunidadAutonomaRepository comunidadAutonomaRepository) {
        this.comunidadAutonomaRepository = comunidadAutonomaRepository;
    }

    /**
     * Get all the comunidades autonomas.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ComunidadAutonomaDTO> findAll() {
        log.debug("Request to get all Comunidades Autonomas");
        return ModelMapperUtils.mapAll(comunidadAutonomaRepository.findAll(), ComunidadAutonomaDTO.class);
    }

    /**
     * Get one comunindad autonoma by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ComunidadAutonomaDTO> findOne(Long id) {
        log.debug("Request to get Comunidad Autonoma : {}", id);
        return Optional.of(ModelMapperUtils.map(comunidadAutonomaRepository.findById(id).get(), ComunidadAutonomaDTO.class));

    }

}
