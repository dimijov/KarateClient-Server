package rs.ac.bg.fon.nprog.so.trening;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.so.OpstaSOTest;
import rs.ac.bg.fon.nprog.so.clan.SOObrisiClana;

class SOObrisiTreningTest extends OpstaSOTest {

	SOObrisiTrening so;
	
	@BeforeEach
	protected
	void setUp() throws Exception {
		super.setUp();
		so=new SOObrisiTrening(dbb);
	}

	@AfterEach
	protected
	void tearDown() throws Exception {
		super.tearDown();
		so=null;
	}

	@Test
	void testSOizvrsiKonkretnuOperaciju() {
		try {
			Trening t1 = new Trening(1);
			so.setParam(t1);
			when(dbb.obrisiObjekat(eq(so.getParam()))).thenReturn(t1);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).obrisiObjekat(so.getParam());
			assertEquals(t1, so.getObrisan());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
