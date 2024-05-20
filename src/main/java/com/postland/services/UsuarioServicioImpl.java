package com.postland.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.postland.dtos.UsuarioDTO;
import com.postland.dtos.UsuarioNuevoDTO;
import com.postland.entities.Publicacion;
import com.postland.entities.Usuario;
import com.postland.repositories.GrupoRepositorio;
import com.postland.repositories.GrupoUsuarioRepositorio;
import com.postland.repositories.PublicacionRepositorio;
import com.postland.repositories.RolRepositorio;
import com.postland.repositories.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private GrupoUsuarioRepositorio grupoUsuarioRepositorio;
	@Autowired
	private GrupoRepositorio grupoRepositorio;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RolRepositorio rolRepositorio;
	@Autowired
	private PublicacionRepositorio publicacionRepositorio;
	@Override
	public List<UsuarioDTO> obtenerUsuarios() {
		List<Usuario> usuarios = usuarioRepositorio.findAll();
		return usuarios.stream().map(u -> modelMapper.map(u, UsuarioDTO.class)).collect(Collectors.toList());
	}

	@Override
	public void crearUsuario(UsuarioNuevoDTO usuarioDTO) {
		// TODO Auto-generated method stub
		//Usuario user = modelMapper.map(miembroRegistroDTO, Usuario.class);
		//if(!StringUtils.cleanPath(avatar.getOriginalFileName()))return;
		System.out.println(usuarioDTO.getPassword());
		if(!validarPassword(usuarioDTO.getPassword()))return;
		Usuario user = modelMapper.map(usuarioDTO, Usuario.class);
		/*try {
			user.setAvatar(Base64.getEncoder().encodeToString(usuarioDTO.getAvatar().getBytes()));
		}catch ( IOException e) {
			return;
		}*/ 
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRol(rolRepositorio.findOneById(1));
		usuarioRepositorio.save(user);
	}
	@Override
	public boolean addFriend(int amigo, OAuth2Authentication auth) {
		Usuario userEncontrado =usuarioRepositorio.findOneById(usuarioRepositorio.findOneByUsername(auth.getPrincipal().toString()).getId());
		Usuario amigoEncontrado = usuarioRepositorio.findOneById(amigo);
		//Comprueba que no sean amigos
		if(!userEncontrado.getAmigos().contains(amigoEncontrado)) {
			userEncontrado.getAmigos().add(amigoEncontrado);
			amigoEncontrado.getAmigos().add(userEncontrado);
			usuarioRepositorio.save(userEncontrado);
			usuarioRepositorio.save(amigoEncontrado);
			return true;
		}
		return false;
	}

	public boolean validarPassword(String pass) {
	    Pattern pattern = Pattern.compile("^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!#$%&? \"]).*$");
	    Matcher matcher = pattern.matcher(pass);
	    return true;
	    //return matcher.find();
	}
	
	
	@Override
	public UsuarioDTO obtenerUsuarioPorId(int id, OAuth2Authentication auth) {
		return modelMapper.map(usuarioRepositorio.findOneById(id), UsuarioDTO.class);
	}
	
	@Override
	public List<UsuarioDTO> obtenerAmigosPorId(int id){
		List<Usuario> amigos = usuarioRepositorio.findOneById(id).getAmigos();
		return amigos.stream().map(u -> modelMapper.map(u, UsuarioDTO.class)).collect(Collectors.toList());
	}
	@Override
	public void likePost(int id, OAuth2Authentication auth) {
		Usuario user = usuarioRepositorio.findOneByUsername(auth.getPrincipal().toString());
		List<Publicacion> publicaciones = user.getPublicacionesGusta();
		Publicacion publicacion = publicacionRepositorio.findOneById(id);
		if(publicaciones.contains(publicacion))return;
		publicaciones.add(publicacion);
		user.setPublicacionesGusta(publicaciones);
		usuarioRepositorio.save(user);
	}
	
	@Override
	public void disLikePost(int id, OAuth2Authentication auth) {
		Usuario user = usuarioRepositorio.findOneByUsername(auth.getPrincipal().toString());
		List<Publicacion> publicaciones = user.getPublicacionesGusta();
		Publicacion publicacion = publicacionRepositorio.findOneById(id);
		if(!publicaciones.contains(publicacion))return;
		publicaciones.remove(publicacion);
		user.setPublicacionesGusta(publicaciones);
		usuarioRepositorio.save(user);
	}

	@Override
	public List<UsuarioDTO> obtenerUsuariosPorGrupoId(int id) {
		List<Usuario> usuarios = grupoUsuarioRepositorio.findUsersByGroupId(grupoRepositorio.findOneById(id));
		return usuarios.stream().map(u -> modelMapper.map(u, UsuarioDTO.class)).collect(Collectors.toList());
	}

	@Override
	public void fileTest(MultipartFile file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
}
