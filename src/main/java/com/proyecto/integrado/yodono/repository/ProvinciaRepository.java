package com.proyecto.integrado.yodono.repository;

import com.proyecto.integrado.yodono.model.Provincia;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Provincia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    @Query(value = "SELECT * FROM Provincia p WHERE p.comunidad_id = ?1 ", nativeQuery = true)
    List<Provincia> findAllByComunidad(Long id);
}
