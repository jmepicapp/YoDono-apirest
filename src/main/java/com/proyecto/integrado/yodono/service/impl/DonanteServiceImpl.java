package com.proyecto.integrado.yodono.service.impl;

import com.proyecto.integrado.yodono.model.Direccion;
import com.proyecto.integrado.yodono.model.Donante;
import com.proyecto.integrado.yodono.model.Rol;
import com.proyecto.integrado.yodono.model.Usuario;
import com.proyecto.integrado.yodono.model.dto.DonanteDTO;
import com.proyecto.integrado.yodono.model.dto.DonanteFrontDTO;
import com.proyecto.integrado.yodono.service.DonanteService;
import com.proyecto.integrado.yodono.repository.DonanteRepository;
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
 * Service Implementation for managing {@link Donante}.
 */
@Service
@Transactional
public class DonanteServiceImpl implements DonanteService {

    private final Logger log = LoggerFactory.getLogger(DonanteServiceImpl.class);

    @Autowired
    private final DonanteRepository donanteRepository;

    @Autowired
	private BCryptPasswordEncoder passwordEncoder;

    public DonanteServiceImpl(DonanteRepository donanteRepository) {
        this.donanteRepository = donanteRepository;
    }

    /**
     * Save a donante.
     *
     * @param donanteFrontDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DonanteDTO save(DonanteFrontDTO donanteFrontDTO) {
        log.debug("Request to save Donante : {}", donanteFrontDTO);

        Donante donante = crearDonante(donanteFrontDTO);
        donante.setUsuario(crearUsuario(donanteFrontDTO));

        donante = donanteRepository.save(donante);
        return ModelMapperUtils.map(donante, DonanteDTO.class);
    }

    private Donante crearDonante(DonanteFrontDTO donanteFrontDTO) {
        Donante donante = new Donante();
        donante.setApellidos(donanteFrontDTO.getApellidos());
        donante.setDireccion(ModelMapperUtils.map(donanteFrontDTO.getDireccion(), Direccion.class));
        donante.setNombre(donanteFrontDTO.getNombre());
        donante.setTelefono(donanteFrontDTO.getTelefono());
        donante.setUsuario(crearUsuario(donanteFrontDTO));
        return donante;
    }

    private Usuario crearUsuario(DonanteFrontDTO donanteFrontDTO) {
        //Creación entidad usuario
        Usuario usuario = new Usuario();
        usuario.setActivo(true);
        usuario.setEmail(donanteFrontDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(donanteFrontDTO.getPassword()));
        usuario.setRol(new Rol(Long.valueOf(2), "ROLE_EMPRESA"));
        return usuario;
    }

    /**
     * Get all the donantes.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<DonanteDTO> findAll() {
        log.debug("Request to get all donantes");
        return ModelMapperUtils.mapAll(donanteRepository.findAll(), DonanteDTO.class);

    }

    /**
     * Get one donante by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DonanteDTO> findOne(Long id) {
        log.debug("Request to get Donante : {}", id);
        return Optional.of(ModelMapperUtils.map(donanteRepository.findById(id).get(), DonanteDTO.class));

    }

    /**
     * Get one donante by id.
     *
     * @param email the email of the entity Usuario.
     * @return the entity.
     */
    @Override
    public Optional<DonanteDTO> findByEmailUsuario(String email) {
        return Optional.of(ModelMapperUtils.map(donanteRepository.findByEmailUsuario(email).get(), DonanteDTO.class));
    }

    /**
     * Delete the donante by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Donante : {}", id);
        donanteRepository.deleteById(id);
    }
}
