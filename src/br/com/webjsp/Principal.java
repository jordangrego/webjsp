package br.com.webjsp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.webjsp.negocio.ClienteBll;

public class Principal {

	public static void main(String[] args) throws Exception {
		
/*
		Path path = Paths.get("C:\\ANAC\\2-Sistemas\\trunk\\Aev\\01.Sistema\\06.Implementacao\\01.Aplicacao\\ANAC.AEV.Web\\Imagens\\anac_logo.png");
		byte[] data = Files.readAllBytes(path);
		
		new ClienteBll().gravaLogo(data, 3);
		System.out.println("Fechou");
		*/
		
		
		byte[] logo = new ClienteBll().recuperaLogo(3);
		
		System.out.println(logo.length);
		
		
		/*
		UsuarioPerfil formUsuarioPerfil = new UsuarioPerfil();
		UsuarioPerfilBll negocioUsuarioPerfil = new UsuarioPerfilBll();
		
		int perfis[] = {1};
		for (int i = 0; i < perfis.length; i++) {
			int txtPerfil = perfis[i];

			formUsuarioPerfil.setIdPerfil(txtPerfil);
			negocioUsuarioPerfil.inserirUsuarioPerfil(formUsuarioPerfil);
		}*/

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

