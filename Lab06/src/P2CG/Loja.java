package P2CG;



import java.util.ArrayList;


public class Loja {
	private ArrayList<Usuario> usuarios;
	
	
	public Loja(){
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
	public void adicionaDinheiro(String login, double quantia)throws Exception{
		Usuario	usuario = procuraUsuario(login);
		if(usuario == null){
			throw new Exception("Esse login de usuário não existe.");
		}
		usuario.adicionaDinheiro(quantia);
		
	}
	public void vendeJogo(String login, String nome, double preco, Jogabilidade jogabilidade, Tipo tipo){
		try {
			Jogo jogo = new Jogo(nome, preco, jogabilidade, tipo);
			Usuario usuario = procuraUsuario(login);
			usuario.compraJogo(jogo);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
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
	

