package fr.esiea.kamui.frame;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame{ 

	     protected JMenuBar barreMenus;
	     protected JMenu Fichier,Rapport;
	     protected JMenuItem Ajouter,Modifier,Supprimer,Deconnexion,Imprimer;
	     protected static Container contenue;
	     protected static CardLayout Card;
	     protected HomePanel homePanel;
	     
	    public MainFrame() {
	        setTitle("GLPOO - KAMUI");
	        Toolkit tk = Toolkit.getDefaultToolkit();
	        Dimension dm = tk.getScreenSize();
	        setSize(dm.width,dm.height);
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        barreMenus = new JMenuBar();
	        setJMenuBar(barreMenus);
	        
	        Fichier = new JMenu("Fichier");
	        barreMenus.add(Fichier);
	        
	        Ajouter = new JMenuItem("Ajouter");
	        Fichier.add(Ajouter);
	        Modifier = new JMenuItem("Modifier");
	        Fichier.add(Modifier);
	        Supprimer = new JMenuItem("Supprimer");
	        Fichier.add(Supprimer);
	        Deconnexion = new JMenuItem("Deconnexion");
	        Fichier.add(Deconnexion);
	        	       
	        Rapport = new JMenu("Rapport");
	        barreMenus.add(Rapport);
	        
	        Imprimer = new JMenuItem("Imprimer");
	        Rapport.add(Imprimer);
	      
	        contenue = getContentPane();
	        Card = new CardLayout();
	        contenue.setLayout(Card);
	        	       
	        homePanel = new HomePanel();	        
	        
	        contenue.add(homePanel,"homePanel");
	       
	        
	    }
	    public static void suivant()
	    {
	        Card.next(contenue);
	    }
	    public static void precedent()
	    {
	        Card.last(contenue);
	    }
	    public static void showHomePanel()
	    {
	        Card.show(contenue,"homePanel");
	    }
	    

}
