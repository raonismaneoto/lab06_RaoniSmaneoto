package P2CG;

public class FactoryDeJogo {
	public Jogo criaJogo(String nome, double preco, Jogabilidade jogabilidade, String tipo) throws Exception{
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

	