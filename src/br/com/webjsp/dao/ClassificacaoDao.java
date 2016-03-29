package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webjsp.entidade.Classificacao;

public class ClassificacaoDao extends AbstractDao {
	public ClassificacaoDao() {
		super.configuraConexao();
	}

	public List<Classificacao> pesquisar(Classificacao classificacao) throws SQLException {
		List<Classificacao> listaRetorno = new ArrayList<Classificacao>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM public.classificacao");
		sql.append(" where ");

		if (classificacao.getIdCliente() != 0) {
			sql.append(" id_cliente= " + classificacao.getIdCliente() + " AND ");
		}
		if (classificacao.getCodigo() != 0) {
			sql.append(" codigo like  '%" + classificacao.getCodigo() + "%' AND ");
		}
		if (classificacao.getDescricaoClassificacao() != null
				&& !classificacao.getDescricaoClassificacao().equals("")) {
			sql.append(" lower (descricao_classificacao) like lower ('%" + classificacao.getDescricaoClassificacao()
					+ "%') AND ");
		}

		sql.append(" 1 = 1;");

		this.comandoSQL = conexao.prepareStatement(sql.toString());

		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			Classificacao classificacaoRetorno = new Classificacao();
			classificacaoRetorno.setIdClassificacao(resultadoSql.getLong("id_classificacao"));
			classificacaoRetorno.setIdCliente(resultadoSql.getLong("id_cliente"));
			classificacaoRetorno.setCodigo(resultadoSql.getInt("codigo"));
			classificacaoRetorno.setDescricaoClassificacao(resultadoSql.getString("descricao_classificacao"));
			classificacaoRetorno.setPrazoGuarda(resultadoSql.getInt("prazo_guarda"));
			listaRetorno.add(classificacaoRetorno);
		}
		return listaRetorno;

	}

	public Classificacao recuperar(int idClassificacao) throws SQLException {
		Classificacao classificacaoRetorno = null;

		this.comandoSQL = conexao.prepareStatement(
				"SELECT * FROM public.classificacao WHERE id_classificacao = " + idClassificacao + ";");
		ResultSet resulstadoSql = comandoSQL.executeQuery();

		while (resulstadoSql.next()) {
			classificacaoRetorno = new Classificacao();
			classificacaoRetorno.setIdClassificacao(resulstadoSql.getLong("id_classificacao"));
			classificacaoRetorno.setIdCliente(resulstadoSql.getLong("id_cliente"));
			classificacaoRetorno.setCodigo(resulstadoSql.getInt("codigo"));
			classificacaoRetorno.setDescricaoClassificacao(resulstadoSql.getString("descricao_classificacao"));
			classificacaoRetorno.setPrazoGuarda(resulstadoSql.getInt("prazo_guarda"));
		}

		return classificacaoRetorno;
	}

	public void inserir(Classificacao classificacao) throws SQLException {
		this.comandoSQL = conexao.prepareStatement(
				"INSERT INTO public.classificacao(id_classificacao, id_cliente, codigo, descricao_classificacao, prazo_guarda) VALUES (nextval('classificacao_id_classificacao_seq'), "
						+ classificacao.getIdCliente() + "," + classificacao.getCodigo() + ", "
						+ classificacao.getDescricaoClassificacao() + ", " + classificacao.getPrazoGuarda() + ");");

		comandoSQL.execute();
	}
}
