package eisbären;

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

	private EisbärController c;
	private JButton lösen;
	private JButton start;
	private JTextField anzWürfel;
	private JTextField eisbären;
	private JTextField löcher;
	private JLabel lAnzWürfel;
	private JLabel lEisbären;
	private JLabel lLöcher;
	private JPanel pNorth;
	private MiddlePanel pMiddle;
	private SpringLayout layoutNorth;
	
	public GUI(EisbärController c)
	{
		lösen = new JButton("Lösen");
		start = new JButton("Start");
		anzWürfel = new JTextField();
		eisbären = new JTextField();
		löcher = new JTextField();
		lAnzWürfel = new JLabel("Anzahl Würfel");
		lEisbären = new JLabel("Eisbären: ");
		lLöcher = new JLabel("Löcher: ");
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
		//anzWürfel.setColumns(1);
		
		// Layout
		layoutNorth.putConstraint(SpringLayout.NORTH, lAnzWürfel, 20, SpringLayout.NORTH, pNorth);
		layoutNorth.putConstraint(SpringLayout.EAST, lAnzWürfel, -20, SpringLayout.EAST, pNorth);
		layoutNorth.putConstraint(SpringLayout.WEST, lAnzWürfel, 20, SpringLayout.WEST, pNorth);
		
		layoutNorth.putConstraint(SpringLayout.NORTH, anzWürfel, 10, SpringLayout.SOUTH, lAnzWürfel);
		layoutNorth.putConstraint(SpringLayout.EAST, anzWürfel, -20, SpringLayout.WEST, start);
		layoutNorth.putConstraint(SpringLayout.WEST, anzWürfel, 20, SpringLayout.WEST, pNorth);

		layoutNorth.putConstraint(SpringLayout.EAST, start, -20, SpringLayout.EAST, pNorth);
		layoutNorth.putConstraint(SpringLayout.SOUTH, start, 0, SpringLayout.SOUTH, anzWürfel);
		
		pNorth.setLayout(layoutNorth);
		
		pNorth.add(lAnzWürfel);
		pNorth.add(anzWürfel);
		pNorth.add(start);
		
	}
	
	public void firstRun(int[] values)
	{
		int dice = Integer.parseInt(anzWürfel.getText());
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

		lösen.addActionListener(c);
		pMiddle.rerun(dice, values);
		//add(pNorth, BorderLayout.NORTH);
		//add(pMiddle, BorderLayout.CENTER);
		//add(pSouth,BorderLayout.SOUTH);
		
		SpringLayout sl = new SpringLayout();
		
		sl.putConstraint(SpringLayout.NORTH, lAnzWürfel, 20, SpringLayout.NORTH, getContentPane());
		sl.putConstraint(SpringLayout.EAST, lAnzWürfel, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.WEST, lAnzWürfel, 20, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.NORTH, anzWürfel, 10, SpringLayout.SOUTH, lAnzWürfel);
		sl.putConstraint(SpringLayout.EAST, anzWürfel, -20, SpringLayout.WEST, start);
		sl.putConstraint(SpringLayout.WEST, anzWürfel, 20, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.EAST, start, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, start, 0, SpringLayout.SOUTH, anzWürfel);
		
		sl.putConstraint(SpringLayout.NORTH, pMiddle, 20, SpringLayout.SOUTH, start);
		sl.putConstraint(SpringLayout.EAST, pMiddle, 0, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, pMiddle, -20, SpringLayout.NORTH, eisbären);
		sl.putConstraint(SpringLayout.WEST, pMiddle, 0, SpringLayout.WEST, getContentPane());

		sl.putConstraint(SpringLayout.EAST, eisbären, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, eisbären, -10, SpringLayout.NORTH, löcher);
		sl.putConstraint(SpringLayout.WEST, eisbären, 20, SpringLayout.EAST, lEisbären);
		
		sl.putConstraint(SpringLayout.SOUTH, lEisbären, -10, SpringLayout.NORTH, lLöcher);
		sl.putConstraint(SpringLayout.WEST, lEisbären, 20, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.SOUTH, lLöcher, -10, SpringLayout.NORTH, lösen);
		sl.putConstraint(SpringLayout.WEST, lLöcher, 20, SpringLayout.WEST, getContentPane());
		
		sl.putConstraint(SpringLayout.EAST, löcher, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, löcher, -10, SpringLayout.NORTH, lösen);
		sl.putConstraint(SpringLayout.WEST, löcher, 0, SpringLayout.WEST, eisbären);
		
		sl.putConstraint(SpringLayout.EAST, lösen, -20, SpringLayout.EAST, getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, lösen, -20, SpringLayout.SOUTH, getContentPane());
		sl.putConstraint(SpringLayout.WEST, lösen, 20, SpringLayout.WEST, getContentPane());

		getContentPane().setLayout(sl);

		getContentPane().add(lAnzWürfel);
		getContentPane().add(anzWürfel);
		getContentPane().add(start);
		getContentPane().add(pMiddle);
		getContentPane().add(eisbären);
		getContentPane().add(lEisbären);
		getContentPane().add(lLöcher);
		getContentPane().add(löcher);
		getContentPane().add(lösen);
		
		start.setText("Neuer Versuch");
	}

	public void reRun(int[] values)
	{
		int dice = Integer.parseInt(anzWürfel.getText());

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
	
	public String getWürfel()
	{
		return anzWürfel.getText();
	}
	
	public String getEisbären()
	{
		return eisbären.getText();
	}
	
	public String getLöcher()
	{
		return löcher.getText();
	}

	public void fehler(String string) 
	{
		JOptionPane.showMessageDialog(this, string);
	}

	public void lösung(String erg, boolean ergb, String lsg) {
		// TODO Auto-generated method stub
		if(ergb)
		{
			JOptionPane.showMessageDialog(this, erg);
		}
		else
		{
			int eg;
			eg = JOptionPane.showConfirmDialog(this, erg + "\n Möchten Sie die Lösung sehen?");
			if(eg == 0)
			{
				JOptionPane.showMessageDialog(this, lsg);
			}
		}
	}
}




