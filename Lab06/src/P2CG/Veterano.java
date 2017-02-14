package P2CG;

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
	
	 @Override
	 public String toString(){
		 return "Veterano";
	 }
}
