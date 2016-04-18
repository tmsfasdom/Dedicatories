package com.dedicatories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dedicatories.dao.UsuarioDaoImpl;
import com.dedicatories.modelo.Usuario;
import com.dedicatories.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	
	private UsuarioDaoImpl usuarioDao;

	@Autowired
	public UsuarioServiceImpl(UsuarioDaoImpl usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Transactional
	public void update(Usuario usuario) {
		usuarioDao.update(usuario);
	}

	@Transactional
	public void delete(int userId) {
		usuarioDao.delete(userId);
	}

	@Transactional
	public Usuario getUsuario(int userId) {
		return usuarioDao.getEntity(userId);
	}

	@Transactional
	public List<Usuario> getAllUsuario() {
		return usuarioDao.getAll();
	}

	public boolean verificaUsuario(Usuario user) {
		List<Usuario> listaUsuarios = getAllUsuario();
		for (Usuario usr : listaUsuarios) {
			if (usr.getUserName().equalsIgnoreCase(user.getUserName())
					&& usr.getPassword().contentEquals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	public Usuario recuperaUsuarioPorLogin(String login) {
		return usuarioDao.RecuperaUsuarioPorLogin(login);
	}

}
