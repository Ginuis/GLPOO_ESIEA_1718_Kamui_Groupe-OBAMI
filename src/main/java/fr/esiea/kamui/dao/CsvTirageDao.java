 package fr.esiea.kamui.dao;

import java.io.File;
import java.util.List;

import fr.esiea.kamui.domain.Tirage;

public interface CsvTirageDao {

	public void init(File file);
	
	public File getFile();
	
	public List<String> getEntetes(); 
	
	public List<Tirage> getTirages();

	public List<Tirage> findAllTirage();

}
