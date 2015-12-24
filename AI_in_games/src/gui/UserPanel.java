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

public class UserPanel extends JPanel
{
	private static final long serialVersionUID = 6109087851447197609L;

	private JLabel playersNameLabel;
	private JProgressBar hpBar;
	
	public UserPanel(String name) 
	{
		playersNameLabel = new JLabel();
		hpBar = new JProgressBar();		
		
		initialize(name);
	}

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
	
	public void resetHPBar()
	{
		changeHPBar(100);
	}
	
	public void changeHPBar(int HP)
	{
		hpBar.setValue(HP);
		hpBar.setString(""+HP);
	}

}
