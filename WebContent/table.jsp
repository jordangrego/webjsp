<%@ include file="topo.jsp"%>
<script type="text/javascript" src="scripts/table.js"></script>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">TESTE</h3>
	</div>
	<div class="panel-body">
		<form class="form-inline">
			<div class="form-group">
				<label>teste</label> <input type="text" id="txtTeste" class="form-control obrigatorio" />
			</div>
			
			
		</form>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Pesquisa Lote</h3>
	</div>
	<div class="panel-body">
		<form class="form-inline">
			<div class="form-group">
				<label>Número do Lote</label> <input type="text" class="form-control numero"
					id="txtNumeroLote" />
			</div>
			<button id="btnPesquisar" type="button" class="btn btn-primary pull-right">Pesquisar</button>
		</form>
	</div>
</div>

<table id="tblLotes" class="grid">
	<!-- bootstrap classes added by the uitheme widget -->
	<thead>
	<!--  -->
		<tr>
			<th>Id do Lote</th>
			<th>Número do lote</th>
			<th>Quantidade de Caixas</th>
			<th>Data de Recebimento</th>
			<th>Observação</th>
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
<div id="divRetornoLotes" class="alert alert-warning divRetorno" role="alert">Nenhum Registro Encontrado.</div>
<%@ include file="fundo.jsp"%>