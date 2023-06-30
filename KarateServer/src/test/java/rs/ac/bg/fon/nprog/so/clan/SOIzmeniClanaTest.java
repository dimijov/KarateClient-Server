package rs.ac.bg.fon.nprog.so.clan;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.Grad;
import rs.ac.bg.fon.nprog.domen.Grupa;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSOTest;

class SOIzmeniClanaTest extends OpstaSOTest {

	SOIzmeniClana so;
	
	@BeforeEach
	protected
	void setUp() throws Exception {
		super.setUp();
		so=new SOIzmeniClana(dbb);
	}

	@AfterEach
	protected
	void tearDown() throws Exception {
		super.tearDown();
		so=null;
	}
	
	@Test
	void testProveriPreduslovDrugaKlasa() {
		so.setParam(new Grad());
		assertThrows(ServerskiException.class, ()->so.proveriPreduslov());
	}
	
	@Test
	void testSOizvrsiKonkretnuOperaciju() {
		try {
			Clan c=new Clan(1);
			so.setParam(c);
			when(dbb.izmeniObjekat(eq(so.getParam()))).thenReturn(c);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).izmeniObjekat(so.getParam());
			assertEquals(c, so.getClan());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
