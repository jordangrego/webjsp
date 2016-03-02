<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/topo.jsp"%>
<%@ page
	import="br.com.webjsp.entidade.Usuario, 
				br.com.webjsp.entidade.Cliente, 
				br.com.webjsp.negocio.UsuarioBll, 
				br.com.webjsp.negocio.ClienteBll, 
				br.com.webjsp.exceptions.WebJspException,
				java.util.List"%>
<script type="text/javascript"
	src="/webjsp/scripts/usuario/usuarioFormulario.js"></script>

<%
	List<Cliente> listaCliente = new ClienteBll().pesquisar(new Cliente());

	Usuario usuarioFormulario = null;

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
		<h3 class="panel-title">Cadastro Lote</h3>
	</div>
	<div class="panel-body">
		<form class="form-horizontal">

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

			<div class="btn-toolbar">
				<button id="btnSalvar" type="button"
					class="btn btn-primary pull-right">Salvar</button>
				<button id="btnCancelar" type="button"
					class="btn btn-default pull-right">Cancelar</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="/fundo.jsp"%>