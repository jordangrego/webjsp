package br.com.webjsp.entidade;

public class Classificacao {
	private long idClassificacao;
	private long idCliente;
	private int codigo;
	private String descricaoClassificacao;
	private int prazoGuarda;
	
	private Cliente cliente;

	public long getIdClassificacao() {
		return idClassificacao;
	}

	public void setIdClassificacao(long idClassificacao) {
		this.idClassificacao = idClassificacao;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoClassificacao() {
		return descricaoClassificacao;
	}

	public void setDescricaoClassificacao(String descricaoClassificacao) {
		this.descricaoClassificacao = descricaoClassificacao;
	}

	public int getPrazoGuarda() {
		return prazoGuarda;
	}

	public void setPrazoGuarda(int prazoGuarda) {
		this.prazoGuarda = prazoGuarda;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Classificacao [idClassificacao=" + idClassificacao + ", idCliente=" + idCliente + ", codigo=" + codigo
				+ ", descricaoClassificacao=" + descricaoClassificacao + ", prazoGuarda=" + prazoGuarda + "]";
	}

	

}
