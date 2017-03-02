package P2CG;

import Exceptions.NumeroNegativoException;

/**
 * Classe responsável por ser pai das possíveis classificações. Com essa estratégia o upgrade fica mais fácil e elegante de ser feito.
 * @author raoni
 *
 */


public interface Status {
	
	
	
	
	public double getDesconto();
	
	public int recompensar(Jogo jogo, int score, boolean zerou);
	public int punir(Jogo jogo, int score, boolean zerou);
	


	
	
	
}
