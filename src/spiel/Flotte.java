package spiel;

public class Flotte 
{
	private int zerstoerteSchiffe;
	private boolean zerstoert;
	Schiff [] schlachtSchiff = new Schiff [5];
	Schiff [] kreuzer1 = new Schiff [4];
	Schiff [] kreuzer2 = new Schiff [4];
	Schiff [] zerstoerer1 = new Schiff [3];
	Schiff [] zerstoerer2 = new Schiff [3];
	Schiff [] zerstoerer3 = new Schiff [3];
	Schiff [] uBoot1 = new Schiff [2];
	Schiff [] uBoot2 = new Schiff [2];
	Schiff [] uBoot3 = new Schiff [2];
	Schiff [] uBoot4 = new Schiff [2];
	
	public void setZerstoerteSchiffe(int zerstoerteSchiffe)
	{
		this.zerstoerteSchiffe = zerstoerteSchiffe;
	}
	
	public boolean getZerstoert()
	{
		return zerstoert;
	}
	public void setZerstoert (boolean zerstoert)
	{
		this.zerstoert = zerstoert;
	}
	public Schiff getSchiff (Schiff [] schiff, int i)
	{
		return schiff[i];
	}

	public Schiff[] getSchlachtSchiff() {
		return schlachtSchiff;
	}

	public void setSchlachtSchiff(Schiff[] schlachtSchiff) {
		this.schlachtSchiff = schlachtSchiff;
	}

	public Schiff[] getKreuzer1() {
		return kreuzer1;
	}

	public void setKreuzer1(Schiff[] kreuzer1) {
		this.kreuzer1 = kreuzer1;
	}

	public Schiff[] getKreuzer2() {
		return kreuzer2;
	}

	public void setKreuzer2(Schiff[] kreuzer2) {
		this.kreuzer2 = kreuzer2;
	}

	public Schiff[] getZerstoerer1() {
		return zerstoerer1;
	}

	public void setZerstoerer1(Schiff[] zerstoerer1) {
		this.zerstoerer1 = zerstoerer1;
	}

	public Schiff[] getZerstoerer2() {
		return zerstoerer2;
	}

	public void setZerstoerer2(Schiff[] zerstoerer2) {
		this.zerstoerer2 = zerstoerer2;
	}

	public Schiff[] getZerstoerer3() {
		return zerstoerer3;
	}

	public void setZerstoerer3(Schiff[] zerstoerer3) {
		this.zerstoerer3 = zerstoerer3;
	}

	public Schiff[] getuBoot1() {
		return uBoot1;
	}

	public void setuBoot1(Schiff[] uBoot1) {
		this.uBoot1 = uBoot1;
	}

	public Schiff[] getuBoot2() {
		return uBoot2;
	}

	public void setuBoot2(Schiff[] uBoot2) {
		this.uBoot2 = uBoot2;
	}

	public Schiff[] getuBoot3() {
		return uBoot3;
	}

	public void setuBoot3(Schiff[] uBoot3) {
		this.uBoot3 = uBoot3;
	}

	public Schiff[] getuBoot4() {
		return uBoot4;
	}

	public void setuBoot4(Schiff[] uBoot4) {
		this.uBoot4 = uBoot4;
	}

	public int getZerstoerteSchiffe() {
		return zerstoerteSchiffe;
	}
	
}
