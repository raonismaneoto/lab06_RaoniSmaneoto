package P2CG;

import java.util.HashSet;

public class Luta extends Jogo{

	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidades)
			throws Exception {
		super(nome, preco, jogabilidades);
	}
	public Luta(String nome, double preco, Jogabilidade jogabilidade)
			throws Exception {
		super(nome, preco, jogabilidade);
	}
	@Override
	public int registraJogada(int score, boolean zerou){
		int x2p = super.registraJogada(score, zerou);
		int marcador = 0;
		if(score  > maiorScore){
			maiorScore = score;
			marcador = 1;
		}
		if (marcador == 1){
			double lutax2p = maiorScore/1000;
			x2p = (int) lutax2p;
		}
		return x2p;
	}
}
