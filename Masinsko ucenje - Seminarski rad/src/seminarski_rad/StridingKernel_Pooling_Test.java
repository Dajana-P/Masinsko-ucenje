package seminarski_rad;

import java.io.IOException;
import java.util.Scanner;
import seminarski_rad.Image;
import seminarski_rad.StridingKernel;
import seminarski_rad.Sublimacija;


public class StridingKernel_Pooling_Test {

	public StridingKernel_Pooling_Test() {
		
	}

	public static void main(String[] args) throws IOException{
		Image slika = new Image();
		String nazivSlike;
		System.out.println("Unesite naziv slike.");
		Scanner sc = new Scanner(System.in);
		while(true) {
			nazivSlike = sc.nextLine();
			try {
				slika = new Image("C:/Users/PD/Desktop/Slike za Masinsko ucenje/" + nazivSlike + ".png");
				break;
			}
			catch(Exception e) {
				System.out.println("Nije pronadjena slika.\nUnesite ponovo.");
			}
		}
		StridingKernel kernel = new StridingKernel();
		slika.Input();
		kernel.UnosDimenzija();
		Image smanjenaSlika = new Image();
		kernel.Pooling(slika, smanjenaSlika);
		smanjenaSlika.SlikaOdMatrice();
		smanjenaSlika.Input();
		Sublimacija.Poruka(nazivSlike);
}
}
 