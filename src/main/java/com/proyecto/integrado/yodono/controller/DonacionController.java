package com.proyecto.integrado.yodono.controller;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.proyecto.integrado.yodono.controller.error.BadRequestAlertException;
import com.proyecto.integrado.yodono.model.Donacion;
import com.proyecto.integrado.yodono.model.dto.DonacionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.integrado.yodono.service.DonacionService;

import javax.swing.text.html.Option;

/**
 * REST controller for managing {@link Donacion}.
 */
@RestController
@RequestMapping("/api")
public class DonacionController {

    private final Logger log = LoggerFactory.getLogger(DonacionController.class);

    private static final String ENTITY_NAME = "Donacion";

    @Autowired
    private final DonacionService donacionService;

    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    /**
     * {@code POST  /donacion} : Create a new donacion.
     *
     * @param donacionDTO the donacionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new donacionDTO, or with status {@code 400 (Bad Request)} if the donacion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/donacion")
    public ResponseEntity<?> createDonacion(@RequestBody DonacionDTO donacionDTO) throws URISyntaxException {
        log.debug("REST request to save Donacion : {}", donacionDTO);
        if (donacionDTO.getId() != null) {
            throw new BadRequestAlertException("A new donacion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DonacionDTO donacionDTOresult = donacionService.save(donacionDTO);
        if (donacionDTOresult == null){
            Map<String, Object> response = new HashMap<>();

            response.put("mensaje",
                    "Ya existe una solicitud de donación pendiente de aprobación con esta empresa");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<DonacionDTO> result = Optional.of(donacionDTOresult);
        //  return ResponseEntity.created(new URI("/api/Donacions/" + result.getId())).body(result);
        return result.map(response -> ResponseEntity.ok().body(result.get()))
                .orElseThrow(() -> new  BadRequestAlertException("Donacion","Ya existe una donacion en curso"));
    }

    /**
     * {@code PUT  /donacion} : Updates an existing donacion.
     *
     * @param donacionDTO the donacionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated donacionDTO,
     * or with status {@code 400 (Bad Request)} if the donacionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the donacionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/donacion")
    public ResponseEntity<DonacionDTO> updateDonacion(@RequestBody DonacionDTO donacionDTO) throws URISyntaxException {
        log.debug("REST request to update Donacion : {}", donacionDTO);
        if (donacionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DonacionDTO result = donacionService.save(donacionDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /Donacions} : get all the donacions.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of donacions in body.
     */
    @GetMapping("/donacion")
    public List<DonacionDTO> getAllDonacions() {
        log.debug("REST request to get all donacions");
        return donacionService.findAll();
    }

    /**
     * {@code GET  /Donaciones} : get all the donaciones.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of donaciones by idUsuario in body.
     */
    @GetMapping("/Donacions/{idUsuario}")
    public List<DonacionDTO> getAllDonacions(@PathVariable Long idUsuario) {
        log.debug("REST request to get all Preferencias");
        return donacionService.findAllByIdUsuario(idUsuario);
    }
    
    /**
     * {@code GET  /historico-Donacions} : get all the Historical donacions of an Donante.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of donaciones by idUsuario in body.
     */
    @GetMapping("/historico-Donaciones/donante/{idDonante}")
    public ResponseEntity<List<DonacionDTO>> getDonanteHistoricalDonacions(@PathVariable Long idDonante) {
        log.debug("REST request to get all Preferencias");
        return ResponseEntity.ok().body(donacionService.findAllByIdDonanteEstadoCanceladoYAceptado(idDonante));
    }
    /**
     * {@code GET  /historico-Donacions} : get all the Historical donacions of an Empresa.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of donaciones by idUsuario in body.
     */
    @GetMapping("/historico-Donaciones/{idEmpresa}")
    public ResponseEntity<List<DonacionDTO>> getEmpresaHistoricalDonacions(@PathVariable Long idEmpresa) {
        log.debug("REST request to get all Preferencias");
        return ResponseEntity.ok().body(donacionService.findAllByIdEmpresaEstadoCanceladoYAceptado(idEmpresa));
    }
    /**
     * {@code GET  /pendant-Donacions} : get all the pendant donacions of an Donante.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of donaciones by idUsuario in body.
     */
    @GetMapping("/pendant-Donacions/donante/{idDonante}")
    public ResponseEntity<List<DonacionDTO>> getDonantePendantDonacions(@PathVariable Long idDonante) {
        log.debug("REST request to get all Preferencias");
        return ResponseEntity.ok().body(donacionService.findAllByIdDonanteEstadoPendiente(idDonante));
    }
    /**
     * {@code GET  /pendant-Donacions} : get all the pendant donacions of an Empresa.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of donaciones by idUsuario in body.
     */
    @GetMapping("/pendant-Donacions/{idEmpresa}")
    public ResponseEntity<List<DonacionDTO>> getEmpresaPendantDonacions(@PathVariable Long idEmpresa) {
        log.debug("REST request to get all Preferencias");
        return ResponseEntity.ok().body(donacionService.findAllByIdEmpresaEstadoPendiente(idEmpresa));
    }
    
    /**
     * {@code GET  /Donacions/:id} : get the "id" donacion.
     *
     * @param id the id of the donacionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the donacionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/donacion/{id}")
    public ResponseEntity<DonacionDTO> getDonacion(@PathVariable Long id) {
        log.debug("REST request to get Donacion : {}", id);
        Optional<DonacionDTO> donacionDTO = donacionService.findOne(id);
        return donacionDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /donacion/:id} : delete the "id" donacion.
     *
     * @param id the id of the donacionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/donacion/{id}")
    public ResponseEntity<Void> deleteDonacion(@PathVariable Long id) {
        log.debug("REST request to delete Donacion : {}", id);
        donacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
