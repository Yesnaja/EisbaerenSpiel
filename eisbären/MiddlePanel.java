package eisbären;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MiddlePanel extends JPanel {

	private int dice;
	private int[] values;
	public MiddlePanel()
	{
	}
	
	public void rerun(int dice, int[] values)
	{
		this.dice = dice;
		this.values = values;
		this.repaint();
	}

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 500, 500);
		g2.setColor(Color.BLACK);
		if(dice >= 1)
		{
			g2.drawRect(20, 20, 60, 60);
			if(values[0] >= 2)
			{
				g2.fillOval(27, 27, 6, 6);
				g2.fillOval(67, 67, 6, 6);
			}
			if(values[0] >= 4)
			{
				g2.fillOval(67, 27, 6, 6);
				g2.fillOval(27, 67, 6, 6);
			}
			if(values[0] == 6)
			{
				g2.fillOval(27, 47, 6, 6);
				g2.fillOval(67, 47, 6, 6);
			}
			if(values[0] % 2 == 1)
				g2.fillOval(47, 47, 6, 6);
		}
		if(dice >= 2)
		{
			g2.drawRect(120, 20, 60, 60);
			if(values[1] >= 2)
			{
				g2.fillOval(127, 27, 6, 6);
				g2.fillOval(167, 67, 6, 6);
			}
			if(values[1] >= 4)
			{
				g2.fillOval(167, 27, 6, 6);
				g2.fillOval(127, 67, 6, 6);
			}
			if(values[1] == 6)
			{
				g2.fillOval(127, 47, 6, 6);
				g2.fillOval(167, 47, 6, 6);
			}
			if(values[1] % 2 == 1)
				g2.fillOval(147, 47, 6, 6);
		}
		
		if(dice >= 3)
		{
			g2.drawRect(20, 120, 60, 60);
			if(values[2] >= 2)
			{
				g2.fillOval(27, 127, 6, 6);
				g2.fillOval(67, 167, 6, 6);
			}
			if(values[2] >= 4)
			{
				g2.fillOval(67, 127, 6, 6);
				g2.fillOval(27, 167, 6, 6);
			}
			if(values[2] == 6)
			{
				g2.fillOval(27, 147, 6, 6);
				g2.fillOval(67, 147, 6, 6);
			}
			if(values[2] % 2 == 1)
				g2.fillOval(47, 147, 6, 6);
		}
		
		if(dice >= 4)
		{
			g2.drawRect(120, 120, 60, 60);
			if(values[3] >= 2)
			{
				g2.fillOval(127, 127, 6, 6);
				g2.fillOval(167, 167, 6, 6);
			}
			if(values[3] >= 4)
			{
				g2.fillOval(167, 127, 6, 6);
				g2.fillOval(127, 167, 6, 6);
			}
			if(values[3] == 6)
			{
				g2.fillOval(127, 147, 6, 6);
				g2.fillOval(167, 147, 6, 6);
			}
			if(values[3] % 2 == 1)
				g2.fillOval(147, 147, 6, 6);
		}
		
		if(dice >= 5)
		{
			g2.drawRect(20, 220, 60, 60);
			if(values[4] >= 2)
			{
				g2.fillOval(27, 227, 6, 6);
				g2.fillOval(67, 267, 6, 6);
			}
			if(values[4] >= 4)
			{
				g2.fillOval(67, 227, 6, 6);
				g2.fillOval(27, 267, 6, 6);
			}
			if(values[4] == 6)
			{
				g2.fillOval(27, 247, 6, 6);
				g2.fillOval(67, 247, 6, 6);
			}
			if(values[4] % 2 == 1)
				g2.fillOval(47, 247, 6, 6);
		}
		
		if(dice >= 6)
		{
			g2.drawRect(120, 220, 60, 60);
			if(values[5] >= 2)
			{
				g2.fillOval(127, 227, 6, 6);
				g2.fillOval(167, 267, 6, 6);
			}
			if(values[5] >= 4)
			{
				g2.fillOval(167, 227, 6, 6);
				g2.fillOval(127, 267, 6, 6);
			}
			if(values[5] == 6)
			{
				g2.fillOval(127, 247, 6, 6);
				g2.fillOval(167, 247, 6, 6);
			}
			if(values[5] % 2 == 1)
				g2.fillOval(147, 247, 6, 6);
		}
	}
}
