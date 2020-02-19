package spiel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Spielfeld 
{
	//Felder Matrix zum speichern der einzelnen Felder (Wasser o. Schiff)
	Feld [][] spielfeld = new Feld [10][10];
	//Feld Wasser
	Wasser wasser;
	//Koordinaten Matrix für die Auswertung der Geschosse
	Koordinaten[][] koordinaten = new Koordinaten[10][10];
	//Boolean Kompass: False = Horizontal, True = Vertikal. 
	//Boolean besetzt ob ein Feld mit Schiff besetzt ist. 
	boolean kompass, besetzt;
	//X, Y Koordinaten
	int x, y;
	//int zerstoerteSchiffe1 = 0;
	//int zerstoerteSchiffe2 = 0;
	boolean flotteZerstoert1 = false;
	boolean flotteZerstoert2 = false;
	
	Random zufall = new Random ();
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	Scanner eingabe = new Scanner (System.in);
	
	public void displayGegner ()
	{
		System.out.println("#. [0][1][2][3][4][5][6][7][8][9]");
		for (int i = 0; i < spielfeld.length; i++)
		{
			System.out.print(i + ". ");
			for (int j = 0; j < spielfeld.length; j++)
			{
				System.out.print("[" + koordinaten[i][j] + "]");
			}
			System.out.println();
		}
		System.out.println();
	}
	public void setWasser ()
	{
		for (int i = 0; i < spielfeld.length; i++)
		{
			for (int j = 0; j < spielfeld.length; j++)
			{
				spielfeld[i][j] = new Wasser();
				koordinaten[i][j] = new Koordinaten(i, j);
			}
		}
	}
	public void displaySpielfeld ()
	{
		for (int i = 0; i < spielfeld.length; i++)
		{
			System.out.print(i + ". ");
			for (int j = 0; j < spielfeld.length; j++)
			{
				System.out.print("[" + spielfeld[i][j] + "]");
			}
			System.out.println();
		}
		System.out.println();
	}
	public void checkSchiffSp1 (Schiff [] schiff)
	{
		int schaden = 0;
		for (int i = 0; i < schiff.length; i++)
		{
			if (schiff[i].getSchaden() == true)
				schaden++;
		}
		if (schiff.length == schaden)
		{
			for (int i = 0; i < schiff.length; i++)
			{
				schiff[i].setZerstoert(true);
			}
			System.out.println(schiff[0].getTyp() + " ist zerstört!");
			//zerstoerteSchiffe++;
			//zerstoerteSchiffe1++;
		}
	}
	public void checkSchiffSp2 (Schiff [] schiff)
	{
		int schaden = 0;
		for (int i = 0; i < schiff.length; i++)
		{
			if (schiff[i].getSchaden() == true)
				schaden++;
		}
		if (schiff.length == schaden)
		{
			for (int i = 0; i < schiff.length; i++)
			{
				schiff[i].setZerstoert(true);
				
			}
			System.out.println(schiff[0].getTyp() + " ist zerstört!");
			//zerstoerteSchiffe++;
			//zerstoerteSchiffe2++;
		}
		
	}
	
	public boolean checkFlotteSp2 (Flotte2 flotte)
	{		
		checkSchiffSp2(flotte.kreuzer1);
		checkSchiffSp2(flotte.kreuzer2);
		checkSchiffSp2(flotte.schlachtSchiff);
		checkSchiffSp2(flotte.uBoot1);
		checkSchiffSp2(flotte.uBoot2);
		checkSchiffSp2(flotte.uBoot3);
		checkSchiffSp2(flotte.uBoot4);
		checkSchiffSp2(flotte.zerstoerer1);
		checkSchiffSp2(flotte.zerstoerer2);
		checkSchiffSp2(flotte.zerstoerer3);
		
		if (flotte.kreuzer1[0].getZerstoert() == true &&
				flotte.kreuzer2[0].getZerstoert() == true &&
				flotte.schlachtSchiff[0].getZerstoert() == true &&
				flotte.uBoot1[0].getZerstoert() == true &&
				flotte.uBoot2[0].getZerstoert() == true &&
				flotte.uBoot3[0].getZerstoert() == true &&
				flotte.uBoot4[0].getZerstoert() == true &&
				flotte.zerstoerer1[0].getZerstoert() == true &&
				flotte.zerstoerer2[0].getZerstoert() == true &&
				flotte.zerstoerer3[0].getZerstoert() == true)
		{
			flotteZerstoert2 = true;
		}
		return flotteZerstoert2;
	}
	public boolean checkFlotteSp1 (Flotte flotte)
	{		
		checkSchiffSp1(flotte.kreuzer1);
		checkSchiffSp1(flotte.kreuzer2);
		checkSchiffSp1(flotte.schlachtSchiff);
		checkSchiffSp1(flotte.uBoot1);
		checkSchiffSp1(flotte.uBoot2);
		checkSchiffSp1(flotte.uBoot3);
		checkSchiffSp1(flotte.uBoot4);
		checkSchiffSp1(flotte.zerstoerer1);
		checkSchiffSp1(flotte.zerstoerer2);
		checkSchiffSp1(flotte.zerstoerer3);
		
		if (flotte.kreuzer1[0].getZerstoert() == true &&
				flotte.kreuzer2[0].getZerstoert() == true &&
				flotte.schlachtSchiff[0].getZerstoert() == true &&
				flotte.uBoot1[0].getZerstoert() == true &&
				flotte.uBoot2[0].getZerstoert() == true &&
				flotte.uBoot3[0].getZerstoert() == true &&
				flotte.uBoot4[0].getZerstoert() == true &&
				flotte.zerstoerer1[0].getZerstoert() == true &&
				flotte.zerstoerer2[0].getZerstoert() == true &&
				flotte.zerstoerer3[0].getZerstoert() == true)
		{
			flotteZerstoert1 = true;
		}
		return flotteZerstoert1;
	}
	public void checkPosition (int x, int y)
	{
		if (spielfeld[x][y].getClass().equals(Wasser.class))
		{
			spielfeld[x][y].setAnvisiert(true);
			System.out.println("Leider nur Wasser getroffen");
			koordinaten[x][y].setAnvisiert(true);
			//koordinaten[x][y].setGetroffen(false);
		}
		else
		{
			spielfeld[x][y].setSchaden(true);
			System.out.println("Volltreffer!");
			koordinaten[x][y].setGetroffen(true);
			//spielfeld[x][y].getClass().isInstance(Schiff.class)
		}
	}
	public boolean checkBesetzt (int x, int y, int l, boolean kompass)
	{
		if (kompass == false)
		{
			for (int i = 0; i < l; i++)
			{
				if (spielfeld[x][y + i].getClass().equals(Wasser.class))
					besetzt = false;
				else
				{
					besetzt = true;
					break;
				}
			}			
		}
		else
		{
			for (int i = 0; i < l; i++)
			{
				if (spielfeld[x + i][y].getClass().equals(Wasser.class))
					besetzt = false;
				else
				{
					besetzt = true;
					break;
				}
			}
		}
		return besetzt;
	}
	public void setSchiff (Schiff [] schiff, String typ, int l)
	{
		do
		{
			System.out.println("\nEingabe Position " + typ + "\n");
			checkKompass ();
			System.out.print("\nReihe: ");
			x = eingabe.nextInt();
			System.out.print("Spalte: ");
			y = eingabe.nextInt();
			checkBesetzt(x, y, schiff.length, kompass);
			if (besetzt == true)
				System.out.println("Platz schon besetzt!");
		}
		while (besetzt == true);
			
		if (besetzt == false)
		{
			if (kompass == false)
				{
					for (int i = 0; i < schiff.length; i++)
					{
						schiff[i] = new Schiff (typ, schiff.length);
						spielfeld[x][y + i] = schiff[i];
					}
				}
				else
				{
					for (int i = 0; i < schiff.length; i++)
					{
						schiff[i] = new Schiff (typ, schiff.length);
						spielfeld[x + i][y] = schiff[i];
					}
				}
			System.out.println("Schiff " + typ + " wurde platziert!");
			}		
	}
	public boolean checkKompass ()
	{
		String horizontal = "h";
		String input;
		System.out.print("Kompass\tHorizontal = h\tVertikal = v\nEingabe: ");
		try
		{
			input = br.readLine();
			if (input.equals(horizontal))
				kompass = false;
			else
				kompass = true;
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return kompass;
	}
	public void setRandomSchiff (Schiff [] schiff, String typ, int l)
	{
		do
		{
			kompass = zufall.nextBoolean();
			if (kompass == false)
			{
				x = zufall.nextInt(10);
				y = zufall.nextInt(10 - l);
				checkBesetzt (x, y, l, kompass);
				if (besetzt == false)
				{
					for (int i = 0; i < l; i++)
					{
						schiff[i] = new Schiff (typ, l);
						spielfeld[x][y + i] = schiff[i];
					}
				}				
			}
			else
			{
				x = zufall.nextInt(10 - l);
				y = zufall.nextInt(10);
				checkBesetzt(x, y, l, kompass);
				if (besetzt == false)
				{
					for (int i = 0; i < l; i++)
					{
						schiff[i] = new Schiff (typ, l);
						spielfeld[x + i][y] = schiff[i];
					}
				}
			}
		}
		while (besetzt == true);
	}
	public void setRandomSpielfeld (Flotte flotte)
	{
		setRandomSchiff(flotte.schlachtSchiff, "Schlachtschiff", flotte.schlachtSchiff.length);
		setRandomSchiff(flotte.kreuzer1, "Kreuzer I", flotte.kreuzer1.length);
		setRandomSchiff(flotte.kreuzer2, "Kreuzer II", flotte.kreuzer2.length);
		setRandomSchiff(flotte.zerstoerer1, "Zerstörer I", flotte.zerstoerer1.length);
		setRandomSchiff(flotte.zerstoerer2, "Zerstörer II", flotte.zerstoerer2.length);
		setRandomSchiff(flotte.zerstoerer3, "Zerstörer III", flotte.zerstoerer3.length);
		setRandomSchiff(flotte.uBoot1, "U-Boot I", flotte.uBoot1.length);
		setRandomSchiff(flotte.uBoot2, "U-Boot II", flotte.uBoot2.length);
		setRandomSchiff(flotte.uBoot3, "U-Boot III", flotte.uBoot3.length);
		setRandomSchiff(flotte.uBoot4, "U-Boot IV", flotte.uBoot4.length);
	}
	public void setRandomSpielfeld2 (Flotte2 flotte)
	{
		setRandomSchiff(flotte.schlachtSchiff, "Schlachtschiff", flotte.schlachtSchiff.length);
		setRandomSchiff(flotte.kreuzer1, "Kreuzer I", flotte.kreuzer1.length);
		setRandomSchiff(flotte.kreuzer2, "Kreuzer II", flotte.kreuzer2.length);
		setRandomSchiff(flotte.zerstoerer1, "Zerstörer I", flotte.zerstoerer1.length);
		setRandomSchiff(flotte.zerstoerer2, "Zerstörer II", flotte.zerstoerer2.length);
		setRandomSchiff(flotte.zerstoerer3, "Zerstörer III", flotte.zerstoerer3.length);
		setRandomSchiff(flotte.uBoot1, "U-Boot I", flotte.uBoot1.length);
		setRandomSchiff(flotte.uBoot2, "U-Boot II", flotte.uBoot2.length);
		setRandomSchiff(flotte.uBoot3, "U-Boot III", flotte.uBoot3.length);
		setRandomSchiff(flotte.uBoot4, "U-Boot IV", flotte.uBoot4.length);
	}
	public void setSpielfeld (Flotte flotte)
	{
		setSchiff(flotte.schlachtSchiff, "Schlachtschiff", flotte.schlachtSchiff.length);
		displaySpielfeld();
		setSchiff(flotte.kreuzer1, "Kreuzer I", flotte.kreuzer1.length);
		displaySpielfeld();
		setSchiff(flotte.kreuzer2, "Kreuzer II", flotte.kreuzer2.length);
		displaySpielfeld();
		setSchiff(flotte.zerstoerer1, "Zerstörer I", flotte.zerstoerer1.length);
		displaySpielfeld();
		setSchiff(flotte.zerstoerer2, "Zerstörer II", flotte.zerstoerer2.length);
		displaySpielfeld();
		setSchiff(flotte.zerstoerer3, "Zerstörer III", flotte.zerstoerer3.length);
		displaySpielfeld();
		setSchiff(flotte.uBoot1, "U-Boot I", flotte.uBoot1.length);
		displaySpielfeld();
		setSchiff(flotte.uBoot2, "U-Boot II", flotte.uBoot2.length);
		displaySpielfeld();
		setSchiff(flotte.uBoot3, "U-Boot III", flotte.uBoot3.length);
		displaySpielfeld();
		setSchiff(flotte.uBoot4, "U-Boot IV", flotte.uBoot4.length);
		System.out.println("Flotte platziert!");
	}
	
} 
