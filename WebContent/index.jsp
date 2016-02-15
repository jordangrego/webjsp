<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="topo.jsp"%>
<%@ page import="br.com.webjsp.entidade.Usuario, 
				br.com.webjsp.negocio.UsuarioBll, 
				br.com.webjsp.exceptions.WebJspException" %>

<%

	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
	
	String txtUsuario = "";
	String erro = "";
	
	if (login != null && senha !=null) {
		txtUsuario = login;
		try{
			Usuario usuario = new UsuarioBll().executaLogin(login, senha);
			session.setAttribute( "usuario", usuario);
			response.sendRedirect("/webjsp/main.jsp");
		   }
		   catch (WebJspException e){
			   erro = e.getMessage();
		   }
	}


%>



<script type="text/javascript" src="scripts/index.js"></script>


<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

	<div class="col-lg-4 col-md-4 col-sm-1 col-xs-1"></div>
	<div class="col-lg-4 col-md-4 col-sm-1 col-xs-1">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Login</h3>
			</div>
			<div class="panel-body">

				<form method="POST" action="index.jsp" class="form-horizontal">

					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 nopadding"></div>
						<div class="col-lg-10 col-md-10 col-sm-1 col-xs-1">

							<div class="form-group row">
								<label>Usuário</label> <input type="text" class="form-control"
									id="txtUsuario" name="login" value="<%=txtUsuario %>" />
							</div>
							<div class="form-group row">
								<label>Senha</label> <input type="password" class="form-control"
									id="txtSenha" name="senha" />
							</div>
							<button id="btnLogar" type="submit"
								class="btn btn-primary pull-right">Logar</button>

						</div>
						<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 nopadding"></div>
					</div>
				</form>

			</div>
		</div>
		<%
			if (!erro.equals("")) {
				String divErro = "<div class='alert alert-warning' role='alert'>" + erro + ".</div>";
				out.println(divErro);
			}
		%>

	</div>
	<div class="col-lg-4 col-md-4 col-sm-1 col-xs-1"></div>
</div>




<%@ include file="fundo.jsp"%>