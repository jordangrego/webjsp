package br.com.webjsp.servlets.ajax;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.webjsp.negocio.ClienteBll;

public class RetornaImagemServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1001958210519065493L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		long idCliente = Long.parseLong(request.getParameter("idCliente"));
		byte[] logo = new ClienteBll().recuperaLogo(idCliente);

		response.setContentType("image/png");
		OutputStream o = response.getOutputStream();
		o.write(logo);
		o.flush();
		o.close();
	}

}
