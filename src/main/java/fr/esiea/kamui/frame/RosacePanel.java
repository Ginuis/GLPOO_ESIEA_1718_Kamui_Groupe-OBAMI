package fr.esiea.kamui.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class RosacePanel extends DesignPanel implements ActionListener{

	private JPanel displayPanel;
	private JLabel tirageLabel;
	private JButton buttonGenerate;
	static String text;
	final Logger LOGGER = Logger.getLogger(RosacePanel.class);

	public RosacePanel() {
		super();
		setLayout(null);
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		
		text = TirageListPanel.getTirage().toString();
		LOGGER.info(text);
		
		tirageLabel = new JLabel();
		add(tirageLabel);
		
		buttonGenerate = new JButton("Generate");
		add(buttonGenerate);
		buttonGenerate.addActionListener(this);
 
		displayPanel = new JPanel();

		displayPanel.setBackground(Color.WHITE);
		add(displayPanel);
		displayPanel.setLayout(null);
		displayPanel.setBounds(20, 140, dm.width - 40, 600);
		
		
		displayPanel.add(buttonGenerate);
		displayPanel.add(tirageLabel);
		buttonGenerate.setBounds(40, 40, 400, 50);
		tirageLabel.setBounds(20, 100, 400, 50);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonGenerate) {
			text = TirageListPanel.getTirage().toString();
			LOGGER.info("Le tirage de ce coté est:"+text);
			tirageLabel.setText(text);
		}
		
	}
}
