package P2CG;

import java.util.HashSet;

public class FactoryDeJogo {
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade, String tipo) throws Exception{
		if(!tipo.equals("Plataforma") ||!tipo.equals("Luta") ||!tipo.equals("Rpg")){
			throw new Exception("Tipo inválido.");
		}
		if(tipo.equals("Rpg")){
			Rpg jogo = new Rpg(nome, preco, jogabilidade);
		}
		else if(tipo.equals("Luta")){
			Luta jogo = new Luta(nome, preco, jogabilidade);
		}
		Plataforma jogo = new Plataforma(nome, preco, jogabilidade);
	
		
		return jogo;
	}
}

	