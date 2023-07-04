package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
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
class ClanTest {

	Clan c;
	
	@Mock
	ResultSet rs;
	
	@BeforeEach
	void setUp() throws Exception {
		c=new Clan();
	}

	@AfterEach
	void tearDown() throws Exception {
		c=null;
	}

	@Test
	void testClanKonstruktorID() {
		c=new Clan(1);
		assertNotNull(c);
		assertEquals(1, c.getClanID());
		assertEquals(null,c.getIme());
		assertEquals(null,c.getPrezime());
		assertEquals(null,c.getDatumRodjenja());
		assertEquals(null,c.getAdresa());
		assertEquals(null,c.getBrojTelefona());
		assertEquals(null,c.getGrad());
		assertEquals(null,c.getGrupa());
	}
	
	@Test
	void testClanKonstruktorEmpty() {
		c=new Clan();
		assertNotNull(c);
		assertEquals(0, c.getClanID());
		assertEquals(null,c.getIme());
		assertEquals(null,c.getPrezime());
		assertEquals(null,c.getDatumRodjenja());
		assertEquals(null,c.getAdresa());
		assertEquals(null,c.getBrojTelefona());
		assertEquals(null,c.getGrad());
		assertEquals(null,c.getGrupa());
	}
	
	
	@Test
	void testClanKonstruktorFull() {
		c=new Clan(1, "Dimitrije", "Jovanovic",new Date(100, 6, 27) , "Kostolacka", "+381655493583", new Grad(1, "Beograd", 11000), new Grupa(1,"Pocetnici"));
		assertNotNull(c);
		assertEquals(1, c.getClanID());
		assertEquals("Dimitrije",c.getIme());
		assertEquals("Jovanovic",c.getPrezime());
		assertEquals(new Date(100, 6, 27),c.getDatumRodjenja());
		assertEquals("Kostolacka",c.getAdresa());
		assertEquals("+381655493583",c.getBrojTelefona());
		assertEquals(new Grad(1, "Beograd", 11000),c.getGrad());
		assertEquals(new Grupa(1,"Pocetnici"),c.getGrupa());
	}
	
