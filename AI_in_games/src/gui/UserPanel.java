package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import model.Game;

/**
 * Panel koji sadrzi labelu naziva igraca i njegovu traku sa zivotnim poenima.
 * @author Milos Maric
 *
 */
public class UserPanel extends JPanel
{
	private static final long serialVersionUID = 6109087851447197609L;

	/**
	 * Labela koja sadrzi naziv igraca.
	 */
	private JLabel playersNameLabel;
	
	/**
	 * Traka sa zivotnim poenima igraca ili racunara.
	 */
	private JProgressBar hpBar;
	
	public UserPanel(String name) 
	{
		playersNameLabel = new JLabel();
		hpBar = new JProgressBar();		
		
		initialize(name);
	}

	/**
	 * Metoda koja postavlja GUI elemente u inicijalno stanje.
	 * @param name - naziv igraca.
	 */
	private void initialize(String name) 
	{
		JPanel playersPanel;
		Font textFont;

		setLayout(new GridLayout(2, 1));
		
		playersPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		playersNameLabel.setText(name);
		textFont = new Font("Verdana", Font.BOLD, 15);		
		playersNameLabel.setFont(textFont);
		playersPanel.add(playersNameLabel, BorderLayout.CENTER);		
		add(playersPanel);
		
		hpBar.setStringPainted(true);
		hpBar.setForeground(Color.BLACK);
		resetHPBar();
		add(hpBar);
	}

	/**
	 * Metoda koja menja vrednost zivotnih poena na GUI-ju.
	 */
	public void adjustHP() 
	{
		Game currentGame;
		int hpToSet;
		
		currentGame = MainFrame.getInstance().getGameManager().getCurrentGame();
		hpToSet = 0;
		if(playersNameLabel.getText().equals("Player"))
		{
			hpToSet = currentGame.getPlayersHP();
		}
		else if(playersNameLabel.getText().equals("Computer"))
		{
			hpToSet = currentGame.getComputersHP();
		}
		changeHPBar(hpToSet);
	}
	
	/**
	 * Metoda koja resetuje traku sa zivotnim poenima.
	 */
	public void resetHPBar()
	{
		changeHPBar(100);
	}
	
	/**
	 * Metoda koja stavlja broj zivotnih poena na GUI-ju na odredjeni broj.
	 * @param HP - broj zivotnih poena.
	 */
	public void changeHPBar(int HP)
	{
		hpBar.setValue(HP);
		hpBar.setString(""+HP);
	}

}
