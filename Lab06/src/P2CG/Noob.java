package P2CG;

import java.util.HashSet;

import Exceptions.NumeroNegativoException;

public class Noob implements Status{
		private double desconto;
	
	public Noob() {
		this.desconto = 0.1;
		
		
	}
	
	 public double getDesconto(){
		 return this.desconto;
	 }
	 @Override
	 public int recompensar(Jogo jogo, int score, boolean zerou){
		 int x2p = 0;
		 x2p += jogo.registraJogada(score, zerou); //Chamada polimórfica.
		 for(Jogabilidade jogabilidade: jogo.getJogabilidade()){
			 if(jogabilidade.equals(jogabilidade.Offline)){
				 x2p += 30;
			 }
			 else if(jogabilidade.equals(jogabilidade.Multiplayer)){
				 x2p += 10;
			 }
		 }
		 return x2p;
	 }
	 @Override
	 public int punir(Jogo jogo, int score, boolean zerou){
		 int x2p = 0;
		 x2p += jogo.registraJogada(score, zerou); //Chamada polimórfica.
		 for(Jogabilidade jogabilidade: jogo.getJogabilidade()){
			 if(jogabilidade.equals(jogabilidade.Online)){
				 x2p -= 10;
			 }
			 else if(jogabilidade.equals(jogabilidade.Competitivo)){
				 x2p -= 20;
			 }
			 else if(jogabilidade.equals(jogabilidade.Cooperativo)){
				 x2p -= 50;
			 }
		 }
		 return x2p;
	 }
	 
	 
	 
	 @Override
	 public String toString(){
		 return "Noob";
	 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(desconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noob other = (Noob) obj;
		if (Double.doubleToLongBits(desconto) != Double
				.doubleToLongBits(other.desconto))
			return false;
		return true;
	}

	
	 
	 
}