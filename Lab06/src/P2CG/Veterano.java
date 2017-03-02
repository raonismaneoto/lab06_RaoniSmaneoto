package P2CG;

import Exceptions.NumeroNegativoException;

public class Veterano implements Status{
	private double desconto;
	
	
	public Veterano() throws Exception{
		this.desconto = 0.2;
	}
	
	public double getDesconto(){
		return this.desconto;
	}
	@Override
	public int recompensar(Jogo jogo, int score, boolean zerou){
		int x2p = 0;
		x2p += jogo.registraJogada(score, zerou);
		 for(Jogabilidade jogabilidade: jogo.getJogabilidade()){
			 if(jogabilidade.equals(jogabilidade.Online)){
				 x2p += 10;
			 }
			 else if(jogabilidade.equals(jogabilidade.Cooperativo)){
				 x2p += 20;
			 }
		 }
		 return x2p;
	 }
	
	@Override
	 public int punir(Jogo jogo, int score, boolean zerou){
		 int x2p = 0;
		 x2p += jogo.registraJogada(score, zerou);
		 for(Jogabilidade jogabilidade: jogo.getJogabilidade()){
			 if(jogabilidade.equals(jogabilidade.Offline)){
				 x2p -= 20;
			 }
			 else if(jogabilidade.equals(jogabilidade.Competitivo)){
				 x2p -= 20;
			 }
		 }
		 return x2p;
	 }

	
	 @Override
	 public String toString(){
		 return "Veterano";
	 }

	
}
