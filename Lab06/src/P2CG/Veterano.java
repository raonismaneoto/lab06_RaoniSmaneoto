package P2CG;

import Exceptions.NumeroNegativoException;

public class Veterano extends Usuario{
	private int x2p;
	private double desconto;
	
	public Veterano(String nome, String loginame) throws Exception{
		super(nome, loginame);
		this.x2p = 1000;
		this.desconto = 0.2;
	}
	
	public double getDesconto(){
		return this.desconto;
	}
	
	public void incremento(Jogo jogo){
		this.x2p += jogo.getPreco()*15;
	}
	public void incremento(int x2p){
		 this.x2p += x2p;
	 }
}
