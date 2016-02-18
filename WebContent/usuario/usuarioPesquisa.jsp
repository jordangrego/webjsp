<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/topo.jsp"%>
<script type="text/javascript"
	src="/webjsp/scripts/usuario/usuarioPesquisa.js"></script>


<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Pesquisa Usu�rio</h3>
	</div>
	<div class="panel-body">
		<form class="form-inline">
			<div class="form-group">
				<label>Nome do Usu�rio</label> <input type="text"
					class="form-control" id="txtNomeUsuario" />
			</div>
			<div class="form-group">
				<label>Login</label> <input type="text"
					class="form-control" id="txtLogin" />
			</div>
				<button id="btnCadastrar" type="button"
					class="btn btn-default">Cadastrar</button>
				<button id="btnPesquisar" type="button"
					class="btn btn-primary">Pesquisar</button>
			
		</form>
	</div>
</div>

<table id="tblUsuario" class="grid">
	<!-- bootstrap classes added by the uitheme widget -->
	<thead>
		<!--  -->
		<tr>
			<th>Id do Usu�rio</th>
			<th>Login</th>
			<th>Nome do Usu�rio</th>
			<th>E-Mail</th>
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
<div id="divRetornoClientes" class="alert alert-warning divRetorno"
	role="alert">Nenhum Registro Encontrado.</div>
<%@ include file="/fundo.jsp"%>