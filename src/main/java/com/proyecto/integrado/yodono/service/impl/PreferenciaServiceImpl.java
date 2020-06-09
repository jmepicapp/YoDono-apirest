package com.proyecto.integrado.yodono.service.impl;

import com.proyecto.integrado.yodono.model.dto.EmpresaDTO;
import com.proyecto.integrado.yodono.repository.EmpresaRepository;
import com.proyecto.integrado.yodono.service.PreferenciaService;
import com.proyecto.integrado.yodono.model.Preferencia;
import com.proyecto.integrado.yodono.repository.PreferenciaRepository;
import com.proyecto.integrado.yodono.model.dto.PreferenciaDTO;
import com.proyecto.integrado.yodono.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Preferencia}.
 */
@Service
@Transactional
public class PreferenciaServiceImpl implements PreferenciaService {

    private final Logger log = LoggerFactory.getLogger(PreferenciaServiceImpl.class);

    @Autowired
    private final PreferenciaRepository preferenciaRepository;

    @Autowired
    private final EmpresaRepository empresaRepository;

    public PreferenciaServiceImpl(PreferenciaRepository preferenciaRepository, EmpresaRepository empresaRepository) {
        this.preferenciaRepository = preferenciaRepository;
        this.empresaRepository = empresaRepository;
    }

    /**
     * Save a preferencia.
     *
     * @param preferenciaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PreferenciaDTO save(PreferenciaDTO preferenciaDTO) {
        log.debug("Request to save Preferencia : {}", preferenciaDTO);
        Preferencia preferencia = ModelMapperUtils.map(preferenciaDTO, Preferencia.class);
        preferencia = preferenciaRepository.save(preferencia);
        return ModelMapperUtils.map(preferenciaRepository, PreferenciaDTO.class);
    }

    /**
     * Get all the preferencias.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PreferenciaDTO> findAll() {
        log.debug("Request to get all Preferencias");
        return ModelMapperUtils.mapAll(preferenciaRepository.findAll(), PreferenciaDTO.class);

    }

    /**
     * Get all the preferencias by categorias producto id.
     *
     * @param idCategorias the list of categorias producto id
     * @return the list of entities.
     */
    public List<EmpresaDTO> findAllByCategoriaProducto(List<Long> idCategorias) {

        List<EmpresaDTO> empresaDTOList = ModelMapperUtils.mapAll(empresaRepository.findAll(), EmpresaDTO.class);

        for (PreferenciaDTO preferencia : ModelMapperUtils.mapAll(preferenciaRepository.findAll(), PreferenciaDTO.class)) {
            if (idCategorias.contains(preferencia.getCategoriaProducto().getId())) {
                if(empresaDTOList.contains(preferencia.getEmpresa())){
                    empresaDTOList.remove(preferencia.getEmpresa());
                }
            }
        }

        return empresaDTOList;

    }

    /**
     * Get all the preferencias by empresa id.
     *
     * @param idEmpresa the list of categorias producto id
     * @return the list of entities.
     */
    public List<PreferenciaDTO> findAllByEmpresa(Long idEmpresa) {
        return ModelMapperUtils.mapAll(this.preferenciaRepository.findAllByEmpresa(idEmpresa), PreferenciaDTO.class);

    }

    /**
     * Get all the preferencias by empresa id.
     *
     * @param emailEmpresa the list of categorias producto id
     * @return the list of entities.
     */
    public List<PreferenciaDTO> findAllByEmailEmpresa(String emailEmpresa) {
        return ModelMapperUtils.mapAll(this.preferenciaRepository.findAllByEmailEmpresa(emailEmpresa), PreferenciaDTO.class);

    }

    /**
     * Get one preferencia by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PreferenciaDTO> findOne(Long id) {
        log.debug("Request to get Preferencia : {}", id);
        return Optional.of(ModelMapperUtils.map(preferenciaRepository.findById(id).get(), PreferenciaDTO.class));

    }

    /**
     * Delete the preferencia by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Preferencia : {}", id);
        preferenciaRepository.deleteById(id);
    }
}
