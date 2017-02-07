package P2CG;

import java.util.ArrayList;

import Exceptions.NumeroNegativoException;
import Exceptions.ParametroVazioException;


public class Usuario {
	private String nome;
	private String loginame;
	private ArrayList<Jogo> jogos;
	private double money;
	
	
	public Usuario(String nome, String loginame)throws Exception{
		if(nome.trim().equals("")){
			throw new ParametroVazioException("O nome não pode ser vazio");
		}
		
		this.nome = nome;
		if(loginame.trim().equals("")){
			throw new ParametroVazioException("O nome de login não pode ser vazio");
		}
		this.loginame = loginame;
		this.jogos = new ArrayList<Jogo>();
		this.money = 0;
	}
	
	public void adicionaDinheiro(double quantia)throws NumeroNegativoException{
		if(quantia < 0){
			throw new NumeroNegativoException("A quantia não pode ser negativa");
		}
		this.money += quantia;
		
	}
	public void compraJogo(Jogo jogo, double preco)throws Exception{
		if(jogo == null){
			throw new Exception("O objeto é null");
		}
		if(preco < 0){
			throw new NumeroNegativoException("O preço não pode ser negativo");
		}
		if(this.money >= preco){
				this.money -= preco/10;
				this.jogos.add(jogo);
			}
		}
		
		
	
	public String getNome(){
		return this.nome;
	}
	public String getLogin(){
		return this.loginame;
	}
	public Jogo procuraJogo(Jogo jogo)throws Exception{
		if(jogo == null){
			throw new Exception("O jogo não pode ser null");
		}
		for(Jogo other: jogos){
			if(other.equals(jogo)){
				return other;
			}
		}
		return null;
	}
	
}
