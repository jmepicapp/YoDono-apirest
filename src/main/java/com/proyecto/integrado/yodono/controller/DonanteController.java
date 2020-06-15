package com.proyecto.integrado.yodono.controller;

import com.proyecto.integrado.yodono.model.Donante;
import com.proyecto.integrado.yodono.model.dto.DonanteDTO;
import com.proyecto.integrado.yodono.model.dto.DonanteFrontDTO;
import com.proyecto.integrado.yodono.model.dto.EmpresaDTO;
import com.proyecto.integrado.yodono.model.dto.UsuarioDTO;
import com.proyecto.integrado.yodono.service.DonanteService;
import com.proyecto.integrado.yodono.service.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * REST controller for managing {@link Donante}.
 */
@RestController
@RequestMapping("/api")
public class DonanteController {

    private final Logger log = LoggerFactory.getLogger(DonanteController.class);

    private static final String ENTITY_NAME = "donante";

    @Autowired
    private final DonanteService donanteService;
    
	@Autowired
	private final UsuarioService usuarioService;

    public DonanteController(DonanteService donanteService, UsuarioService usuarioService) {
        this.donanteService = donanteService;
		this.usuarioService = usuarioService;
    }

    /**
     * {@code POST  /donantes} : Create a new donante.
     *
     * @param donanteFrontDTO the donanteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new donanteDTO, or with status {@code 400 (Bad Request)} if the donante has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/donantes")
    public ResponseEntity<?> createDonante(@RequestBody DonanteFrontDTO donanteFrontDTO) throws URISyntaxException {
        log.debug("REST request to save Donante : {}", donanteFrontDTO);
        
        Map<String, Object> response = new HashMap<>();
		Optional<UsuarioDTO> usuarioExists = usuarioService.findByUsername(donanteFrontDTO.getEmail());
		
		
		if (usuarioExists.isPresent()) {
			response.put("mensaje",
					"El email " + donanteFrontDTO.getEmail() + " ya existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			DonanteDTO result = donanteService.save(donanteFrontDTO);
	        return ResponseEntity.ok().body(result);
		}
        
    }

    /**
     * {@code PUT  /donantes} : Updates an existingdonante.
     *
     * @param donanteFrontDTO thedonanteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updateddonanteDTO,
     * or with status {@code 400 (Bad Request)} if thedonanteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if thedonanteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/donantes")
    public ResponseEntity<DonanteDTO> updateDonante(@RequestBody DonanteDTO donanteDTO) throws URISyntaxException {
        log.debug("REST request to update Donante : {}", donanteDTO);
        DonanteDTO result = donanteService.update(donanteDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /donantes} : get all thedonantes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list ofdonantes in body.
     */
    @GetMapping("/donantes")
    public List<DonanteDTO> getAllDonantes() {
        log.debug("REST request to get alldonantes");
        return donanteService.findAll();
    }

    /**
     * {@code GET  /donantes/:id} : get the "id"donante.
     *
     * @param id the id of thedonanteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body thedonanteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/donantes/{id}")
    public ResponseEntity<DonanteDTO> getDonante(@PathVariable Long id) {
        log.debug("REST request to get Donante : {}", id);
        Optional<DonanteDTO>donanteDTO = donanteService.findOne(id);
        return donanteDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code GET  /donantes/email/{emailUsuario}} : get the "id"donante.
     *
     * @param emailUsuario the id of the usuario to filter the DonanteDTO.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body thedonanteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/donantes/email/{emailUsuario}")
    public ResponseEntity<DonanteDTO> getDonanteByEmailUsuaxrio(@PathVariable String emailUsuario) {
        log.debug("REST request to get Donante : {}", emailUsuario);
        Optional<DonanteDTO>donanteDTO = donanteService.findByEmailUsuario(emailUsuario);
        return donanteDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /donantes/:id} : delete the "id"donante.
     *
     * @param id the id of thedonanteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/donantes/{id}")
    public ResponseEntity<Void> deleteDonante(@PathVariable Long id) {
        log.debug("REST request to delete Donante : {}", id);
        donanteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
