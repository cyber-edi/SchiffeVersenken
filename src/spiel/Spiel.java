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
		int versuche1 = 0;
		int versuche2 = 0;
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
			System.out.print("Reihe: ");
			x = zufall.nextInt(10);
			System.out.print("Spalte: ");
			y = zufall.nextInt(10);
			spieler2.checkPosition(x, y);
			spieler2.checkFlotteSp2(flotteSpieler2);
			if (spieler2.flotteZerstoert2 == true)
				break;
			//System.out.println(spieler2.zerstoerteSchiffe2);
			versuche1++;
						
			System.out.println("----------------------------");
			System.out.print("Spieler 2. schießt...");
			x = zufall.nextInt(10);
			y = zufall.nextInt(10);
			System.out.println("in der Reihe: " + x + ". Spalte: " + y);
			spieler1.checkPosition(x, y);
			spieler1.checkFlotteSp1(flotteSpieler1);
			if (spieler1.flotteZerstoert1 == true)
				break;
			//System.out.println(spieler1.zerstoerteSchiffe1);
			spieler1.displaySpielfeld();
			versuche2++;
		}
		if (spieler1.flotteZerstoert1 == true)
			System.out.println("Leider verloren!");
		if (spieler2.flotteZerstoert2 == true)
			System.out.println("Gewonnen!!");
		
	}
	
}
