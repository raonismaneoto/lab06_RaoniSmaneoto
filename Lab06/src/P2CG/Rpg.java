package P2CG;

import java.util.HashSet;

public class Rpg extends Jogo{

	public Rpg(String nome, double preco, HashSet<Jogabilidade> jogabilidades)
			throws Exception {
		super(nome, preco, jogabilidades);
	}
	
	public Rpg(String nome, double preco, Jogabilidade jogabilidade)
			throws Exception {
		super(nome, preco, jogabilidade);
	}
	
	@Override
	public int registraJogada(int score, boolean zerou){
		int x2p = super.registraJogada(score, zerou);
		if(score  > maiorScore){
			maiorScore = score;
		}
		x2p += 10;
		return x2p;
	}
	
}
