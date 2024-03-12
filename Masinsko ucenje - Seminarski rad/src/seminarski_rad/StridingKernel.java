package seminarski_rad;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

import seminarski_rad.Image;

public class StridingKernel {

	public int N;
	public int Stride;
	
	public StridingKernel() {

	}
	
	public void UnosDimenzija() { 
	System.out.println("Unesite velicinu kernela.");
	Scanner sc= new Scanner(System.in); 
	N = sc.nextInt();
	Stride = N;
	}
	
	public void Pooling(Image slika, Image rezultujucaSlika) {
		int[][] Kernel = new int[N][N];
		int sVisina = (int) Math.ceil((double)slika.visina/N);
		int sSirina = (int) Math.ceil((double)slika.sirina/N);
		int[][] SmanjenaMatrica = new int[sVisina][sSirina];
		   
		for(int i = 0, a = 0; i < slika.visina; i = i+Stride, a++) {
			for(int j = 0, b = 0; j < slika.sirina; j = j+Stride, b++) {
				//Petlje za prolazak kroz Kernel
				for(int x = 0; x < N; x++) {
					for(int y = 0; y < N; y++) {
						if(i+x >= slika.visina || j+y >= slika.sirina) {
							Kernel[x][y] = 1;
						}
						else {
						Kernel[x][y] = slika.matricaPiksela[i+x][j+y];
						}
					}
				}
				SmanjenaMatrica[a][b] = MinVrednostKernela(Kernel);
			}
		}
		rezultujucaSlika.matricaPiksela = SmanjenaMatrica;
		rezultujucaSlika.sirina = sSirina;
		rezultujucaSlika.visina = sVisina;
	}
	
	public int MinVrednostKernela(int[][] matrica) {
		int MIN = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				  if(matrica[i][j] < MIN) {
					  MIN = matrica[i][j];
				  }
			}
		}
		return MIN;
	}
}