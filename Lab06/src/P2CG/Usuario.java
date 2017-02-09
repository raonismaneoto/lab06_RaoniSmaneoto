package P2CG;

import java.util.ArrayList;

import Exceptions.NumeroNegativoException;
import Exceptions.ParametroVazioException;


public abstract class Usuario {
	protected String nome;
	protected String loginame;
	protected ArrayList<Jogo> jogos;
	protected double money;
	
	
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
	
	protected void compraJogo(Jogo jogo)throws Exception{
		if(jogo == null){
			throw new Exception("O objeto é null");
		}
		double preco = jogo.getPreco() - jogo.getPreco()*getDesconto();
		if(preco < 0){
			throw new NumeroNegativoException("O preço não pode ser negativo");
		}
		if(jogo.equals(procuraJogo(jogo))){
			throw new Exception("Você ja possui esse jogo");
		}
		if(this.money >= preco){
				this.money -= preco;
				this.jogos.add(jogo);
				this.incremento(jogo);
			}
		
		}
	

	protected abstract void incremento(Jogo jogo);
	protected abstract void incremento(int x2p);
	protected abstract double getDesconto();
	

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
	public Jogo procuraJogo(String jogo)throws Exception{
		if(jogo == null){
			throw new Exception("O jogo não pode ser null");
		}
		for(Jogo other: jogos){
			if(other.getNome().equals(jogo)){
				return other;
			}
		}
		return null;
	}
	
	public void registraJogada(String nomeDoJogo, int score, int zerou){
		Jogo other = procuraJogo(nomeDoJogo);
	}
	
}
