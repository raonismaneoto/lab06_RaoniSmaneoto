package P2CG;

import Exceptions.NumeroNegativoException;

public class Noob extends Status{
	
	
	public Noob() throws Exception {
		this.desconto = 0.1;
		
		
	}
	
	 public double getDesconto(){
		 return this.desconto;
	 }
	 
	 public String dizQuemTuEs(){
		 return "Noob";
	 }
	 
	 
	 
}