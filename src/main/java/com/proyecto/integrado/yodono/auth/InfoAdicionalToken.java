package com.proyecto.integrado.yodono.auth;

import com.proyecto.integrado.yodono.model.dto.UsuarioDTO;
import com.proyecto.integrado.yodono.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        UsuarioDTO usuarioDTO = usuarioService.findByUsername(oAuth2Authentication.getName()).get();

        Map<String, Object> info = new HashMap<>();
        info.put("rol", usuarioDTO.getRol());
        info.put("id_usuario", usuarioDTO.getId());
        info.put("email_usuario", usuarioDTO.getEmail());

        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
