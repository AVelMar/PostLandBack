package com.postland.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.postland.entities.Usuario;
import com.postland.repositories.UsuarioRepositorio;
import com.postland.services.UsuarioServicio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuarioRepositorio userRepository;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Usuario user = userRepository.findOneByUsername(username);
		System.out.println(user);
		return new UserDetailsImpl(user);		
	}	
}