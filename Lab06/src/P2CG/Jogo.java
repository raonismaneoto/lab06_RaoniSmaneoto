package P2CG;

import java.util.HashSet;

import Exceptions.NumeroNegativoException;
import Exceptions.ParametroVazioException;

public class Jogo {
	private String nome;
	private double preco;
	private int maiorScore;
	private int quantidadeDeVezes;
	private int quantidadeDeZeradas;
	private HashSet<String> jogabilidade;
	
	
	
	public Jogo(String nome, double preco)throws Exception{
		if(nome.trim().equals("")){
			throw new ParametroVazioException("O nome não pode ser vazio");
		}
		this.nome = nome;
		if(preco < 0){
			throw new NumeroNegativoException("O preço não pode ser negativo");
		}
		this.preco = preco;
		this.quantidadeDeVezes = 0;
		this.quantidadeDeZeradas = 0;
		this.jogabilidade = new HashSet<String>();
	}
	
	public int registraJogada(int score, boolean zerou){
		
	}
	
	public void addJogabilidade(String jogabilidade) throws Exception{
		if(jogabilidade.trim().equals("")){
			throw new ParametroVazioException("A jogabilidade não pode ser vazia");
		}
		this.jogabilidade.add(jogabilidade);
	}
	
	public String getNome(){
		return this.nome;
	}
	public double getPreco(){
		return this.preco;
	}
	public int getMaiorScore(){
		return this.maiorScore;
	}
	public int getQuantidadeDeVezesJogadas(){
		return this.quantidadeDeVezes;
	}
	public int getQuantidadeDeVezesZeradas(){
		return this.quantidadeDeZeradas;
	}
	public HashSet<String> getJogabilidade(){
		return this.jogabilidade;
	}
	public void adicionaJogada(){
		this.quantidadeDeVezes += 1;
	}
	public void adicionaZerada(){
		this.quantidadeDeZeradas ++;
	}
	public void setMaiorScore(int Score)throws Exception{
		if(Score < 0){
			throw new NumeroNegativoException("O Score não pode ser negativo");
		}
		if(Score > maiorScore){
			this.maiorScore = Score;
		}
	}
	public void setPreco(double preco){
		this.preco = preco;
	}
}
