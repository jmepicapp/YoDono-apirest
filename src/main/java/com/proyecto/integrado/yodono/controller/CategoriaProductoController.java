package com.proyecto.integrado.yodono.controller;

import com.proyecto.integrado.yodono.service.CategoriaProductoService;
import com.proyecto.integrado.yodono.model.dto.CategoriaProductoDTO;
import com.proyecto.integrado.yodono.controller.error.BadRequestAlertException;

import com.proyecto.integrado.yodono.model.CategoriaProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link CategoriaProducto}.
 */
@RestController
@RequestMapping("/api")
public class CategoriaProductoController {

    private final Logger log = LoggerFactory.getLogger(CategoriaProductoController.class);

    private static final String ENTITY_NAME = "categoriaProducto";

    @Autowired
    private final CategoriaProductoService categoriaProductoService;

    public CategoriaProductoController(CategoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    /**
     * {@code POST  /categoria-productos} : Create a new categoriaProducto.
     *
     * @param categoriaProductoDTO the categoriaProductoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new categoriaProductoDTO, or with status {@code 400 (Bad Request)} if the categoriaProducto has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @Secured({"ROLE_ADMIN"})
    @PostMapping("/categoria-productos")
    public ResponseEntity<CategoriaProductoDTO> createCategoriaProducto(@RequestBody CategoriaProductoDTO categoriaProductoDTO) throws URISyntaxException {
        log.debug("REST request to save CategoriaProducto : {}", categoriaProductoDTO);
        if (categoriaProductoDTO.getId() != null) {
            throw new BadRequestAlertException("A new categoriaProducto cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CategoriaProductoDTO result = categoriaProductoService.save(categoriaProductoDTO);
        return ResponseEntity.created(new URI("/api/categoria-productos/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /categoria-productos} : Updates an existing categoriaProducto.
     *
     * @param categoriaProductoDTO the categoriaProductoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated categoriaProductoDTO,
     * or with status {@code 400 (Bad Request)} if the categoriaProductoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the categoriaProductoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @Secured({"ROLE_ADMIN"})
    @PutMapping("/categoria-productos")
    public ResponseEntity<CategoriaProductoDTO> updateCategoriaProducto(@RequestBody CategoriaProductoDTO categoriaProductoDTO) throws URISyntaxException {
        log.debug("REST request to update CategoriaProducto : {}", categoriaProductoDTO);
        if (categoriaProductoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CategoriaProductoDTO result = categoriaProductoService.save(categoriaProductoDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /categoria-productos} : get all the categoriaProductos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of categoriaProductos in body.
     */
    @GetMapping("/categoria-productos")
    public List<CategoriaProductoDTO> getAllCategoriaProductos() {
        log.debug("REST request to get all CategoriaProductos");
        return categoriaProductoService.findAll();
    }

    /**
     * {@code GET  /categoria-productos/:id} : get the "id" categoriaProducto.
     *
     * @param id the id of the categoriaProductoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the categoriaProductoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/categoria-productos/{id}")
    public ResponseEntity<CategoriaProductoDTO> getCategoriaProducto(@PathVariable Long id) {
        log.debug("REST request to get CategoriaProducto : {}", id);
        Optional<CategoriaProductoDTO> categoriaProductoDTO = categoriaProductoService.findOne(id);
        return categoriaProductoDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /categoria-productos/:id} : delete the "id" categoriaProducto.
     *
     * @param id the id of the categoriaProductoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/categoria-productos/{id}")
    public ResponseEntity<Void> deleteCategoriaProducto(@PathVariable Long id) {
        log.debug("REST request to delete CategoriaProducto : {}", id);
        categoriaProductoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
