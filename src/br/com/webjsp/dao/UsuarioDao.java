package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webjsp.entidade.Usuario;

public class UsuarioDao extends AbstractDao {
	public UsuarioDao() {
		super.configuraConexao();
	}

	/**
	 * Recupera um �nico TipoDado pelo Id.
	 * 
	 * @param idLote
	 * @return
	 * @throws SQLException
	 */
	public Usuario recuperarLogin(String login) throws SQLException {
		Usuario usuarioRetorno = null;

		this.comandoSQL = conexao.prepareStatement(
				"SELECT id_usuario, id_cliente, nome, login, senha, email, usuario_ad, dominio, ativo FROM usuario where lower(login) = lower('"
						+ login + "')");
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
	 * 
	 * @param idLote
	 * @return
	 * @throws SQLException
	 */
	public Usuario recuperarPorId(int idUsuario) throws SQLException {
		Usuario usuarioRetorno = null;

		this.comandoSQL = conexao.prepareStatement(
				"SELECT id_usuario, id_cliente, nome, login, senha, email, usuario_ad, dominio, ativo FROM usuario where id_usuario = "
						+ idUsuario);
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
	 * 
	 * @param idLote
	 * @return
	 * @throws SQLException
	 */
	public List<Usuario> pesquisar(Usuario usuarioCriterio) throws SQLException {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_usuario, id_cliente, nome, login, senha, email, usuario_ad, dominio, ativo FROM usuario");
		sql.append(" where ");

		if (usuarioCriterio.getIdUsuario() > 0) {
			sql.append(" id_usuario = " + usuarioCriterio.getIdUsuario() + " AND ");
		}

		if (usuarioCriterio.getIdCliente() > 0) {
			sql.append(" id_cliente = " + usuarioCriterio.getIdCliente() + " AND ");
		}

		if (usuarioCriterio.getNome() != null && !usuarioCriterio.getNome().equals("")) {
			sql.append(" lower(nome) like lower('%" + usuarioCriterio.getNome() + "%') AND ");
		}

		if (usuarioCriterio.getLogin() != null && !usuarioCriterio.getLogin().equals("")) {
			sql.append(" lower(login) like lower('%" + usuarioCriterio.getLogin() + "%') AND ");
		}

		if (usuarioCriterio.getEmail() != null && !usuarioCriterio.getEmail().equals("")) {
			sql.append(" lower(email) like lower('%" + usuarioCriterio.getEmail() + "%') AND ");
		}

		sql.append(" (1 = 1) ");

		this.comandoSQL = conexao.prepareStatement(sql.toString());
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			Usuario usuarioRetorno = new Usuario();
			usuarioRetorno.setIdUsuario(resultadoSql.getLong("id_usuario"));
			usuarioRetorno.setIdCliente(resultadoSql.getLong("id_cliente"));
			usuarioRetorno.setNome(resultadoSql.getString("nome"));
			usuarioRetorno.setLogin(resultadoSql.getString("login"));
			usuarioRetorno.setSenha(resultadoSql.getString("senha"));
			usuarioRetorno.setEmail(resultadoSql.getString("email"));
			usuarioRetorno.setUsuarioAd(resultadoSql.getBoolean("usuario_ad"));
			usuarioRetorno.setDominio(resultadoSql.getString("dominio"));
			usuarioRetorno.setAtivo(resultadoSql.getBoolean("ativo"));
			listaUsuario.add(usuarioRetorno);
		}

		return listaUsuario;
	}

	public void inserir(Usuario usuario) throws SQLException {
		this.comandoSQL = conexao.prepareStatement(
				"INSERT INTO public.usuario(id_usuario, id_cliente, nome, login, senha, email, usuario_ad, ativo) VALUES (NEXTVAL('usuario_id_usuario_seq'), 3, '"
						+ usuario.getNome() + "','" + usuario.getLogin() + "','" + usuario.getSenha() + "','"
						+ usuario.getEmail() + "','" + false + "','" + true + "');");
		comandoSQL.execute();
	}
}
