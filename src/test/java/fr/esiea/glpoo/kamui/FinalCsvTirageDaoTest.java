package fr.esiea.glpoo.kamui;

import java.io.File;
import java.util.List;

import fr.esiea.kamui.dao.FinalCsvTirageDao;
import fr.esiea.kamui.domain.Tirage;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


public class FinalCsvTirageDaoTest extends AbstractCsvTirageDaoTest{
	
	private final static String RESOURCES_PATH = "src/main/resources/";
	private final static String TIRAGES_FILE_PATH = "euromillions_4.csv";
	
	@Before
	public void doBefore() {
		final File file = new File(RESOURCES_PATH + TIRAGES_FILE_PATH);
		dao = new FinalCsvTirageDao();
		dao.init(file);
	}

}
