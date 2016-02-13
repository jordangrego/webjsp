package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.webjsp.entidade.Usuario;

public class UsuarioDao extends AbstractDao {
	public UsuarioDao() {
		super.configuraConexao();
	}
	
	/**
	 * Recupera um �nico TipoDado pelo Id.
	 * @param idLote
	 * @return
	 * @throws SQLException
	 */
	public Usuario recuperarLogin(String login) throws SQLException {
		Usuario usuarioRetorno = null;

		this.comandoSQL = conexao.prepareStatement("SELECT id_usuario, id_cliente, nome, login, senha, email, usuario_ad, dominio, ativo FROM usuario where lower(login) = lower('" + login + "')");
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			usuarioRetorno = new Usuario();
			usuarioRetorno.setIdUsuario(resultadoSql.getLong("id_usuario"));
			usuarioRetorno.setIdCliente(resultadoSql.getLong("id_cliente"));
			usuarioRetorno.setNome(resultadoSql.getString("nome"));
			usuarioRetorno.setLogin(resultadoSql.getString("login"));
			usuarioRetorno.setSenha(resultadoSql.getString("senha"));
			usuarioRetorno.setEmail(resultadoSql.getString("email"));
			usuarioRetorno.setUsuarioAd(resultadoSql.getBoolean("usuario_ad"));
			usuarioRetorno.setDominio(resultadoSql.getString("dominio"));
			usuarioRetorno.setAtivo(resultadoSql.getBoolean("ativo"));
		}

		return usuarioRetorno;
	}
	
	/**
	 * Recupera um �nico TipoDado pelo Id.
	 * @param idLote
	 * @return
	 * @throws SQLException
	 */
	public Usuario recuperarpor(int idUsuario) throws SQLException {
		Usuario usuarioRetorno = null;

		this.comandoSQL = conexao.prepareStatement("SELECT id_usuario, id_cliente, nome, login, senha, email, usuario_ad, dominio, ativo FROM usuario where id_usuario = " + idUsuario);
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			usuarioRetorno = new Usuario();
			usuarioRetorno.setIdUsuario(resultadoSql.getLong("id_usuario"));
			usuarioRetorno.setIdCliente(resultadoSql.getLong("id_cliente"));
			usuarioRetorno.setNome(resultadoSql.getString("nome"));
			usuarioRetorno.setLogin(resultadoSql.getString("login"));
			usuarioRetorno.setSenha(resultadoSql.getString("senha"));
			usuarioRetorno.setEmail(resultadoSql.getString("email"));
			usuarioRetorno.setUsuarioAd(resultadoSql.getBoolean("usuario_ad"));
			usuarioRetorno.setDominio(resultadoSql.getString("dominio"));
			usuarioRetorno.setAtivo(resultadoSql.getBoolean("ativo"));
		}

		return usuarioRetorno;
	}
}
