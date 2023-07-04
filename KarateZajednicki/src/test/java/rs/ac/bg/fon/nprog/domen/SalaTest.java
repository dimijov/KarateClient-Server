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
class SalaTest {

	Sala s;
	
	@Mock
	ResultSet rs;
	
	@BeforeEach
	void setUp() throws Exception {
		s=new Sala();
	}

	@AfterEach
	void tearDown() throws Exception {
		s=null;
	}

	@Test
	void testSalaKonstruktorID() {
		s=new Sala(1);
		assertNotNull(s);
		assertEquals(1, s.getSalaID());
		assertEquals(null,s.getNaziv());
		assertEquals(0,s.getKapacitet());

	}
	
	@Test
	void testSalaKonstruktorEmpty() {
		s=new Sala();
		assertNotNull(s);
		assertEquals(0, s.getSalaID());
		assertEquals(null,s.getNaziv());
		assertEquals(0,s.getKapacitet());
	}
	
	
	@Test
	void testSalaKonstruktorFull() {
		s=new Sala(1, "Sala 1",20);
		assertNotNull(s);
		assertEquals(1, s.getSalaID());
		assertEquals("Sala 1",s.getNaziv());
		assertEquals(20,s.getKapacitet());

	}
	
	@Test
	void testSalasetSalaIdNegative() {
		assertThrows(IllegalArgumentException.class,()->s.setSalaID(-1));
	}
	
	@Test
	void testSalasetSalaIdOk() {
		s.setSalaID(1);
		assertEquals(1,s.getSalaID());
	}
	
	
	@Test
	void testSalasetNazivNull() {
		assertThrows(NullPointerException.class,()->s.setNaziv(null));
	}
	
	@Test
	void testSalasetNazivOk() {
		s.setNaziv("Sala 1");
		assertEquals("Sala 1",s.getNaziv());
	}
	
	@Test
	void testSalaseKapacitetManjeOdNula() {
		assertThrows(IllegalArgumentException.class,()->s.setKapacitet(0));
	}
	
	@Test
	void testSalasetPostanskiBrojOk() {
		s.setKapacitet(20);
		assertEquals(20,s.getKapacitet());
	}
	
	
	@Test
	void testSalatoString() {
		
		s.setNaziv("Dojo sala");
		String rezultat=s.toString();
		assertTrue(rezultat.contains("Dojo sala"));

	}
	
	
	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 2, false",
			}
	)
	void testEqualsObject(int SalaId1, int SalaId2, boolean rez) {
		s.setSalaID(SalaId1);
		Sala s2=new Sala();
		s2.setSalaID(SalaId2);
		assertEquals(rez, s.equals(s2));
	}
	
	
	
	
	@Test
	void testSalavratiParametre() {
		s.setSalaID(1);
		s.setNaziv("Sala 1");
		s.setKapacitet(20);
		
		String format=s.vratiParametre();
		assertEquals("'1', 'Sala 1', '20'", format);
	}
	
	
	@Test
	void testSalavratiUpdate() {
		s.setSalaID(1);
		s.setNaziv("Sala 1");
		s.setKapacitet(20);
		
		String format=s.vratiUpdate();
		assertEquals("salaID='1', naziv='Sala 1', kapacitet='20'", format);
	}
	
	
	@Test
	void testSalaRSuTabelu() throws Exception {
		AutoCloseable ac=MockitoAnnotations.openMocks(this);
		KreirajSalaResultSet();
		

		Sala s1=new Sala();
		List<OpstiDomenskiObjekat> lista1=s1.RSuTabelu(rs);

		Sala s2=new Sala();
		s2.setSalaID(1);
		s2.setNaziv("Sala 1");
		s2.setKapacitet(20);

		List<OpstiDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(s2);

		assertEquals(lista1, lista2);
		ac.close();
	}

	private void KreirajSalaResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt("salaID")).thenReturn(1);
		Mockito.when(rs.getString("naziv")).thenReturn("Sala 1");
		Mockito.when(rs.getInt("kapacitet")).thenReturn(20);	
	}
	


}
