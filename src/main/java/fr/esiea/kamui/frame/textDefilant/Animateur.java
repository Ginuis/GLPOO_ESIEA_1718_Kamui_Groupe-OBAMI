package fr.esiea.kamui.frame.textDefilant;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drumont Errick
 */

  public class Animateur extends Thread {

	public Banniere banniere_1;
	private boolean actif=true;

	public Animateur(Banniere banniere_1){
		this.banniere_1=banniere_1;
	}

	@Override
	public void run(){
		while(actif){
			try {
				Thread.sleep(100);
				banniere_1.avancer();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

  
}
