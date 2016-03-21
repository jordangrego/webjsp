package br.com.webjsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.webjsp.entidade.Cliente;

public class ClienteDao extends AbstractDao {

	public ClienteDao() {
		super.configuraConexao();
	}

	/**
	 * Insere novo registro.
	 * 
	 * @param lote
	 * @throws SQLException
	 */
	public void inserir(Cliente cliente) throws SQLException {
		Date data = new Date();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");

		this.comandoSQL = conexao.prepareStatement(
				"INSERT INTO public.cliente(id_cliente, id_usuario, razao_social, email_cliente, cnpj, data_hora, qtd_caixa_padrao, existe_caixa_triplex, perc_aprovacao, tamanho_numero_caixa, logo, fundo_espelho, id_tipo_codigo_barra, prazo_entrega, meta_paginas_dia, paginas_total_contrato) VALUES (NEXTVAL('cliente_id_cliente_seq'), 1,'"
						+ cliente.getRazaoSocial() + "', '" + cliente.getEmailCliente() + "', '" + cliente.getCnpj()
						+ "', '" + dataFormatada.format(data) + "', " + cliente.getQtdCaixaPadrao() + ", " + cliente.isExisteCaixaTriplex()
						+ ", " + cliente.getPercAprovacao() + ", " + cliente.getTamanhoNumeroCaixa() + ", "
						+ cliente.getLogo() + ", " + cliente.getFundoEspelho() + ", "
						+ cliente.getIdTipoCodigoBarra() + " , " + cliente.getPrazo_entrega() + " , "
						+ cliente.getMetaPaginasDia() + ", " + cliente.getPaginas_total_contrato() + " );");
		comandoSQL.execute();

		/*
		 * this.comandoSQL = conexao.prepareStatement(
		 * "SELECT id_tipo_dado, descricao_tipo FROM public.tipo_dado order by id_tipo_dado desc limit 1"
		 * ); ResultSet resultadoSql = comandoSQL.executeQuery();
		 * 
		 * while (resultadoSql.next()) {
		 * lote.setIdTipoDado(Integer.parseInt(resultadoSql.getString(1)));
		 * lote.setDescricaoTipoDado(resultadoSql.getString(2).toString()); }
		 */
	}

	/**
	 * Altera o Registro.
	 * 
	 * @param lote
	 * @throws SQLException
	 */
	public void alterar(Cliente cliente) throws SQLException {
		/*
		 * this.comandoSQL = conexao.prepareStatement(
		 * "UPDATE public.tipo_dado set descricao_tipo = '" +
		 * lote.getDescricaoTipoDado() + "' where id_tipo_dado = " +
		 * lote.getIdTipoDado()); comandoSQL.execute();
		 */
	}

	/**
	 * Deleta registro com o Id passado.
	 * 
	 * @param idCliente
	 * @throws SQLException
	 */
	public void deletar(int idCliente) throws SQLException {
		this.comandoSQL = conexao.prepareStatement("DELETE FROM public.cliente where id_cliente = " + idCliente);
		comandoSQL.execute();
	}

	/**
	 * Recupera um �nico TipoDado pelo Id.
	 * 
	 * @param idLote
	 * @return
	 * @throws SQLException
	 */
	public Cliente recuperar(int idCliente) throws SQLException {
		Cliente clienteRetorno = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_cliente, id_usuario, razao_social, email_cliente, cnpj, data_hora, ");
		sql.append(" qtd_caixa_padrao, existe_caixa_triplex, perc_aprovacao, tamanho_numero_caixa,  ");
		sql.append(" logo, fundo_espelho, id_tipo_codigo_barra, prazo_entrega, meta_paginas_dia, ");
		sql.append(" paginas_total_contrato");
		sql.append(" FROM public.cliente");
		sql.append(" where ");
		sql.append(" id_cliente = " + idCliente);

		this.comandoSQL = conexao.prepareStatement(sql.toString());
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			clienteRetorno = new Cliente();
			clienteRetorno.setIdCliente(resultadoSql.getInt("id_cliente"));
			clienteRetorno.setIdUsuario(resultadoSql.getInt("id_usuario"));
			clienteRetorno.setRazaoSocial(resultadoSql.getString("razao_social"));
			clienteRetorno.setCnpj(resultadoSql.getString("cnpj"));
			clienteRetorno.setEmailCliente(resultadoSql.getString("email_cliente"));
			clienteRetorno.setDataHora(resultadoSql.getDate("data_hora"));
			clienteRetorno.setQtdCaixaPadrao(resultadoSql.getInt("qtd_caixa_padrao"));
			clienteRetorno.setExisteCaixaTriplex(resultadoSql.getBoolean("existe_caixa_triplex"));
			clienteRetorno.setPercAprovacao(resultadoSql.getInt("perc_aprovacao"));
		}

