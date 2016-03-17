<%@page import="java.util.ArrayList"%>
<%@page import="org.postgresql.util.PSQLDriverVersion"%>
<%@page import="br.com.webjsp.negocio.UsuarioPerfilBll"%>
<%@page import="br.com.webjsp.entidade.UsuarioPerfil"%>

<%@ include file="/topo.jsp"%>
<%@ page
	import="br.com.webjsp.entidade.Usuario, 
				br.com.webjsp.entidade.Cliente, 
				br.com.webjsp.negocio.UsuarioBll, 
				br.com.webjsp.negocio.ClienteBll, 
				br.com.webjsp.exceptions.WebJspException,
				br.com.webjsp.entidade.Perfil,
				br.com.webjsp.negocio.PerfilBll,
				br.com.webjsp.entidade.UsuarioPerfil,
				java.util.List"%>
<script type="text/javascript"
	src="/webjsp/scripts/usuario/usuarioFormulario.js"></script>

<%
	List<Cliente> listaCliente = new ClienteBll().pesquisar(new Cliente());
	List<Perfil> listaPerfis = new PerfilBll().recuperar(new Perfil());
	List<UsuarioPerfil> listaUsuarioPerfil = new UsuarioPerfilBll().recuperaUsuarioPerfil(new UsuarioPerfil());
	Usuario usuarioFormulario = null;

	//Excluir

	if (request.getParameter("hdnIdUsuarioExcluir") != null && request.getParameter("hdnAcao").equals("e")) {
		int txtIdUsuario = Integer.parseInt(request.getParameter("hdnIdUsuarioExcluir"));
		UsuarioBll negocioUsuario = new UsuarioBll();
		UsuarioPerfilBll negocioUsuarioPerfil = new UsuarioPerfilBll();

		negocioUsuarioPerfil.excluirUsuarioPerfil(txtIdUsuario);
		negocioUsuario.excluir(txtIdUsuario);

		response.sendRedirect("http://localhost:8080/webjsp/usuario/usuarioPesquisa.jsp");
		return;
	}

	//Inserir
	if (request.getParameter("hdnIdUsuario") != null) {
		Usuario form = new Usuario();
		UsuarioPerfil formUsuarioPerfil = new UsuarioPerfil();
		UsuarioBll negocio = new UsuarioBll();
		UsuarioPerfilBll negocioUsuarioPerfil = new UsuarioPerfilBll();

		String txtLogin = request.getParameter("txtLogin");
		String txtNome = request.getParameter("txtNomeUsuario");
		String txtSenha = request.getParameter("txtSenha");
		String txtEmail = request.getParameter("txtEmail");
		//int txtCliente = 1;
		int txtCliente = Integer.parseInt(request.getParameter("txtCliente"));

		form.setIdUsuario(Integer.parseInt(request.getParameter("hdnIdUsuario").toString()));
		form.setLogin(txtLogin);
		form.setNome(txtNome);
		form.setSenha(txtSenha);
		form.setEmail(txtEmail);
		form.setIdCliente(txtCliente);

		// aqui ele verifica se é para fazer insert ou update
		if (form.getIdUsuario() == 0) {
			try {
				negocio.inserir(form);
				System.out.println("Aff");
				//Aqui ele pega o id do Perfil e vai gravando
				String perfis[] = request.getParameterValues("perfis");
				for (int i = 0; i < perfis.length; i++) {
					int txtPerfil = Integer.parseInt(perfis[i]);

					formUsuarioPerfil.setIdPerfil(txtPerfil);
					negocioUsuarioPerfil.inserirUsuarioPerfil(formUsuarioPerfil);
				}
			} catch (NullPointerException e) {
%><div class="alert alert-danger" role="alert">Preecha os campos
	obrigatórios</div>
<%
	} catch (Exception e) {
%><div class="alert alert-danger" role="alert">Login já utilizado,
	por favor, informe outro.</div>
<%
	}

		} else {
			negocio.alterar(form);

			//Aqui ele pega o id do Perfil e vai gravando
			ArrayList<Integer> listaUsuarioPerfis = new ArrayList<Integer>();

			String perfis[] = request.getParameterValues("perfis");

			for (int i = 0; i < perfis.length; i++) {
				UsuarioPerfil perfil = new UsuarioPerfil();
				int txtPerfil = Integer.parseInt(perfis[i]);

				perfil.setIdPerfil(txtPerfil);

				listaUsuarioPerfis.add(txtPerfil);
			}

			int txtIdUsuario = (int) form.getIdUsuario();

			List<Integer> listaUsuarioPerfis2 = new ArrayList<Integer>();
			listaUsuarioPerfis2 = listaUsuarioPerfis;

			negocioUsuarioPerfil.alterarUsuarioPerfil(listaUsuarioPerfis2, txtIdUsuario);
			System.out.println(listaUsuarioPerfis);
		}

		String sucesso = "Usuario gravado com sucesso \n";
		System.out.println(sucesso);
	}

	if (request.getParameter("idUsuario") != null) {
		// é update pois passou idUsuario
		usuarioFormulario = new UsuarioBll()
				.recuperar(Integer.parseInt(request.getParameter("idUsuario").toString()));
	} else {
		// é insert pois nao foi passado idUsuario, seto os campos para "" para nao dar nullpointException... mas eh porquice isso.
		usuarioFormulario = new Usuario();
		usuarioFormulario.setLogin("");
		usuarioFormulario.setEmail("");
		usuarioFormulario.setSenha("");
		usuarioFormulario.setNome("");
	}
