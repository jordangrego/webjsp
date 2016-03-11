package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webjsp.entidade.Perfil;

public class PerfilDao extends AbstractDao {
	public PerfilDao() {
		super.configuraConexao();
	}

	// Pesquisa os Perfis
	public List<Perfil> pesquisaPerfis(Perfil perfil) throws SQLException {
		List<Perfil> listaRetorno = new ArrayList<Perfil>();
		this.comandoSQL = conexao.prepareStatement("SELECT id_perfil, descricao_perfil FROM public.perfil;".toString());
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			Perfil perfilRetorno = new Perfil();
			perfilRetorno.setIdPerfil(resultadoSql.getLong("id_perfil"));
			perfilRetorno.setDescricaoPerfil(resultadoSql.getString("descricao_perfil"));
			listaRetorno.add(perfilRetorno);
		}

		return listaRetorno;
	}

}
