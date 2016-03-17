package br.com.webjsp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webjsp.entidade.UsuarioPerfil;
import br.com.webjsp.negocio.UsuarioPerfilBll;

public class Principal {

	public static void main(String[] args) throws Exception {
		UsuarioPerfil formUsuarioPerfil = new UsuarioPerfil();
		UsuarioPerfilBll negocioUsuarioPerfil = new UsuarioPerfilBll();
		
		int perfis[] = {1};
		for (int i = 0; i < perfis.length; i++) {
			int txtPerfil = perfis[i];

			formUsuarioPerfil.setIdPerfil(txtPerfil);
			negocioUsuarioPerfil.inserirUsuarioPerfil(formUsuarioPerfil);
		}

			/**
			 * for (Integer perfis : listaPerfis){ perfis.getIdPerfil(); if
			 * (!this.UsuarioPerfilExiste(usuarioPerfil, idUsuario)) {
			 * usuarioPerfil.intValue(); this.comandoSQL =
			 * conexao.prepareStatement(
			 * "INSERT INTO public.usuario_perfil(id_usuario_perfil, id_usuario, id_perfil) VALUES (nextval('usuario_perfil_id_usuario_perfil_seq'),"
			 * + idUsuario + ", " + usuarioPerfil + ");");
			 * 
			 * comandoSQL.execute(); } }
			 **/
		}
		
		// descobrir o que inserir

	}

