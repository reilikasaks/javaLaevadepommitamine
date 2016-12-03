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

		int count1 = 0;
		int count2 = 0;
		while (count1<9){
			count2=0;
			//vahepeal peab counti ära nullima, muidu ta teisel korral
			//ei käivita sisemist tsüklit (sest count2=9)
			while (count2<9){
				laud[count1][count2] = (int)(Math.random()*1.3);
				count2++;
			}
			count1++;
		}

		int count3=0;
		while (count3<9){
			System.out.println(Arrays.toString(laud[count3]));
			count3++;
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