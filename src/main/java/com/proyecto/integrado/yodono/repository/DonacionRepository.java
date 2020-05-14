package com.proyecto.integrado.yodono.repository;

import java.util.List;

import com.proyecto.integrado.yodono.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Donacion entity.
 */
@Repository
public interface DonacionRepository extends JpaRepository<Donacion, Long> {

	@Query(value ="select * from donaciones p where p.donante_id IN "+"(select id from Donantes d where d.id = p.donante_id)",nativeQuery = true)
	List<Donacion> findAllByIdUsuario(Long idUsuario);
	
	@Query(value ="select p from donaciones p where p.estado = 'PENDIENTE'", nativeQuery = true)
	List<Donacion> findAllByEstadoPendiente();
	
	@Query(value ="select * from donaciones p where (p.estado = 'CANCELADO' or p.estado = 'ACEPTADO') and p.donante_id IN "+"(select id from Donantes d where d.id = p.donante_id)",nativeQuery = true)
	List<Donacion> findAllByIdDonanteEstadoCanceladoYAceptado(Long idUsuario);
	
	@Query(value ="select * from donaciones p where (p.estado = 'CANCELADO' or p.estado = 'ACEPTADO') and p.empresa_id IN "+"(select id from Empresas e where e.id = p.empresa_id)",nativeQuery = true)
	List<Donacion> findAllByIdEmpresaEstadoCanceladoYAceptado(Long idUsuario);
	
	@Query(value ="select * from donaciones p where p.estado = 'PENDIENTE' and p.donante_id IN "+"(select id from Donantes d where ud.id = p.donante_id)",nativeQuery = true)
	List<Donacion> findAllByIdDonanteEstadoPendiente(Long idUsuario);
	
	@Query(value ="select * from donaciones p where p.estado = 'PENDIENTE' and p.empresa_id IN "+"(select id from Empresas e where ue.id = p.empresa_id)",nativeQuery = true)
	List<Donacion> findAllByIdEmpresaEstadoPendiente(Long idUsuario);
	
};