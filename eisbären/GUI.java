package eisb�ren;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class GUI extends JFrame{

	private Eisb�rController c;
	private JButton l�sen;
	private JButton start;
	private JTextField anzW�rfel;
	private JTextField eisb�ren;
	private JTextField l�cher;
	private JLabel lAnzW�rfel;
	private JLabel lEisb�ren;
	private JLabel lL�cher;
	private JPanel pNorth;
	private MiddlePanel pMiddle;
	private SpringLayout layoutNorth;
	
	public GUI(Eisb�rController c)
	{
		l�sen = new JButton("L�sen");
		start = new JButton("Start");
		anzW�rfel = new JTextField();
		eisb�ren = new JTextField();
		l�cher = new JTextField();
		lAnzW�rfel = new JLabel("Anzahl W�rfel");
		lEisb�ren = new JLabel("Eisb�ren: ");
		lL�cher = new JLabel("L�cher: ");
		pNorth = new JPanel();
		pMiddle = new MiddlePanel();
		layoutNorth = new SpringLayout();
		
		this.c = c;
		
		buildWindow();
		buildPanelNorth();
		this.add(pNorth, BorderLayout.CENTER);
	}

	private void buildWindow() 
	{
		// Fenster Einstellungen
		this.setSize(220,200);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void buildPanelNorth() 
	{
		// Attribut Einstellungen
		start.addActionListener(c);
		//anzW�rfel.setColumns(1);
		
		// Layout
		layoutNorth.putConstraint(SpringLayout.NORTH, lAnzW�rfel, 20, SpringLayout.NORTH, pNorth);
		layoutNorth.putConstraint(SpringLayout.EAST, lAnzW�rfel, -20, SpringLayout.EAST, pNorth);
		layoutNorth.putConstraint(SpringLayout.WEST, lAnzW�rfel, 20, SpringLayout.WEST, pNorth);
		
		layoutNorth.putConstraint(SpringLayout.NORTH, anzW�rfel, 10, SpringLayout.SOUTH, lAnzW�rfel);
		layoutNorth.putConstraint(SpringLayout.EAST, anzW�rfel, -20, SpringLayout.WEST, start);
		layoutNorth.putConstraint(SpringLayout.WEST, anzW�rfel, 20, SpringLayout.WEST, pNorth);

		layoutNorth.putConstraint(SpringLayout.EAST, start, -20, SpringLayout.EAST, pNorth);
		layoutNorth.putConstraint(SpringLayout.SOUTH, start, 0, SpringLayout.SOUTH, anzW�rfel);
		
		pNorth.setLayout(layoutNorth);
		
		pNorth.add(lAnzW�rfel);
		pNorth.add(anzW�rfel);
		pNorth.add(start);
		
	}
	
	public void firstRun(int[] values)
	{
		int dice = Integer.parseInt(anzW�rfel.getText());
		if( dice == 1 || dice == 2 )
		{
			this.setSize(220, 350);
		}
		else if( dice == 3 || dice == 4 )
		{
			this.setSize(220, 450);
		}
		else if( dice == 5 || dice == 6 )
		{
			this.setSize(220, 550);
		}

		l�sen.addActionListener(c);
		pMiddle.rerun(dice, values);
		//add(pNorth, BorderLayout.NORTH);
		//add(pMiddle, BorderLayout.CENTER);
		//add(pSouth,BorderLayout.SOUTH);
		
		SpringLayout sl = new SpringLayout();
		
		sl.putConstraint(SpringLayout.NORTH, lAnzW�rfel, 20, SpringLayout.NORTH, getContentPane());
		sl.putConstraint(SpringLayout.EAST, lAnzW�rfel, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.WEST, lAnzW�rfel, 20, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.NORTH, anzW�rfel, 10, SpringLayout.SOUTH, lAnzW�rfel);
		sl.putConstraint(SpringLayout.EAST, anzW�rfel, -20, SpringLayout.WEST, start);
		sl.putConstraint(SpringLayout.WEST, anzW�rfel, 20, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.EAST, start, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, start, 0, SpringLayout.SOUTH, anzW�rfel);
		
		sl.putConstraint(SpringLayout.NORTH, pMiddle, 20, SpringLayout.SOUTH, start);
		sl.putConstraint(SpringLayout.EAST, pMiddle, 0, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, pMiddle, -20, SpringLayout.NORTH, eisb�ren);
		sl.putConstraint(SpringLayout.WEST, pMiddle, 0, SpringLayout.WEST, getContentPane());

		sl.putConstraint(SpringLayout.EAST, eisb�ren, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, eisb�ren, -10, SpringLayout.NORTH, l�cher);
		sl.putConstraint(SpringLayout.WEST, eisb�ren, 20, SpringLayout.EAST, lEisb�ren);
		
		sl.putConstraint(SpringLayout.SOUTH, lEisb�ren, -10, SpringLayout.NORTH, lL�cher);
		sl.putConstraint(SpringLayout.WEST, lEisb�ren, 20, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.SOUTH, lL�cher, -10, SpringLayout.NORTH, l�sen);
		sl.putConstraint(SpringLayout.WEST, lL�cher, 20, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.EAST, l�cher, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, l�cher, -10, SpringLayout.NORTH, l�sen);
		sl.putConstraint(SpringLayout.WEST, l�cher, 0, SpringLayout.WEST, eisb�ren);
		
		sl.putConstraint(SpringLayout.EAST, l�sen, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, l�sen, -20, SpringLayout.SOUTH, getContentPane());
		sl.putConstraint(SpringLayout.WEST, l�sen, 20, SpringLayout.WEST, getContentPane());

		getContentPane().setLayout(sl);

		getContentPane().add(lAnzW�rfel);
		getContentPane().add(anzW�rfel);
		getContentPane().add(start);
		getContentPane().add(pMiddle);
		getContentPane().add(eisb�ren);
		getContentPane().add(lEisb�ren);
		getContentPane().add(lL�cher);
		getContentPane().add(l�cher);
		getContentPane().add(l�sen);
		
		start.setText("Neuer Versuch");
	}

	public void reRun(int[] values)
	{
		int dice = Integer.parseInt(anzW�rfel.getText());

		if( dice == 1 || dice == 2 )
		{
			this.setSize(220, 350);
		}
		else if( dice == 3 || dice == 4 )
		{
			this.setSize(220, 450);
		}
		else if( dice == 5 || dice == 6 )
		{
			this.setSize(220, 550);
		}
		
		pMiddle.rerun(dice, values);
	}
	
	public String getW�rfel()
	{
		return anzW�rfel.getText();
	}
	
	public String getEisb�ren()
	{
		return eisb�ren.getText();
	}
	
	public String getL�cher()
	{
		return l�cher.getText();
	}

	public void fehler(String string) 
	{
		JOptionPane.showMessageDialog(this, string);
	}

	public void l�sung(String erg, boolean ergb, String lsg) {
		// TODO Auto-generated method stub
		if(ergb)
		{
			JOptionPane.showMessageDialog(this, erg);
		}
		else
		{
			int eg;
			eg = JOptionPane.showConfirmDialog(this, erg + "\n M�chten Sie die L�sung sehen?");
			if(eg == 0)
			{
				JOptionPane.showMessageDialog(this, lsg);
			}
		}
	}
}




