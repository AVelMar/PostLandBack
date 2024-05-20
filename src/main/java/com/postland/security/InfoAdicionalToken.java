package com.postland.security;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.postland.entities.Usuario;
import com.postland.repositories.UsuarioRepositorio;

@Component
public class InfoAdicionalToken implements TokenEnhancer {
	@Autowired
	private UsuarioRepositorio miembroRepository;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario user = miembroRepository.findOneByUsername(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("Nombre", authentication.getName());
		info.put("id", user.getId());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

		return accessToken;
	}
}