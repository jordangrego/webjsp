package br.com.webjsp.entidade;

public class Perfil {
	private long idPerfil;
	private String descricaoPerfil;

	public long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", descricaoPerfil=" + descricaoPerfil + "]";
	}
	
}
