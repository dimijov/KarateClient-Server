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

import rs.ac.bg.fon.nprog.domen.Grad;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;

class SOVratiGradoveTest extends OpstaSOTest {

	
	SOVratiGradove so;
	
	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		so=new SOVratiGradove(dbb);
	}

	@AfterEach
	void tearDown() throws Exception {
		super.tearDown();
		so=null;
	}

	@Test
	void testSOizvrsiKonkretnuOperaciju() {
		try {
			Grad g1 = new Grad(1, "Beograd", 11000);
			Grad g2 = new Grad(2,"Novi Sad",21000);
			List<OpstiDomenskiObjekat> listaGradova=new ArrayList<OpstiDomenskiObjekat>();

			listaGradova.add(g1);
			listaGradova.add(g2);

			when(dbb.vratiSveObjekte((OpstiDomenskiObjekat) any())).thenReturn(listaGradova);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).vratiSveObjekte((OpstiDomenskiObjekat) any());
			assertEquals(listaGradova, so.getLista());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
