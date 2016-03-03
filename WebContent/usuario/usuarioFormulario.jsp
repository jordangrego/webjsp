<%@page import="br.com.webjsp.negocio.UsuarioPerfilBll"%>
<%@page import="br.com.webjsp.entidade.UsuarioPerfil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/topo.jsp"%>
<%@ page
	import="br.com.webjsp.entidade.Usuario, 
				br.com.webjsp.entidade.Cliente, 
				br.com.webjsp.negocio.UsuarioBll, 
				br.com.webjsp.negocio.ClienteBll, 
				br.com.webjsp.exceptions.WebJspException,
				br.com.webjsp.entidade.Perfil,
				br.com.webjsp.negocio.PerfilBll,
				java.util.List"%>
<script type="text/javascript"
	src="/webjsp/scripts/usuario/usuarioFormulario.js"></script>

<%
	List<Cliente> listaCliente = new ClienteBll().pesquisar(new Cliente());
	List<Perfil> listaPerfis = new PerfilBll().recuperar(new Perfil());
	Usuario usuarioFormulario = null;

	//Inserir
	if (request.getParameter("idUsuario") == null) {
		Usuario form = new Usuario();
		UsuarioPerfil formUsuarioPerfil = new UsuarioPerfil();
		UsuarioBll negocio = new UsuarioBll();
		UsuarioPerfilBll negocioUsuarioPerfil = new UsuarioPerfilBll();

		String txtLogin = request.getParameter("txtLogin");
		String txtNome = request.getParameter("txtNomeUsuario");
		String txtSenha = request.getParameter("txtSenha");
		String txtEmail = request.getParameter("txtEmail");
		int txtCliente = Integer.parseInt(request.getParameter("txtCliente"));

		
		//Aqui ele pega o id do Perfil e vai gravando
		String perfis[] = request.getParameterValues("perfis");
		for (int i = 0; i < perfis.length; i++) {
			int txtPerfil = Integer.parseInt(perfis[i]);

			formUsuarioPerfil.setIdUsuarioPerfil(txtPerfil);
			negocioUsuarioPerfil.inserir(formUsuarioPerfil);
		}
	}

	if (request.getParameter("idUsuario") != null) {
		// é update pois passou idUsuario
		usuarioFormulario = new UsuarioBll()
				.recuperar(Integer.parseInt(request.getParameter("idUsuario").toString()));
	} else {
		// é insert pois nao foi passado idUsuario, seto os campos para "" para nao dar nullpoitExcaption... mas eh porquice isso.
		usuarioFormulario = new Usuario();
		usuarioFormulario.setLogin("");
		usuarioFormulario.setEmail("");
		usuarioFormulario.setSenha("");
		usuarioFormulario.setNome("");
	}
%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Cadastrar Usuário</h3>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" data-toggle="validator" role="form"
			id="frmUsuario" method="POST">
			<input type="hidden" id="hdnIdLoteExcluir" name="hdnIdLoteExcluir"
				value="" /> <input type="hidden" id="hdnIdLote" name="hdnIdLote"
				value="<%=usuarioFormulario.getIdUsuario()%>" />
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Login</label> <input type="text" class="form-control numero"
						value="<%=usuarioFormulario.getLogin()%>" id="txtLogin" />

				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Nome do Usuário</label> <input type="text"
						class="form-control numero" id="txtNomeUsuario"
						value="<%=usuarioFormulario.getNome()%>" />

				</div>

			</div>

			<%
				if (usuarioFormulario.getIdCliente() == 0) {
			%>
			<div class="panel panel-primary">
				<div class="panel-body">

					<div class="form-group row">
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<label>Senha</label> <input type="text"
								class="form-control numero" id="txtSenha" />

						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<label>Confirmação da Senha</label> <input type="text"
								class="form-control numero" id="txtConfirmacaoSenha" />

						</div>

					</div>
				</div>
			</div>
			<%
				}
			%>

			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>E-Mail</label> <input type="text"
						class="form-control numero" id="txtEmail"
						value="<%=usuarioFormulario.getEmail()%>" />

				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Cliente</label> <select class="form-control" id="ddlCliente">
						<option value="0">Selecione</option>
						<%
							for (Cliente cliente : listaCliente) {
						%>
						<option name="txtCliente" value="<%=cliente.getIdCliente()%>" 
							<%if (cliente.getIdCliente() == usuarioFormulario.getIdCliente()) {
					out.println("selected=\"selected\"");
				}%>>
							<%=cliente.getRazaoSocial()%></option>
						<%
							}
						%>
					</select>

				</div>

			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Perfil</label>

					<table class="table table-striped table-bordered">
						<%
							for (Perfil perfil : listaPerfis) {
						%>
						<tr>
							<td style="width: 30px;"><input type="checkbox"
								name="perfis" value="<%=perfil.getIdPerfil()%>"></td>
							<td><%=perfil.getDescricaoPerfil()%></td>
						</tr>
						<%
							}
						%>
					</table>

				</div>
			</div>

			<div class="btn-toolbar">
				<button id="btnSalvar" type="submit"
					class="btn btn-primary pull-right">Salvar</button>
				<button id="btnCancelar" type="button"
					class="btn btn-default pull-right">Cancelar</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="/fundo.jsp"%>