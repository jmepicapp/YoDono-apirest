package com.proyecto.integrado.yodono.repository;

import com.proyecto.integrado.yodono.model.Donante;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the Donante entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DonanteRepository extends JpaRepository<Donante, Long> {

    @Query(value = "Select * from donantes d where d.usuario_id = (select id from usuarios u where u.email = ?1)", nativeQuery = true)
    Optional<Donante> findByEmailUsuario(String email);
}
