package rs.ac.bg.fon.nprog.so;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.domen.Grupa;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;

class SOVratiGrupeTest extends OpstaSOTest {

	SOVratiGrupe so;
	
	@BeforeEach
	protected
	void setUp() throws Exception {
		super.setUp();
		so=new SOVratiGrupe(dbb);
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
			Grupa g1 = new Grupa(1, "easy");
			Grupa g2 = new Grupa(2,"medium");
			List<OpstiDomenskiObjekat> listaGrupa=new ArrayList<OpstiDomenskiObjekat>();

			listaGrupa.add(g1);
			listaGrupa.add(g2);

			when(dbb.vratiSveObjekte((OpstiDomenskiObjekat) any())).thenReturn(listaGrupa);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).vratiSveObjekte((OpstiDomenskiObjekat) any());
			assertEquals(listaGrupa, so.getLista());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
