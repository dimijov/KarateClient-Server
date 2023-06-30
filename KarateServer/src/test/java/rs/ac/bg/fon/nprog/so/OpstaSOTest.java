package rs.ac.bg.fon.nprog.so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import rs.ac.bg.fon.nprog.db.DBBroker;


@RunWith(MockitoJUnitRunner.class)
public abstract class OpstaSOTest {

	private AutoCloseable closeable;

	@Mock
	protected DBBroker dbb;
	
	@BeforeEach
	void setUp() throws Exception {
		closeable = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}

	@Test
	void testOpstaSO() {
		DBBroker dbbroker =new DBBroker();
		assertNotNull(dbbroker);
	}

}
