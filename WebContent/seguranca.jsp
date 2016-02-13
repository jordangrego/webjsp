<%@ page import="br.com.webjsp.entidade.Usuario"%>
<%

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