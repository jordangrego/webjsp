package br.com.webjsp.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.dao.TipoDadoDao;
import br.com.webjsp.entidade.TipoDado;
import br.com.webjsp.negocio.validadores.TipoDadoValidador;

public class TipoDadoBll {
	
	private TipoDadoDao tipoDadoDao = null;

	public TipoDadoBll() {
		this.tipoDadoDao = new TipoDadoDao();
	}

	/**
	 * Insere novo registro.
	 * 
	 * @param tipoDado
	 * @throws SQLException
	 */
	public void inserir(TipoDado tipoDado) throws Exception {
		TipoDadoValidador.validaInsercao(tipoDado);
		this.tipoDadoDao.inserir(tipoDado);
	}

	/**
	 * Altera o Registro.
	 * 
	 * @param tipoDado
	 * @throws SQLException
	 */
	public void alterar(TipoDado tipoDado) throws Exception {
		TipoDadoValidador.validaAlteracao(tipoDado);
		this.tipoDadoDao.alterar(tipoDado);
	}

	/**
	 * Deleta registro com o Id passado.
	 * 
	 * @param idTipoDado
	 * @throws SQLException
	 */
	public void deletar(int idTipoDado) throws SQLException {
		this.tipoDadoDao.deletar(idTipoDado);
	}

	/**
	 * Recupera um único TipoDado pelo Id.
	 * 
	 * @param idTipoDado
	 * @return
	 * @throws SQLException
	 */
	public TipoDado recuperar(int idTipoDado) throws SQLException {
		return this.tipoDadoDao.recuperar(idTipoDado);
	}

	/**
	 * Pesquisa TipoDado usando o parametro tipoDadoCriterio como critério de
	 * consulta.
	 * 
	 * @param tipoDadoCriterio
	 * @return
	 * @throws SQLException
	 */
	public List<TipoDado> pesquisar(TipoDado tipoDadoCriterio) throws SQLException {
		return this.tipoDadoDao.pesquisar(tipoDadoCriterio);
	}
}
