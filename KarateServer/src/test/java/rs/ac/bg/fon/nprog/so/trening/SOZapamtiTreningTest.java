package rs.ac.bg.fon.nprog.so.trening;

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

import rs.ac.bg.fon.nprog.domen.Grupa;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Sala;
import rs.ac.bg.fon.nprog.domen.StavkaTreninga;
import rs.ac.bg.fon.nprog.domen.Trener;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSOTest;

class SOZapamtiTreningTest extends OpstaSOTest {

    SOZapamtiTrening so;
    
    @BeforeEach
    protected void setUp() throws Exception {
        super.setUp();
        so = new SOZapamtiTrening(dbb);
    }

    @AfterEach
    protected void tearDown() throws Exception {
        super.tearDown();
        so = null;
    }
    
    @Test
    void testProveriPreduslov() throws ServerskiException {
        
    	Trening t=new Trening(1, "lenj", new Date(12, 6, 27, 13, 30, 0), 50, new Trener(1), new Grupa(1), new Sala(1));

        List<OpstiDomenskiObjekat> listaTreninzi = new ArrayList<>();
        listaTreninzi.add(t);
        when(dbb.vratiSveObjekte(any(Trening.class))).thenReturn(listaTreninzi);
        so.setParam(t);
        assertThrows(ServerskiException.class, () -> so.proveriPreduslov());
    }

    @Test
    void testSOizvrsiKonkretnuOperaciju() {
        try {
        	Trening t=new Trening(1, "lenj", new Date(12, 6, 27, 13, 30, 0), 50, new Trener(1), new Grupa(1), new Sala(1));
        	StavkaTreninga st=new StavkaTreninga();
        	st.setTrening(t);
        	st.setRbStavke(1);
        	StavkaTreninga st2=new StavkaTreninga();
        	st2.setTrening(t);
        	st2.setRbStavke(2);
        	
        	List<OpstiDomenskiObjekat> stavke=new ArrayList<>();
        	stavke.add(st);
        	stavke.add(st2);
        	t.setListaStavki(stavke);
        	
            so.setParam(t);
            when(dbb.sacuvajObjekat(eq(t))).thenReturn(t);
            when(dbb.sacuvajObjekat(any(StavkaTreninga.class))).thenReturn(stavke.get(0));
            so.izvrsiOperaciju();
            verify(dbb, times(1)).sacuvajObjekat(eq(t));
            verify(dbb, times(2)).sacuvajObjekat(any(StavkaTreninga.class));
            assertEquals(t, so.getTrening());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}






