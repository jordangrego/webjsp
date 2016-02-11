package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webjsp.entidade.TipoDado;

public class TipoDadoDao extends AbstractDao {
	
	public TipoDadoDao() {
		super.configuraConexao();
	}

	/**
	 * Insere novo registro.
	 * @param tipoDado
	 * @throws SQLException
	 */
	public void inserir(TipoDado tipoDado) throws SQLException {
		this.comandoSQL = conexao.prepareStatement("INSERT INTO public.tipo_dado (id_tipo_dado, descricao_tipo) VALUES ((SELECT NEXTVAL('public.tipo_dado_id_tipo_dado_seq')), '" + tipoDado.getDescricaoTipoDado() + "');");
		comandoSQL.execute();
		
		this.comandoSQL = conexao.prepareStatement("SELECT id_tipo_dado, descricao_tipo FROM public.tipo_dado order by id_tipo_dado desc limit 1");
		ResultSet resultadoSql = comandoSQL.executeQuery();
		
		while (resultadoSql.next()) {
			tipoDado.setIdTipoDado(Integer.parseInt(resultadoSql.getString(1)));
			tipoDado.setDescricaoTipoDado(resultadoSql.getString(2).toString());
		}
	}

	/**
	 * Altera o Registro.
	 * @param tipoDado
	 * @throws SQLException
	 */
	public void alterar(TipoDado tipoDado) throws SQLException {
		this.comandoSQL = conexao.prepareStatement("UPDATE public.tipo_dado set descricao_tipo = '" + tipoDado.getDescricaoTipoDado() + "' where id_tipo_dado = " + tipoDado.getIdTipoDado());
		comandoSQL.execute();
	}

	/**
	 * Deleta registro com o Id passado.
	 * @param idTipoDado
	 * @throws SQLException
	 */
	public void deletar(int idTipoDado) throws SQLException {
		this.comandoSQL = conexao.prepareStatement("DELETE FROM public.tipo_dado where id_tipo_dado = " + idTipoDado);
		comandoSQL.execute();
	}

	/**
	 * Recupera um único TipoDado pelo Id.
	 * @param idTipoDado
	 * @return
	 * @throws SQLException
	 */
	public TipoDado recuperar(int idTipoDado) throws SQLException {
		TipoDado tipoDadoRetorno = null;

		this.comandoSQL = conexao.prepareStatement("SELECT id_tipo_dado, descricao_tipo FROM public.tipo_dado where id_tipo_dado = " + idTipoDado);
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			tipoDadoRetorno = new TipoDado();
			tipoDadoRetorno.setIdTipoDado(Integer.parseInt(resultadoSql.getString(1)));
			tipoDadoRetorno.setDescricaoTipoDado(resultadoSql.getString(2).toString());
		}

		return tipoDadoRetorno;
	}

	/**
	 * Pesquisa TipoDado usando o parametro tipoDadoCriterio como critério de consulta.
	 * @param tipoDadoCriterio
	 * @return
	 * @throws SQLException
	 */
	public List<TipoDado> pesquisar(TipoDado tipoDadoCriterio) throws SQLException {
		List<TipoDado> listaRetorno = new ArrayList<TipoDado>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id_tipo_dado, descricao_tipo FROM public.tipo_dado where ");

		if (tipoDadoCriterio.getIdTipoDado() > 0) {
			sql.append(" id_tipo_dado = " + tipoDadoCriterio.getIdTipoDado() + " AND ");
		}

		if (tipoDadoCriterio.getDescricaoTipoDado() != null && !tipoDadoCriterio.getDescricaoTipoDado().equals("")) {
			sql.append(" descricao_tipo like '%" + tipoDadoCriterio.getDescricaoTipoDado() + "%' AND ");
		}

		sql.append(" 1 = 1 ");

		this.comandoSQL = conexao.prepareStatement(sql.toString());
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			TipoDado tipoDadoRetorno = new TipoDado();
			tipoDadoRetorno = new TipoDado();
			tipoDadoRetorno.setIdTipoDado(Integer.parseInt(resultadoSql.getString(1)));
			tipoDadoRetorno.setDescricaoTipoDado(resultadoSql.getString(2).toString());
			listaRetorno.add(tipoDadoRetorno);
		}

		return listaRetorno;
	}
}
