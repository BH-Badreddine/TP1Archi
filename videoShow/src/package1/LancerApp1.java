package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {


	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// création de la fenêtre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// création de la zône de dessin dans la fenêtre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fenêtre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[10];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); 
		d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); 
		d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		
		//dessiner une étoile verte-->Color RGB(0,255,0)
		Etoile e = new Etoile(220,230,16,(float)1.5,new Color(0,255,0),new Color(0,255,0));
		d.ajouterObjet(e);
		//dessiner un polygone noire-->Color RGB(0,0,0)
		PolygoneRegulier p = new PolygoneRegulier(5,350,260,30,(float)1.5,new Color(0,0,0),new Color(0,0,0));
		d.ajouterObjet(p);
		//dessiner une étoile jaune animée par un mvt circulaire
		AnimationForme etoilJAnim = new AnimationForme(new Etoile(100,150,16,(float)2,new Color(255,255,0),new Color(255,255,0)),
				new MvtCirculaire(80,200,80,45.5,20.3));
		d.ajouterObjet(etoilJAnim);
		//dessiner un polygone gris animé par un mvt circulaire
		AnimationForme polyGAnim = new AnimationForme(new PolygoneRegulier(5,350,60,40,(float)2,new Color(128,128,128),new Color(128,128,128)),
				new MvtCirculaire(350,100,80,45.5,20.3));
		d.ajouterObjet(polyGAnim);
		
		
		while(true) {
		// la zone de dessin se réaffiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//réaliser à tous les trains un déplacement élémentaire
		d.animer();
		
		}

	}

}
