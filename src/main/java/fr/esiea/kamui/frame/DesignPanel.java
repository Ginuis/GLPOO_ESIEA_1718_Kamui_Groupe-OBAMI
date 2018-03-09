package fr.esiea.kamui.frame;

import javax.swing.*;

import fr.esiea.kamui.frame.textDefilant.Banniere;

import java.awt.event.*;
import java.awt.*;

public class DesignPanel extends JPanel  {

	/**
	 *
	 * @author Drumont Errick
	 */
	private JPanel panelHaut, panelBas, panelBanderoleHaut, panelBanderoleBas;
	private JLabel label_1, entete_label_3;
	protected JLabel tirageListLabel, bonusLabel, homeLabel;
	private Font policeCentury, policeCastellar, policeTower;
	private Color Couleur1, Couleur2, Couleur3, Couleur4, Couleur5;
	protected JButton imprimerButton;
	private Banniere banniere;

	public DesignPanel() {

		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();

		setLayout(null);

		policeCentury = new Font("Century Gothic", Font.BOLD, 15);
		policeCastellar = new Font("Castellar", Font.BOLD, 20);
		policeTower = new Font("High Tower Text", Font.BOLD, 20);

		Couleur3 = new Color(255, 113, 113);
		Couleur1 = new Color(109, 193, 218);
		Couleur2 = new Color(134, 232, 205);
		Couleur4 = new Color(240, 240, 240);
		Couleur5 = new Color(162, 162, 162);

		banniere = new Banniere("GLPOO - KAMUI", 40);
		banniere.setFont(policeCastellar);
		banniere.start();

		imprimerButton = new JButton("Imprimer");
		imprimerButton.setFont(policeCentury);

		panelHaut = new JPanel();
		panelHaut.setBackground(Couleur1);
		panelBas = new JPanel();
		panelBas.setBackground(Couleur2);
		panelBanderoleHaut = new JPanel();
		panelBanderoleHaut.setBackground(Color.BLACK);
		panelBanderoleBas = new JPanel();
		panelBanderoleBas.setBackground(Color.GRAY);

		tirageListLabel = new JLabel("Liste des Tirages");
		tirageListLabel.setFont(policeTower);
		bonusLabel = new JLabel("Bonus");
		bonusLabel.setFont(policeTower);
		homeLabel = new JLabel("Accueil");
		homeLabel.setFont(policeTower);

		add(panelHaut);
		panelHaut.setLayout(null);
		add(panelBas);
		panelBas.setLayout(null);
		add(panelBanderoleHaut);
		panelBanderoleHaut.setLayout(null);
		add(panelBanderoleBas);
		panelBanderoleBas.setLayout(null);
		add(banniere);

		panelHaut.add(banniere);

		add(imprimerButton);

		panelBas.add(imprimerButton);

		panelHaut.setBounds(0, 0, dm.width, 80);
		panelBas.setBounds(0, 85, dm.width, 40);
		panelBanderoleHaut.setBounds(0, 80, dm.width, 5);
		panelBanderoleBas.setBounds(0, 125, dm.width, 5);

		imprimerButton.setBounds(1000, 10, 200, 20);
		banniere.setBounds(30, 10, 300, 70);

		add(tirageListLabel);
		add(bonusLabel);
		add(homeLabel);

		panelHaut.add(tirageListLabel);
		panelHaut.add(bonusLabel);
		panelHaut.add(homeLabel);

		homeLabel.setBounds(500,10, 240, 70);
		tirageListLabel.setBounds(700, 10, 240, 70);
		bonusLabel.setBounds(1000, 10, 150, 70);
		

	}

}