		return clienteRetorno;
	}

	/**
	 * Pesquisa TipoDado usando o parametro tipoDadoCriterio como crit�rio de
	 * consulta.
	 * 
	 * @param clienteCriterio
	 * @return
	 * @throws SQLException
	 */
	public List<Cliente> pesquisar(Cliente clienteCriterio) throws SQLException {
		List<Cliente> listaRetorno = new ArrayList<Cliente>();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_cliente, id_usuario, razao_social, email_cliente, cnpj, data_hora, ");
		sql.append(" qtd_caixa_padrao, existe_caixa_triplex, perc_aprovacao, tamanho_numero_caixa,  ");
		sql.append(" logo, fundo_espelho, id_tipo_codigo_barra, prazo_entrega, meta_paginas_dia, ");
		sql.append(" paginas_total_contrato ");
		sql.append(" FROM public.cliente ");
		sql.append(" where ");

		/*
		 * if (clienteCriterio.getIdLote() > 0) { sql.append(" id_lote = " +
		 * clienteCriterio.getIdLote() + " AND "); }
		 * 
		 * if (clienteCriterio.getIdCliente() > 0) { sql.append(" id_cliente = "
		 * + clienteCriterio.getIdCliente() + " AND "); }
		 * 
		 * if (clienteCriterio.getIdUsuario() > 0) { sql.append(" id_usuario = "
		 * + clienteCriterio.getIdUsuario() + " AND "); }
		 * 
		 * if (clienteCriterio.getNumeroLote() > 0) { sql.append(
		 * " numero_lote = " + clienteCriterio.getNumeroLote() + " AND "); }
		 * 
		 * if (clienteCriterio.getQtdCaixa() > 0) { sql.append(" qtd_caixa = " +
		 * clienteCriterio.getQtdCaixa() + " AND "); }
		 * 
		 * if (clienteCriterio.getObservacao() != null &&
		 * !clienteCriterio.getObservacao().equals("")) { sql.append(
		 * " observacao like '%" + clienteCriterio.getObservacao() + "%' AND ");
		 * }
		 * 
		 * 
		 */

		if (clienteCriterio.getRazaoSocial() != null && !clienteCriterio.getRazaoSocial().equals("")) {
			sql.append(" lower(razao_social) like lower('%" + clienteCriterio.getRazaoSocial() + "%') AND ");
		}

		sql.append(" 1 = 1 ");

		this.comandoSQL = conexao.prepareStatement(sql.toString());
		ResultSet resultadoSql = comandoSQL.executeQuery();

		while (resultadoSql.next()) {
			Cliente clienteRetorno = new Cliente();
			clienteRetorno.setIdCliente(resultadoSql.getInt("id_cliente"));
			clienteRetorno.setIdUsuario(resultadoSql.getInt("id_usuario"));
			clienteRetorno.setRazaoSocial(resultadoSql.getString("razao_social"));
			clienteRetorno.setCnpj(resultadoSql.getString("cnpj"));
			clienteRetorno.setEmailCliente(resultadoSql.getString("email_cliente"));
			clienteRetorno.setDataHora(resultadoSql.getDate("data_hora"));
			clienteRetorno.setQtdCaixaPadrao(resultadoSql.getInt("qtd_caixa_padrao"));
			clienteRetorno.setExisteCaixaTriplex(resultadoSql.getBoolean("existe_caixa_triplex"));
			clienteRetorno.setPercAprovacao(resultadoSql.getInt("perc_aprovacao"));
			listaRetorno.add(clienteRetorno);
		}

		return listaRetorno;
	}
	
	public void gravaLogo(byte[] imagem, long idCliente) {
		try {
			PreparedStatement ps = conexao.prepareStatement("update public.cliente set logo=? where id_cliente = ?");
			ps.setBytes(1, imagem);
			ps.setLong(2, idCliente);
			this.comandoSQL = ps;
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public byte[] recuperaLogo(long idCliente) {
		try {
			PreparedStatement ps = conexao.prepareStatement("select logo from public.cliente where id_cliente = ?");
			ps.setLong(1, idCliente);
			this.comandoSQL = ps;
			
			ResultSet resultadoSql = comandoSQL.executeQuery();

			while (resultadoSql.next()) {
				byte[] logo = resultadoSql.getBytes("logo");
				return logo;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
