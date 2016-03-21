package br.com.webjsp.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.dao.ClienteDao;
import br.com.webjsp.entidade.Cliente;

public class ClienteBll {
	private ClienteDao clienteDao = null;

	public ClienteBll() {
		this.clienteDao = new ClienteDao();
	}
	
	/**
	 * Insere novo registro.
	 * 
	 * @param cliente
	 * @throws SQLException
	 */
	public void inserir(Cliente cliente) throws Exception {
		// TipoDadoValidador.validaInsercao(lote);
		this.clienteDao.inserir(cliente);
	}

	/**
	 * Altera o Registro.
	 * 
	 * @param lote
	 * @throws SQLException
	 */
	public void alterar(Cliente cliente) throws Exception {
		// TipoDadoValidador.validaAlteracao(lote);
		this.clienteDao.alterar(cliente);
	}

	/**
	 * Deleta registro com o Id passado.
	 * 
	 * @param idCliente
	 * @throws SQLException
	 */
	public void deletar(int idCliente) throws SQLException {
		this.clienteDao.deletar(idCliente);
	}

	/**
	 * Recupera um �nico TipoDado pelo Id.
	 * 
	 * @param idCliente
	 * @return
	 * @throws SQLException
	 */
	public Cliente recuperar(int idCliente) throws SQLException {
		return this.clienteDao.recuperar(idCliente);
	}

	/**
	 * Pesquisa TipoDado usando o parametro tipoDadoCriterio como critério de
	 * consulta.
	 * 
	 * @param criterioCriterio
	 * @return
	 * @throws SQLException
	 */
	public List<Cliente> pesquisar(Cliente criterioCriterio) throws SQLException {
		return this.clienteDao.pesquisar(criterioCriterio);
	}
	
	
	public void gravaLogo(byte[] imagem, long idCliente) {
		this.clienteDao.gravaLogo(imagem, idCliente);

	}
	
	public byte[] recuperaLogo(long idCliente) {
		return this.clienteDao.recuperaLogo(idCliente);
	}
	
}
