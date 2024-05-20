package com.postland.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.postland.entities.Usuario;

public class UserDetailsImpl implements UserDetails{
	private final Usuario usuario;
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return usuario.isActivado();
	}

	public UserDetailsImpl(Usuario usuario) {
		this.usuario = usuario;
		List<GrantedAuthority> auth = Collections.singletonList(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		System.out.println(auth);
		this.authorities=auth;
	}
}