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
class StavkaTreningaTest {

	
	StavkaTreninga st;
	
	@Mock
	ResultSet rs;
	
	
	@BeforeEach
	void setUp() throws Exception {
		st=new StavkaTreninga();
	}

	@AfterEach
	void tearDown() throws Exception {
		st=null;
	}

	@Test
	void testStavkaTreningaKonstruktorTreningID() {
		st=new StavkaTreninga(new Trening(1));
		assertNotNull(st);
		assertEquals(new Trening(1), st.getTrening());
		assertEquals(0,st.getRbStavke());
		assertEquals(0,st.getBrojPonavljanja());
		assertEquals(0,st.getTrajanje());
		assertEquals(null,st.getTezina());
		assertEquals(null,st.getVezba());
	}
	
	@Test
	void testStavkaTreningaKonstruktorEmpty() {
		st=new StavkaTreninga();
		assertNotNull(st);
		assertEquals(null, st.getTrening());
		assertEquals(0,st.getRbStavke());
		assertEquals(0,st.getBrojPonavljanja());
		assertEquals(0,st.getTrajanje());
		assertEquals(null,st.getTezina());
		assertEquals(null,st.getVezba());

	}
	
	
	@Test
	void testTreningKonstruktorFull() {
		st=new StavkaTreninga(1,new Trening(1),2,"srednje",10,new Vezba(1));
		assertNotNull(st);
		assertEquals(new Trening(1), st.getTrening());
		assertEquals(1,st.getRbStavke());
		assertEquals(2,st.getBrojPonavljanja());
		assertEquals(10,st.getTrajanje());
		assertEquals("srednje",st.getTezina());
		assertEquals(new Vezba(1),st.getVezba());

	}
	
	
	@Test
	void testStavkaTreningasetVezbaNull() {
		assertThrows(NullPointerException.class,()->st.setVezba(null));
	}
	
	@Test
	void testStavkaTreningasetSalaOk() {
		st.setVezba(new Vezba(1));
		assertEquals(new Vezba(1),st.getVezba());
	}
	
	@Test
	void testStavkaTreningasetRbStavkeNula() {
		assertThrows(IllegalArgumentException.class,()->st.setRbStavke(0));
	}
	
	@Test
	void testStavkaTreningasetRbStavkeOk() {
		st.setRbStavke(1);
		assertEquals(1,st.getRbStavke());
	}
	
	
	@Test
	void testStavkaTreningasetTreningNull() {
		assertThrows(NullPointerException.class,()->st.setTrening(null));
	}
	
	@Test
	void testStavkaTreningasetTreningOk() {
		st.setTrening(new Trening(1));
		assertEquals(new Trening(1),st.getTrening());
	}
	
	@Test
	void testStavkaTreningasetBrojPonavljanjaNula() {
		assertThrows(IllegalArgumentException.class,()->st.setBrojPonavljanja(0));
	}
	
	@Test
	void testStavkaTreningasetBrojPonavljanjaOk() {
		st.setBrojPonavljanja(1);
		assertEquals(1,st.getBrojPonavljanja());
	}
	
	@Test
	void testStavkaTreningasetTezinaNull() {
		assertThrows(NullPointerException.class,()->st.setTezina(null));
	}
	
	@Test
	void testStavkaTreningasetTezinaVanOkvira() {
		assertThrows(IllegalArgumentException.class,()->st.setTezina("srednje tesko"));
	}
	
	@Test
	void testStavkaTreningasetTezinaOk() {
		st.setTezina("lako");
		assertEquals("lako",st.getTezina());
	}
	
	@Test
	void testStavkaTreningasetTrajanjeManjeOdNula() {
		assertThrows(IllegalArgumentException.class,()->st.setTrajanje(-1));
	}
	
	@Test
	void testStavkaTreningasetTrajanjeOk() {
		st.setTrajanje(1);
		assertEquals(1,st.getTrajanje());
	}
	
	
	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 2, false",
			}
	)
	void testEqualsObject(int stavkatreningId1, int stavkatreningId2, boolean rez) {
		Trening t=new Trening(1);
		st.setRbStavke(stavkatreningId1);
		StavkaTreninga st2=new StavkaTreninga();
		st2.setRbStavke(stavkatreningId2);
		st.setTrening(t);
		st2.setTrening(t);
		assertEquals(rez, st.equals(st2));
	}
	
	@Test
	void testStavkaTreningavratiSlozenPk() {
		st.setRbStavke(1);
		st.setTrening(new Trening(1));
		String format=st.vratiSlozenPK();
		assertEquals(" rbStavke='1' AND treningID='1' ", format);
	}
	
	@Test
	void testStavkaTreningavratiParametre() {
		st.setRbStavke(1);
		st.setTrening(new Trening(1));
		st.setBrojPonavljanja(5);
		st.setTezina("srednje");
		st.setTrajanje(10);
		st.setVezba(new Vezba(1));
		
		
		String format=st.vratiParametre();
		System.out.println(format);
		assertEquals("'1', '1', '5', 'srednje', '10', '1'", format);
	}
	
	@Test
	void testStavkaTreningavratiUpdate() {
		st.setRbStavke(1);
		st.setTrening(new Trening(1));
		st.setBrojPonavljanja(5);
		st.setTezina("srednje");
		st.setTrajanje(10);
		st.setVezba(new Vezba(1));
		
		
		String format=st.vratiUpdate();
		System.out.println(format);
		assertEquals("rbStavke='1',treningID='1', brojPonavljanja='5', tezina='srednje', trajanje='10', vezbaID='1'", format);
	}
	
	@Test
	void testStavkaTreningaRSuTabelu() throws Exception {
		AutoCloseable ac=MockitoAnnotations.openMocks(this);
		KreirajStavkaTreningaResultSet();
		

		StavkaTreninga st1=new StavkaTreninga();
		List<OpstiDomenskiObjekat> lista1=st1.RSuTabelu(rs);

		StavkaTreninga st2=new StavkaTreninga();
		st2.setRbStavke(1);
		st2.setTrening(new Trening(1));
		st2.setBrojPonavljanja(5);
		st2.setTezina("srednje");
		st2.setTrajanje(10);
		st2.setVezba(new Vezba(1));
		List<OpstiDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(st2);

		assertEquals(lista1, lista2);
		ac.close();
	}
	

	private void KreirajStavkaTreningaResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt("rbStavke")).thenReturn(1);
		Mockito.when(rs.getInt("treningID")).thenReturn(1);
		Mockito.when(rs.getInt("brojPonavljanja")).thenReturn(5);
		Mockito.when(rs.getString("tezina")).thenReturn("srednje");
		Mockito.when(rs.getInt("trajanje")).thenReturn(10);
		Mockito.when(rs.getInt("vezbaID")).thenReturn(1);
    }
	
	

}
