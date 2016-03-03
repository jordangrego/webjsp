package br.com.webjsp.entidade;

public class UsuarioPerfil {
	private long idUsuarioPerfil;
	private long idUsuario;
	private long idPerfil;
	
	public long getIdUsuarioPerfil() {
		return idUsuarioPerfil;
	}
	public void setIdUsuarioPerfil(long idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	@Override
	public String toString() {
		return "UsuarioPerfil [idUsuarioPerfil=" + idUsuarioPerfil + ", idUsuario=" + idUsuario + ", idPerfil="
				+ idPerfil + "]";
	}
}
