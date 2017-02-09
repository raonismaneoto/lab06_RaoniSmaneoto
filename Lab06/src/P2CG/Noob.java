package P2CG;

import Exceptions.NumeroNegativoException;

public class Noob extends Usuario{
	private int x2p;
	private double desconto;
	
	
	
	public Noob(String nome, String loginame) throws Exception {
		super(nome, loginame);
		this.desconto = 0.1;
		this.x2p = 0;
		
		
	}
	
	 public double getDesconto(){
		 return this.desconto;
	 }
	 
	 public void incremento(Jogo jogo){
			this.x2p += jogo.getPreco()*10;
		}
	 
	 public void incremento(int x2p){
		 this.x2p += x2p;
	 }
	 
	 
}