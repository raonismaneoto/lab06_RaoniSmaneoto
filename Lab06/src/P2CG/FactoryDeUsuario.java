package P2CG;

/**
 * Classe com a única função de criar usuários.
 * @author raonims
 *
 */

public class FactoryDeUsuario {
	
	public Usuario criaUsuario(String nome, String login, String tipo) throws Exception{
		Usuario usuario = new Usuario(nome, login);
		return usuario;
	}

}
