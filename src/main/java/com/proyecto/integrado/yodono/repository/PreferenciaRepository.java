package com.proyecto.integrado.yodono.repository;

import com.proyecto.integrado.yodono.model.Preferencia;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Preferencia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PreferenciaRepository extends JpaRepository<Preferencia, Long> {

    @Query(value = "select * from preferencias pr where pr.empresa_id = :idEmpresa", nativeQuery = true)
    List<Preferencia> findAllByEmpresa(@Param("idEmpresa") Long idEmpresa);

    @Query(value = "select * " +
            "from preferencias pr join empresa e " +
            "on pr.empresa_id = e.id " +
            "where e.id = (select id from usuarios u where u.email = :emailUsuario)", nativeQuery = true)
    List<Preferencia> findAllByEmailEmpresa(@Param("emailUsuario") String emailUsuario);
}
