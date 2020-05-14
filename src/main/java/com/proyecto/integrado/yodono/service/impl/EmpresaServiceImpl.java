package com.proyecto.integrado.yodono.service.impl;

import com.proyecto.integrado.yodono.model.Direccion;
import com.proyecto.integrado.yodono.model.Empresa;
import com.proyecto.integrado.yodono.model.Rol;
import com.proyecto.integrado.yodono.model.Usuario;
import com.proyecto.integrado.yodono.model.dto.EmpresaDTO;
import com.proyecto.integrado.yodono.model.dto.EmpresaFrontDTO;
import com.proyecto.integrado.yodono.repository.EmpresaRepository;
import com.proyecto.integrado.yodono.service.EmpresaService;
import com.proyecto.integrado.yodono.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Empresa}.
 */
@Service
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

    private final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private final EmpresaRepository empresaRepository;

    @Autowired
	private BCryptPasswordEncoder passwordEncoder;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    /**
     * Save a empresa.
     *
     * @param empresaFrontDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public EmpresaDTO save(EmpresaFrontDTO empresaFrontDTO) {
        log.debug("Request to save Empresa : {}", empresaFrontDTO);

        Empresa empresa = crearEmpresa(empresaFrontDTO);
        empresa.setUsuario(crearUsuario(empresaFrontDTO));

        empresa = empresaRepository.save(empresa);
        return ModelMapperUtils.map(empresa, EmpresaDTO.class);
    }

    private Empresa crearEmpresa(EmpresaFrontDTO empresaFrontDTO) {
        Empresa empresa = new Empresa();
        empresa.setId(empresaFrontDTO.getId());
        empresa.setDireccion(ModelMapperUtils.map(empresaFrontDTO.getDireccion(), Direccion.class));
        empresa.setNombre(empresaFrontDTO.getNombre());
        empresa.setTelefono(empresaFrontDTO.getTelefono());
        empresa.setUsuario(crearUsuario(empresaFrontDTO));
        return empresa;
    }

    private Usuario crearUsuario(EmpresaFrontDTO empresaFrontDTO) {
        //Creación entidad usuario
        Usuario usuario = new Usuario();
        usuario.setActivo(true);
        usuario.setEmail(empresaFrontDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(empresaFrontDTO.getPassword()));
        usuario.setRol(new Rol(Long.valueOf(2), "ROLE_EMPRESA"));
        return usuario;
    }

    /**
     * Get all the empresas.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<EmpresaDTO> findAll() {
        log.debug("Request to get all Empresas");
        return ModelMapperUtils.mapAll(empresaRepository.findAll(), EmpresaDTO.class);

    }

    /**
     * Get one empresas by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<EmpresaDTO> findOne(Long id) {
        log.debug("Request to get Empresa : {}", id);
        return Optional.of(ModelMapperUtils.map(empresaRepository.findById(id).get(), EmpresaDTO.class));

    }

    /**
     * Get one empresas by id.
     *
     * @param email the email of the entity Usuario.
     * @return the entity.
     */
    @Override
    public Optional<EmpresaDTO> findByEmailUsuario(String email) {
        return Optional.of(ModelMapperUtils.map(empresaRepository.findByEmailUsuario(email).get(), EmpresaDTO.class));
    }

    /**
     * Delete the empresas by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Empresa : {}", id);
        empresaRepository.deleteById(id);
    }
}
