package rs.ac.bg.fon.nprog.so.trening;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
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
import rs.ac.bg.fon.nprog.domen.StavkaTreninga;
import rs.ac.bg.fon.nprog.domen.Trener;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSOTest;

class SOIzmeniTreningTest extends OpstaSOTest {

	 	SOIzmeniTrening so;
	    
	    @BeforeEach
	    protected void setUp() throws Exception {
	        super.setUp();
	        so = new SOIzmeniTrening(dbb);
	    }

	    @AfterEach
	    protected void tearDown() throws Exception {
	        super.tearDown();
	        so = null;
	    }
	    
	    @Test
	    void testProveriPreduslov() throws ServerskiException {
        	Trening t=new Trening(1, "lenj", new Date(12, 6, 27, 13, 30, 0), 50, new Trener(1), new Grupa(1), new Sala(1));
        	Trening tt=new Trening(2, "lenj", new Date(12, 6, 27, 13, 30, 0), 50, new Trener(1), new Grupa(1), new Sala(1));
	        List<OpstiDomenskiObjekat> listaTreninzi = new ArrayList<>();
	        listaTreninzi.add(tt);
	        when(dbb.vratiSveObjekte(any(Trening.class))).thenReturn(listaTreninzi);
	        so.setParam(t);
	        assertThrows(ServerskiException.class, () -> so.proveriPreduslov());
	    }

	    @Test
	    void testSOizvrsiKonkretnuOperaciju() {
	    	 try {
	             Trening t = new Trening(1, "lenj", new Date(12, 6, 27, 13, 30, 0), 50, new Trener(1), new Grupa(1), new Sala(1));
	             List<OpstiDomenskiObjekat> stavke = new ArrayList<>();
	             stavke.add(new StavkaTreninga());
	             t.setListaStavki(stavke);

	             when(dbb.izmeniObjekat(eq(t))).thenReturn(t);
	             when(dbb.vratiObjekte(any(StavkaTreninga.class))).thenReturn(stavke);

	             so.setParam(t);
	             so.izvrsiOperaciju();

	             verify(dbb, times(1)).izmeniObjekat(eq(t));
	             verify(dbb, times(2)).vratiObjekte(any(StavkaTreninga.class));
	             verify(dbb, times(stavke.size())).obrisiObjekat(any(StavkaTreninga.class));
	             verify(dbb, times(stavke.size())).sacuvajObjekat(any(StavkaTreninga.class));

	             assertEquals(t, so.getTrening());
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	    }

	}
