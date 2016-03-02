<%@page import="javax.xml.bind.ParseConversionEvent"%>
<%@page import="br.com.webjsp.negocio.LoteBll"%>
<%@page import="br.com.webjsp.entidade.Lote"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/topo.jsp"%>
<script type="text/javascript"
	src="/webjsp/scripts/lote/loteFormulario.js"></script>

<%
	Lote loteFormulario = null;

	// criei um input novo, um input hidden chamada hdnIdLote, por padrão ele eh carregado com o valor do Id do lote se houver.
	if (request.getParameter("hdnIdLote") != null) {
		Lote form = new Lote();
		LoteBll negocio = new LoteBll();

		int txtNumeroLote = Integer.parseInt(request.getParameter("txtNumeroLote"));
		String txtObservacao = request.getParameter("txtObservacao");
		int txtNumeroCaixas = Integer.parseInt(request.getParameter("txtNumeroCaixas"));

		form.setIdLote(Integer.parseInt(request.getParameter("hdnIdLote").toString()));
		form.setNumeroLote(txtNumeroLote);
		form.setObservacao(txtObservacao);
		form.setQtdCaixa(txtNumeroCaixas);

		// aqui ele verifica se é para fazer insert ou update
		if (form.getIdLote() == 0) {
			negocio.inserir(form);
		} else {
			negocio.alterar(form);
		}

		String sucesso = "Lote Salvo com Sucesso! \n";
		System.out.print(sucesso);

	}

	if (request.getParameter("idLote") != null) {
		loteFormulario = new LoteBll().recuperar(Integer.parseInt(request.getParameter("idLote").toString()));
	} else {
		loteFormulario = new Lote();
		loteFormulario.setNumeroLote(0);
		loteFormulario.setObservacao("");
		loteFormulario.setQtdCaixa(0);
	}
%>

<div class="panel panel-default">
	<div class="panel-heading">
		<%
			if (request.getParameter("idLote") != null) {
		%><h3 class="panel-title">Alterar Lote</h3>
		<%
			} else {
		%><h3 class="panel-title">Cadastrar Lote</h3>
		<%
			}
		%>
	</div>
	<div class="panel-body">
		<form data-toggle="validator" role="form" id="frmLote"
			class="form-horizontal" method="POST">
			<input type="hidden" id="hdnIdLote" name="hdnIdLote"
				value="<%=loteFormulario.getIdLote()%>" />
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label for="txtNumeroLote" class="control-label">Número do
						Lote</label> <input type="text" class="form-control numero"
						id="txtNumeroLote" name="txtNumeroLote"
						value="<%=loteFormulario.getNumeroLote()%>" required />
					<div class="help-block with-errors"></div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label for="txtNumeroCaixas" class="control-label">Número
						de Caixas</label> <input type="text" class="form-control numero"
						id="txtNumeroCaixas" name="txtNumeroCaixas"
						value="<%=loteFormulario.getQtdCaixa()%>" required />
					<div class="help-block with-errors"></div>
				</div>

			</div>
			<div class="form-group row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<label for="txtObservacao" class="control-label">Observação</label>
					<textarea class="form-control" rows="3" id="txtObservacao"
						name="txtObservacao" required><%=loteFormulario.getObs()%></textarea>
					<div class="help-block with-errors"></div>
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
