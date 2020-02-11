package spiel;

public class Feld
{
	Schiff schiff;
	private boolean anvisiert;
	private boolean schaden;
	
	Feld ()
	{
		
	}
	public void setAnvisiert (boolean anvisiert)
	{
		this.anvisiert = true;
	}
	
	public void setSchaden (boolean schaden)
	{
		schiff.setSchaden(true);
		this.schaden = schaden;
	}
	public Schiff getSchiff ()
	{
		return schiff;
	}
}	