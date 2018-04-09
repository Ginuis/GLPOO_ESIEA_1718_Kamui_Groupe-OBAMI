package fr.esiea.kamui.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Mise en place de sections accessible par click en evitant les boutons moins 
 * esthétiques 
 */
public class HomePanel extends DesignPanel implements ActionListener {

	private JPanel gifPanel;
	private JLabel gifLabel, instructionLabel;
	String path = "src/main/resources/kamui.GIF";

	public HomePanel() {
		super();
		setLayout(null);
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();

		gifPanel = new JPanel();
		gifPanel.setBackground(Color.RED);
		add(gifPanel);
		gifPanel.setLayout(null);
		gifPanel.setBounds(20, 140, dm.width - 40, 600);

		Icon myImgIcon = new ImageIcon(path);
		gifLabel = new JLabel(myImgIcon);
		// component.add(imageLbl, BorderLayout.CENTER);

		add(gifLabel);
		gifPanel.add(gifLabel);
		gifLabel.setBounds(20, 20, dm.width - 80, 500);

		instructionLabel = new JLabel("Cliquez sur Liste des tirages et selectionner un tirage");
		instructionLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		add(instructionLabel);
		gifPanel.add(instructionLabel);
		instructionLabel.setBounds(400, 530, dm.width - 80, 60);

		imprimerButton.addActionListener(this);

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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
