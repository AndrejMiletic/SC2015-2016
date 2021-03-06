package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Glavni deo igre koji sadrzi log-er rundi i zivotne poene igraca.
 * @author Milos Maric
 */
public class MainGamePanel extends JPanel
{
	private static final long serialVersionUID = 5726251690753894453L;
	
	/**
	 * Panel igraca.
	 */
	private UserPanel playersPanel;
	
	/**
	 * Panel racunara.
	 */
	private UserPanel computersPanel;
	
	/**
	 * Tekstualno polje u kom se ispisuje log rundi.
	 */
	private JTextArea gameLogArea;
	
	/**
	 * Polje koje cuva prethodne log-ove rundi.
	 */
	private String gameLog;
	
	public MainGamePanel() 
	{		
		playersPanel = new UserPanel("Player");
		computersPanel = new UserPanel("Computer");
		gameLogArea = new JTextArea();
		gameLog = "";
	
		initialize();
	}
	
	/**
	 * Metoda koja inicijalizuje GUI elemente.
	 */
	private void initialize() 
	{
		Dimension userPanelSize;
		JPanel gameLogPanel;
		
		userPanelSize = new Dimension(this.getWidth(), 75);
		setLayout(new BorderLayout());
		gameLogArea.setEditable(false);
		gameLogArea.setBackground(Color.WHITE);
		gameLogArea.setForeground(Color.BLACK);
		
		computersPanel.setPreferredSize(userPanelSize);
		playersPanel.setPreferredSize(userPanelSize);

		gameLogPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		gameLogPanel.setBackground(Color.WHITE);
		gameLogPanel.add(gameLogArea);
		
		add(computersPanel, BorderLayout.NORTH);
		add(gameLogPanel, BorderLayout.CENTER);
		add(playersPanel, BorderLayout.SOUTH);
	}

	/**
	 * Metoda koja menja izgled GUI elemenata na osnovu odigrane runde.
	 * @param roundLog - tekst koji predstavlja log runde.
	 */
	public void showRoundResults(String roundLog)
	{
		addRoundLog(roundLog);
		playersPanel.adjustHP();
		computersPanel.adjustHP();
	}
	
	/**
	 * Metoda koja pri pocinjanju nove igre resetuje sve GUI elemente.
	 */
	public void resetMainGamePanel()
	{
		gameLogArea.setText("");
		gameLog = "";
		playersPanel.resetHPBar();
		computersPanel.resetHPBar();
	}
	
	private void addRoundLog(String roundLog)
	{
		gameLog = roundLog + gameLog;
		gameLogArea.setText(gameLog);
	}
}
