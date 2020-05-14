package com.proyecto.integrado.yodono.service.impl;

import com.proyecto.integrado.yodono.service.ProvinciaService;
import com.proyecto.integrado.yodono.model.Provincia;
import com.proyecto.integrado.yodono.repository.ProvinciaRepository;
import com.proyecto.integrado.yodono.model.dto.ProvinciaDTO;
import com.proyecto.integrado.yodono.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Provincia}.
 */
@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    private final Logger log = LoggerFactory.getLogger(ProvinciaServiceImpl.class);

    @Autowired
    private final ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    /**
     * Get all the provincias.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProvinciaDTO> findAll() {
        log.debug("Request to get all Provincias");
        return ModelMapperUtils.mapAll(provinciaRepository.findAll(), ProvinciaDTO.class);

    }

    @Override
    public List<ProvinciaDTO> findAllByComunidad(Long id) {
        return ModelMapperUtils.mapAll(provinciaRepository.findAllByComunidad(id), ProvinciaDTO.class);
    }

    /**
     * Get one provincia by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProvinciaDTO> findOne(Long id) {
        log.debug("Request to get Provincia : {}", id);
        return Optional.of(ModelMapperUtils.map(provinciaRepository.findById(id).get(), ProvinciaDTO.class));

    }

}
