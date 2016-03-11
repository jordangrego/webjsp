package br.com.webjsp.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.dao.PerfilDao;
import br.com.webjsp.entidade.Perfil;

public class PerfilBll {
	private PerfilDao perfilDao = null;

	public PerfilBll() {
		this.perfilDao = new PerfilDao();
	}

	public List<Perfil> recuperar(Perfil perfil) throws SQLException {
		return this.perfilDao.pesquisaPerfis(perfil);
	}
	

}
