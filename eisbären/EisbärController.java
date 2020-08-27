package eisb�ren;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eisb�rController implements ActionListener {

	private GUI g;
	private Model m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Eisb�rController c = new Eisb�rController();
	}
	
	public Eisb�rController()
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
			String diceText = g.getW�rfel();
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
			String diceText = g.getW�rfel();
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
		if(e.getActionCommand().equals("L�sen"))
		{
			if(m.eisb�renTest(g.getEisb�ren()) && m.l�cherTest(g.getL�cher()))
			{
				boolean ergb = true;
				String erg ="";
				if(m.richtigEisb�ren())
				{
					erg+= "Die Anzahl Eisb�ren ist Korrekt\n";
				}
				else
				{
					erg+= "Die Anzahl Eisb�ren ist  nicht  Korrekt\n";
					ergb = false;
				}
				if(m.richtigL�cher())
				{
					erg+= "Die Anzahl L�cher ist Korrekt\n";
				}
				else
				{
					erg+= "Die Anzahl L�cher ist  nicht  Korrekt\n";
					ergb = false;
				}
				int[] lsg = m.l�sung();
				String l�sung = "Die Richtige Menge Eisb�ren betr�gt " + lsg[0] + "\nDie Richtige Menge L�cher betr�gt "+ lsg[1];
				g.l�sung(erg,ergb,l�sung);
			}
			else
			{
				System.out.println(1);
				g.fehler("Bitte geb g�ltige Integer werte ein.\nAls Kleiner Tipp: Die Anzahl der Eisb�ren kann 36 nicht �bersteigen\n und die anzahl der L�cher kann nicht h�her sein als 6");
			}
		}
	}


}