	@Test
	void testClansetGrupaNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->c.setGrupa(null));
	}
	
	@Test
	void testClansetGrupaOk() {
		c.setGrupa(new Grupa(1,"Pocetnici"));
		assertEquals(new Grupa(1,"Pocetnici"),c.getGrupa());
	}
	
	@Test
	void testClansetClanIDNegatice() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->c.setClanID(-1));
	}
	
	@Test
	void testClansetClanIDOk() {
		c.setClanID(123);
		assertEquals(123,c.getClanID());
	}
	
	@Test
	void testClansetImeNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()->c.setIme(null));
	}
	
	@Test
	void testClansetImeOk() {
		c.setIme("Dimitrije");
		assertEquals("Dimitrije",c.getIme());
	}
	
	@Test
	void testClansetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, ()->c.setPrezime(null));
	}
	
	@Test
	void testClansetPrezimeOk() {
		c.setPrezime("Jovanovic");
		assertEquals("Jovanovic",c.getPrezime());
	}
	
	@Test
	void testClansetDatumRodjenjaOk() {
		c.setDatumRodjenja(new Date(100, 6, 27));

		assertEquals(new Date(100, 6, 27), c.getDatumRodjenja());	
	}
	
	@Test
	void testClansetDatumRodjenjaPosleDanasnjeg() {
		assertThrows(IllegalArgumentException.class, ()->c.setDatumRodjenja(new Date(150, 6, 27)));
	}
	
	
	@Test
	void testClansetAdresaNull() {
		assertThrows(java.lang.NullPointerException.class, ()->c.setAdresa(null));
	}
	
	@Test
	void testClansetAdresaOk() {
		c.setAdresa("Kostolacka");
		assertEquals("Kostolacka",c.getAdresa());
	}
	
	@Test
	void testClansetBrojTelefonaNull() {
		assertThrows(java.lang.NullPointerException.class, ()->c.setBrojTelefona(null));
	}
	
	@Test
	void testClansetBrojTelefonaNije381format() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->c.setBrojTelefona("0655493683"));
	}
	
	@Test
	void testClansetGradNull() {
		assertThrows(java.lang.NullPointerException.class, ()->c.setGrad(null));
	}
	
	@Test
	void testClansetGradOk() {
		c.setGrad(new Grad(1,"Beograd",11000));
		assertEquals(new Grad(1,"Beograd",11000),c.getGrad());
	}
	
	
	@Test
	void testClantoString() {
		c.setIme("Dimi");
		c.setPrezime("Jovanovic");

		String rezultat=c.toString();

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
	void testEqualsObject(int clanId1, int clanId2, boolean rez) {
		c.setClanID(clanId1);
		Clan c2=new Clan();
		c2.setClanID(clanId2);
		assertEquals(rez, c.equals(c2));
	}
	
	
	@Test
	void testClanvratiParametre() {
		c.setClanID(1);
		c.setIme("Dimitrije");
		c.setPrezime("Jovanovic");
		c.setDatumRodjenja(new Date(100,6,27));
		c.setAdresa("Kostolacka");
		c.setBrojTelefona("+381655493583");
		c.setGrad(new Grad(1,"Beograd",11000));
		c.setGrupa(new Grupa(1,"Pocetnici"));
		String format=c.vratiParametre();
		assertEquals("'1', 'Dimitrije', 'Jovanovic', '2000-07-27', 'Kostolacka','+381655493583', '1', '1'", format);
	}
	
	
	@Test
	void testClanVratiUpdate() {
		c.setClanID(1);
		c.setIme("Dimitrije");
		c.setPrezime("Jovanovic");
		c.setDatumRodjenja(new Date(100,6,27));
		c.setAdresa("Kostolacka");
		c.setBrojTelefona("+381655493583");
		c.setGrad(new Grad(1,"Beograd",11000));
		c.setGrupa(new Grupa(1,"Pocetnici"));
		String format=c.vratiUpdate();
		assertEquals("clanID='1', ime='Dimitrije', prezime='Jovanovic', datumRodjenja='2000-07-27',adresa='Kostolacka', brojTelefona='+381655493583',gradID='1',grupaID='1'", format);
	}
	
	
	@Test
	void testClanRSuTabelu() throws Exception {
		AutoCloseable ac=MockitoAnnotations.openMocks(this);
		KreirajClanResultSet();
		

		Clan c1=new Clan();
		List<OpstiDomenskiObjekat> lista1=c1.RSuTabelu(rs);

		Clan c2=new Clan();
		c2.setClanID(1);
		c2.setIme("Dimitrije");
		c2.setPrezime("Jovanovic");
		c2.setDatumRodjenja(new java.sql.Date(100,6,27));
		c2.setAdresa("Kostolacka");
		c2.setBrojTelefona("+381655493583");
		c2.setGrad(new Grad(1,"Beograd",11000));
		c2.setGrupa(new Grupa(1,"Pocetnici"));

		List<OpstiDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(c2);

		assertEquals(lista1, lista2);
		ac.close();
	}
	

	private void KreirajClanResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt("clanID")).thenReturn(1);
		Mockito.when(rs.getString("ime")).thenReturn("Dimitrije");
		Mockito.when(rs.getString("prezime")).thenReturn("Jovanovic");
		Mockito.when(rs.getDate("datumRodjenja")).thenReturn(new java.sql.Date(100, 6, 27));
		Mockito.when(rs.getString("adresa")).thenReturn("Kostolacka");
		Mockito.when(rs.getString("brojTelefona")).thenReturn("+381655493583");
		Mockito.when(rs.getInt("gradID")).thenReturn(1);
		Mockito.when(rs.getInt("grupaID")).thenReturn(1);
		Mockito.when(rs.getString("nazivGrada")).thenReturn("Beograd");
		Mockito.when(rs.getString("nazivGrupe")).thenReturn("Pocetnici");
		Mockito.when(rs.getInt("postanskiBroj")).thenReturn(11000);
    }
	
	
	
	

}
