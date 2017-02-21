package P2CG;

public class FactoryDeUsuario {
	
	public Usuario criaUsuario(String nome, String login, String tipo) throws Exception{
		Usuario usuario = new Usuario(nome, login);
		return usuario;
	}

}
