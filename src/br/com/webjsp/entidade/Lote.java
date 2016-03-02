package br.com.webjsp.entidade;

import java.util.Date;

public class Lote {
	
	private int idLote;
	private int idCliente;
	private int idUsuario;
	private int numeroLote;
	private Date dataRecebimento;
	private int qtdCaixa;
	private String observacao;
	
	public int getIdLote() {
		return idLote;
	}
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
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
	public int getNumeroLote() {
		return numeroLote;
	}
	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}
	public Date getDataRecebimento() {
		return dataRecebimento;
	}
	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	public int getQtdCaixa() {
		return qtdCaixa;
	}
	public void setQtdCaixa(int qtdCaixa) {
		this.qtdCaixa = qtdCaixa;
	}
	public String getObservacao() {
		return observacao;
	}
	
	public String getObs() {
		if (this.observacao == null) {
			return "";
		}
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", idCliente=" + idCliente + ", idUsuario=" + idUsuario + ", numeroLote="
				+ numeroLote + ", dataRecebimento=" + dataRecebimento + ", qtdCaixa=" + qtdCaixa + ", observacao="
				+ observacao + "]";
	}
}
