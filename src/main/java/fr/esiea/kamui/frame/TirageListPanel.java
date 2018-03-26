package fr.esiea.kamui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.log4j.Logger;

import fr.esiea.kamui.dao.FinalCsvTirageDao;
import fr.esiea.kamui.domain.Tirage;
import fr.esiea.kamui.modelTable.DynamicModel;

public class TirageListPanel extends DesignPanel implements ActionListener {

	final Logger LOGGER = Logger.getLogger(FinalCsvTirageDao.class);
	private JTable table;
	private DynamicModel model;
	private final JButton buttonSelectionner;
	private final JButton buttonAnnuler;
	private FinalCsvTirageDao dao;
	private String nomFichierAcces = "src/main/resources/euromillions_4.csv";
	private JPanel tablePanel;

	public TirageListPanel() {

		super();
		setLayout(null);
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();

		model = new DynamicModel();

		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		JScrollPane jsp = new JScrollPane(table);

		tablePanel = new JPanel();

		tablePanel.setBackground(Color.WHITE);
		add(tablePanel);
		tablePanel.setLayout(null);
		tablePanel.setBounds(10, 140, dm.width - 20, 600);

		tablePanel.add(jsp);
		tablePanel.add(table.getTableHeader());

		jsp.setBounds(0, 50, dm.width - 20, 450);
		table.setBounds(0, 0, dm.width - 20, 50);

		ImageIcon imgSelectionner = new ImageIcon("src/main/resources/buttonSelectionner.png");
		ImageIcon imgAnnuler = new ImageIcon("src/main/resources/buttonAnnuler.png");
		buttonSelectionner = new JButton();
		buttonAnnuler = new JButton();
		buttonSelectionner.setIcon(imgSelectionner);
		buttonAnnuler.setIcon(imgAnnuler);
		tablePanel.add(buttonSelectionner);
		tablePanel.add(buttonAnnuler);

		// Mouse listener sur le tableau
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					selectLine();
				}
			}
		});

		// Position des button
		buttonSelectionner.setBounds(400, 500, 300, 100);
		buttonAnnuler.setBounds(775, 500, 300, 100);

		imprimerButton.addActionListener(this);

		// Action du menu graphique
		homeLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MainFrame.showHomePanel();
			}
		});

		tirageListLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MainFrame.showTirageListPanel();
			}
		});

		bonusLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Todo
			}
		});
	}

	// Selection d'une ligne du tableau
	public void selectLine() {
		LOGGER.info("Vous avez cliqué sur un element");
		final int[] rows = table.getSelectedRows();
		int boule1s[] = null;
		//int boule2s[] = null;
		//int boule3s[] = null;
		//int boule4s[] = null;
		//int boule5s[] = null;
		/*
		 * je l'utiliserais pour savoir quelles sont lignes qui ont été selectionné pour
		 * le tirage for (int i = rows.length - 1; 0 < i; i--) {
		 * 
		 * }
		 */
		LOGGER.info(rows[0]);
		
		if (rows.length != 0) {
			dao = new FinalCsvTirageDao();

			for (int i = 0; i <= rows.length; i++) {
				boule1s[i] = dao.findAllTirage(nomFichierAcces).get(rows[i]).getBoule1();
				//boule2s[i] = dao.findAllTirage(nomFichierAcces).get(rows[i]).getBoule2();
				//boule3s[i] = dao.findAllTirage(nomFichierAcces).get(rows[i]).getBoule3();
				//boule4s[i] = dao.findAllTirage(nomFichierAcces).get(rows[i]).getBoule4();
				//boule5s[i] = dao.findAllTirage(nomFichierAcces).get(rows[i]).getBoule5();

			}
			LOGGER.info(boule1s);
			//LOGGER.info("Les boules selectionnées sont : [" + boule1s + " " + boule2s + " " + boule3s + " " + boule4s
			//		+ " " + boule5s + "]");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
