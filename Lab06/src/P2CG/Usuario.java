package P2CG;

import java.util.ArrayList;

import Exceptions.NumeroNegativoException;
import Exceptions.ParametroVazioException;


public class Usuario {
	private String nome;
	private String loginame;
	private ArrayList<Jogo> jogos;
	private double money;
	private Status classificacao;
	private int x2p;
	
	
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
		
		this.classificacao = new Noob();
		this.x2p = 0;
	}
	
	public void adicionaDinheiro(double quantia)throws NumeroNegativoException{
		if(quantia < 0){
			throw new NumeroNegativoException("A quantia não pode ser negativa");
		}
		this.money += quantia;
		
	}
	public void upStatus() throws Exception{
		if(this.x2p >= 1000){
			this.classificacao = new Veterano();
		}
	}
	public int getX2p(){
		return this.x2p;
	}
	
	public void compraJogo(Jogo jogo)throws Exception{
		if(jogo == null){
			throw new Exception("O objeto é null");
		}
		double preco = jogo.getPreco() - jogo.getPreco()*this.classificacao.getDesconto();
		if(preco < 0){
			throw new NumeroNegativoException("O preço não pode ser negativo");
		}
		if(jogo.equals(procuraJogo(jogo))){
			throw new Exception("Você ja possui esse jogo");
		}
		if(this.money >= preco){
				this.money -= preco;
				this.jogos.add(jogo);
				if(this.getClassificacao().equals("Noob")){
					double pontos = jogo.getPreco()*10;
					x2p += (int)pontos;
				}
				else if (this.getClassificacao().equals("Veterano")){
					double pontos = jogo.getPreco()*15;
					x2p += (int)pontos;
				}
				
			}
		else{
			throw new Exception("O usuário não possui dinheiro suficiente.");
		}
		
		}
	

	
	
	public String getClassificacao(){
		return this.classificacao.dizQuemTuEs();
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
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception{
		Jogo other = procuraJogo(nomeDoJogo);
		if(other == null){
			throw new Exception("O usuário não possui esse jogo.");
		}
		x2p  += other.registraJogada(score, zerou);
		
		
		
	}
	public double getMoney(){
		return this.money;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result
				+ ((loginame == null) ? 0 : loginame.hashCode());
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
		Usuario other = (Usuario) obj;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (loginame == null) {
			if (other.loginame != null)
				return false;
		} else if (!loginame.equals(other.loginame))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
