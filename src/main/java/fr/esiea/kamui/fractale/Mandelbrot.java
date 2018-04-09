package fr.esiea.kamui.fractale;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import org.apache.log4j.Logger;

import fr.esiea.kamui.frame.RosacePanel;

public class Mandelbrot extends JPanel {
	
	final Logger LOGGER = Logger.getLogger(Mandelbrot.class);
	private int maxIter;
	private int valeur1, valeur2, valeur3;
	
	public Mandelbrot(int maxIter, int valeur1, int valeur2, int valeur3) {
		this.maxIter = maxIter;
		this.valeur1 = valeur1;
		this.valeur2 = valeur2;
		this.valeur3 = valeur3;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension d = getSize();
		int x;
		int y;
		int it;
		double r, i;
		double cr, ci;
		double tr, ti;

		int color_r;
		int color_g;
		int color_b;
		
		LOGGER.info(valeur1+" "+valeur2+" "+valeur3);

		// Make a loop on all the pixels in the panel
		for (x = 0; x < d.width; ++x) {
			for (y = 0; y < d.height; ++y) {

				// Pixel scaling: map a 4x4 area with (0,0) at the center
				cr = ((double) x - d.width / 2) / d.width * 4;
				ci = -((double) y - d.height / 2) / d.height * 4;

				// For the Mandelbrot set, we start fixing C=
				r = 0;
				i = 0;
				for (it = 0; it < maxIter; ++it) {
					// Z=Z*Z+C
					tr = r * r - i * i + cr;
					ti = 2 * r * i + ci;
					r = tr;
					i = ti;

					// If the distance of the point is greater than 2, exit
					if (r * r + i * i > 4)
						break;
				}

				// We artificially boost colors
				it = (int) (maxIter * Math.sqrt((double) it / maxIter));
				
				
				color_r = 255 - it * 255 / valeur1 / maxIter;
				color_g = 255 - it * 255 / valeur3 / maxIter;
				color_b = 255 - it * 255 / valeur2 / maxIter;

				// Plot the point
				g.setColor(new Color(color_r, color_g, color_b));

				g.drawLine(x, y, x, y);
			}
		}
	}

	public int getMaxIter() {
		return maxIter;
	}

	public void setMaxIter(int maxIter) {
		this.maxIter = maxIter;
	}

}
