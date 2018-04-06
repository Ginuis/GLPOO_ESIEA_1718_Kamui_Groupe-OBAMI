package fr.esiea.glpoo.kamui;

import java.io.File;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public abstract class AbstractCsvTirageDaoTest01 extends AbstractCsvTirageDaoTest {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractCsvTirageDaoTest01.class);


	@Override
	public void init(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEntetes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Test
	public void testPremiereBoule() {
        LOGGER.debug("testPremiereBoule... Debut");

        // Arrange
        final int nombreBouleAttendus = 41;

        // Act and assert
        doTestPremiereBoule(nombreBouleAttendus);
        LOGGER.debug("testPremiereBoule... Fin");
    }
	
	@Test
	public void testPremiereEtoile() {
        LOGGER.debug("testPremiereEtoile... Debut");

        // Arrange
        final int nombreBouleAttendus = 2;

        // Act and assert
        doTestPremiereEtoile(nombreBouleAttendus);
        LOGGER.debug("testPremiereEtoile... Fin");
    }
	
	@Test
	public void testTailleEntetes() {
        LOGGER.debug("testTailleEntetes... Debut");

        // Arrange
        final int tailleAttendue = 75;

        // Act and assert
        doTestTailleEntetes(tailleAttendue);

        LOGGER.debug("testTailleEntetes... Fin");
    }
	
	@Test
    public void testPremierEntetes() {
        LOGGER.debug("testPremierEntetes... Debut");

        // Arrange
        final String enteteAttendu = "annee_numero_de_tirage";
        final int position = 0;

        // Act and assert
        doTestPremierEntetes(enteteAttendu, position);

        LOGGER.debug("testPremierEntetes... Fin");
    }


}
