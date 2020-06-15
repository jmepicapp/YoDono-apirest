package com.proyecto.integrado.yodono.service.impl;

import com.proyecto.integrado.yodono.model.Usuario;
import com.proyecto.integrado.yodono.model.dto.UsuarioDTO;
import com.proyecto.integrado.yodono.repository.UsuarioRepository;
import com.proyecto.integrado.yodono.service.UsuarioService;
import com.proyecto.integrado.yodono.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Usuario}.
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

    private final Logger log = LoggerFactory.getLogger(Usuario.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Request to get Usuario : {}", email);
        UsuarioDTO usuarioDTO = ModelMapperUtils.map(usuarioRepository.findByEmail(email).get(), UsuarioDTO.class);

        if (usuarioDTO == null) {
            throw new UsernameNotFoundException("Error en el login: no existe el usuario con el email '" + email + "' en el sistema");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(usuarioDTO.getRol().getNombre());
        authorities.add(simpleGrantedAuthority);
        log.debug("Rol: " + simpleGrantedAuthority.getAuthority());

        return new User(usuarioDTO.getEmail(), usuarioDTO.getPassword(), usuarioDTO.getActivo(), true, true, true, authorities);

    }

    /**
     * Get one rol by id.
     *
     * @param email the email of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findByUsername(String email) {
        log.debug("Request to get Usuario : {}", email);
        if(usuarioRepository.findByEmail(email).isPresent()) {
            return Optional.of(ModelMapperUtils.map(usuarioRepository.findByEmail(email).get(), UsuarioDTO.class));
        }else {
        	return Optional.empty();
        }

    }
}
