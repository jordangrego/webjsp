package br.com.webjsp.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.dao.ClassificacaoDao;
import br.com.webjsp.dao.ClienteDao;
import br.com.webjsp.entidade.Classificacao;
import br.com.webjsp.entidade.Cliente;

public class ClassificacaoBll {
	ClassificacaoDao classificacaoDao = null;

	public ClassificacaoBll() {
		this.classificacaoDao = new ClassificacaoDao();
	}

	public List<Classificacao> pesquisar(Classificacao classificacao, boolean isRecuperaCliente) throws SQLException {
		
		List<Classificacao> listaClassificacao = this.classificacaoDao.pesquisar(classificacao);
		
		
		if (isRecuperaCliente) {
			ClienteDao clienteDao = new ClienteDao();
			for(Classificacao classsificacaoRec : listaClassificacao) {
				Cliente cliente = clienteDao.recuperar((int)classsificacaoRec.getIdCliente());
				classsificacaoRec.setCliente(cliente);
				
			}
		}
		
		
		
		return listaClassificacao;
	}
	
	public void inserir (Classificacao classificacao) throws SQLException{
		this.classificacaoDao.inserir(classificacao);
	}
	
	public Classificacao recuperar (int idClassificacao) throws SQLException{
		return this.classificacaoDao.recuperar(idClassificacao);		
	}
}
