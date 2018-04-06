package fr.esiea.glpoo.kamui;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.kamui.dao.CsvTirageDao;
import fr.esiea.kamui.domain.Tirage;
import junit.framework.Assert;
import org.junit.Test;

public abstract class AbstractCsvTirageDaoTest implements CsvTirageDao {

	protected CsvTirageDao dao;

	private static final Logger LOGGER = Logger.getLogger(AbstractCsvTirageDaoTest.class);

	private final static String RESOURCES_PATH = "src/test/resources/";
	private final static String TIRAGES_FILE_NAME = "euromillions_4.csv";
	
	@Before
    public void doBefore() {
        LOGGER.debug("doBefore Debut");

        final File file = new File(RESOURCES_PATH + TIRAGES_FILE_NAME);
        dao.init(file);

        LOGGER.debug("doBefore Fin");
    }
	
	// J'écris mes tests
	
	/**
     * Teste la valeur de la premiere boule du premier tirage
     * 
     * RESULT Premiere boule : 41
     */
    @Test
    protected void doTestPremiereBoule(final int nombreBouleAttendue) {
    	// Act
        final List<Tirage> tirages = dao.getTirages();

        // Assert
        assertEquals(nombreBouleAttendue, ((Tirage) tirages).getBoule1());
    }

    /**
     * Teste la valeur de la premiere etoile du premier tirage.
     * 
     * 
     * RESULT Premiere etoire : 2
     */
    @Test
    protected void doTestPremiereEtoile(final int nombreEtoileAttendue) {
    	// Act
        final List<Tirage> tirages = dao.getTirages();

        // Assert
        assertEquals(nombreEtoileAttendue, ((Tirage) tirages).getEtoile1());
    }

    @Test
    protected void doTestTailleEntetes(final int tailleAttendue) {
        // Act
        final List<String> entetes = dao.getEntetes();

        // Assert
        assertEquals(tailleAttendue, entetes.size());
    }

    @Test
    protected void doTestPremierEntetes(final String enteteAttendue, final int position) {
    	// Act
        final List<String> entetes = dao.getEntetes();

        // Assert
        assertEquals(enteteAttendue, entetes.get(position));
    }

}