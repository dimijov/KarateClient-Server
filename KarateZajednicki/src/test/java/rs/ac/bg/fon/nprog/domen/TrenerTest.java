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
class TrenerTest {

	Trener t;
	
	@Mock
	private ResultSet rs;
	
	@BeforeEach
	void setUp() throws Exception {
		t=new Trener();
	}

	@AfterEach
	void tearDown() throws Exception {
		t=null;
	}

	@Test
	void testTrenerKonstruktorID() {
		t=new Trener(1);
		assertNotNull(t);
		assertEquals(1, t.getTrenerID());
		assertEquals(null,t.getIme());
		assertEquals(null,t.getPrezime());
		assertEquals(0,t.getGodineIskustva());
		assertEquals(null,t.getPojas());
		assertEquals(null,t.getUsername());
		assertEquals(null,t.getPassword());
	}
	
	@Test
	void testTrenerKonstruktorEmpty() {
		t=new Trener();
		assertNotNull(t);
		assertEquals(0, t.getTrenerID());
		assertEquals(null,t.getIme());
		assertEquals(null,t.getPrezime());
		assertEquals(0,t.getGodineIskustva());
		assertEquals(null,t.getPojas());
		assertEquals(null,t.getUsername());
		assertEquals(null,t.getPassword());
	}
	
	@Test
	void testTrenerKonstruktorUserPass() {
		t=new Trener("dimijo", "dimidimi");
		assertNotNull(t);
		assertEquals(0, t.getTrenerID());
		assertEquals(null,t.getIme());
		assertEquals(null,t.getPrezime());
		assertEquals(0,t.getGodineIskustva());
		assertEquals(null,t.getPojas());
		assertEquals("dimijo",t.getUsername());
		assertEquals("dimidimi",t.getPassword());
	}
	
	
	@Test
	void testTrenerKonstruktorFull() {
		t=new Trener(1, "Dimitrije", "Jovanovic", 5, "braon", "dimijo", "dimidimi");
		assertNotNull(t);
		assertEquals(1, t.getTrenerID());
		assertEquals("Dimitrije",t.getIme());
		assertEquals("Jovanovic",t.getPrezime());
		assertEquals(5,t.getGodineIskustva());
		assertEquals("braon",t.getPojas());
		assertEquals("dimijo",t.getUsername());
		assertEquals("dimidimi",t.getPassword());
	}
	
	@Test
	void testTrenersetPasswordNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->t.setPassword(null));
	}
	
	@Test
	void testTrenersetPasswordOk() {
		t.setPassword("123");
		assertEquals("123",t.getPassword());
	}
	
	@Test
	void testTrenersetTrenerIDNegative() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->t.setTrenerID(-1));
	}
	
	@Test
	void testTrenersetTrenerIDOk() {
		t.setTrenerID(123);
		assertEquals(123,t.getTrenerID());
	}
	
	@Test
	void testTrenersetImeNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->t.setIme(null));
	}
	
	@Test
	void testTrenersetImeOk() {
		t.setIme("dimi");
		assertEquals("dimi",t.getIme());
	}
	
	@Test
	void testTrenersetPrezimeNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->t.setIme(null));
	}
	
	@Test
	void testTrenersetPrezimeOk() {
		t.setPrezime("jovic");
		assertEquals("jovic",t.getPrezime());
	}
	
	@Test
	void testTrenersetGodineIskustvaNegative() {
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->t.setGodineIskustva(-2));
	}
	
	@Test
	void testTrenersetGodineIskustvaOk() {
		t.setGodineIskustva(12);
		assertEquals(12,t.getGodineIskustva());
	}
	
	@Test
	void testTrenersetPojasNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->t.setPojas(null));
	}
	
	@Test
	void testTrenersetPojasVan() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->t.setPojas("zuti"));
	}
	
	@Test
	void testTrenersetPojasOk() {
		t.setPojas("crni");
		assertEquals("crni",t.getPojas());
	}
	
	@Test
	void testTrenersetUsernameNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->t.setUsername(null));
	}
	
	@Test
	void testTrenersetUsernameeOk() {
		t.setUsername("dimijo");
		assertEquals("dimijo",t.getUsername());
	}
	
	@Test
	void testTrenertoString() {
		t.setIme("Dimi");
		t.setPrezime("Jovanovic");

		String rezultat=t.toString();

		assertTrue(rezultat.contains("Dimi"));
		assertTrue(rezultat.contains("Jovanovic"));
	}
	
	
	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 2, false",
			}
	)
	void testEqualsObject(int trenerId1, int trenerId2, boolean rez) {
		t.setTrenerID(trenerId1);
		Trener t2=new Trener();
		t2.setTrenerID(trenerId2);

		assertEquals(rez, t.equals(t2));
	}
	
	@Test
	void testTrenervratiParametre() {
		t.setTrenerID(1);
		t.setIme("Dimitrije");
		t.setPrezime("Jovanovic");
		t.setGodineIskustva(5);
		t.setPojas("braon");
		t.setUsername("dimijo");
		t.setPassword("dimidimi");
		String format=t.vratiParametre();
		assertEquals("'1', 'Dimitrije', 'Jovanovic', '5', 'braon','dimijo', 'dimidimi'", format);
	}
	
	@Test
	void testTrenervratiUpdate() {
		t.setTrenerID(1);
		t.setIme("Dimitrije");
		t.setPrezime("Jovanovic");
		t.setGodineIskustva(5);
		t.setPojas("braon");
		t.setUsername("dimijo");
		t.setPassword("dimidimi");
		String format=t.vratiUpdate();
		assertEquals("trenerID='1', ime='Dimitrije', prezime='Jovanovic', godineIskustva='5',pojas='braon', username='dimijo',password='dimidimi'", format);
	}
	
	@Test
	void testTrenerRSuTabelu() throws Exception {
		AutoCloseable ac=MockitoAnnotations.openMocks(this);
		KreirajTrenerResultSet();
		

		Trener t1=new Trener();
		List<OpstiDomenskiObjekat> lista1=t1.RSuTabelu(rs);

		Trener t2=new Trener();
		t2.setTrenerID(1);
		t2.setIme("Dimitrije");
		t2.setPrezime("Jovanovic");
		t2.setGodineIskustva(5);
		t2.setPojas("braon");
		t2.setUsername("dimijo");
		t2.setPassword("dimidimi");

		List<OpstiDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(t2);

		assertEquals(lista1, lista2);
		ac.close();
	}
	

	private void KreirajTrenerResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt("trenerID")).thenReturn(1);
		Mockito.when(rs.getString("ime")).thenReturn("Dimitrije");
		Mockito.when(rs.getString("prezime")).thenReturn("Jovanovic");
		Mockito.when(rs.getString("godineIskustva")).thenReturn("5");
		Mockito.when(rs.getString("pojas")).thenReturn("braon");
		Mockito.when(rs.getString("username")).thenReturn("dimijo");
		Mockito.when(rs.getString("password")).thenReturn("dimidimi");
    }
	
	
	
	
	

}