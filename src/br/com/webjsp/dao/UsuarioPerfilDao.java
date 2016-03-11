package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webjsp.entidade.UsuarioPerfil;
import br.com.webjsp.negocio.UsuarioPerfilBll;

public class UsuarioPerfilDao extends AbstractDao {

	public UsuarioPerfilDao() {
		super.configuraConexao();
	}

	public UsuarioPerfil inserePerfil(UsuarioPerfil usuarioPerfil) throws Exception {
		// Pega o último ID_USUARIO
		this.comandoSQL = conexao.prepareStatement("SELECT MAX(id_usuario) FROM public.usuario;");
		ResultSet resultadoSql = comandoSQL.executeQuery();
		long recebeIdUsuario = 0;
		while (resultadoSql.next()) {
			recebeIdUsuario = resultadoSql.getLong("max");
		}

		this.comandoSQL = conexao.prepareStatement(
				"INSERT INTO public.usuario_perfil(id_usuario_perfil, id_usuario, id_perfil) VALUES (nextval('usuario_perfil_id_usuario_perfil_seq'), "
						+ recebeIdUsuario + ", " + usuarioPerfil.getIdPerfil() + ");");
		comandoSQL.execute();

		return null;
	}

	public void alteraPerfil(List<Integer> idPerfil, long idUsuario) throws Exception {
		List<Integer> listaUsuarioPerfilTela = new UsuarioPerfilBll().recuperaIdUsuario(idUsuario);
		List<Integer> listaParaExclusao = new ArrayList<Integer>();

		// Fazer insert em caso de novos
		for (Integer perfis : idPerfil) {

			if (!this.UsuarioPerfilExiste(perfis, idUsuario)) {

				this.comandoSQL = conexao.prepareStatement(
						"INSERT INTO public.usuario_perfil(id_usuario_perfil, id_usuario, id_perfil) VALUES (nextval('usuario_perfil_id_usuario_perfil_seq'),"
								+ idUsuario + ", " + perfis + ");");

				comandoSQL.execute();
			}
		}

		// Deleta em caso de retirados
		for (Integer idUsuarioPerfilBanco : listaUsuarioPerfilTela) {
			boolean existeTela = false;

			for (Integer idUsuarioPerfilTela : idPerfil) {
				if (idUsuarioPerfilBanco.equals(idUsuarioPerfilTela)) {
					existeTela = true;
				}
			}

			if (existeTela == false) {
				listaParaExclusao.add(idUsuarioPerfilBanco);
			}
			// realiza a exclusão do perfil não mais usado pelo usuário
			if (listaParaExclusao.size() > 0) {
				excluirPerfilUsuario(listaParaExclusao, idUsuario);
			}

		}
	}

	public void excluirUsuarioPerfil(long idUsuario) throws SQLException {
		this.comandoSQL = conexao
				.prepareStatement("DELETE FROM public.usuario_perfil WHERE id_usuario = " + idUsuario + ";");
		comandoSQL.execute();
	}

	public void excluirPerfilUsuario(List<Integer> idPerfil, long idUsuario) throws SQLException {
		for (Integer idPerfil2 : idPerfil)
			this.comandoSQL = conexao.prepareStatement("DELETE FROM public.usuario_perfil WHERE id_usuario = "
					+ idUsuario + " AND id_perfil = " + idPerfil2 + ";");
		comandoSQL.execute();
	}

	public List<Integer> recuperaIdUsuarioPerfil(long idUsuario) throws SQLException {
		List<Integer> listaRetorno = new ArrayList<Integer>();
		this.comandoSQL = conexao
				.prepareStatement("SELECT id_perfil FROM public.usuario_perfil WHERE id_usuario = " + idUsuario + " ;");
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			Integer idPerfil = (int) resultadoSql.getLong("id_perfil");
			listaRetorno.add(idPerfil);
		}
		return listaRetorno;
	}

	private boolean UsuarioPerfilExiste(long idPerfil, long recebeIdUsuario) throws SQLException {
		boolean existe = true;

		this.comandoSQL = conexao.prepareStatement("SELECT * FROM public.usuario_perfil WHERE ID_USUARIO = "
				+ recebeIdUsuario + " AND ID_PERFIL = " + idPerfil + ";");

		ResultSet resultadoSql = comandoSQL.executeQuery();
		if (!resultadoSql.next()) {
			existe = false;
		}

		return existe;
	}

	public List<UsuarioPerfil> recuperaUsuarioPerfil(UsuarioPerfil usuarioPerfil) throws SQLException {
		List<UsuarioPerfil> listaRetorno = new ArrayList<UsuarioPerfil>();
		this.comandoSQL = conexao.prepareStatement(
				"SELECT id_usuario_perfil, id_usuario, id_perfil FROM public.usuario_perfil WHERE id_usuario = '"
						+ usuarioPerfil.getIdUsuario() + "' ;");
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			UsuarioPerfil usuarioPerfilRetorno = new UsuarioPerfil();
			usuarioPerfilRetorno.setIdPerfil(resultadoSql.getLong("id_usuario_perfil"));
			usuarioPerfilRetorno.setIdUsuario(resultadoSql.getLong("id_usuario"));
			usuarioPerfilRetorno.setIdUsuarioPerfil(resultadoSql.getLong("id_perfil"));
			listaRetorno.add(usuarioPerfilRetorno);
		}

		return listaRetorno;

	}

	public boolean IsPossuiPerfil(long idPerfil, long idUsuario) throws SQLException {
		this.comandoSQL = conexao.prepareStatement(
				"SELECT id_usuario_perfil, id_usuario, id_perfil FROM public.usuario_perfil WHERE id_perfil = '"
						+ idPerfil + "' AND id_usuario = '" + idUsuario + "' ;");
		ResultSet resultadoSql = comandoSQL.executeQuery();
		if (!resultadoSql.next()) {
			return false;
		}
		return true;
	}

}
