package spiel;

import java.util.Scanner;
import java.util.Random;

public class Spiel 
{
	public static void main (String [] args)
	{
		Random zufall = new Random ();
		Scanner eingabe = new Scanner (System.in);
		int x, y;
		int versuche1 = 1;
		int versuche2 = 1;
		Flotte flotteSpieler1 = new Flotte ();
		Flotte2 flotteSpieler2 = new Flotte2 ();
		Spielfeld spieler1 = new Spielfeld();
		Spielfeld spieler2 = new Spielfeld();
		spieler1.setWasser();
		spieler1.setRandomSpielfeld(flotteSpieler1);
		spieler2.setWasser();
		spieler2.setRandomSpielfeld2(flotteSpieler2);
		
		while (spieler1.flotteZerstoert1 == false || 
				spieler2.flotteZerstoert2 == false)
		{
			System.out.println(versuche1 + ". Versuch ");
			spieler2.displayGegner();
			System.out.println("Spieler 1. schießt...");
			
			do
			{				
				do
				{
					System.out.print("Reihe: ");
					x = eingabe.nextInt(10);
				}
				while (x < 0 || x > 9);
				do
				{
					System.out.print("Spalte: ");
					y = eingabe.nextInt(10);
				}
				while (y < 0 || y > 9);
			}
			while (spieler2.koordinaten[x][y].isAnvisiert() ==true ||
					spieler2.koordinaten[x][y].isGetroffen() == true);
			
			spieler2.checkPosition(x, y);
			spieler2.checkFlotteSp2(flotteSpieler2);
			if (spieler2.flotteZerstoert2 == true)
				break;
			//System.out.println(spieler2.zerstoerteSchiffe2);
			versuche1++;
						
			
			System.out.println("----------------------------");
			System.out.print("Spieler 2. schießt...");
			do
			{
				x = zufall.nextInt(10);
				y = zufall.nextInt(10);				
			}
			while (spieler1.koordinaten[x][y].isAnvisiert() == true ||
					spieler1.koordinaten[x][y].isGetroffen() == true);
			
			spieler1.checkPosition(x, y);
			System.out.println("in der Reihe: " + x + ". Spalte: " + y);
				
			spieler1.checkFlotteSp1(flotteSpieler1);
			if (spieler1.flotteZerstoert1 == true)
				break;
			//System.out.println(spieler1.zerstoerteSchiffe1);
			spieler1.displaySpielfeld();
			versuche2++;
		}
		if (spieler1.flotteZerstoert1 == true)
			System.out.println("Leider verloren!\n In " + versuche2 + " Versuchen.");
		if (spieler2.flotteZerstoert2 == true)
			System.out.println("Gewonnen!!!\n In " + versuche1 + " Versuchen.");
		
	}
	
}
