package br.com.webjsp.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.dao.UsuarioPerfilDao;
import br.com.webjsp.entidade.Perfil;
import br.com.webjsp.entidade.UsuarioPerfil;
import br.com.webjsp.exceptions.WebJspException;;

public class UsuarioPerfilBll {
	private UsuarioPerfilDao usuarioPerfilDao = null;

	public UsuarioPerfilBll() {
		this.usuarioPerfilDao = new UsuarioPerfilDao();
	}

	public UsuarioPerfil inserirUsuarioPerfil(UsuarioPerfil usuarioPerfil) throws Exception {
		try {
			return this.usuarioPerfilDao.inserePerfil(usuarioPerfil);
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	public void excluirUsuarioPerfil(long idUsuario) throws SQLException {
		try {
			this.usuarioPerfilDao.excluirUsuarioPerfil(idUsuario);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public void alterarUsuarioPerfil(List<Integer> idPerfil, long idUsuario) throws Exception {
		try {
			this.usuarioPerfilDao.alteraPerfil(idPerfil, idUsuario);
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	public List<UsuarioPerfil> recuperaUsuarioPerfil(UsuarioPerfil usuarioPerfil) throws WebJspException {
		try {
			return this.usuarioPerfilDao.recuperaUsuarioPerfil(usuarioPerfil);
		} catch (SQLException e) {
			throw new WebJspException(e.getMessage());
		}
	}

	public List<Integer> recuperaIdUsuario(long idUsuario) throws SQLException {
		return this.usuarioPerfilDao.recuperaIdUsuarioPerfil(idUsuario);
	}

	public static boolean IsPossuiPerfil(List<Perfil> listaPerfisDoUsuario, long idPerfil, long idUsuario)
			throws SQLException {
		UsuarioPerfilDao usuarioPerfilDao = new UsuarioPerfilDao();
		boolean usuarioPossuiPerfil = false;
		if (usuarioPerfilDao.IsPossuiPerfil(idPerfil, idUsuario) == true) {
			usuarioPossuiPerfil = true;
		}
		return usuarioPossuiPerfil;
	}

}
