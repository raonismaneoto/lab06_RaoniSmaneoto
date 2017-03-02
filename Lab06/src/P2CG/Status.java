package P2CG;

import Exceptions.NumeroNegativoException;

/**
 * Interface que é implementada por noob e veterano possibilitando a mudança automática de classificação.
 * @author raoni
 *
 */


public interface Status {
	
	
	
	
	public double getDesconto();
	
	public int recompensar(Jogo jogo, int score, boolean zerou);
	public int punir(Jogo jogo, int score, boolean zerou);
	


	
	
	
}
