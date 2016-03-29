<%@page import="br.com.webjsp.negocio.ClassificacaoBll"%>
<%@page import="br.com.webjsp.entidade.Classificacao"%>
<%@ include file="/topo.jsp"%>
<script type="text/javascript"
	src="/webjsp/scripts/classificacao/classificacaoFormulario.js"></script>
<%@ page
	import="br.com.webjsp.entidade.Cliente, br.com.webjsp.negocio.ClienteBll, java.util.List"%>

<%
	List<Cliente> listaCliente = new ClienteBll().pesquisar(new Cliente());

	Classificacao classificacaoFormulario = null;

	if (request.getParameter("hdnIdClassificacao") != null) {
		Classificacao form = new Classificacao();
		ClassificacaoBll negocio = new ClassificacaoBll();

		int txtIdCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
		int txtCodigo = Integer.parseInt(request.getParameter("txtCodigo"));
		String txtDescricao = request.getParameter("txtDescricao");
		int txtPrazo = Integer.parseInt(request.getParameter("txtPrazo"));

		form.setIdCliente(txtIdCliente);
		form.setCodigo(txtCodigo);
		form.setDescricaoClassificacao(txtDescricao);
		form.setPrazoGuarda(txtPrazo);

		if (form.getIdClassificacao() == 0) {
			negocio.inserir(form);
		} else {

		}
	}

	if (request.getParameter("idClassificacao") != null) {
		classificacaoFormulario = new ClassificacaoBll()
				.recuperar(Integer.parseInt(request.getParameter("idClassificacao").toString()));
	} else {
		classificacaoFormulario = new Classificacao();
		classificacaoFormulario.setDescricaoClassificacao("");
	}
%>


<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Cadastrar Classificação</h3>
	</div>

	<div class="panel-body">
		<form class="form-horizontal" name="formClassificacao"
			id="formClassificacao" method="POST">
			<input type="hidden" id="hdnIdClassificacao" name="hdnIdClassificacao"
				value="<%=classificacaoFormulario.getIdClassificacao()%>" />
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"
					id="divRazaoSocial">
					<label>Cliente</label> <select class="form-control"
						id="txtIdCliente" name="txtIdCliente">
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
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divCodigo">
					<label>Código</label> <input type="text"
						class="form-control numero"
						value="<%=classificacaoFormulario.getCodigo()%>" id="txtCodigo"
						name="txtCodigo" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divDescricao">
					<label>Descrição</label> <input type="text" class="form-control"
						value="<%=classificacaoFormulario.getDescricaoClassificacao()%>"
						id="txtDescricao" name="txtDescricao" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="divPrazo">
					<label>Prazo de guarda</label> <input type="text"
						class="form-control numero"
						value="<%=classificacaoFormulario.getPrazoGuarda()%>"
						id="txtPrazo" name="txtPrazo" />
				</div>
			</div>
			<div class="btn-toolbar">
				<button id="btnSalvar" type="button"
					class="btn btn-primary pull-right">Salvar</button>
				<%
					if (request.getParameter("idClassificacao") != null) {
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