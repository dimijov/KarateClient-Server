package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
class TreningTest {

	
	Trening t;
	
	@Mock
	private ResultSet rs;
	
	@BeforeEach
	void setUp() throws Exception {
		t=new Trening();
	}

	@AfterEach
	void tearDown() throws Exception {
		t=null;
	}

	@Test
	void testTreningKonstruktorID() {
		t=new Trening(1);
		assertNotNull(t);
		assertEquals(1, t.getTreningID());
		assertEquals(null,t.getNaziv());
		assertEquals(null,t.getDatumVreme());
		assertEquals(0,t.getTrajanje());
		assertEquals(null,t.getSala());
		assertEquals(null,t.getGrupa());
		assertEquals(null,t.getTrener());
		assertEquals(new ArrayList<>(),t.getListaStavki());

	}
	
	@Test
	void testTreningKonstruktorEmpty() {
		t=new Trening();
		assertNotNull(t);
		assertEquals(0, t.getTreningID());
		assertEquals(null,t.getNaziv());
		assertEquals(null,t.getDatumVreme());
		assertEquals(0,t.getTrajanje());
		assertEquals(null,t.getSala());
		assertEquals(null,t.getGrupa());
		assertEquals(null,t.getTrener());
		assertEquals(null,t.getListaStavki());

	}
	
	
	@Test
	void testTreningKonstruktorFull() {
		t=new Trening(1, "lenj", new Date(123, 6, 27, 13, 30, 0), 50, new Trener(1), new Grupa(1), new Sala(1));
		assertNotNull(t);
		assertEquals(1, t.getTreningID());
		assertEquals("lenj",t.getNaziv());
		assertEquals(new Date(123, 6, 27, 13, 30, 0),t.getDatumVreme());
		assertEquals(50,t.getTrajanje());
		assertEquals(new Sala(1),t.getSala());
		assertEquals(new Grupa(1),t.getGrupa());
		assertEquals(new Trener(1),t.getTrener());
		assertEquals(new ArrayList<>(),t.getListaStavki());

	}
	
	@Test
	void testTreningsetSalaNull() {
		assertThrows(NullPointerException.class,()->t.setSala(null));
	}
	
	@Test
	void testTreningsetSalaOk() {
		t.setSala(new Sala(1));
		assertEquals(new Sala(1),t.getSala());
	}
	
	
	@Test
	void testTreningsetTreningIdNula() {
		assertThrows(IllegalArgumentException.class,()->t.setTreningID(-1));
	}
	
	@Test
	void testTreningsetTreningIdOk() {
		t.setTreningID(1);
		assertEquals(1,t.getTreningID());
	}
	
	
	@Test
	void testTreningsetNazivNull() {
		assertThrows(NullPointerException.class,()->t.setNaziv(null));
	}
	
	@Test
	void testTreningsetNazivOk() {
		t.setNaziv("lenj");
		assertEquals("lenj",t.getNaziv());
	}
	

	@Test
	void testTreningsetTrajanjeMinus() {
		assertThrows(IllegalArgumentException.class,()->t.setTrajanje(-5));
	}
	
	@Test
	void testTreningsetTrajanjeOk() {
		t.setTrajanje(10);
		assertEquals(10,t.getTrajanje());
	}
	
	@Test
	void testTreningsetTrenerNull() {
		assertThrows(NullPointerException.class,()->t.setTrener(null));
	}
	
	@Test
	void testTreningsetTrenerOk() {
		t.setTrener(new Trener(1));
		assertEquals(new Trener(1), t.getTrener());
	}
	
	@Test
	void testTreningsetGrupaNull() {
		assertThrows(NullPointerException.class,()->t.setGrupa(null));
	}
	
