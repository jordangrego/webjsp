package br.com.webjsp.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.webjsp.entidade.Cliente;
import br.com.webjsp.negocio.ClienteBll;

public class ManterClientesServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8987603985671092775L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Cliente clienteCriterio = new Cliente();
			
			if (request.getParameter("nome_cliente") != null && !request.getParameter("nome_cliente").equals("")) {
				clienteCriterio.setRazaoSocial(request.getParameter("nome_cliente"));
			}
			
			List<Cliente> listaClientes = new ClienteBll().pesquisar(clienteCriterio);
			
			
			StringBuilder retorno = new StringBuilder();
			retorno.append("[");

			int count = 0;
			for(Cliente cliente : listaClientes) {
				count++;
				retorno.append("{");
				
				retorno.append("\"idCliente\":");
				retorno.append("\"" + cliente.getIdCliente() + "\",");
				
				retorno.append("\"razaoSocial\":");
				retorno.append("\"" + cliente.getRazaoSocial() + "\",");
				
				retorno.append("\"email\":");
				retorno.append("\"" + (cliente.getEmailCliente() != null ? cliente.getEmailCliente() : "") + "\"");
				
				retorno.append("}");
				
				if (count != listaClientes.size()) {
					retorno.append(",");			
				}		
			}
			
			
			retorno.append("]");
			
			PrintWriter out = response.getWriter();
			out.println(retorno.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
