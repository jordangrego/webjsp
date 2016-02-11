<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="topo.jsp"%>
<script type="text/javascript" src="scripts/index.js"></script>

<div class="alert alert-success" role="alert">boot</div>

<div class="well">
	<div class="form-group">
		<div class="form-element row">
			<label>Estado</label> <select class="form-control" id="ddlEstado">
				<option value="DF">DF</option>
				<option value="SP">SP</option>
			</select>
		</div>
		<div class="form-element row">
			<label>Cidade</label> <select class="form-control" id="ddlCidade">
			</select>
		</div>
	</div>
</div>

<%@ include file="fundo.jsp"%>