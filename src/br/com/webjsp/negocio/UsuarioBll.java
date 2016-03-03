package br.com.webjsp.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.webjsp.dao.UsuarioDao;
import br.com.webjsp.entidade.Usuario;
import br.com.webjsp.exceptions.WebJspException;

public class UsuarioBll {
	
	private final String USUARIO_INEXISTENTE = "Usuário não existe";
	private final String SENHA_ERRADA = "Senha não confere";
	private final String USUARIO_INATIVO = "Usuário inativo";
	
	private UsuarioDao usuarioDao = null;

	public UsuarioBll() {
		this.usuarioDao = new UsuarioDao();
	}
	
	public Usuario executaLogin(String login, String senha) throws WebJspException {
		Usuario usuario = null;
		try {
			usuario = this.usuarioDao.recuperarLogin(login);
			
			if (usuario == null) {
				throw new WebJspException(USUARIO_INEXISTENTE);
			}
			
			if (!isSenhaCorreta(usuario, senha)) {
				throw new WebJspException(SENHA_ERRADA);
			}
			
			if (!usuario.isAtivo()) {
				throw new WebJspException(USUARIO_INATIVO);
			}
			
		} catch (SQLException e) {
			throw new WebJspException(e.getMessage());
		}
		
		return usuario;
	}
	
	public List<Usuario> pesquisar(Usuario usuarioCriterio) throws WebJspException {
		try {
			return this.usuarioDao.pesquisar(usuarioCriterio);
		} catch (SQLException e) {
			throw new WebJspException(e.getMessage());
		}
	}
	
	private boolean isSenhaCorreta(Usuario usuario, String senha) {
		
		boolean senhaCorreta = false;
		
		if (usuario.getSenha().toLowerCase().equals(senha.toLowerCase())) {
			senhaCorreta = true;
		}
		
		return senhaCorreta;
	}
	
	public Usuario recuperar(int idUsuario) throws WebJspException {
		try {
			return this.usuarioDao.recuperarPorId(idUsuario);
		} catch (SQLException e) {
			throw new WebJspException(e.getMessage());
		}
	}
	
	public Usuario inserir(Usuario usuario){
		return usuario;		
	}
	
}
