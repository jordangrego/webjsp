<%@ include file="/topo.jsp"%>
<%@ page
	import="br.com.webjsp.entidade.Cliente, br.com.webjsp.negocio.ClienteBll, java.util.List"%>
<%
	List<Cliente> listaCliente = new ClienteBll().pesquisar(new Cliente());
%>
<script type="text/javascript"
	src="/webjsp/scripts/classificacao/classificacaoPesquisa.js"></script>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Pesquisar Classifica��o</h3>
	</div>
	<div class="panel-body">
		<form class="form-inline">
			<div class="form-group">
				<label>Cliente</label> <select class="form-control"
					id="ddlCliente" name="txtCliente">
					<option value=0>Selecione</option>
					<%
						for (Cliente cliente : listaCliente) {
					%>
					<option value="<%=cliente.getIdCliente()%>"><%=cliente.getRazaoSocial()%></option>
					<%
						}
					%>
				</select>
			</div>
			<div class="form-group">
				<label>C�digo</label> <input type="text" class="form-control"
					id="txtCodigo" />
			</div>
			<div class="form-group">
				<label>Descri��o</label> <input type="text" class="form-control"
					id="txtDescricao" />
			</div>
			<button id="btnCadastrar" type="button" class="btn btn-default">Cadastrar</button>
			<button id="btnPesquisar" type="button" class="btn btn-primary">Pesquisar</button>

		</form>
	</div>
</div>

<table id="tblClassificacao" class="grid">
	<!-- bootstrap classes added by the uitheme widget -->
	<thead>
		<!--  -->
		<tr>
			<th>Id Classificacao</th>
			<th>Cliente</th>
			<th>C�digo</th>
			<th>Descri��o</th>
			<th>Prazo</th>
			<th></th>
			<!-- <th class="filter-select filter-exact"
				data-placeholder="Pick a gender">Sex</th>-->
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th colspan="7" class="ts-pager form-horizontal">
				<button type="button" class="btn first">
					<i class="icon-step-backward glyphicon glyphicon-step-backward"></i>
				</button>
				<button type="button" class="btn prev">
					<i class="icon-arrow-left glyphicon glyphicon-backward"></i>
				</button> <span class="pagedisplay"></span> <!-- this can be any element, including an input -->
				<button type="button" class="btn next">
					<i class="icon-arrow-right glyphicon glyphicon-forward"></i>
				</button>
				<button type="button" class="btn last">
					<i class="icon-step-forward glyphicon glyphicon-step-forward"></i>
				</button> <select class="pagesize input-mini" title="Select page size">
					<option selected="selected" value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>
			</select> <select class="pagenum input-mini" title="Select page number"></select>
			</th>
		</tr>
	</tfoot>
	<tbody>
	</tbody>
</table>
<div id="divRetornoClassificacao" class="alert alert-warning divRetorno"
	role="alert">Nenhum Registro Encontrado.</div>
<%@ include file="/fundo.jsp"%>