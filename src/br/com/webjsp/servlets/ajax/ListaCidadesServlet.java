package br.com.webjsp.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaCidadesServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7961707432046643380L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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
		} else {
			retorno.append("[");
			retorno.append("{");
			retorno.append("\"nome\":");
			retorno.append("\"" + "Sao Paulo" + "\",");
			retorno.append("\"id\":");
			retorno.append("\"" + "3" + "\"");
			retorno.append("},");
			retorno.append("{");
			retorno.append("\"nome\":");
			retorno.append("\"" + "Campinas" + "\",");
			retorno.append("\"id\":");
			retorno.append("\"" + "2" + "\"");
			retorno.append("}");
			retorno.append("]");
		}		
        
        out.println(retorno.toString());
        System.out.println(retorno.toString());
    }
}
