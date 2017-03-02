package P2CG;

import java.util.HashSet;

public class LojaFacade {
	private LojaController delegador;
	
	public LojaFacade(){
		this.delegador = new LojaController();
	}
	
	
	public void adicionaUsuario(Usuario usuario)throws Exception{
		delegador.adicionaUsuario(usuario);
	}
	public Usuario procuraUsuario(String login){
		return delegador.procuraUsuario(login);
	}
	public void criaUsuario(String nome, String login, String tipo){
		delegador.criaUsuario(nome, login, tipo);
	}
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade, String tipo){
		return delegador.criaJogo(nome, preco, jogabilidade, tipo);
	}
	
	public void adicionaDinheiro(String login, double quantia)throws Exception{
		delegador.adicionaDinheiro(login, quantia);
	}
	public void vendeJogo(String login, String nome, double preco, HashSet<Jogabilidade> jogabilidade, String tipo){
		delegador.vendeJogo(login, nome, preco, jogabilidade, tipo);
	}
	
	public void upgrade(String login)throws Exception{
		delegador.upgrade(login);
	}
	
	public void downgrade(String login)throws Exception{
		delegador.downgrade(login);
	}
	
	
	
}
