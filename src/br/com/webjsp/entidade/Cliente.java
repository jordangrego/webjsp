package br.com.webjsp.entidade;

import java.util.Arrays;
import java.util.Date;

public class Cliente {
	private int idCliente;
	private int idUsuario;
	private String razaoSocial;
	private String emailCliente;
	private String cnpj;
	private Date dataHora;
	private int qtdCaixaPadrao;
	private boolean existeCaixaTriplex;
	private int percAprovacao;
	private int tamanhoNumeroCaixa;
	private byte[] logo;
	private byte[] fundoEspelho;
	private int idTipoCodigoBarra;
	private int prazo_entrega;
	private int metaPaginasDia;
	private int paginas_total_contrato;
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getEmailCliente() {
		return emailCliente;
	}
	
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Date getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	public int getQtdCaixaPadrao() {
		return qtdCaixaPadrao;
	}
	
	public void setQtdCaixaPadrao(int qtdCaixaPadrao) {
		this.qtdCaixaPadrao = qtdCaixaPadrao;
	}
	
	public boolean isExisteCaixaTriplex() {
		return existeCaixaTriplex;
	}
	
	public void setExisteCaixaTriplex(boolean existeCaixaTriplex) {
		this.existeCaixaTriplex = existeCaixaTriplex;
	}
	
	public int getPercAprovacao() {
		return percAprovacao;
	}
	
	public void setPercAprovacao(int percAprovacao) {
		this.percAprovacao = percAprovacao;
	}
	
	public int getTamanhoNumeroCaixa() {
		return tamanhoNumeroCaixa;
	}
	
	public void setTamanhoNumeroCaixa(int tamanhoNumeroCaixa) {
		this.tamanhoNumeroCaixa = tamanhoNumeroCaixa;
	}
	
	public byte[] getLogo() {
		return logo;
	}
	
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	public byte[] getFundoEspelho() {
		return fundoEspelho;
	}
	
	public void setFundoEspelho(byte[] fundoEspelho) {
		this.fundoEspelho = fundoEspelho;
	}
	
	public int getIdTipoCodigoBarra() {
		return idTipoCodigoBarra;
	}
	
	public void setIdTipoCodigoBarra(int idTipoCodigoBarra) {
		this.idTipoCodigoBarra = idTipoCodigoBarra;
	}
	
	public int getPrazo_entrega() {
		return prazo_entrega;
	}
	
	public void setPrazo_entrega(int prazo_entrega) {
		this.prazo_entrega = prazo_entrega;
	}
	
	public int getMetaPaginasDia() {
		return metaPaginasDia;
	}

	public void setMetaPaginasDia(int metaPaginasDia) {
		this.metaPaginasDia = metaPaginasDia;
	}
	
	public int getPaginas_total_contrato() {
		return paginas_total_contrato;
	}	

	public void setPaginas_total_contrato(int paginas_total_contrato) {
		this.paginas_total_contrato = paginas_total_contrato;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", idUsuario=" + idUsuario + ", razaoSocial=" + razaoSocial
				+ ", emailCliente=" + emailCliente + ", cnpj=" + cnpj + ", dataHora=" + dataHora + ", qtdCaixaPadrao="
				+ qtdCaixaPadrao + ", existeCaixaTriplex=" + existeCaixaTriplex + ", percAprovacao=" + percAprovacao
				+ ", tamanhoNumeroCaixa=" + tamanhoNumeroCaixa + ", logo=" + Arrays.toString(logo) + ", fundoEspelho="
				+ Arrays.toString(fundoEspelho) + ", idTipoCodigoBarra=" + idTipoCodigoBarra + ", prazo_entrega="
				+ prazo_entrega + ", metaPaginasDia=" + metaPaginasDia + ", paginas_total_contrato="
				+ paginas_total_contrato + "]";
	}
	
	/*@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", idUsuario=" + idUsuario + ", razaoSocial=" + razaoSocial
				+ ", emailCliente=" + emailCliente + ", cnpj=" + cnpj + ", dataHora=" + dataHora + ", qtdCaixaPadrao="
				+ qtdCaixaPadrao + ", existeCaixaTriplex=" + existeCaixaTriplex + ", percAprovacao=" + percAprovacao
				+ ", tamanhoNumeroCaixa=" + tamanhoNumeroCaixa + ", logo=" + Arrays.toString(logo) + ", fundoEspelho="
				+ Arrays.toString(fundoEspelho) + ", idTipoCodigoBarra=" + idTipoCodigoBarra + ", prazo_entrega="
				+ prazo_entrega + ", paginas_total_contrato=" + paginas_total_contrato + ", getIdCliente()="
				+ getIdCliente() + ", getIdUsuario()=" + getIdUsuario() + ", getRazaoSocial()=" + getRazaoSocial()
				+ ", getEmailCliente()=" + getEmailCliente() + ", getCnpj()=" + getCnpj() + ", getDataHora()="
				+ getDataHora() + ", getQtdCaixaPadrao()=" + getQtdCaixaPadrao() + ", isExisteCaixaTriplex()="
				+ isExisteCaixaTriplex() + ", getPercAprovacao()=" + getPercAprovacao() + ", getTamanhoNumeroCaixa()="
				+ getTamanhoNumeroCaixa() + ", getLogo()=" + Arrays.toString(getLogo()) + ", getFundoEspelho()="
				+ Arrays.toString(getFundoEspelho()) + ", getIdTipoCodigoBarra()=" + getIdTipoCodigoBarra()
				+ ", getPrazo_entrega()=" + getPrazo_entrega() + ", getPaginas_total_contrato()="
				+ getPaginas_total_contrato() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}*/

	

}
