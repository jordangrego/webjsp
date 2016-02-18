package br.com.webjsp.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.webjsp.entidade.Usuario;
import br.com.webjsp.negocio.UsuarioBll;

public class ManterUsuarioServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7931713148708365071L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Usuario usuarioCriterio = new Usuario();
			
			if (request.getParameter("nome_usuario") != null && !request.getParameter("nome_usuario").equals("")) {
				usuarioCriterio.setNome(request.getParameter("nome_usuario"));
			}
			
			if (request.getParameter("login") != null && !request.getParameter("login").equals("")) {
				usuarioCriterio.setLogin(request.getParameter("login"));
			}
			
			if (request.getParameter("email") != null && !request.getParameter("email").equals("")) {
				usuarioCriterio.setEmail(request.getParameter("email"));
			}
			
			List<Usuario> listaUsuario = new UsuarioBll().pesquisar(usuarioCriterio);
			
			
			StringBuilder retorno = new StringBuilder();
			retorno.append("[");

			int count = 0;
			for(Usuario usuario : listaUsuario) {
				count++;
				retorno.append("{");
				
				retorno.append("\"idUsuario\":");
				retorno.append("\"" + usuario.getIdUsuario() + "\",");
				
				retorno.append("\"nome\":");
				retorno.append("\"" + usuario.getNome() + "\",");
				
				retorno.append("\"login\":");
				retorno.append("\"" + usuario.getLogin() + "\",");
				
				retorno.append("\"email\":");
				retorno.append("\"" + (usuario.getEmail() != null ? usuario.getEmail() : "") + "\"");
				
				retorno.append("}");
				
				if (count != listaUsuario.size()) {
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
