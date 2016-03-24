<%@ page import="br.com.webjsp.entidade.Usuario"%>
<script type="text/javascript" src="/webjsp/scripts/menu.js"></script>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/webjsp/index.jsp">JSP - Postgre</a>
		</div>

		<%
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
			if (usuarioLogado != null) {
		%>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="/webjsp/main.jsp">Home</a></li>
				<li><a href="/webjsp/table.jsp">Tabela</a></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Cadastros <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/webjsp/lote/lotePesquisa.jsp">Lotes</a></li>
						<li><a href="/webjsp/cliente/clientePesquisa.jsp">Clientes</a></li>
						<li><a href="/webjsp/usuario/usuarioPesquisa.jsp">Usuários</a></li>
						<li><a href="/webjsp/classificacao/classificacaoPesquisa.jsp">Classificacao</a></li>
						<!-- 
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
						 -->
					</ul>
					
					</li>

			</ul>
			<form id="formLogOff" action="/webjsp/logoff.jsp" method="post" />
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="#"><span
						class="glyphicon glyphicon-user"></span> <%=usuarioLogado.getLogin().toUpperCase()%></a></li>
				<li><a href="#"><span id="spanLogOff"
						class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></li>
			</ul>
			</form>
		</div>




		<%
			} else {
		%>

		<%
			}
		%>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>