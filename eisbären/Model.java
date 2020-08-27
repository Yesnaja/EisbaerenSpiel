package eisb�ren;

import java.util.Random;

public class Model 
{
	private int dice;
	private int[] values;
	private int eisb�ren;
	private int l�cher;
	private int leisb;
	private int ll�ch;
	
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

	public boolean eisb�renTest(String eisb�ren) 
	{
		int tmp;
		try
		{
			tmp = Integer.parseInt(eisb�ren);
		}
		catch(Exception e)
		{
			return false;
		}
		if(tmp>=0&&tmp <=36)
		{
			this.eisb�ren = tmp;
			return true;
		}
		return false;
	}

	public boolean l�cherTest(String l�cher) 
	{
		int tmp;
		try
		{
			tmp = Integer.parseInt(l�cher);
		}
		catch(Exception e)
		{
			return false;
		}
		if(tmp>=0&&tmp <=36)
		{
			this.l�cher = tmp;
			return true;
		}
		return false;
	}

	public boolean richtigEisb�ren() 
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
		if(eisb�ren == leisb)
			return true;
		return false;
	}

	public boolean richtigL�cher() 
	{
		ll�ch = 0;
		for( int i = 0; i < dice; i++)
		{
			if(values[i] % 2== 1)
				ll�ch++;
		}
		if(l�cher == ll�ch)
			return true;
		return false;
	}
	
	public int[] l�sung()
	{
		int[] erg = new int[2];
		erg[0] = leisb;
		erg[1] = ll�ch;
		
		return erg;
	}

}
