package com.proyecto.integrado.yodono.service.impl;

import com.proyecto.integrado.yodono.model.Direccion;
import com.proyecto.integrado.yodono.model.Empresa;
import com.proyecto.integrado.yodono.model.Rol;
import com.proyecto.integrado.yodono.model.Usuario;
import com.proyecto.integrado.yodono.model.dto.EmpresaDTO;
import com.proyecto.integrado.yodono.model.dto.EmpresaFrontDTO;
import com.proyecto.integrado.yodono.repository.EmpresaRepository;
import com.proyecto.integrado.yodono.repository.RolRepository;
import com.proyecto.integrado.yodono.repository.UsuarioRepository;
import com.proyecto.integrado.yodono.service.EmpresaService;
import com.proyecto.integrado.yodono.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private final UsuarioRepository usuarioRepository;

	@Autowired
	private final RolRepository rolRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public EmpresaServiceImpl(EmpresaRepository empresaRepository, UsuarioRepository usuarioRepository,
			RolRepository rolRepository) {
		this.empresaRepository = empresaRepository;
		this.usuarioRepository = usuarioRepository;
		this.rolRepository = rolRepository;
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

	@Override
	public EmpresaDTO update(EmpresaDTO empresaDTO) {
		Empresa empresaExists = empresaRepository.getOne(empresaDTO.getId());
		if (empresaExists != null) {
			Empresa empresa = new Empresa();
			empresa.setId(empresaDTO.getId());
			empresa.setPoblacion(empresaDTO.getPoblacion());
			empresa.setNombre(empresaDTO.getNombre());
			empresa.setTelefono(empresaDTO.getTelefono());
			empresa.setUsuario(usuarioRepository.getOne(Long.valueOf(empresaExists.getUsuario().getId())));
			empresa = empresaRepository.save(empresa);
			return ModelMapperUtils.map(empresa, EmpresaDTO.class);
		}
		return null;
	}

	private Empresa crearEmpresa(EmpresaFrontDTO empresaFrontDTO) {
		Empresa empresa = new Empresa();
		empresa.setId(empresaFrontDTO.getId());
		// empresa.setDireccion(ModelMapperUtils.map(empresaFrontDTO.getDireccion(),
		// Direccion.class));
		empresa.setPoblacion(empresaFrontDTO.getPoblacion());
		empresa.setNombre(empresaFrontDTO.getNombre());
		empresa.setTelefono(empresaFrontDTO.getTelefono());
		empresa.setUsuario(crearUsuario(empresaFrontDTO));
		return empresa;
	}

	private Usuario crearUsuario(EmpresaFrontDTO empresaFrontDTO) {
		// Creación entidad usuario
		Usuario usuario = new Usuario();
		usuario.setActivo(true);
		usuario.setEmail(empresaFrontDTO.getEmail());
		usuario.setPassword(passwordEncoder.encode(empresaFrontDTO.getPassword()));
		usuario.setRol(rolRepository.getOne(Long.valueOf(2)));
		return usuario;
	}

	/**
	 * Get all the empresas.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<Empresa> findAll(Pageable pageable) {
		log.debug("Request to get all Empresas");
		return empresaRepository.findAll(pageable);

	}
	
	/**
	 * Get all the empresas by población.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<Empresa> findAllByPoblacion(String poblacion, Pageable pageable) {
		log.debug("Request to get all Empresas");
		return empresaRepository.findAllByPoblacion(poblacion, pageable);

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
		if (empresaRepository.findById(id).isPresent()) {
			return Optional.of(ModelMapperUtils.map(empresaRepository.findById(id).get(), EmpresaDTO.class));
		} else {
			return Optional.empty();
		}

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
