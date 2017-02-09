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
	private HashSet<Jogabilidade> jogabilidade;
	private Tipo tipo;
	
	
	
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades, Tipo tipo)throws Exception{
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
		this.jogabilidade = jogabilidades;
	}
	public Jogo(String nome, double preco, Jogabilidade jogabilidade, Tipo tipo)throws Exception{
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
		this.jogabilidade = new HashSet<Jogabilidade>();
		this.jogabilidade.add(jogabilidade);
		this.tipo = tipo;
	}
	public Jogo(String nome, double preco, Tipo tipo)throws Exception{
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
		this.jogabilidade = new HashSet<Jogabilidade>();
		this.tipo = tipo;
	}
	
	public int registraJogada(int score, boolean zerou){
		int x2p = 0;
		int marcador = 0;
		if(zerou){
			this.quantidadeDeZeradas ++;
		}
		if(score > maiorScore){
			if(tipo.equals(tipo.Luta)){
				if(score <= 100000 && maiorScore < 100000){
					maiorScore = score;
					marcador = 1;
				}
			}
			else{
				maiorScore = score;
			}
			
		}
		if(this.tipo.equals(tipo.RPG)){
			x2p+=10;
		}
		else if(this.tipo.equals(tipo.Luta) && marcador == 1){
			x2p += maiorScore/1000;
		}
		else{
			x2p += 20;
		}
		
		return x2p;
	}
	
	public void addJogabilidade(Jogabilidade jogabilidade) throws Exception{
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
	public HashSet<Jogabilidade> getJogabilidade(){
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
