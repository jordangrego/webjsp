package br.com.webjsp.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.webjsp.entidade.Lote;
import br.com.webjsp.negocio.LoteBll;

public class PesquisarLotesServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8987603985671092775L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Lote loteCriterio = new Lote();
			
			if (request.getParameter("numero_lote") != null && !request.getParameter("numero_lote").equals("")) {
				loteCriterio.setNumeroLote(Integer.parseInt(request.getParameter("numero_lote")));
			}
			
			List<Lote> listaLote = new LoteBll().pesquisar(loteCriterio);
			
			
			StringBuilder retorno = new StringBuilder();
			retorno.append("[");

			int count = 0;
			for(Lote lote : listaLote) {
				count++;
				retorno.append("{");
				
				retorno.append("\"idLote\":");
				retorno.append("\"" + lote.getIdLote() + "\",");
				
				retorno.append("\"idCliente\":");
				retorno.append("\"" + lote.getIdCliente() + "\",");
				
				retorno.append("\"idUsuario\":");
				retorno.append("\"" + lote.getIdUsuario() + "\",");
				
				retorno.append("\"numerolote\":");
				retorno.append("\"" + lote.getNumeroLote() + "\",");
				
				retorno.append("\"qtdCaixas\":");
				retorno.append("\"" + lote.getQtdCaixa() + "\",");
				
				retorno.append("\"observacao\":");
				retorno.append("\"" + (lote.getObservacao() != null ? lote.getObservacao().replace("\n", "").replace("\r", "") : "") + "\",");
				
				retorno.append("\"dataRecebimento\":");
				retorno.append("\"" + lote.getDataRecebimento() + "\"");
				
				retorno.append("}");
				
				if (count != listaLote.size()) {
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