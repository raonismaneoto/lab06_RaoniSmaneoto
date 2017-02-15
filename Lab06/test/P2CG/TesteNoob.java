package P2CG;

import junit.framework.Assert;

import org.junit.Test;

public class TesteNoob {
	@Test
	public void testGeral() throws Exception{
		Noob n1 = new Noob();
		Assert.assertEquals(0.1, n1.getDesconto());
	}
}
