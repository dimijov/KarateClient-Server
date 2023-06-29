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
class GradTest {

	Grad g;
	
	@Mock
	private ResultSet rs;
	
	@BeforeEach
	void setUp() throws Exception {
		g=new Grad();
	}

	@AfterEach
	void tearDown() throws Exception {
		g=null;
	}

	@Test
	void testGradKonstruktorID() {
		g=new Grad(1);
		assertNotNull(g);
		assertEquals(1, g.getGradID());
		assertEquals(null,g.getNaziv());
		assertEquals(0,g.getPostanskiBroj());

	}
	
	@Test
	void testGradKonstruktorEmpty() {
		g=new Grad();
		assertNotNull(g);
		assertEquals(0, g.getGradID());
		assertEquals(null,g.getNaziv());
		assertEquals(0,g.getPostanskiBroj());

	}
	
	
	@Test
	void testGradKonstruktorFull() {
		g=new Grad(1, "Beograd",11000);
		assertNotNull(g);
		assertEquals(1, g.getGradID());
		assertEquals("Beograd",g.getNaziv());
		assertEquals(11000,g.getPostanskiBroj());

	}
	
	@Test
	void testGradsetGradIdNula() {
		assertThrows(IllegalArgumentException.class,()->g.setGradID(0));
	}
	
	@Test
	void testGradsetGradIdOk() {
		g.setGradID(1);
		assertEquals(1,g.getGradID());
	}
	
	
	@Test
	void testGradsetNazivNull() {
		assertThrows(NullPointerException.class,()->g.setNaziv(null));
	}
	
	@Test
	void testGradsetNazivOk() {
		g.setNaziv("Beograd");
		assertEquals("Beograd",g.getNaziv());
	}
	
	@Test
	void testGradsetPostanskiBrojManjeOdNula() {
		assertThrows(IllegalArgumentException.class,()->g.setPostanskiBroj(-1));
	}
	
	@Test
	void testGradsetPostanskiBrojOk() {
		g.setPostanskiBroj(11000);
		assertEquals(11000,g.getPostanskiBroj());
	}
	
	
	@Test
	void testGradtoString() {
		
		g.setNaziv("Beograd");
		String rezultat=g.toString();
		assertTrue(rezultat.contains("Beograd"));

	}
	
	
	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 2, false",
			}
	)
	void testEqualsObject(int gradId1, int gradId2, boolean rez) {
		g.setGradID(gradId1);
		Grad g2=new Grad();
		g2.setGradID(gradId2);
		assertEquals(rez, g.equals(g2));
	}
	
	
	
	
	@Test
	void testGradvratiParametre() {
		g.setGradID(1);
		g.setNaziv("Beograd");
		g.setPostanskiBroj(11000);
		
		String format=g.vratiParametre();
		assertEquals("'1', 'Beograd', '11000'", format);
	}
	
	
	@Test
	void testGradvratiUpdate() {
		g.setGradID(1);
		g.setNaziv("Beograd");
		g.setPostanskiBroj(11000);
		
		String format=g.vratiUpdate();
		assertEquals("gradID='1', naziv='Beograd', postanskiBroj='11000'", format);
	}
	
	
	@Test
	void testGradRSuTabelu() throws Exception {
		AutoCloseable ac=MockitoAnnotations.openMocks(this);
		KreirajGradResultSet();
		

		Grad g1=new Grad();
		List<OpstiDomenskiObjekat> lista1=g1.RSuTabelu(rs);

		Grad g2=new Grad();
		g2.setGradID(1);
		g2.setNaziv("Beograd");
		g2.setPostanskiBroj(11000);

		List<OpstiDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(g2);

		assertEquals(lista1, lista2);
		ac.close();
	}

	private void KreirajGradResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt("gradID")).thenReturn(1);
		Mockito.when(rs.getString("naziv")).thenReturn("Beograd");
		Mockito.when(rs.getInt("postanskiBroj")).thenReturn(11000);	
	}
	

}
