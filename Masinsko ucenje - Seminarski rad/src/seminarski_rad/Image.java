package seminarski_rad;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Image {

	int[][] matricaPiksela;
    int sirina;
    int visina;
	BufferedImage slika;
	
	public Image() {
		
	}
    
	public Image(String putanja) throws IOException {

		File pathToFile = new File(putanja);
	    slika = ImageIO.read(pathToFile);
		matricaPiksela = MatricaOdSlike(slika);
	}
	
	public int[][] MatricaOdSlike(BufferedImage slika) {
	    sirina = slika.getWidth();
	    visina = slika.getHeight();
	    int[][] pikseli = new int[sirina][visina];
	    for (int i = 0; i < visina; i++) {
	        for (int j = 0; j < sirina; j++) {
	        	Color boja = new Color(slika.getRGB(j, i));		//j raste sa sirinom, dok i reste sa visinom
	        	if(boja.getRed() == 255) boja = new Color(1, 1, 1);
	            pikseli[i][j] = boja.getRed();
	        }
	    }
	    return pikseli;
	}
	
	public void StampanjeMatrice() {
		for (int i = 0; i < sirina; i++) {
	        for (int j = 0; j < visina; j++) {
	            System.out.print(matricaPiksela[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public void PrikazSlike() {
		
		ImageIcon icon=new ImageIcon(slika);
		JFrame frame=new JFrame();
        frame.setSize(sirina,visina+40);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(false);
	}
	
	public void Input() {
		System.out.println("Za prikaz slike u obliku matrice uneti broj 1.\nZa prikaz slike uneti broj 2.");
		Scanner sc = new Scanner(System.in);
		String k = sc.next();
		switch(k) {
		
		case "1" : StampanjeMatrice();
		break;
		
		case "2" : PrikazSlike();
		break;
		
		default : System.out.println("Pogresan broj ste uneli."); 
		Input();
		}
	}
	
	public void SlikaOdMatrice() {
		slika = new BufferedImage(sirina, visina, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < visina; i++) {
	        for (int j = 0; j < sirina; j++) {
	        	Color boja;
	        	if(matricaPiksela[i][j] == 1) {
	        		boja = new Color(255, 255, 255);
	        	}
	        	else {
	        		boja = new Color(0, 0, 0);
	        	}
	        	slika.setRGB(j, i, boja.getRGB());
	        }
	    }
	}
}
