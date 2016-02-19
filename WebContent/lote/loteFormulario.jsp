<%@page import="br.com.webjsp.negocio.LoteBll"%>
<%@page import="br.com.webjsp.entidade.Lote"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/topo.jsp"%>
<script type="text/javascript"
	src="/webjsp/scripts/lote/loteFormulario.js"></script>
<%
	Lote form = new Lote();

	form.setNumeroLote(50);
	form.setObservacao("txtObservacao");
	form.setQtdCaixa(10);

	LoteBll negocio = new LoteBll();
	negocio.inserir(form);
%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Cadastro Lote</h3>
	</div>
	<div class="panel-body">
		<form class="form-horizontal">

			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>N�mero do Lote</label> <input type="text"
						class="form-control numero" id="txtNumeroLote" />

				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<label>N�mero de Caixas</label> <input type="text"
						class="form-control numero" id="txtNumeroCaixas" />

				</div>

			</div>
			<div class="form-group row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<label>Observa��o</label> <textarea class="form-control" rows="3" id="txtObservacao"></textarea>

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
