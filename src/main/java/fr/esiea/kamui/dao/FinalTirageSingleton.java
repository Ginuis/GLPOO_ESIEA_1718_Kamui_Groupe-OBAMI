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
	 * Cette fonction nous permet d'avoir une instance de TirageFunction si elle
	 * n'existe pas déjà
	 */
	/**
	 * 
	 * @return singleton
	 */
	public static synchronized FinalTirageSingleton getInstance() {
		if (singleton == null) {
			singleton = new FinalTirageSingleton();
		}
		return singleton;
	}

<<<<<<< HEAD
	/*
	 * Cette fonction nous permet de trouver les tirages en singleton 
	 * afin de restreindre l'instanciation d'une classe à un seul objet (à revoir)
	 */
	
=======
	/**
	 * 
	 * @param nomFichier
	 * @return tirages
	 */
>>>>>>> 828c5a37766ff56b2cc135df778552219f3ae7fb
	public List<Tirage> findAllTirageSingleton(String nomFichier) {
		List<Tirage> tirages = dao.findAllTirage(nomFichier);
		for (Tirage tirage : tirages) {
			LOGGER.info(tirage.toString() + "\n");
		}
		return tirages;
	}

}
