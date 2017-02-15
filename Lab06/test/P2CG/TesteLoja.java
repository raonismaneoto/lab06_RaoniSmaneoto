package P2CG;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteLoja {
	Jogo j1, j2, j3;
	Usuario u1, u2, u3;
	Loja l1, l2;
	@Before
	public void before() throws Exception{
		j1 = new Jogo("Gta", 20.5, Tipo.Luta);
		j2 = new Jogo("Tibia", 30, Tipo.RPG);
		u1 = new Usuario("Raoni", "Smaneoto");
		u2 = new Usuario("Stone", "stonys");
		l1 = new Loja();
		
	}
	
	@Test
	public void adicionaUsuario() throws Exception{
		l1.adicionaUsuario(u1);
		l1.adicionaUsuario(u2);
		l1.adicionaDinheiro("Smaneoto", 200000);
		l1.adicionaDinheiro("stonys", 200000);
		u1.compraJogo(j1);
		u2.compraJogo(j2);
		System.out.println(l1);
	}
	
	@Test
	public void vendeJogo() throws Exception{
		l1.adicionaUsuario(u1);
		l1.adicionaDinheiro("Smaneoto", 30);
		l1.vendeJogo("Smaneoto", "Gta", 30, Jogabilidade.Competitivo, Tipo.Luta);
		u1.registraJogada("Gta", 300, true);
		Jogo teste = u1.procuraJogo("Gta");
		Assert.assertEquals(teste, u1.procuraJogo("Gta"));
	}
	
	@Test
	public void upGrade() throws Exception{
		l1.adicionaUsuario(u1);
		l1.adicionaDinheiro("Smaneoto", 200000);
		u1.compraJogo(j1);
		for(int i = 0; i < 100; i++){
			u1.registraJogada("Gta",99000 + i , true);
		}
		l1.upgrade("Smaneoto");
		Assert.assertEquals("Veterano", u1.getClassificacao());
		
	}
	
	
}
