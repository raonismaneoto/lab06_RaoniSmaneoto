package P2CG;

import java.util.HashSet;


/**
 * Classe com a única função de criar jogos.
 * @author raonims
 *
 */

public class FactoryDeJogo {
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade, String tipo) throws Exception{
		if(!tipo.equals("Plataforma") ||!tipo.equals("Luta") ||!tipo.equals("Rpg")){
			throw new Exception("Tipo inválido.");
		}
		if(tipo.equals("Rpg")){
			return this.criaRpg(nome, preco, jogabilidade);
		}
		else if(tipo.equals("Luta")){
			return this.criaLuta(nome, preco, jogabilidade);
		}
		return this.criaPlataforma(nome, preco, jogabilidade);
	
		
		
	}

	private Jogo criaRpg(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) throws Exception {
		Rpg jogo = new Rpg(nome, preco, jogabilidade);
		return jogo;
	}
	private Jogo criaLuta(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) throws Exception {
			Luta jogo = new Luta(nome, preco, jogabilidade);
		return jogo;
	}
	private Jogo criaPlataforma(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) throws Exception {
		Plataforma jogo = new Plataforma(nome, preco, jogabilidade);
		return jogo;
	}
}

	