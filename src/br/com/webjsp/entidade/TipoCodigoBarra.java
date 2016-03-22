package br.com.webjsp.entidade;

public class TipoCodigoBarra {
	private long idTipoCodigoBarra;
	private String descricaoTipoCodigoBarra;

	public long getIdTipoCodigoBarra() {
		return idTipoCodigoBarra;
	}

	public void setIdTipoCodigoBarra(long idTipoCodigoBarra) {
		this.idTipoCodigoBarra = idTipoCodigoBarra;
	}

	public String getDescricaoTipoCodigoBarra() {
		return descricaoTipoCodigoBarra;
	}

	public void setDescricaoTipoCodigoBarra(String descricaoTipoCodigoBarra) {
		this.descricaoTipoCodigoBarra = descricaoTipoCodigoBarra;
	}

	@Override
	public String toString() {
		return "TipoCodigoBarra [idTipoCodigoBarra=" + idTipoCodigoBarra + ", descricaoTipoCodigoBarra="
				+ descricaoTipoCodigoBarra + "]";
	}

	
}
