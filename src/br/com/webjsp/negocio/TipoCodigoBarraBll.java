package br.com.webjsp.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.dao.TipoCodigoBarraDao;
import br.com.webjsp.entidade.TipoCodigoBarra;

public class TipoCodigoBarraBll {
	private TipoCodigoBarraDao tipoCodigoBarraDao = null;
	
	public TipoCodigoBarraBll(){
		this.tipoCodigoBarraDao = new TipoCodigoBarraDao();
	}
	
	//Pesquisa dos Tipos de Código Barra
	public List<TipoCodigoBarra> pesquisaTipoCodigoBarra (TipoCodigoBarra tipoCodigoBarra) throws SQLException {
		return this.tipoCodigoBarraDao.pesquisaTipoCodigoBarra(tipoCodigoBarra);
	}
}
