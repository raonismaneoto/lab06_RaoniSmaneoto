package P2CG;

import Exceptions.NumeroNegativoException;

public class Veterano extends Status{
	
	public Veterano() throws Exception{
		this.desconto = 0.2;
	}
	
	public double getDesconto(){
		return this.desconto;
	}
	
	public String dizQuemTuEs(){
		 return "Veterano";
	 }
}
