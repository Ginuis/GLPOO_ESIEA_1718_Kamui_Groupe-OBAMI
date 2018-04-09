package fr.esiea.glpoo.kamui;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.kamui.dao.CsvTirageDao;
import fr.esiea.kamui.domain.Tirage;

public abstract class AppTest implements CsvTirageDao{
	
	protected static CsvTirageDao dao;

	private static final Logger LOGGER = Logger.getLogger(AbstractCsvTirageDaoTest.class);

	private final static String RESOURCES_PATH = "src/test/resources/";
	private final static String TIRAGES_FILE_NAME = "euromillions_4.csv";

	/*
	@Before
    public void doBefore() {
        LOGGER.debug("doBefore Debut");

        final File file = new File(RESOURCES_PATH + TIRAGES_FILE_NAME);
        dao.init(file);

        LOGGER.debug("doBefore Fin");
    }*/
	
	// J'écris mes tests
	
	/**
     * Teste la valeur de la premiere boule du premier tirage
     * 
     * RESULT Premiere boule : 41
     */
    @Test
    public void doTestPremiereBoule() {
    	// Act
        final List<Tirage> tirages = dao.getTirages();
        final int nombreBouleAttendue = 41;

        // Assert
        assertEquals(nombreBouleAttendue, ((Tirage) tirages).getBoule1());
    }

    /**
     * Teste la valeur de la premiere etoile du premier tirage.
     * 
     * 
     * RESULT Premiere etoile : 2
     */
    @Test
    public void doTestPremiereEtoile() {
    	// Act
        final List<Tirage> tirages = dao.getTirages();
        final int nombreEtoileAttendue = 2;
        // Assert
        assertEquals(nombreEtoileAttendue, ((Tirage) tirages).getEtoile1());
    }

    @Test
    public void doTestTailleEntetes() {
        // Act
        final List<String> entetes = dao.getEntetes();
        final int tailleAttendue = 75;
        // Assert
        assertEquals(tailleAttendue, entetes.size());
    }

    @Test
    public void doTestPremierEntetes() {
    	// Act
        final List<String> entetes = dao.getEntetes();
        final String enteteAttendue = "annee_numero_de_tirage";
        final int position = 0;
        // Assert
        assertEquals(enteteAttendue, entetes.get(position));
    }

}
