package br.com.webjsp.servlets.ajax;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.webjsp.entidade.Classificacao;
import br.com.webjsp.negocio.ClassificacaoBll;

public class ManterClassificacaoServlet extends HttpServlet {

	private static final long serialVersionUID = 398357440861424946L;

	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			Classificacao classificacaoCriterio = new Classificacao();

			if (request.getParameter("id_cliente") != null && request.getParameter("id_cliente") != "") {
				int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
				classificacaoCriterio.setIdCliente(idCliente);
			}
			if (request.getParameter("codigo") != null && request.getParameter("codigo") != "") {
				int codigo = Integer.parseInt(request.getParameter("codigo"));
				classificacaoCriterio.setCodigo(codigo);
			}
			if (request.getParameter("descricao_classificacao") != null
					&& request.getParameter("descricao_classificacao") != "") {
				classificacaoCriterio.setDescricaoClassificacao("descricao_classificacao");
			}

			List<Classificacao> listaClassificacao = new ClassificacaoBll().pesquisar(classificacaoCriterio, true);

			StringBuilder retorno = new StringBuilder();
			retorno.append("[");

			int count = 0;
			for (Classificacao classificacao : listaClassificacao) {
				count++;

				retorno.append("{");

				retorno.append("\"idClassificacao\":");
				retorno.append("\"" + classificacao.getIdClassificacao() + "\",");

				retorno.append("\"cliente\":");
				retorno.append("\"" + classificacao.getCliente().getRazaoSocial()+ "\",");

				retorno.append("\"codigo\":");
				retorno.append("\"" + classificacao.getCodigo() + "\",");

				retorno.append("\"descricao\":");
				retorno.append("\"" + classificacao.getDescricaoClassificacao() + "\",");

				retorno.append("\"prazo\":");
				retorno.append("\"" + classificacao.getPrazoGuarda() + "\"");

				retorno.append("}");

				if (count != listaClassificacao.size()) {
					retorno.append(",");
				}
			}

			retorno.append("]");

			PrintWriter out = response.getWriter();
			out.println(retorno.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
