package com.proyecto.integrado.yodono.repository;

import com.proyecto.integrado.yodono.model.Poblacion;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Poblacion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PoblacionRepository extends JpaRepository<Poblacion, Long> {

    @Query(value = "SELECT * FROM Poblaciones p WHERE p.provincia_id = ?1", nativeQuery = true)
    List<Poblacion> findAllByPoblacionProvincia(Long id);
}
