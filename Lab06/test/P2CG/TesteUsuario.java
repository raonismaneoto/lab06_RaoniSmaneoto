package P2CG;



import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import Exceptions.NumeroNegativoException;


public class TesteUsuario {
	Usuario u1, u2, u3;
	@Before
	public void before() throws Exception{
		u1 = new Usuario("Raoni", "Smaneoto");
	}
	
	@Test
	public void adicionaDinheiro() throws NumeroNegativoException{
		u1.adicionaDinheiro(200);
		Assert.assertEquals(200, u1.getMoney(), 0.05);
		
	}
	@Test
	public void compraJogo() throws Exception{
		Jogo j1 = new Jogo("Gta", 20.5, Jogabilidade.Competitivo, Tipo.Luta);
		u1.adicionaDinheiro(2000);
		u1.compraJogo(j1);
		Assert.assertEquals(205, u1.getX2p());
		Assert.assertEquals(1981.55, u1.getMoney(), 0.05);
		Assert.assertEquals(j1, u1.procuraJogo(j1));
		Jogo j2 = new Jogo("Tibia", 20, Jogabilidade.Online, Tipo.RPG);
		u1.compraJogo(j2);
		System.out.println(u1);
	
		
		
	}
	
	@Test
	public void registraJogada() throws Exception{
		Jogo j1 = new Jogo("Gta", 20.5, Jogabilidade.Competitivo, Tipo.Plataforma);
		u1.adicionaDinheiro(2000);
		u1.compraJogo(j1);
		u1.registraJogada("Gta", 2000, true);
		Assert.assertEquals(225, u1.getX2p());
	}
	
	
}
