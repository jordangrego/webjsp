package br.com.webjsp;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.entidade.Lote;
import br.com.webjsp.entidade.Perfil;
import br.com.webjsp.negocio.LoteBll;
import br.com.webjsp.negocio.PerfilBll;

public class Principal {
	public static void main(String[] args) throws SQLException {

		/*Lote loteCriterio = new Lote();

		List<Lote> listaLote = new LoteBll().pesquisar(loteCriterio);

		System.out.println(listaLote);*/
		
		//Perfil perfil = new Perfil();
		List<Perfil> listaPerfis = new PerfilBll().recuperar(new Perfil());
		for (Perfil perfil1 : listaPerfis){
			System.out.println(perfil1.getIdPerfil());
			System.out.println(perfil1.getDescricaoPerfil());
		}
	}
}
