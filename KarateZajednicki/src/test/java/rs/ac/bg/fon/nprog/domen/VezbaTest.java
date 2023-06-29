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
class VezbaTest {

	Vezba v;
	
	@Mock
	ResultSet rs;
	
	
	@BeforeEach
	void setUp() throws Exception {
		v=new Vezba();
	}

	@AfterEach
	void tearDown() throws Exception {
		v=new Vezba();
	}

	@Test
	void test() {
		v=null;
	}
	
	@Test
	void testVezbaKonstruktorID() {
		v=new Vezba(1);
		assertNotNull(v);
		assertEquals(1, v.getVezbaID());
		assertEquals(null,v.getNaziv());
		assertEquals(null,v.getOpis());
		assertEquals(0,v.getDuzina());

	}
	
	@Test
	void testVezbaKonstruktorEmpty() {
		v=new Vezba();
		assertNotNull(v);
		assertEquals(0, v.getVezbaID());
		assertEquals(null,v.getNaziv());
		assertEquals(null,v.getOpis());
		assertEquals(0,v.getDuzina());

	}
	
	
	@Test
	void testVezbaKonstruktorFull() {
		v=new Vezba(1,"Kate","Koreografija pokreta",10);
		assertNotNull(v);
		assertEquals(1, v.getVezbaID());
		assertEquals("Kate",v.getNaziv());
		assertEquals("Koreografija pokreta",v.getOpis());
		assertEquals(10,v.getDuzina());
	}
	
	@Test
	void testVezbasetVezbaIdNula() {
		assertThrows(IllegalArgumentException.class,()->v.setVezbaID(0));
	}
	
	@Test
	void testVezbasetVezbaIdOk() {
		v.setVezbaID(1);
		assertEquals(1,v.getVezbaID());
	}
	
	
	@Test
	void testVezbasetNazivNull() {
		assertThrows(NullPointerException.class,()->v.setNaziv(null));
	}
	
	@Test
	void testVezbasetNazivOk() {
		v.setNaziv("Kate");
		assertEquals("Kate",v.getNaziv());
	}
	
	
	@Test
	void testVezbasetOpisNull() {
		assertThrows(NullPointerException.class,()->v.setOpis(null));
	}
	
	@Test
	void testVezbasetOpisOk() {
		v.setOpis("Kate");
		assertEquals("Kate",v.getOpis());
	}
	
	@Test
	void testVezbasetDuzinaManjeOdJedan() {
		assertThrows(IllegalArgumentException.class,()->v.setDuzina(0));
	}
	
	@Test
	void testVezbasetDuzinaOk() {
		v.setDuzina(5);
		assertEquals(5,v.getDuzina());
	}
	
	
	@Test
	void testVezbatoString() {
		v.setNaziv("Dojo");
		String rezultat=v.toString();
		assertTrue(rezultat.contains("Dojo"));

	}
	
	
	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 2, false",
			}
	)
	void testEqualsObject(int VezbaId1, int VezbaId2, boolean rez) {
		v.setVezbaID(VezbaId1);
		Vezba v2=new Vezba();
		v2.setVezbaID(VezbaId2);
		assertEquals(rez, v.equals(v2));
	}
	
	
	
	
	@Test
	void testVezbavratiParametre() {
		v.setVezbaID(1);
		v.setNaziv("Dojo");
		v.setOpis("Koreografija pokreta");
		v.setDuzina(5);
		
		String format=v.vratiParametre();
		assertEquals("'1', 'Dojo', 'Koreografija pokreta', '5'", format);
	}
	
	
	@Test
	void testVezbavratiUpdate() {
		v.setVezbaID(1);
		v.setNaziv("Dojo");
		v.setOpis("Koreografija pokreta");
		v.setDuzina(5);
		
		String format=v.vratiUpdate();
		assertEquals("vezbaID='1', naziv='Dojo', opis='Koreografija pokreta, duzina='5'", format);
	}
	
	
	@Test
	void testVezbaRSuTabelu() throws Exception {
		AutoCloseable ac=MockitoAnnotations.openMocks(this);
		KreirajVezbaResultSet();
		

		Vezba v1=new Vezba();
		List<OpstiDomenskiObjekat> lista1=v1.RSuTabelu(rs);

		Vezba v2=new Vezba();
		v2.setVezbaID(1);
		v2.setNaziv("Dojo");
		v2.setOpis("Koreografija pokreta");
		v2.setDuzina(5);

		List<OpstiDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(v2);

		assertEquals(lista1, lista2);
		ac.close();
	}

	private void KreirajVezbaResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt("vezbaID")).thenReturn(1);
		Mockito.when(rs.getString("naziv")).thenReturn("Dojo");
		Mockito.when(rs.getString("opis")).thenReturn("Koreografija pokreta");
		Mockito.when(rs.getInt("duzina")).thenReturn(5);	
	}
	


}
