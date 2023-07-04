package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
class GrupaTest {

	Grupa g;
	
	@Mock
	private ResultSet rs;
	
	
	@BeforeEach
	void setUp() throws Exception {
		g=new Grupa();
	}

	@AfterEach
	void tearDown() throws Exception {
		g=null;
	}

	@Test
	void testGrupaKonstruktorID() {
		g=new Grupa(1);
		assertNotNull(g);
		assertEquals(1, g.getGrupaID());
		assertEquals(null,g.getNaziv());

	}
	
	@Test
	void testGrupaKonstruktorEmpty() {
		g=new Grupa();
		assertNotNull(g);
		assertEquals(0, g.getGrupaID());
		assertEquals(null,g.getNaziv());

	}
	
	
	@Test
	void testGrupaKonstruktorFull() {
		g=new Grupa(1,"Pocetnici");
		assertNotNull(g);
		assertEquals(1, g.getGrupaID());
		assertEquals("Pocetnici",g.getNaziv());

	}
	
	@Test
	void testGrupasetGrupaIdNegative() {
		assertThrows(IllegalArgumentException.class,()->g.setGrupaID(-1));
	}
	
	@Test
	void testGrupasetGrupaIdOk() {
		g.setGrupaID(1);
		assertEquals(1,g.getGrupaID());
	}
	
	
	@Test
	void testGrupasetNazivNull() {
		assertThrows(NullPointerException.class,()->g.setNaziv(null));
	}
	
	@Test
	void testGrupasetNazivOk() {
		g.setNaziv("Pocetnici");
		assertEquals("Pocetnici",g.getNaziv());
	}
	
	
	@Test
	void testGrupatoString() {
		
		g.setNaziv("Pocetnici");
		String rezultat=g.toString();
		assertTrue(rezultat.contains("Pocetnici"));

	}
	
	
	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 2, false",
			}
	)
	void testEqualsObject(int GrupaId1, int GrupaId2, boolean rez) {
		g.setGrupaID(GrupaId1);
		Grupa g2=new Grupa();
		g2.setGrupaID(GrupaId2);
		assertEquals(rez, g.equals(g2));
	}
	
	
	
	
	@Test
	void testGrupavratiParametre() {
		g.setGrupaID(1);
		g.setNaziv("Pocetnici");

		
		String format=g.vratiParametre();
		assertEquals("'1', 'Pocetnici'", format);
	}
	
	
	@Test
	void testGrupavratiUpdate() {
		g.setGrupaID(1);
		g.setNaziv("Pocetnici");

		
		String format=g.vratiUpdate();
		assertEquals("grupaID='1', naziv='Pocetnici'", format);
	}
	
	
	@Test
	void testGrupaRSuTabelu() throws Exception {
		AutoCloseable ac=MockitoAnnotations.openMocks(this);
		KreirajGrupaResultSet();
		

		Grupa g1=new Grupa();
		List<OpstiDomenskiObjekat> lista1=g1.RSuTabelu(rs);

		Grupa g2=new Grupa();
		g2.setGrupaID(1);
		g2.setNaziv("Pocetnici");

		List<OpstiDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(g2);

		assertEquals(lista1, lista2);
		ac.close();
	}

	private void KreirajGrupaResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt("grupaID")).thenReturn(1);
		Mockito.when(rs.getString("naziv")).thenReturn("Pocetnici");
	}

}
