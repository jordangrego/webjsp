package br.com.webjsp.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesquisarClienteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8987603985671092775L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuilder retorno = new StringBuilder();

		PrintWriter out = response.getWriter();

		if (request.getParameter("uf").equals("DF")) {
			retorno.append("[{");
			retorno.append("\"nome\":");
			retorno.append("\"" + "Brasilia" + "\",");
			retorno.append("\"id\":");
			retorno.append("\"" + "1" + "\"");
			retorno.append("},{");
			retorno.append("\"nome\":");
			retorno.append("\"" + "Taguatinga" + "\",");
			retorno.append("\"id\":");
			retorno.append("\"" + "2" + "\"");
			retorno.append("}]");
		} 

		out.println(retorno.toString());
		System.out.println(retorno.toString());
	}
}
