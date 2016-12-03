import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		System.out.println("Alustame pommitamisega!");

		int [][] laud = new int[9][9];
		//uus 9x9 laud
		//0 - meri
		//1 - laev
		//2 - pihta saanud laev

		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				laud[i][j] = (int)(Math.random()*1.3);
			}
		}

		for (int i = 0; i < 9 ; i++) {
			System.out.println(Arrays.toString(laud[i]));
		}
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Kuhu tahad pommitada? Formaat: y-x");
			String input = sc.nextLine();
			String[] xy = input.split("-");
			int x = Integer.parseInt(xy[1])-1;
			int y = Integer.parseInt(xy[0])-1;

			int tabamus = laud[y][x];
			if (tabamus == 1) {
				laud[y][x] = 2;
				System.out.println("Pihtas!");
			} else if (tabamus == 0) {
				System.out.println("Mööda!");
			} else if (tabamus == 2) {
				System.out.println("Siia sa juba lasid!");
			} else {
				System.out.println("ERROR! Kuidas sa üldse siia said!?");
				break;
			}
		}
		System.out.println("Mäng on läbi!");
	}
}