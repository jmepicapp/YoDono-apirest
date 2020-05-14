package com.proyecto.integrado.yodono.repository;

import com.proyecto.integrado.yodono.model.ComunidadAutonoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Provincia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ComunidadAutonomaRepository extends JpaRepository<ComunidadAutonoma, Long> {
}
