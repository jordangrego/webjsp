package br.com.webjsp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.webjsp.entidade.Perfil;

public class PerfilDao extends AbstractDao {
	public PerfilDao() {
		super.configuraConexao();
	}
	// Pesquisa os Perfis
	public Perfil pesquisaPerfis(Perfil perfil) throws SQLException{
		Perfil perfilRetorno = null;
		this.comandoSQL = conexao.prepareStatement("SELECT id_perfil, descricao_perfil FROM public.perfil;");
		ResultSet resultadoSql = comandoSQL.executeQuery();
		
		while(resultadoSql.next()){
			perfilRetorno = new Perfil();
			perfilRetorno.setIdPerfil(resultadoSql.getLong("id_perfil"));
			perfilRetorno.setDescricaoPerfil(resultadoSql.getString("descricao_perfil"));
		}
		
		return perfilRetorno;
	}
}
