package P2CG;

/**
 * Classe responsável por ser pai das possíveis classificações. Com essa estratégia o upgrade fica mais fácil e elegante de ser feito.
 * @author raoni
 *
 */


public abstract class Status {
	protected double desconto;
	
	
	protected abstract double getDesconto();
	


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
		Status other = (Status) obj;
		if (Double.doubleToLongBits(desconto) != Double
				.doubleToLongBits(other.desconto))
			return false;
		return true;
	}
	@Override
	public abstract String toString();
	
	
	
}
