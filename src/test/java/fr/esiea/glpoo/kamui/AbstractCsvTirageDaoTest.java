package fr.esiea.glpoo.kamui;

import org.apache.log4j.Logger;

import fr.esiea.kamui.dao.CsvTirageDao;

public abstract class AbstractCsvTirageDaoTest implements CsvTirageDao {

	protected CsvTirageDao dao;

	private static final Logger LOGGER = Logger.getLogger(AbstractCsvTirageDaoTest.class);

	private final static String RESOURCES_PATH = "src/test/resources/";
	private final static String TIRAGES_FILE_NAME = "euromillions_4.csv";
	
	// J'écris mes tests

}