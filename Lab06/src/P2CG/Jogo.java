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
		this.tipo = tipo;
		this.maiorScore = 0;
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
		this.maiorScore = 0;
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
		this.maiorScore = 0;
	}
	
	public int registraJogada(int score, boolean zerou){
		int x2p = 0;
		int marcador = 0;
		if(zerou){
			this.quantidadeDeZeradas ++;
		}
		if(score > maiorScore){
			if(tipo.equals(Tipo.Luta)){
				if(score <= 100000){
					maiorScore = score;
					marcador = 1;
				}
			}
			else{
				maiorScore = score;
			}
			
		}
		if(this.tipo.equals(Tipo.RPG)){
			x2p+=10;
		}
		else if(this.tipo.equals(Tipo.Luta) && marcador == 1){
			double lutax2p = maiorScore/1000;
			x2p = (int) lutax2p;
		}
		else if(this.tipo.equals(Tipo.Plataforma) && zerou == true){
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((jogabilidade == null) ? 0 : jogabilidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Jogo other = (Jogo) obj;
		if (jogabilidade == null) {
			if (other.jogabilidade != null)
				return false;
		} else if (!jogabilidade.equals(other.jogabilidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	public String toString(){
		return "+ " + this.nome + " - " + this.tipo + "\n ==> Jogou " + this.quantidadeDeVezes + " vez(es)" + "\n ==> Zerou " + this.quantidadeDeZeradas + " vez(es)" + "\n ==> Maior score: " + this.maiorScore;
	}
}
