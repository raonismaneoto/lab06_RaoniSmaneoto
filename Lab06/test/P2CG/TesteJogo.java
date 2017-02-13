package P2CG;

import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import org.junit.Assert;

public class TesteJogo {
	Jogo j1, j2, j3;
	@Before
	public void before() throws Exception{
		HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
		jogabilidade.add(Jogabilidade.Online);
		j1 = new Jogo("Gta", 20.5, jogabilidade, Tipo.Luta);

 }
 
	@Test
	public void construtorTest() throws Exception{
		j2 = new Jogo("GtaV", 23.0, Jogabilidade.Online, Tipo.Plataforma);
		j3 = new Jogo("GtaV", 24.0, Tipo.Luta);
		Assert.assertNotEquals(j2, j3);
		
		
	}
	@Test
	public void registraJogada() throws Exception{
		Assert.assertEquals(1, j1.registraJogada(1000, true));
		Assert.assertEquals(0, j1.registraJogada(1000, true));
		
		
		j2 = new Jogo("GtaV", 23.0, Jogabilidade.Online, Tipo.Plataforma);
		Assert.assertEquals(20, j2.registraJogada(2000, true));
		
	
		
	
	}
	@Test
	public void adicionaJogabilidade() throws Exception{
		j1.addJogabilidade(Jogabilidade.Competitivo);
		System.out.println(j1.getJogabilidade());
	}
	
 
}
