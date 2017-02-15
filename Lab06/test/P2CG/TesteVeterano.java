package P2CG;

import junit.framework.Assert;

import org.junit.Test;

public class TesteVeterano {
	@Test
	public void testGeral() throws Exception{
		Veterano v1 = new Veterano();
		Assert.assertEquals(0.2, v1.getDesconto());
	}
}
