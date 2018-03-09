package fr.esiea.kamui.dao;

import org.apache.log4j.Logger;

import fr.esiea.kamui.domain.Tirage;

import java.util.List;

public class FinalTirageSingleton {
	final Logger LOGGER = Logger.getLogger(FinalCsvTirageDao.class);

	private static FinalTirageSingleton singleton;
	private FinalCsvTirageDao dao;

	public FinalTirageSingleton() {
		dao = new FinalCsvTirageDao();
	}

	/*
	 * Cette fonction nous permets d'avoir une instance de TirageFunction si elle
	 * n'existe pas déjà
	 */
	public static synchronized FinalTirageSingleton getInstance() {
		if (singleton == null) {
			singleton = new FinalTirageSingleton();
		}
		return singleton;
	}

	public List<Tirage> findAllTirageSingleton(String nomFichier) {
		List<Tirage> tirages = dao.findAllTirage(nomFichier);
		for (Tirage tirage : tirages) {
			LOGGER.info(tirage.toString() + "\n");
		}
		return tirages;
	}

}
