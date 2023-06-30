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
import rs.ac.bg.fon.nprog.domen.Sala;


class SOVratiSaleTest extends OpstaSOTest {

	
	SOVratiSale so;
	
	@BeforeEach
	protected
	void setUp() throws Exception {
		super.setUp();
		so=new SOVratiSale(dbb);
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
			Sala s1 = new Sala(1, "sala1",5);
			Sala s2 = new Sala(2,"sala2",12);
			List<OpstiDomenskiObjekat> listaSala=new ArrayList<OpstiDomenskiObjekat>();

			listaSala.add(s1);
			listaSala.add(s2);

			when(dbb.vratiSveObjekte((OpstiDomenskiObjekat) any())).thenReturn(listaSala);
			so.izvrsiOperaciju();
			verify(dbb, times(1)).vratiSveObjekte((OpstiDomenskiObjekat) any());
			assertEquals(listaSala, so.getLista());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
