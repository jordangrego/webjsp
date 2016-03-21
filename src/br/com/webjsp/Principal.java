package br.com.webjsp;

import java.util.Date;

import br.com.webjsp.entidade.Cliente;
import br.com.webjsp.negocio.ClienteBll;

public class Principal {

	public static void main(String[] args) throws Exception {
		Cliente cliente = new Cliente();
		ClienteBll negocio = new ClienteBll();
		
		Date date = new Date();
		
		cliente.setRazaoSocial("Luan");
		cliente.setEmailCliente("luan373@gmail.com");
		cliente.setCnpj("75.336.342/0001-86");
		cliente.setLogo(null);
		cliente.setFundoEspelho(null);
		cliente.setQtdCaixaPadrao(50);		
		cliente.setExisteCaixaTriplex(false);
		cliente.setPercAprovacao(85);
		cliente.setPrazo_entrega(20);
		cliente.setPaginas_total_contrato(50000);
		cliente.setMetaPaginasDia(20);
		cliente.setIdTipoCodigoBarra(1);
		cliente.setDataHora(date);
		try {
		negocio.inserir(cliente);
		} catch (Exception e ) {
			e.getMessage();
		}
	}
}