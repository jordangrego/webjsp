package br.com.webjsp;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.entidade.Lote;
import br.com.webjsp.negocio.LoteBll;

public class Principal {
	public static void main(String[] args) throws SQLException {
		
			Lote loteCriterio = new Lote();
		
			loteCriterio.setObservacao("a");
			
			
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
				retorno.append("\"" + lote.getObservacao().replace("\n", "").replace("\r", "") + "\",");
				
				retorno.append("\"dataRecebimento\":");
				retorno.append("\"" + lote.getDataRecebimento() + "\"");
				
				retorno.append("}");
				
				if (count != listaLote.size()) {
					retorno.append(",");			
				}		
			}
			
			
			retorno.append("]");
			
			System.out.println(retorno.toString());
	}
}
