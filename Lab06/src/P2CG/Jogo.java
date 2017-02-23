package P2CG;

import java.util.HashSet;

import Exceptions.NumeroNegativoException;
import Exceptions.ParametroVazioException;

public class Jogo {
	private String nome;
	private double preco;
	protected int maiorScore;
	private int quantidadeDeVezes;
	private int quantidadeDeZeradas;
	private HashSet<Jogabilidade> jogabilidade;
	
	/** Existem três construtores diferentes de modo que fique viável construir o objeto passando
	 * a visibilidade de diferentes formas.
	 *
	 * 
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @param tipo
	 * @throws Exception
	 */
	
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades)throws Exception{
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
		this.maiorScore = 0;
	}
	public Jogo(String nome, double preco, Jogabilidade jogabilidade)throws Exception{
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
		this.maiorScore = 0;
	}
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
		this.jogabilidade = new HashSet<Jogabilidade>();
		this.maiorScore = 0;
	}
	/**
	 * Retorna a quantidade de x2p que será incrementada nos pontos do usuário toda vez que ele jogar.
	 * Atualiza o maiorScore caso o score seja maior do que o antigo maiorScore.
	 * 
	 * @param score
	 * @param zerou
	 * @return
	 */
	public int registraJogada(int score, boolean zerou){
		int x2p = 0;
		int marcador = 0;
		this.quantidadeDeVezes ++;
		if(zerou){
			this.quantidadeDeZeradas ++;
		}
		return x2p;
	}
	/**
	 * Permite a adição de mais jogabilidades, caso o jogo tenha sido criado com menos do que ele realmente tem.
	 * @param jogabilidade
	 *
	 */
	public void addJogabilidade(Jogabilidade jogabilidade){
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
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public String toString(){
		return "+ " + this.nome + " - " + this.getClass().getName() + "\n ==> Jogou " + this.quantidadeDeVezes + " vez(es)" + "\n ==> Zerou " + this.quantidadeDeZeradas + " vez(es)" + "\n ==> Maior score: " + this.maiorScore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