%>

<div class="panel panel-default">
	<div class="panel-heading">
		<%
			if (request.getParameter("idUsuario") == null) {
		%>
		<h3 class="panel-title">Cadastrar Usuário</h3>
		<%
			} else {
		%>
		<h3 class="panel-title">Alterar Usuário</h3>
		<%
			}
		%>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" name="formUsuario" id="formUsuario"
			data-toggle="validator" role="form" id="frmUsuario" method="POST">
			<input type="hidden" id="hdnAcao" name="hdnAcao" value="" /> <input
				type="hidden" id="hdnIdUsuarioExcluir" name="hdnIdUsuarioExcluir"
				value="" /> <input type="hidden" id="hdnIdUsuario"
				name="hdnIdUsuario" value="<%=usuarioFormulario.getIdUsuario()%>" />
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divLogin">
					<label>Login</label> <input type="text" class="form-control"
						value="<%=usuarioFormulario.getLogin()%>" id="txtLogin"
						name="txtLogin" required />

				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divNome">
					<label>Nome do Usuário</label> <input type="text"
						class="form-control" id="txtNomeUsuario" name="txtNomeUsuario"
						value="<%=usuarioFormulario.getNome()%>" required />

				</div>
			</div>

			<%
				if (usuarioFormulario.getIdCliente() == 0) {
			%>
			<div class="panel panel-primary">
				<div class="panel-body form-group" id="divSenha">

					<div class="form-group row">
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<label for="inputPassword" class="control-label">Senha</label> <input
								type="password" class="form-control numero" id="txtSenha"
								name="txtSenha" required />
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<label for="inputPassword" class="control-label">Confirmação
								da Senha</label> <input type="password" class="form-control numero"
								id="txtConfirmacaoSenha" name="txtConfirmacaoSenha" />

						</div>

					</div>
				</div>
			</div>
			<%
				}
			%>

			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divEmail">
					<label>E-Mail</label> <input type="email" class="form-control"
						id="txtEmail" name="txtEmail"
						value="<%=usuarioFormulario.getEmail()%>" required />

				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divCliente" >
					<label>Cliente</label> <select class="form-control" id="ddlCliente"
						name="txtCliente" required>
						<option value=0>Selecione</option>
						<%
							for (Cliente cliente : listaCliente) {
						%>
						<option value="<%=cliente.getIdCliente()%>"
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
			<div class="form-group row" >
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divCheckbox">
					<label>Perfil</label>

					<table class="table table-striped table-bordered">
						<%
							for (Perfil perfil : listaPerfis) {
						%>
						<tr>
							<td style="width: 30px;"><input type="checkbox"
								class="ckPerfil" name="perfis" id="perfis"
								value="<%=perfil.getIdPerfil()%>"
								<%if (request.getParameter("idUsuario") != null) {
					if (UsuarioPerfilBll.IsPossuiPerfil(listaPerfis, perfil.getIdPerfil(),
							usuarioFormulario.getIdUsuario()) == true) {%>
								checked="checked"> <%
 	}
 		}
 %></td>
							<td><%=perfil.getDescricaoPerfil()%></td>
						</tr>
						<%
							}
						%>
					</table>
					<div id="divCheck" class="divCheck"></div>
				</div>

			</div>


			<div class="btn-toolbar">
				<button id="btnSalvar" type="button"
					class="btn btn-primary pull-right">Salvar</button>
				<%
					if (request.getParameter("idUsuario") != null) {
				%>
				<button id="btnExcluir" name="btnExcluir" type="button"
					class="btn btn-default pull-right">Excluir</button>
				<%
					} else {
					}
				%>
				<button id="btnCancelar" type="button"
					class="btn btn-default pull-right">Cancelar</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="/fundo.jsp"%>