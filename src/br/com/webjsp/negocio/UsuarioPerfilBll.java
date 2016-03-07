package br.com.webjsp.negocio;

import java.sql.SQLException;

import br.com.webjsp.dao.UsuarioPerfilDao;
import br.com.webjsp.entidade.UsuarioPerfil;

public class UsuarioPerfilBll {
	private UsuarioPerfilDao usuarioPerfilDao = null;

	public UsuarioPerfilBll() {
		this.usuarioPerfilDao = new UsuarioPerfilDao();
	}

	public void inserirUsuarioPerfil(UsuarioPerfil usuarioPerfil) throws SQLException {
		this.usuarioPerfilDao.inserePerfil(usuarioPerfil);
	}

}
