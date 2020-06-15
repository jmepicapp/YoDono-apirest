package com.proyecto.integrado.yodono.repository;

import com.proyecto.integrado.yodono.model.Empresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the Empresa entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query(value = "Select * from empresas e where e.usuario_id = (select id from usuarios u where u.email = ?1)", nativeQuery = true)
    Optional<Empresa> findByEmailUsuario(String email);
    
    @Query(value = "Select * from empresas e where e.poblacion like ?1", nativeQuery = true)
    Page<Empresa> findAllByPoblacion(String poblacion, Pageable page); 
    
}
