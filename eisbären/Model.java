package eisbären;

import java.util.Random;

public class Model 
{
	private int dice;
	private int[] values;
	private int eisbären;
	private int löcher;
	private int leisb;
	private int llöch;
	
	public boolean DiceTest(String diceText) {
		// TODO Auto-generated method stub
		int zahl;
		try
		{
			zahl = Integer.parseInt(diceText);
		}
		catch(Exception e)
		{
			return false;
		}
		if(zahl >=1 && zahl <= 6)
		{
			dice = zahl;
			return true;
		}
		return true;
	}

	public int[] random() 
	{
		int[] erg = new int[dice];

		Random r = new Random();
		for(int i = 0; i<dice;i++)
		{
			erg[i] = r.nextInt(6)+1;
		}
		values = erg;
		return erg;
	}

	public boolean eisbärenTest(String eisbären) 
	{
		int tmp;
		try
		{
			tmp = Integer.parseInt(eisbären);
		}
		catch(Exception e)
		{
			return false;
		}
		if(tmp>=0&&tmp <=36)
		{
			this.eisbären = tmp;
			return true;
		}
		return false;
	}

	public boolean löcherTest(String löcher) 
	{
		int tmp;
		try
		{
			tmp = Integer.parseInt(löcher);
		}
		catch(Exception e)
		{
			return false;
		}
		if(tmp>=0&&tmp <=36)
		{
			this.löcher = tmp;
			return true;
		}
		return false;
	}

	public boolean richtigEisbären() 
	{
		leisb = 0;
		for( int i = 0; i < dice; i++)
		{
			if(values[i] == 2 || values[i] == 3)
				leisb = leisb+2;
			if(values[i] == 4 || values[i] == 5)
				leisb = leisb+4;
			if(values[i] == 6)
				leisb = leisb+6;
		}
		if(eisbären == leisb)
			return true;
		return false;
	}

	public boolean richtigLöcher() 
	{
		llöch = 0;
		for( int i = 0; i < dice; i++)
		{
			if(values[i] % 2== 1)
				llöch++;
		}
		if(löcher == llöch)
			return true;
		return false;
	}
	
	public int[] lösung()
	{
		int[] erg = new int[2];
		erg[0] = leisb;
		erg[1] = llöch;
		
		return erg;
	}

}
