package rs.ac.bg.fon.nprog.so.clan;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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


class SOVratiClanoveTest extends OpstaSOTest {

	
	SOVratiClanove so;
	
	@BeforeEach
	protected
	void setUp() throws Exception {
		super.setUp();
		so=new SOVratiClanove(dbb);
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
			Clan c1 = new Clan(1, "aa", "bb", new Date(100, 6, 27), "Kostolacka", "+381626573340", new Grad(1), new Grupa(1));
			Clan c2 = new Clan(2, "aaa", "bbb", new Date(101, 6, 27), "Kostolacka", "+381626573340", new Grad(2), new Grupa(2));

			List<OpstiDomenskiObjekat> listaClanova=new ArrayList<OpstiDomenskiObjekat>();

			listaClanova.add(c1);
			listaClanova.add(c2);

			when(dbb.vratiSveObjekte((OpstiDomenskiObjekat) any())).thenReturn(listaClanova);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).vratiSveObjekte((OpstiDomenskiObjekat) any());
			assertEquals(listaClanova, so.getLista());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
