package fr.esiea.kamui;

import javax.swing.JFrame;

import fr.esiea.kamui.frame.MainFrame;
import fr.esiea.kamui.frame.MainWindows;


public class Launcher {

	public static void main(String[] args) {
		final JFrame frame = new MainWindows();
		frame.setVisible(true);
		final JFrame designFrame = new MainFrame();
		designFrame.setVisible(true);
	}

}
