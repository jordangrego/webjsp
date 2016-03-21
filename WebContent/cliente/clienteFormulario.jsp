<%@page import="java.sql.Blob"%>
<%@ include file="/topo.jsp"%>
<%@ page
	import="br.com.webjsp.entidade.Cliente,br.com.webjsp.negocio.ClienteBll"%>

<%@page import="java.util.ArrayList, java.util.Date"%>

<script type="text/javascript"
	src="/webjsp/scripts/cliente/clienteFormulario.js"></script>
<%
	//Inserir
	if (request.getParameter("hdnIdCliente") != null) {
		Cliente form = new Cliente();
		ClienteBll negocio = new ClienteBll();

		Date date = new Date();

		String txtRazaoSocial = request.getParameter("txtRazaoSocial");
		String txtEmailCliente = request.getParameter("txtEmailCliente");
		String txtCnpj = request.getParameter("txtCNPJ");
		String imgLogo = request.getParameter("fileLogo");
		String imgFundoEspelho = request.getParameter("fileFundoEspelho");
		int txtQtdCaixaPadrao = Integer.parseInt(request.getParameter("txtQtdCaixaBoxLote"));
		boolean isExisteCaixaTriplex = Boolean.parseBoolean(request.getParameter("checkCaixaTriplex"));
		int txtPercAprovacao = Integer.parseInt(request.getParameter("txtMinAprov"));
		int txtPrazoEntrega = Integer.parseInt(request.getParameter("txtPrazoEntrega"));
		int txtPaginasTotalContrato = Integer.parseInt(request.getParameter("txtQtdPagTotaisContrato"));
		int txtMetaPaginasDia = Integer.parseInt(request.getParameter("txtMetaDiaria"));
		
		int txtIdTipoCodigoBarra = Integer.parseInt(request.getParameter("txtBarcode"));

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
	} else {
		
	}
%>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Cadastrar Cliente</h3>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" name="formCliente" id="formCliente"
			method="POST">
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Nome</label> <input type="text" class="form-control"
						value="" id="txtRazaoSocial" name="txtRazaoSocial" />
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>E-mail</label> <input type="text" class="form-control"
						value="" id="txtEmailCliente" name="txtEmailCliente" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>CNPJ</label> <input type="text" class="form-control"
						value="" id="txtCNPJ" name="txtCNPJ" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Logo</label> <input type="file"
						class="btn btn-default btn-sm file-upload" value="" id="fileLogo"
						name="fileLogo" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>Fundo Espelho</label> <input type="file"
						class="btn btn-default btn-sm file-upload" value=""
						id="fileFundoEspelho" name="fileFundoEspelho" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Quantidade Caracteres Caixa Box</label> <input type="text"
						class="form-control" value="" id="txtQtdCaracteresCaixaBox"
						name="txtQtdCaracteresCaixaBox" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Quantidade Caixa Box Lote</label> <input type="text"
						class="form-control" value="" id="txtQtdCaixaBoxLote"
						name="txtQtdCaixaBoxLote" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Caixa Triplex?</label> <input type="checkbox" class="center"
						value="" id="checkCaixaTriplex" name="checkCaixaTriplex" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>% Minimo para Aprovação</label> <input type="text"
						class="form-control" value="" id="txtMinAprov" name="txtMinAprov" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Prazo de Entrega</label> <input type="text"
						class="form-control" value="" id="txtPrazoEntrega"
						name="txtPrazoEntrega" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Qtd. páginas totais do contrato</label> <input type="text"
						class="form-control" value="" id="txtQtdPagTotaisContrato"
						name="txtQtdPagTotaisContrato" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>Meta Diária</label> <input type="text" class="form-control"
						value="" id="txtMetaDiaria" name="txtMetaDiaria" />
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12 col-xs-12">
					<label>BarCode</label> <select class="form-control lista"
						id="txtBarcode" name="txtBarcode" required>
						<option value=0>Selecione</option>
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