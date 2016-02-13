package br.com.webjsp.entidade;

public class Usuario {
	private long idUsuario;
	private long idCliente;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private boolean usuarioAd;
	private String dominio;
	private boolean ativo;
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isUsuarioAd() {
		return usuarioAd;
	}
	public void setUsuarioAd(boolean usuarioAd) {
		this.usuarioAd = usuarioAd;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", idCliente=" + idCliente + ", nome=" + nome + ", login=" + login
				+ ", senha=" + senha + ", email=" + email + ", usuarioAd=" + usuarioAd + ", dominio=" + dominio
				+ ", ativo=" + ativo + "]";
	}
	
}
