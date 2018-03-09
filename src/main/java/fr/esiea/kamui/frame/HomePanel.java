package fr.esiea.kamui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePanel extends DesignPanel implements ActionListener {

	public HomePanel() {
		super();
		setLayout(null);

		imprimerButton.addActionListener(this);

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
		// TODO Auto-generated method stub

	}

}
