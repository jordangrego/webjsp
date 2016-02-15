<%@ page import="br.com.webjsp.entidade.Usuario"%>
<%

//Verifica se o usu�rio n�o est� logado e se o mesmo est� acessando uma tela que n�o seja a de login.
String scheme = request.getScheme();
String serverName = request.getServerName();
int serverPort = request.getServerPort();
String urlServidor = scheme + "://" + serverName + ":" + serverPort;

String url = request.getRequestURL().toString();

String pathJsp = url.replace(urlServidor, "");

Usuario usuarioSeguranca = (Usuario) session.getAttribute("usuario");
if (usuarioSeguranca == null && (!pathJsp.equals("/webjsp/index.jsp") && !pathJsp.equals("/webjsp/"))) {
	response.sendRedirect("/webjsp/index.jsp");
}

%>