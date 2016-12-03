import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		System.out.println("Alustame pommitamisega!");

		int [][] lauaAlgSeis = new int[9][9];
		int [][] lauaSeis = new int[9][9];

		//uus 9x9 lauaAlgSeis
		//0 - meri
		//1 - laev
		//2 - pihta saanud laev
		//3 - mööda

		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				lauaAlgSeis[i][j] = (int)(Math.random()*1.3);
			}
		}
		prindiLaud(lauaSeis);

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Kuhu tahad pommitada? Formaat: y-x");
			String input = sc.nextLine();
			String[] xy = input.split("-");
			int x = Integer.parseInt(xy[1])-1;
			int y = Integer.parseInt(xy[0])-1;

			int tabamus = lauaAlgSeis[y][x];
			if (tabamus == 1) {
				lauaAlgSeis[y][x] = 2;
				lauaSeis[y][x] = 2;
				System.out.println("Pihtas!");
			} else if (tabamus == 0) {
				System.out.println("Mööda!");
				lauaSeis[y][x] = 3;
			} else if (tabamus == 2 || tabamus==3) {
				System.out.println("Siia sa juba lasid!");
			} else {
				System.out.println("ERROR! Kuidas sa üldse siia said!?");
				break;
			}
			prindiLaud(lauaSeis);
			boolean labi = kasOnMangLabi(lauaAlgSeis);
			if (labi){
				System.out.println("Mäng on läbi!");
				break;
			}
		}
	}

	private static boolean kasOnMangLabi(int[][] laud) {
		for (int i = 0; i <9 ; i++) {
			for (int j = 0; j <9 ; j++) {
				if (laud[j][i]==1){
					return false;
				}
			}
			
		}
		return true;
	}

	public static void prindiLaud(int[][] laud){
		//public - avalikult kättesaadav
		//static - lihtsal moel kättesaadav, ei pea uut objekti kutsuma
		//void - tühjus; tagastab tühjust
		for (int i = 0; i < 9 ; i++) {
			System.out.println(Arrays.toString(laud[i]));
		}
	}
}