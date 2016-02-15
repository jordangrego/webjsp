<%@ page import="br.com.webjsp.entidade.Usuario"%>
<%

//Verifica se o usuário não está logado e se o mesmo está acessando uma tela que não seja a de login.
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