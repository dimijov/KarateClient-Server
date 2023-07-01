package rs.ac.bg.fon.nprog.so.trening;

import static org.junit.jupiter.api.Assertions.*;
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

import rs.ac.bg.fon.nprog.domen.Grupa;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Sala;
import rs.ac.bg.fon.nprog.domen.Trener;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.so.OpstaSOTest;

class SONadjiTreningeTest extends OpstaSOTest {

	SONadjiTreninge so;
	
	@BeforeEach
	protected
	void setUp() throws Exception {
		super.setUp();
		so=new SONadjiTreninge(dbb);
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

			Trening t=new Trening(1, "lenj", new Date(123, 6, 27, 13, 30, 0), 50, new Trener(1), new Grupa(1), new Sala(1));
			Trening tt=new Trening(2, "lenji", new Date(123, 6, 27, 15, 30, 0), 50, new Trener(1), new Grupa(1), new Sala(1));
			
			List<OpstiDomenskiObjekat> listaTreninga=new ArrayList<OpstiDomenskiObjekat>();
			

			listaTreninga.add(t);
			listaTreninga.add(tt);
			
			

			so.setTrening(t);
			when(dbb.nadjiObjekte(so.getTrening())).thenReturn(listaTreninga);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).nadjiObjekte(so.getTrening());
			assertEquals(listaTreninga, so.getListaNadjenih());
			assertEquals(2, so.getListaNadjenih().size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
