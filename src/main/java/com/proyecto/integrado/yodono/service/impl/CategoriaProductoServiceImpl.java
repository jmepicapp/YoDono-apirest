package com.proyecto.integrado.yodono.service.impl;

import com.proyecto.integrado.yodono.service.CategoriaProductoService;
import com.proyecto.integrado.yodono.model.CategoriaProducto;
import com.proyecto.integrado.yodono.repository.CategoriaProductoRepository;
import com.proyecto.integrado.yodono.model.dto.CategoriaProductoDTO;
import com.proyecto.integrado.yodono.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link CategoriaProducto}.
 */
@Service
@Transactional
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    private final Logger log = LoggerFactory.getLogger(CategoriaProductoServiceImpl.class);

    @Autowired
    private final CategoriaProductoRepository categoriaProductoRepository;

    public CategoriaProductoServiceImpl(CategoriaProductoRepository categoriaProductoRepository) {
        this.categoriaProductoRepository = categoriaProductoRepository;
    }

    /**
     * Save a categoriaProducto.
     *
     * @param categoriaProductoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CategoriaProductoDTO save(CategoriaProductoDTO categoriaProductoDTO) {
        log.debug("Request to save CategoriaProducto : {}", categoriaProductoDTO);
        CategoriaProducto categoriaProducto = ModelMapperUtils.map(categoriaProductoDTO, CategoriaProducto.class);
        categoriaProducto = categoriaProductoRepository.save(categoriaProducto);
        return ModelMapperUtils.map(categoriaProducto, CategoriaProductoDTO.class);
    }

    /**
     * Get all the categoriaProductos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoriaProductoDTO> findAll() {
        log.debug("Request to get all CategoriaProductos");
        return ModelMapperUtils.mapAll(categoriaProductoRepository.findAll(), CategoriaProductoDTO.class);
    }

    /**
     * Get one categoriaProducto by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CategoriaProductoDTO> findOne(Long id) {
        log.debug("Request to get CategoriaProducto : {}", id);
        return Optional.of(ModelMapperUtils.map(categoriaProductoRepository.findById(id).get(), CategoriaProductoDTO.class));

    }

    /**
     * Delete the categoriaProducto by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CategoriaProducto : {}", id);
        categoriaProductoRepository.deleteById(id);
    }
}
