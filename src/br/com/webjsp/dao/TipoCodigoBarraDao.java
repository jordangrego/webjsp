package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webjsp.entidade.TipoCodigoBarra;

public class TipoCodigoBarraDao extends AbstractDao {

	public TipoCodigoBarraDao() {
		super.configuraConexao();
	}

	public List<TipoCodigoBarra> pesquisaTipoCodigoBarra(TipoCodigoBarra tipoCodigoBarra) throws SQLException {
		List<TipoCodigoBarra> listaRetorno = new ArrayList<TipoCodigoBarra>();
		this.comandoSQL = conexao.prepareStatement(
				"SELECT * FROM public.tipo_codigo_barra;");
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			TipoCodigoBarra tipoCodigoBarraRetorno = new TipoCodigoBarra();
			tipoCodigoBarraRetorno.setIdTipoCodigoBarra((resultadoSql.getLong("id_tipo_codigo_barra")));
			tipoCodigoBarraRetorno.setDescricaoTipoCodigoBarra((resultadoSql.getString("descricao_tipo_codigo_barra")));
			listaRetorno.add(tipoCodigoBarraRetorno);
		}

		return listaRetorno;
	}
}
