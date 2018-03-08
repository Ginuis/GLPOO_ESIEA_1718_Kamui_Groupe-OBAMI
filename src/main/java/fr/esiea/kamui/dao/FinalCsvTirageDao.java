package fr.esiea.kamui.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.esiea.kamui.domain.*;

public class FinalCsvTirageDao implements CsvTirageDao {

	final Logger LOGGER = Logger.getLogger(FinalCsvTirageDao.class);

	private final static String SEPARATOR = ";";
	private List<Tirage> tirages;
	private List<String> entetes;
	private File file;

	public FinalCsvTirageDao() {
		tirages = new ArrayList<Tirage>();
	}

	@Override
	public void init(File file) {
		this.file = file;
		reloadTirage();
	}

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public List<String> getEntetes() {
		return entetes;
	}

	/**
	 * Chargerment des Tirages
	 */
	private void reloadTirage() {
		LOGGER.debug("findAllChiens");

		if (file == null) {
			throw new IllegalStateException("Le fichier est nul...");
		}

		throw new UnsupportedOperationException("Bientot...");

	}

	/**
	 * Pour recupérer les lignes du fichier .csv
	 * 
	 * @return lignes
	 * @throws IOException
	 */
	private List<String> getLinesFromFile(File fichier) throws IOException {
		List<String> lignes = new ArrayList<String>();

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fichier);
			br = new BufferedReader(fr);
			for (String ligne = br.readLine(); ligne != null; ligne = br.readLine()) {
				ligne = ligne.trim(); // on retire les espaces

				if (ligne.startsWith("#")) { // si cette ligne est en commentaire
					continue;
				}
				if (ligne.isEmpty()) { // si c'est une ligne vide
					continue;
				}

				lignes.add(ligne);
			}
			entetes(lignes.get(0)); // On récupère les entetes avant de les
			lignes.remove(0); // effacer du contenu du tableau
		} catch (

		IOException e) {
			LOGGER.error("Lecture impossible", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					LOGGER.error("Fermeture impossible", e);
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					LOGGER.error("Fermeture impossible", e);
				}
			}
		}

		return lignes;
	}

	/**
	 * Transforme les lignes recupérer dans le csv et les transformes en objet
	 * tirage
	 * 
	 * @param line
	 * @return tirage
	 */
	private Tirage lineToTirage(String line) {
		final String[] tabTirage = line.split(";");
		final int b1 = Integer.parseInt(tabTirage[5]);
		final int b2 = Integer.parseInt(tabTirage[6]);
		final int b3 = Integer.parseInt(tabTirage[7]);
		final int b4 = Integer.parseInt(tabTirage[8]);
		final int b5 = Integer.parseInt(tabTirage[9]);
		final int e1 = Integer.parseInt(tabTirage[10]);
		final int e2 = Integer.parseInt(tabTirage[11]);

		Tirage tirage = new Tirage(b1, b2, b3, b4, b5, e1, e2);
		return tirage;
	}

	/**
	 * Pour les entetes
	 * 
	 * @param entetes
	 */
	private void entetes(String entetes) {
		String[] tabEntetes = entetes.split(SEPARATOR);
		this.entetes = new ArrayList<String>(tabEntetes.length);
		for (String entete : tabEntetes) {
			this.entetes.add(entete);
		}
	}

	/**
	 * 
	 * @param nomFichier
	 * @return
	 */
	public List<Tirage> findAllTirage(String nomFichier) {
		File fichier = new File(nomFichier);

		List<String> lignes = null;

		try {
			lignes = getLinesFromFile(fichier);
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}

		tirages = new ArrayList<Tirage>(lignes.size());

		for (String ligne : lignes) {

			final Tirage tirage = lineToTirage(ligne);
			tirages.add(tirage);
		}
		return tirages;
	}

	public List<Tirage> getTirages() {
		return tirages;
	}

}
