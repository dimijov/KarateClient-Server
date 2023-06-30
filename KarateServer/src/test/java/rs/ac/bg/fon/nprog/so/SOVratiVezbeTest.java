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


import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Vezba;

class SOVratiVezbeTest extends OpstaSOTest {

	SOVratiVezbe so;
	
	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		so=new SOVratiVezbe(dbb);
	}

	@AfterEach
	void tearDown() throws Exception {
		super.tearDown();
		so=null;
	}

	@Test
	void testSOizvrsiKonkretnuOperaciju() {
		try {
			Vezba v1 = new Vezba(1, "dojo","koreografija",5);
			Vezba v2 = new Vezba(2,"kate","borba sa protivnikom",12);
			List<OpstiDomenskiObjekat> listaVezbi=new ArrayList<OpstiDomenskiObjekat>();

			listaVezbi.add(v1);
			listaVezbi.add(v2);

			when(dbb.vratiSveObjekte((OpstiDomenskiObjekat) any())).thenReturn(listaVezbi);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).vratiSveObjekte((OpstiDomenskiObjekat) any());
			assertEquals(listaVezbi, so.getLista());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
