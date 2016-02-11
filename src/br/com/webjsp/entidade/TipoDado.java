package br.com.webjsp.entidade;

public class TipoDado {
	
	private int idTipoDado;
	private String descricaoTipoDado;
	
	public int getIdTipoDado() {
		return idTipoDado;
	}
	public void setIdTipoDado(int idTipoDado) {
		this.idTipoDado = idTipoDado;
	}
	public String getDescricaoTipoDado() {
		return descricaoTipoDado;
	}
	public void setDescricaoTipoDado(String descricaoTipoDado) {
		this.descricaoTipoDado = descricaoTipoDado;
	}
	
	@Override
	public String toString() {
		return "TipoDado [idTipoDado=" + idTipoDado + ", descricaoTipoDado=" + descricaoTipoDado + "]";
	}
	
}
