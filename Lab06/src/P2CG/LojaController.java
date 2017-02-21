package P2CG;



import java.util.ArrayList;


public class LojaController {
	private ArrayList<Usuario> usuarios;
	private FactoryDeUsuario fabrica;
	
	
	public LojaController(){
		this.usuarios = new ArrayList<Usuario>();
	}
	
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
	
	public void criaUsuario(String nome, String login, String tipo){
		try {
			fabrica.criaUsuario(nome, login, tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	public void vendeJogo(String login, String nome, double preco, Jogabilidade jogabilidade, Tipo tipo){
		try {
			Jogo jogo = new Jogo(nome, preco, jogabilidade, tipo);
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
	}
	

