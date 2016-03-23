<%@page import="br.com.webjsp.negocio.TipoCodigoBarraBll"%>
<%@page import="java.io.InputStream, java.io.FileInputStream"%>
<%@page import="org.apache.tomcat.jni.File"%>
<%@page import="java.sql.Blob"%>
<%@ include file="/topo.jsp"%>
<%@ page
	import="br.com.webjsp.entidade.Cliente,br.com.webjsp.negocio.ClienteBll, br.com.webjsp.entidade.TipoCodigoBarra"%>

<%@page import="java.util.ArrayList, java.util.Date, java.util.List"%>

<script type="text/javascript"
	src="/webjsp/scripts/cliente/clienteFormulario.js"></script>
<%
	List<TipoCodigoBarra> listaTipoCodigoBarra = new TipoCodigoBarraBll()
			.pesquisaTipoCodigoBarra(new TipoCodigoBarra());
	Cliente clienteFormulario = null;
	//Inserir
	if (request.getParameter("hdnIdCliente") != null) {
		Cliente form = new Cliente();
		ClienteBll negocio = new ClienteBll();

		Date date = new Date();

		String txtRazaoSocial = request.getParameter("txtRazaoSocial");
		String txtEmailCliente = request.getParameter("txtEmailCliente");
		String txtCnpj = request.getParameter("txtCNPJ");
		String imgLogo = request.getParameter("fileLogo");
		//Part filePart = request.getPart("fileLogo");
		//	InputStream is = new FileInputStream(filePart);

		String imgFundoEspelho = request.getParameter("fileFundoEspelho");
		int txtQtdCaixaPadrao = Integer.parseInt(request.getParameter("txtQtdCaixaBoxLote"));
		boolean isExisteCaixaTriplex = request.getParameter("checkCaixaTriplex") != null;
		int txtPercAprovacao = Integer.parseInt(request.getParameter("txtMinAprov"));
		int txtPrazoEntrega = Integer.parseInt(request.getParameter("txtPrazoEntrega"));
		int txtPaginasTotalContrato = Integer.parseInt(request.getParameter("txtQtdPagTotaisContrato"));
		int txtMetaPaginasDia = Integer.parseInt(request.getParameter("txtMetaDiaria"));

		int txtIdTipoCodigoBarra = Integer.parseInt(request.getParameter("txtBarcode"));
		
		form.setIdCliente(Integer.parseInt(request.getParameter("hdnIdCliente").toString()));
		form.setRazaoSocial(txtRazaoSocial);
		form.setEmailCliente(txtEmailCliente);
		form.setCnpj(txtCnpj);
		form.setLogo(null);
		form.setFundoEspelho(null);
		form.setQtdCaixaPadrao(txtQtdCaixaPadrao);
		form.setExisteCaixaTriplex(isExisteCaixaTriplex);
		form.setPercAprovacao(txtPercAprovacao);
		form.setPrazo_entrega(txtPrazoEntrega);
		form.setPaginas_total_contrato(txtPaginasTotalContrato);
		form.setMetaPaginasDia(txtMetaPaginasDia);
		form.setIdTipoCodigoBarra(txtIdTipoCodigoBarra);
		form.setDataHora(date);

		if (form.getIdCliente() == 0) {
			negocio.inserir(form);
		} else {
			negocio.alterar(form);
		}
	}

	if (request.getParameter("idCliente") != null) {
		// � update pois passou idCliente
		clienteFormulario = new ClienteBll()
				.recuperar(Integer.parseInt(request.getParameter("idCliente").toString()));
	} else {
		clienteFormulario = new Cliente();
		clienteFormulario.setRazaoSocial("");
		clienteFormulario.setEmailCliente("");
		clienteFormulario.setCnpj("");
	}
%>
<div class="panel panel-default">
	<%
		if (request.getParameter("idCliente") == null) {
	%>
	<div class="panel-heading">
		<h3 class="panel-title">Cadastrar Cliente</h3>
	</div>
	<%
		} else {
	%>
	<div class="panel-heading">
		<h3 class="panel-title">Alterar Cliente</h3>
	</div>
	<%
		}
	%>
	<div class="panel-body">
		<form class="form-horizontal" name="formCliente" id="formCliente"
			method="POST">
			<input type="hidden" id="hdnIdCliente" name="hdnIdCliente"
				value="<%=clienteFormulario.getIdCliente()%>" />
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Nome</label> <input type="text" class="form-control"
						value="<%=clienteFormulario.getRazaoSocial()%>"
						id="txtRazaoSocial" name="txtRazaoSocial" />
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>E-mail</label> <input type="text" class="form-control"
						value="<%=clienteFormulario.getEmailCliente()%>"
						id="txtEmailCliente" name="txtEmailCliente" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>CNPJ</label> <input type="text" class="form-control"
						value="<%=clienteFormulario.getCnpj()%>" id="txtCNPJ"
						name="txtCNPJ" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Logo</label> <input type="file"
						class="btn btn-default btn-sm file-upload"
						value="<%=clienteFormulario.getLogo()%>" id="fileLogo"
						name="fileLogo" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Fundo Espelho</label> <input type="file"
						class="btn btn-default btn-sm file-upload"
						value="<%=clienteFormulario.getFundoEspelho()%>"
						id="fileFundoEspelho" name="fileFundoEspelho" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Quantidade Caixa Box Lote</label> <input type="text"
						class="form-control"
						value="<%=clienteFormulario.getQtdCaixaPadrao()%>"
						id="txtQtdCaixaBoxLote" name="txtQtdCaixaBoxLote" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Caixa Triplex?</label> <input type="checkbox" class="center"
						value="<%=clienteFormulario.isExisteCaixaTriplex()%>"
						id="checkCaixaTriplex" name="checkCaixaTriplex" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>% Minimo para Aprova��o</label> <input type="text"
						class="form-control"
						value="<%=clienteFormulario.getPercAprovacao()%>" id="txtMinAprov"
						name="txtMinAprov" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Prazo de Entrega</label> <input type="text"
						class="form-control"
						value="<%=clienteFormulario.getPrazo_entrega()%>"
						id="txtPrazoEntrega" name="txtPrazoEntrega" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Qtd. p�ginas totais do contrato</label> <input type="text"
						class="form-control"
						value="<%=clienteFormulario.getPaginas_total_contrato()%>"
						id="txtQtdPagTotaisContrato" name="txtQtdPagTotaisContrato" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Meta Di�ria</label> <input type="text" class="form-control"
						value="<%=clienteFormulario.getMetaPaginasDia()%>"
						id="txtMetaDiaria" name="txtMetaDiaria" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>BarCode</label> <select class="form-control lista"
						id="txtBarcode" name="txtBarcode" required>
						<option value=0>Selecione</option>
						<%
							for (TipoCodigoBarra tipoCodigoBarra : listaTipoCodigoBarra) {
						%>
						<option value="<%=tipoCodigoBarra.getIdTipoCodigoBarra()%>" <%if(tipoCodigoBarra.getIdTipoCodigoBarra() == clienteFormulario.getIdTipoCodigoBarra()){ out.println("selected=\"selected\""); } %>>
							<%=tipoCodigoBarra.getDescricaoTipoCodigoBarra()%></option>
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