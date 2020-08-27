package eisbären;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EisbärController implements ActionListener {

	private GUI g;
	private Model m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		EisbärController c = new EisbärController();
	}
	
	public EisbärController()
	{
		g = new GUI(this);
		g.setVisible(true);
		m = new Model();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Start"))
		{
			String diceText = g.getWürfel();
			if(m.DiceTest(diceText))
			{
				int[] values = m.random();
				g.firstRun(values);
			}
			else
			{
				g.fehler("Bitte gib eine Zahl zwischen 1 und 6 an");
			}
			
		}
		if(e.getActionCommand().equals("Neuer Versuch"))
		{
			String diceText = g.getWürfel();
			if(m.DiceTest(diceText))
			{
				int[] values = m.random();
				g.reRun(values);
			}
			else
			{
				g.fehler("Bitte gib eine Zahl zwischen 1 und 6 an");
			}
		}
		if(e.getActionCommand().equals("Lösen"))
		{
			if(m.eisbärenTest(g.getEisbären()) && m.löcherTest(g.getLöcher()))
			{
				boolean ergb = true;
				String erg ="";
				if(m.richtigEisbären())
				{
					erg+= "Die Anzahl Eisbären ist Korrekt\n";
				}
				else
				{
					erg+= "Die Anzahl Eisbären ist  nicht  Korrekt\n";
					ergb = false;
				}
				if(m.richtigLöcher())
				{
					erg+= "Die Anzahl Löcher ist Korrekt\n";
				}
				else
				{
					erg+= "Die Anzahl Löcher ist  nicht  Korrekt\n";
					ergb = false;
				}
				int[] lsg = m.lösung();
				String lösung = "Die Richtige Menge Eisbären beträgt " + lsg[0] + "\nDie Richtige Menge Löcher beträgt "+ lsg[1];
				g.lösung(erg,ergb,lösung);
			}
			else
			{
				System.out.println(1);
				g.fehler("Bitte geb gültige Integer werte ein.\nAls Kleiner Tipp: Die Anzahl der Eisbären kann 36 nicht übersteigen\n und die anzahl der Löcher kann nicht höher sein als 6");
			}
		}
	}


}
