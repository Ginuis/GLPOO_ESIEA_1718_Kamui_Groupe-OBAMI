package fr.esiea.glpoo.kamui;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import fr.esiea.kamui.dao.CsvTirageDao;
import fr.esiea.kamui.domain.Tirage;

public abstract class AbstractCsvTirageDaoTest {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractCsvTirageDaoTest.class);
	protected CsvTirageDao dao;
	
	@Test
    public void testTailleEntetes() {
		LOGGER.debug("testTailleEntetes Debut");
        // Act
        final List<String> entetes = dao.getEntetes();
        final int tailleAttendue = 75;
        // Assert
        assertEquals(tailleAttendue, entetes.size());
        LOGGER.debug("testTailleEntetes Fin");
    }

    @Test
    public void testPremierEntetes() {
    	LOGGER.debug("testPremierEntetes Debut");
    	// Act
        final List<String> entetes = dao.getEntetes();
        final String enteteAttendue = "annee_numero_de_tirage";
        final int position = 0;
        // Assert
        assertEquals(enteteAttendue, entetes.get(position));
        LOGGER.debug("testPremierEntetes Fin");
    }
    
    @Test
    public void testDeuxiemeEntetes() {
    	LOGGER.debug("testDeuxiemeEntetes Debut");
    	// Act
    	final List<String> entetes = dao.getEntetes();
    	final String enteteAttendue = "jour_de_tirage";
    	final int position = 1;
    	// Assert
    	assertEquals(enteteAttendue, entetes.get(position));
    	LOGGER.debug("testDeuxiemeEntetes Fin");
    }
    
	@Test
	public void testBoule1() throws Exception {
		LOGGER.debug("testBoule1 Debut");
		//Arrange
		final int bouleAttendue = 41;
		// Act
		final List<Tirage> tirages = dao.findAllTirage();
		// Assert
		Assert.assertEquals(bouleAttendue, tirages.get(0).getBoule1());
		LOGGER.debug("testBoule1 Fin");
	}

	@Test
	public void testBoule2() throws Exception {
		LOGGER.debug("testBoule2 Debut");
		//Arrange
		final int bouleAttendue = 6;
		// Act
		final List<Tirage> tirages = dao.findAllTirage();
		// Assert
		Assert.assertEquals(bouleAttendue, tirages.get(0).getBoule2());
		LOGGER.debug("testBoule2 Fin");
	}

	@Test
	public void testBoule3() throws Exception {
		LOGGER.debug("testBoule3 Debut");
		//Arrange
		final int bouleAttendue = 13;
		// Act
		final List<Tirage> tirages = dao.findAllTirage();
		// Assert
		Assert.assertEquals(bouleAttendue, tirages.get(0).getBoule3());
		LOGGER.debug("testBoule3 Fin");
	}

	@Test
	public void testBoule4() throws Exception {
		LOGGER.debug("testBoule4 Debut");
		//Arrange
		final int bouleAttendue = 39;
		// Act
		final List<Tirage> tirages = dao.findAllTirage();
		// Assert
		Assert.assertEquals(bouleAttendue, tirages.get(0).getBoule4());
		LOGGER.debug("testBoule4 Fin");
	}

	@Test
	public void testBoule5() {
		LOGGER.debug("testBoule5 Debut");
		//Arrange
		final int bouleAttendue = 9;
		// Act
		final List<Tirage> tirages = dao.findAllTirage();
		// Assert
		Assert.assertEquals(bouleAttendue, tirages.get(0).getBoule5());
		LOGGER.debug("testBoule5 fin");
	}

	@Test
	public void testEtoile1() throws Exception {
		LOGGER.debug("testEtoile1 Debut");
		//Arrange
		final int etoileAttendue = 2;
		// Act
		final List<Tirage> tirages = dao.findAllTirage();
		// Assert
		Assert.assertEquals(etoileAttendue, tirages.get(0).getEtoile1());
		LOGGER.debug("testEtoile1 fin");
	}

	@Test
	public void testEtoile2() throws Exception {
		LOGGER.debug("testEtoile2 Debut");
		//Arrange
		final int etoileAttendue = 12;
		// Act
		final List<Tirage> tirages = dao.findAllTirage();
		// Assert
		Assert.assertEquals(etoileAttendue, tirages.get(0).getEtoile2());
		LOGGER.debug("testEtoile2 Fin");
}
}
