package rs.ac.bg.fon.nprog.so.clan;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.Grad;
import rs.ac.bg.fon.nprog.domen.Grupa;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.so.OpstaSOTest;

class SOObrisiClanaTest extends OpstaSOTest {

	SOObrisiClana so;
	
	@BeforeEach
	protected
	void setUp() throws Exception {
		super.setUp();
		so=new SOObrisiClana(dbb);
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
			Clan c1 = new Clan(1);
			so.setParam(c1);
			when(dbb.obrisiObjekat(eq(so.getParam()))).thenReturn(c1);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).obrisiObjekat(so.getParam());
			assertEquals(c1, so.getObrisan());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
