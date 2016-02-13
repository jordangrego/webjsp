package br.com.webjsp.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.dao.LoteDao;
import br.com.webjsp.entidade.Lote;

public class LoteBll {
	private LoteDao loteDao = null;

	public LoteBll() {
		this.loteDao = new LoteDao();
	}

	/**
	 * Insere novo registro.
	 * 
	 * @param lote
	 * @throws SQLException
	 */
	public void inserir(Lote lote) throws Exception {
		// TipoDadoValidador.validaInsercao(lote);
		this.loteDao.inserir(lote);
	}

	/**
	 * Altera o Registro.
	 * 
	 * @param lote
	 * @throws SQLException
	 */
	public void alterar(Lote lote) throws Exception {
		// TipoDadoValidador.validaAlteracao(lote);
		this.loteDao.alterar(lote);
	}

	/**
	 * Deleta registro com o Id passado.
	 * 
	 * @param idLote
	 * @throws SQLException
	 */
	public void deletar(int idLote) throws SQLException {
		this.loteDao.deletar(idLote);
	}

	/**
	 * Recupera um �nico TipoDado pelo Id.
	 * 
	 * @param idLote
	 * @return
	 * @throws SQLException
	 */
	public Lote recuperar(int idLote) throws SQLException {
		return this.loteDao.recuperar(idLote);
	}

	/**
	 * Pesquisa TipoDado usando o parametro tipoDadoCriterio como critério de
	 * consulta.
	 * 
	 * @param loteCriterio
	 * @return
	 * @throws SQLException
	 */
	public List<Lote> pesquisar(Lote loteCriterio) throws SQLException {
		return this.loteDao.pesquisar(loteCriterio);
	}
}
