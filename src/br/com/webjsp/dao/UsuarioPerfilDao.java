package br.com.webjsp.dao;

import java.sql.SQLException;

import br.com.webjsp.entidade.UsuarioPerfil;

public class UsuarioPerfilDao extends AbstractDao {
	public UsuarioPerfilDao() {
		super.configuraConexao();
	}

	public void inserePerfil(UsuarioPerfil usuarioPerfil) throws SQLException {
		this.comandoSQL = conexao.prepareStatement(
				"INSERT INTO public.usuario_perfil(id_usuario_perfil, id_usuario, id_perfil) VALUES (nextval('usuario_perfil_id_usuario_perfil_seq'), 3, '"
						+ usuarioPerfil.getIdUsuarioPerfil() + "');");
		comandoSQL.execute();
	}
}
