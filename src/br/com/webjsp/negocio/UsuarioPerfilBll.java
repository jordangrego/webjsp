package br.com.webjsp.negocio;

import java.sql.SQLException;

import br.com.webjsp.dao.UsuarioPerfilDao;
import br.com.webjsp.entidade.UsuarioPerfil;

public class UsuarioPerfilBll {
	private UsuarioPerfilDao usuarioPerfilDao = null;

	public UsuarioPerfilBll() {
		this.usuarioPerfilDao = new UsuarioPerfilDao();
	}

	public UsuarioPerfil inserir(UsuarioPerfil usuarioPerfil) throws SQLException {
		return this.usuarioPerfilDao.inserePerfil(usuarioPerfil);
	}

}
