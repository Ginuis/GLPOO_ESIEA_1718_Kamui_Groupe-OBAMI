package fr.esiea.kamui.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.esiea.kamui.frame.textDefilant.Banniere;

public class WelcomePanel extends JPanel{
	private JPanel bannierePanel, gifPanel, buttonPanel;
	private JButton nextButton;
	private Banniere banniere;
	
	public WelcomePanel() {
		setLayout(null);
		
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Initialisation
		bannierePanel = new JPanel();
		bannierePanel.setBackground(Color.CYAN);
		gifPanel = new JPanel();
		gifPanel.setBackground(Color.WHITE);
		buttonPanel = new JPanel();
		
		
		nextButton = new JButton("Lancez vous!!!");
		
		banniere = new Banniere("Welcome to Kamui. Genjustu", 300);
		banniere.start();
		
		//Ajout au panel
		add(bannierePanel);
		bannierePanel.setLayout(null);
		add(gifPanel);
		gifPanel.setLayout(null);
		add(buttonPanel);
		buttonPanel.setLayout(null);
		
		buttonPanel.add(nextButton);
		
		bannierePanel.add(banniere);
		
		//Definition des positions
		bannierePanel.setBounds(100, 25, dm.width-200, 150);
		banniere.setBounds(10, 10, dm.width-250, 100);
		
		gifPanel.setBounds(20, 175, dm.width-400, 600);
	}
}