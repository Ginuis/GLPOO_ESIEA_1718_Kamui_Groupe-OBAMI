 package fr.esiea.kamui.dao;

import java.io.File;
import java.util.List;

public interface CsvTirageDao {

	public void init(File file);
	
	public File getFile();
	
	public List<String> getEntetes(); 
}
