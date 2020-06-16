package com.proyecto.integrado.yodono.controller;

import com.proyecto.integrado.yodono.model.dto.EmpresaDTO;
import com.proyecto.integrado.yodono.model.dto.EmpresaFrontDTO;
import com.proyecto.integrado.yodono.model.dto.UsuarioDTO;
import com.proyecto.integrado.yodono.service.EmpresaService;
import com.proyecto.integrado.yodono.service.UsuarioService;
import com.proyecto.integrado.yodono.model.Empresa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * REST controller for managing {@link Empresa}.
 */
@RestController
@RequestMapping("/api")
public class EmpresaController {

	private final Logger log = LoggerFactory.getLogger(EmpresaController.class);

	private static final String ENTITY_NAME = "Empresa";

	@Autowired
	private final EmpresaService empresaService;
	
	@Autowired
	private final UsuarioService usuarioService;

	public EmpresaController(EmpresaService empresaService, UsuarioService usuarioService) {
		this.empresaService = empresaService;
		this.usuarioService = usuarioService;
	}

	/**
	 * {@code POST  /empresas} : Create a new empresa.
	 *
	 * @param empresaFrontDTO the empresaDTO to create.
	 * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
	 *         body the new empresaDTO, or with status {@code 400 (Bad Request)} if
	 *         the empresa has already an ID.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PostMapping("/empresas")
	public ResponseEntity<?> createEmpresa(@RequestBody EmpresaFrontDTO empresaFrontDTO)
			throws URISyntaxException {
		log.debug("REST request to save Empresa : {}", empresaFrontDTO);
		
		Map<String, Object> response = new HashMap<>();
		Optional<EmpresaDTO> empresaExists = empresaService.findOne(empresaFrontDTO.getId());
		Optional<UsuarioDTO> usuarioExists = usuarioService.findByUsername(empresaFrontDTO.getEmail());
		
		
		if (empresaExists.isPresent()) {
			response.put("mensaje",
					"Ya existe una empresa con NIF " + empresaFrontDTO.getId() + " ya existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (usuarioExists.isPresent()) {
			response.put("mensaje",
					"Ya existe un usuario con el email " + empresaFrontDTO.getEmail());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} else {
			EmpresaDTO result = empresaService.save(empresaFrontDTO);
			return ResponseEntity.ok().body(result);
		}
		
	}

	/**
	 * {@code PUT  /empresas} : Updates an existing empresa.
	 *
	 * @param empresaDTO the empresaDTO to update.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
	 *         the updated empresaDTO, or with status {@code 400 (Bad Request)} if
	 *         the empresaDTO is not valid, or with status
	 *         {@code 500 (Internal Server Error)} if the empresaDTO couldn't be
	 *         updated.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PutMapping("/empresas")
	public ResponseEntity<EmpresaDTO> updateEmpresa(@RequestBody EmpresaDTO empresaDTO) throws URISyntaxException {
		log.debug("REST request to update Empresa : {}", empresaDTO);
		EmpresaDTO result = empresaService.update(empresaDTO);
		return ResponseEntity.ok().body(result);
	}

	/**
	 * {@code GET  /empresas/page/:page} : get all the empresas.
	 *
	 * @param page the pagination information.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
	 *         of empresas in body.
	 */
	@GetMapping("/empresas/page/{page}")
	public Page<Empresa> getAllEmpresas(@PathVariable Integer page) {
		log.debug("REST request to get a page of empresas");
		Pageable pageable = PageRequest.of(page, 8);
		Page<Empresa> list = empresaService.findAll(pageable);
		return list;
	}
	
	/**
	 * {@code GET  /empresas/page/:page} : get all the empresas.
	 *
	 * @param page the pagination information.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
	 *         of empresas in body.
	 */
	@GetMapping("/empresas/{poblacion}/page/{page}")
	public Page<Empresa> getAllEmpresasByPoblacion(@PathVariable String poblacion, @PathVariable Integer page) {
		log.debug("REST request to get a page of empresas by poblacion");
		Pageable pageable = PageRequest.of(page, 8);
		Page<Empresa> list = empresaService.findAllByPoblacion(poblacion, pageable);
		return list;
	}

	/**
	 * {@code GET  /empresas/:id} : get the "id" empresa.
	 *
	 * @param id the id of the empresaDTO to retrieve.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
	 *         the empresaDTO, or with status {@code 404 (Not Found)}.
	 */
	@GetMapping("/empresas/{id}")
	public ResponseEntity<EmpresaDTO> getEmpresa(@PathVariable Long id) {
		log.debug("REST request to get Empresa : {}", id);
		Optional<EmpresaDTO> empresaDTO = empresaService.findOne(id);
		return empresaDTO.map(response -> ResponseEntity.ok().body(response))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	/**
	 * {@code GET /empresas/email/{emailUsuario}} : get the "id" empresaDTO.
	 *
	 * @param emailUsuario the id of the usuario to filter the empresaDTO.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
	 *         the empresaDTO, or with status {@code 404 (Not Found)}.
	 */
	@GetMapping("/empresas/email/{emailUsuario}")
	public ResponseEntity<EmpresaDTO> getEmpresaByEmailUsuario(@PathVariable String emailUsuario) {
		log.debug("REST request to get Donante : {}", emailUsuario);
		Optional<EmpresaDTO> empresaDTO = empresaService.findByEmailUsuario(emailUsuario);
		return empresaDTO.map(response -> ResponseEntity.ok().body(response))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	/**
	 * {@code DELETE  /empresas/:id} : delete the "id" empresa.
	 *
	 * @param id the id of the empresaDTO to delete.
	 * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
	 */
	@DeleteMapping("/empresas/{id}")
	public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
		log.debug("REST request to delete Empresa : {}", id);
		empresaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