	@Test
	void testTreningsetGrupaOk() {
		t.setGrupa(new Grupa(1));
		assertEquals(new Grupa(1), t.getGrupa());
	}
	
	

	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 2, false",
			}
	)
	void testEqualsObject(int treningId1, int treningId2, boolean rez) {
		t.setTreningID(treningId1);
		Trening t2=new Trening();
		t2.setTreningID(treningId2);
		assertEquals(rez, t.equals(t2));
	}
	
	
	
	
	@Test
	void testTreningvratiParametre() {
		t.setTreningID(1);
		t.setNaziv("lenj");
		t.setDatumVreme(new Date(123, 6, 27, 13, 30, 0));
		t.setTrajanje(50);
		StavkaTreninga st1=new StavkaTreninga(t);
		StavkaTreninga st2=new StavkaTreninga(t);	
		List<OpstiDomenskiObjekat> lista=new ArrayList<>();
		lista.add(st1);
		lista.add(st2);
		t.setListaStavki(lista);
		t.setTrener(new Trener(1));
		t.setGrupa(new Grupa(1));
		t.setSala(new Sala(1));
		
		
		String format=t.vratiParametre();
		System.out.println(format);
		assertEquals("'1', 'lenj', '2023-07-27 13:30:00.0', '50', '1', '1', '1'", format);
	}
	
	
	@Test
	void testTreningvratiUpdate() {
		t.setTreningID(1);
		t.setNaziv("lenj");
		t.setDatumVreme(new Date(123, 6, 27, 13, 30, 0));
		t.setTrajanje(50);
		StavkaTreninga st1=new StavkaTreninga(t);
		StavkaTreninga st2=new StavkaTreninga(t);	
		List<OpstiDomenskiObjekat> lista=new ArrayList<>();
		lista.add(st1);
		lista.add(st2);
		t.setListaStavki(lista);
		t.setTrener(new Trener(1));
		t.setGrupa(new Grupa(1));
		t.setSala(new Sala(1));
		
		
		String format=t.vratiUpdate();
		System.out.println(format);
		assertEquals("treningID='1', naziv='lenj', datumVreme='2023-07-27 13:30:00.0', trajanje='50',trenerID='1',grupaID='1',salaID='1'", format);
	}
	
	@Test
	void testTreningvratiAtributePretrazivanja() {
		t.setDatumVreme(new Date(123, 6, 27, 13, 30, 0));
		t.setTrener(new Trener(1));
        String format=t.vratiAtributePretrazivanja();
        assertEquals(" tr.trenerID ='1' AND DATE(datumVreme) = '2023-07-27' ", format);

	}
	
	
	@Test
	void testTreningRSuTabelu() throws Exception {
		AutoCloseable ac=MockitoAnnotations.openMocks(this);
		KreirajTreningResultSet();
		

		Trening t1=new Trening();
		List<OpstiDomenskiObjekat> lista1=t1.RSuTabelu(rs);

		Trening t2=new Trening(1);
		t2.setNaziv("lenj");
		t2.setDatumVreme(new Date(123, 6, 27, 13, 30, 0));
		t2.setTrajanje(50);
		t2.setTrener(new Trener(0, "A", "B", 2, "crni", "aa", "bb"));
		t2.setGrupa(new Grupa(1,"Pocetnici"));
		t2.setSala(new Sala(1,"Dojo",20));
		t2.getListaStavki().add(new StavkaTreninga(1, t2, 1, "lako", 5, new Vezba(1, "Dojo", "Koreografija", 5)));
		List<OpstiDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(t2);

		assertEquals(lista1, lista2);
		ac.close();
	}
	

	private void KreirajTreningResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt("treningID")).thenReturn(1);
		Mockito.when(rs.getString("nazivTreninga")).thenReturn("lenj");
		Mockito.when(rs.getInt("trajanje")).thenReturn(50);
		Mockito.when(rs.getTimestamp("datumVreme")).thenReturn(new java.sql.Timestamp(123, 6, 27, 13, 30, 0, 0));
		
		Mockito.when(rs.getInt("trenerID")).thenReturn(1);
		Mockito.when(rs.getString("ime")).thenReturn("A");
		Mockito.when(rs.getString("prezime")).thenReturn("B");
		Mockito.when(rs.getInt("godineIskustva")).thenReturn(2);
		Mockito.when(rs.getString("pojas")).thenReturn("crni");
		Mockito.when(rs.getString("username")).thenReturn("aa");
		Mockito.when(rs.getString("password")).thenReturn("bb");
		
		Mockito.when(rs.getInt("grupaID")).thenReturn(1);
		Mockito.when(rs.getString("nazivGrupe")).thenReturn("Pocetnici");
		
		Mockito.when(rs.getInt("salaID")).thenReturn(1);
		Mockito.when(rs.getString("nazivSale")).thenReturn("Dojo");
		Mockito.when(rs.getInt("kapacitet")).thenReturn(20);
		
		
		Mockito.when(rs.getInt("rbStavke")).thenReturn(1);
		Mockito.when(rs.getInt("brojPonavljanja")).thenReturn(1);
		Mockito.when(rs.getString("tezina")).thenReturn("lako");
		Mockito.when(rs.getInt("trajanjeStavke")).thenReturn(5);
		
		Mockito.when(rs.getInt("vezbaID")).thenReturn(1);
		Mockito.when(rs.getString("nazivVezbe")).thenReturn("Dojo");
		Mockito.when(rs.getString("opis")).thenReturn("Koreografija");
		Mockito.when(rs.getInt("duzina")).thenReturn(5);	
    }
	

}
