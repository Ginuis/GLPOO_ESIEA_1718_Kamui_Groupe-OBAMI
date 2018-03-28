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

	final Logger LOGGER = Logger.getLogger(TirageListPanel.class);
	private JTable table;
	private DynamicModel model;
	private final JButton buttonSelectionner;
	private final JButton buttonAnnuler;
	private JPanel tablePanel;
	private static Tirage tirage;

	public TirageListPanel() {
		
		super();
  		setLayout(null);
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();

		model = new DynamicModel();
		
		tirage = new Tirage(0, 0, 0,	0, 0, 0, 0);

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
					//tirage = new Tirage(0, 0, 0,	0, 0, 0, 0);
					tirage = selectLine();
					//Tirage tirage = new Tirage(selectLine().getBoule1(), selectLine().getBoule2(), selectLine().getBoule3(), selectLine().getBoule4(),
					//		selectLine().getBoule5(), selectLine().getEtoile1(), selectLine().getEtoile2());
					
					LOGGER.info("Tirage a faire passer"+tirage.toString());
					MainFrame.showRosacePanel();
				}
			}
		});

		// Position des button
		buttonSelectionner.setBounds(400, 500, 300, 100);
		buttonAnnuler.setBounds(775, 500, 300, 100);

		imprimerButton.addActionListener(this);

		buttonSelectionner.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					MainFrame.showRosacePanel();
				}
			}
		});

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
	public Tirage selectLine() {
		LOGGER.info("Vous avez cliqué sur un element");
		final int row = table.getSelectedRow();
		LOGGER.info(row);
		LOGGER.info(model.getTirages().get(row));
		return model.getTirages().get(row);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static Tirage getTirage() {
		return tirage;
	}
}
