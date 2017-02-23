package P2CG;

import java.util.HashSet;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco,
			HashSet<Jogabilidade> jogabilidades) throws Exception {
		super(nome, preco, jogabilidades);
	}
	public Plataforma(String nome, double preco,
			Jogabilidade jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
	}
	@Override
	public int registraJogada(int score, boolean zerou){
		int x2p = super.registraJogada(score, zerou);
		if(score  > maiorScore){
			maiorScore = score;
		}
		if(zerou == true){
			x2p += 20;
		}
		return x2p;
	}
	
}
