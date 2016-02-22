package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import br.com.webjsp.entidade.Lote;

public class LoteDao extends AbstractDao {
	public LoteDao() {
		super.configuraConexao();
	}

	/**
	 * Insere novo registro.
	 * 
	 * @param lote
	 * @throws SQLException
	 */
	public void inserir(Lote lote) throws SQLException {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");

		this.comandoSQL = conexao.prepareStatement(
				"INSERT INTO public.lote(id_lote, id_cliente, id_usuario, numero_lote, data_recebimento, qtd_caixa, observacao) VALUES (NEXTVAL('lote_id_lote_seq'), 3, 1, '"
						+ lote.getNumeroLote() + "', '" + dataFormatada.format(data) + "', '" + lote.getQtdCaixa()
						+ "', '" + lote.getObservacao() + "');");
		comandoSQL.execute();

		/*
		 * this.comandoSQL = conexao.prepareStatement(
		 * "SELECT id_tipo_dado, descricao_tipo FROM public.tipo_dado order by id_tipo_dado desc limit 1"
		 * ); ResultSet resultadoSql = comandoSQL.executeQuery();
		 * 
		 * while (resultadoSql.next()) {
		 * lote.setIdTipoDado(Integer.parseInt(resultadoSql.getString(1)));
		 * lote.setDescricaoTipoDado(resultadoSql.getString(2).toString()); }
		 */
	}

	/**
	 * Altera o Registro.
	 * 
	 * @param lote
	 * @throws SQLException
	 */
	public void alterar(Lote lote) throws SQLException {
		this.comandoSQL = conexao.prepareStatement(
				"UPDATE public.lote SET  numero_lote='" + lote.getNumeroLote() + "', qtd_caixa='" + lote.getQtdCaixa() + "', observacao='" + lote.getObservacao() + "' WHERE id_lote = '" + lote.getIdLote() + "';");
		
		comandoSQL.execute();
		/*
		 * this.comandoSQL = conexao.prepareStatement(
		 * "UPDATE public.tipo_dado set descricao_tipo = '" +
		 * lote.getDescricaoTipoDado() + "' where id_tipo_dado = " +
		 * lote.getIdTipoDado()); comandoSQL.execute();
		 */
	}

	/**
	 * Deleta registro com o Id passado.
	 * 
	 * @param idLote
	 * @throws SQLException
	 */
	public void deletar(int idLote) throws SQLException {
		this.comandoSQL = conexao.prepareStatement("DELETE FROM public.lote where id_lote = " + idLote);
		comandoSQL.execute();
	}

	/**
	 * Recupera um �nico TipoDado pelo Id.
	 * 
	 * @param idLote
	 * @return
	 * @throws SQLException
	 */
	public Lote recuperar(int idLote) throws SQLException {
		Lote loteRetorno = null;

		this.comandoSQL = conexao.prepareStatement(
				"SELECT id_lote, id_cliente, id_usuario, numero_lote, data_recebimento, qtd_caixa, observacao FROM lote where id_lote = "
						+ idLote);
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			loteRetorno = new Lote();
			loteRetorno.setIdLote(resultadoSql.getInt(1));
			loteRetorno.setIdCliente(resultadoSql.getInt(2));
			loteRetorno.setIdUsuario(resultadoSql.getInt(3));
			loteRetorno.setNumeroLote(resultadoSql.getInt(4));
			loteRetorno.setDataRecebimento(resultadoSql.getDate(5));
			loteRetorno.setQtdCaixa(resultadoSql.getInt(6));
			loteRetorno.setObservacao(resultadoSql.getString(7));
		}

		return loteRetorno;
	}

	/**
	 * Pesquisa TipoDado usando o parametro tipoDadoCriterio como crit�rio de
	 * consulta.
	 * 
	 * @param loteCriterio
	 * @return
	 * @throws SQLException
	 */
	public List<Lote> pesquisar(Lote loteCriterio) throws SQLException {
		List<Lote> listaRetorno = new ArrayList<Lote>();

		StringBuilder sql = new StringBuilder();

		sql.append(
				"SELECT id_lote, id_cliente, id_usuario, numero_lote, data_recebimento, qtd_caixa, observacao FROM lote where ");

		if (loteCriterio.getIdLote() > 0) {
			sql.append(" id_lote = " + loteCriterio.getIdLote() + " AND ");
		}

		if (loteCriterio.getIdCliente() > 0) {
			sql.append(" id_cliente = " + loteCriterio.getIdCliente() + " AND ");
		}

		if (loteCriterio.getIdUsuario() > 0) {
			sql.append(" id_usuario = " + loteCriterio.getIdUsuario() + " AND ");
		}

		if (loteCriterio.getNumeroLote() > 0) {
			sql.append(" numero_lote = " + loteCriterio.getNumeroLote() + " AND ");
		}

		if (loteCriterio.getQtdCaixa() > 0) {
			sql.append(" qtd_caixa = " + loteCriterio.getQtdCaixa() + " AND ");
		}

		if (loteCriterio.getObservacao() != null && !loteCriterio.getObservacao().equals("")) {
			sql.append(" observacao like '%" + loteCriterio.getObservacao() + "%' AND ");
		}

		sql.append(" 1 = 1 ");

		this.comandoSQL = conexao.prepareStatement(sql.toString());
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			Lote loteRetorno = new Lote();
			loteRetorno.setIdLote(resultadoSql.getInt(1));
			loteRetorno.setIdCliente(resultadoSql.getInt(2));
			loteRetorno.setIdUsuario(resultadoSql.getInt(3));
			loteRetorno.setNumeroLote(resultadoSql.getInt(4));
			loteRetorno.setDataRecebimento(resultadoSql.getDate(5));
			loteRetorno.setQtdCaixa(resultadoSql.getInt(6));
			loteRetorno.setObservacao(resultadoSql.getString(7));
			listaRetorno.add(loteRetorno);
		}

		return listaRetorno;
	}
}
