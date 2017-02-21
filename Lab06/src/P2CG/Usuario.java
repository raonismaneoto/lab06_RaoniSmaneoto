package P2CG;

import java.util.ArrayList;

import Exceptions.NumeroNegativoException;
import Exceptions.ParametroVazioException;


public class Usuario {
	/**
	 * Classificação é um atributo do tipo status que tem como filhos noob e veterano, dessa forma, quando o upgrade for solicitado, basta mudar o atributo, sem precisar passar todos os dados atuais para outro objeto. 
	 */
	private String nome;
	private String loginame;
	private ArrayList<Jogo> jogos;
	private double money;
	private Status classificacao;
	private int x2p;
	
	/**
	 * Ao construir o usuário analisa os possíveis erros e lança execeção de acordo com os erros.
	 * 
	 * @param nome
	 * @param loginame
	 * @throws Exception
	 */
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
	/**
	 * Método que é usado por loja para adicionar dinheiro para o usuário.
	 * Única execeção possível é se a quantia for negativa.
	 * @param quantia
	 * @throws NumeroNegativoException
	 */
	public void adicionaDinheiro(double quantia)throws NumeroNegativoException{
		if(quantia < 0){
			throw new NumeroNegativoException("A quantia não pode ser negativa");
		}
		this.money += quantia;
		
	}
	/**
	 * Caso o usuário seja noob ele evolui para veterano dependendo da sua quantidade de x2p.
	 * Método usado por loja.
	 * @throws Exception
	 */
	
	public void upStatus() throws Exception{
		if(this.x2p < 1000){
			throw new Exception("Pontos insuficientes");
		}
		if(this.classificacao.toString().equals("Veterano")){
			throw new Exception("O Usuário já é veterano");
		}
		this.classificacao = new Veterano();
	}
	public int getX2p(){
		return this.x2p;
	}
	

	/**
	 * Nesse método a lógica de compra jogo de acordo com desconto e o incremento de x2p é implementada.
	 * @param jogo
	 * @throws Exception
	 */
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
				if(this.classificacao.toString().equals("Noob")){
					double pontos = jogo.getPreco()*10;
					x2p += (int)pontos;
				}
				else if (this.classificacao.toString().equals("Veterano")){
					double pontos = jogo.getPreco()*15;
					x2p += (int)pontos;
				}
				
			}
		else{
			throw new Exception("O usuário não possui dinheiro suficiente.");
		}
		
		}
	
	public String getClassificacao(){
		return this.classificacao.toString();
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
	/**
	 *  Esses dois métodos de procura jogo representam uma sobrecarga na qual cada um pode ser chamado com diferentes parâmetros.
	 * @param jogo
	 * @return
	 * @throws Exception
	 */
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
	/**
	 * Adiciona os pontos no atributo x2p do usuário chamando o registraJogada de jogo.
	 * @param nomeDoJogo
	 * @param score
	 * @param zerou
	 * @throws Exception
	 */
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
	/**
	 * Método implementado com o intuito de saber o total de preço da lista de jogos para imprimir no toString.
	 * @return
	 */
	public double getTotal(){
		double total = 0;
		for(Jogo jogo: jogos){
			total += jogo.getPreco();
		}
		return total;
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
	@Override
	public String toString(){
		String msg =  this.loginame + "\n" + this.nome + " - " + "Jogador " + this.classificacao.toString() + "\nLista de Jogos: \n";
		for(Jogo jogo: jogos){
			msg += jogo.toString() + "\n";
		}
		msg += "\nTotal de preço dos jogos: R$" + this.getTotal();
		
		return msg;
	}
	
}
