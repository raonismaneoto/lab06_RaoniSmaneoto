package P2CG;



import java.util.ArrayList;
import java.util.HashSet;


public class LojaController {
	private ArrayList<Usuario> usuarios;
	private FactoryDeUsuario fabricaU;
	private FactoryDeJogo fabricaJ;
	
	
	public LojaController(){
		this.usuarios = new ArrayList<Usuario>();
	}
	
	/**
	 * Adiciona um usuário na lista de usuários.
	 * @param usuario
	 * @throws Exception
	 */
	public void adicionaUsuario(Usuario usuario)throws Exception{
		if(usuario == null){
			throw new Exception("O usuario é nulo");
		}
		usuarios.add(usuario);
	}
	public Usuario procuraUsuario(String login){
		for(Usuario usuario: usuarios){
			if(usuario.getLogin().equals(login)){
				return usuario;
			}
		}
		return null;
	}
	/**
	 * Cria um usuário por meio da composição com fábrica de usuário.
	 * @param nome
	 * @param login
	 * @param tipo
	 */
	
	public void criaUsuario(String nome, String login, String tipo){
		try {
			fabricaU.criaUsuario(nome, login, tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Cria um jogo por meio da composição com fábrica de jogo.
	 * @param nome
	 * @param preco
	 * @param jogabilidade
	 * @param tipo
	 * @return
	 */
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade, String tipo){
		try {
			Jogo jogo = fabricaJ.criaJogo(nome, preco, jogabilidade, tipo); //Chamada polimórfica.
			return jogo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Procura o usuáro através do login e delega a ação de adicionar dinheiro para o método de usuário.
	 * @param login
	 * @param quantia
	 * @throws Exception
	 */
	public void adicionaDinheiro(String login, double quantia)throws Exception{
		Usuario	usuario = procuraUsuario(login);
		if(usuario == null){
			throw new Exception("Esse login de usuário não existe.");
		}
		try {
			usuario.adicionaDinheiro(quantia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Cria um jogo e chama o método de comprar jogo de usuário com o jogo criado como parâmetro.
	 * @param login
	 * @param nome
	 * @param preco
	 * @param jogabilidade
	 * @param tipo
	 */
	public void vendeJogo(String login, String nome, double preco, HashSet<Jogabilidade> jogabilidade, String tipo){
		try {
			Jogo jogo = criaJogo(nome, preco, jogabilidade, tipo);
			Usuario usuario = procuraUsuario(login);
			usuario.compraJogo(jogo);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	/**
	 * Responsável por promover a classificação do usuário para veterano, caso tenha x2p >= 1000, por meio da delegação para o método em usuário.
	 * @param login
	 * @throws Exception
	 */
	public void upgrade(String login)throws Exception{
		Usuario usuario = procuraUsuario(login);
		if(usuario == null){
			throw new Exception("Esse login de usuário não existe");
		}
		try {
			usuario.upStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Responsável por rebaixar o usuário de classificação caso ele alcance os requisitos necessários.
	 * @param login
	 * @throws Exception
	 */
	public void downgrade(String login)throws Exception{
		Usuario usuario = procuraUsuario(login);
		if(usuario == null){
			throw new Exception("Esse login de usuário não existe");
		}
		try {
			usuario.downStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * toString adaptado de acordo com a especificação.
	 */
	@Override
	public String toString(){
		String msg = "== Central P2-CG === \n\n";
		for(Usuario usuario: usuarios){
			msg += usuario.toString() + "\n\n";
			
		}
		msg += "--------------------------------------------";
		return msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LojaController other = (LojaController) obj;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}
	}
	

