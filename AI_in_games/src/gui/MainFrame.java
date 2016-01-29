package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import actions.ActionManager;
import controller.GameManager;
import controller.MainFrameWindowListener;
import model.Game;

/**
 * Klasa koja predstavlja glavni prozor igre.
 * @author Milos Maric
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	/**
	 * Instanca koja obezbedjuje implementaciju {@code Singleton} sablona.
	 */
	private static MainFrame instance = null;
	
	/**
	 * Menadzer akcija GUI-ja.
	 */
	private ActionManager actionManager;
	
	/**
	 * Menadzer igranja igre.
	 */
	private GameManager gameManager;
	
	/**
	 * Traka sa magijama igraca.
	 */
	private SpellBar spellBar;
	
	/**
	 * Traka sa dugmetom za prikaz pravila igre.
	 */
	private UtilitiesToolBar utilitiesToolBar;
	
	/**
	 * panel na kom se prikazuje tok igre.
	 */
	private MainGamePanel gamePanel; 
	
	/**
	 * Oznacava da li je aktivno ucenje ukljuceno.
	 */
	private Boolean activeLearning;
	
	public MainFrame() 
	{
		activeLearning = false;
		actionManager = new ActionManager();
		gameManager = new GameManager();
	}
	
	/**
	 * Metoda koja inicijalizuje glavni prozor igre.
	 */
	private void initialise() 
	{
		// podesavanja prozora
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int height = screenSize.height /2;
		int width = screenSize.width /2;
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.NORMAL);
		setTitle("AI in games");
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(400, 400));
		setLayout(new BorderLayout());	
		
		spellBar = new SpellBar();
		utilitiesToolBar = new UtilitiesToolBar();
		spellBar.setMinimumSize(new Dimension(400, 80));
		gamePanel = new MainGamePanel();
		
		add(utilitiesToolBar, BorderLayout.NORTH);
		add(gamePanel, BorderLayout.CENTER);
		add(spellBar, BorderLayout.SOUTH);
		
		addWindowListener(new MainFrameWindowListener());
	}
	

	/**
	 * Metoda preko koje se pokrece igranje nove runde kada igrac klikne na dugme magije koju
	 * je odabrao.
	 * @param playerSpell - naziv magije koju je igrac odabrao.
	 */
	public void playNewRound(String playerSpell)
	{
		String roundLog, gameEndingLog;
		Game currentGame;
		
		roundLog = gameManager.playNewRound(playerSpell);
		gamePanel.showRoundResults(roundLog);
		
		/*
		JOptionPane.showMessageDialog(
									this, 
									roundLog, 
									"Round ended!", 
									JOptionPane.OK_OPTION, 
									new ImageIcon("resources/images/dialog_icon.png"));
		*/
		spellBar.increaseCount(playerSpell);
		
		if(gameManager.getCurrentGame().isOver())
		{
			currentGame = gameManager.getCurrentGame();
			gameEndingLog = currentGame.toString(); 
			JOptionPane.showMessageDialog(
										this, 
										gameEndingLog, 
										"Game summary!", 
										JOptionPane.OK_OPTION,
										new ImageIcon("resources/images/dialog_icon.png"));
			
			gameManager.finishCurrentGame();
			spellBar.resetSpellBar();
			gamePanel.resetMainGamePanel();
		}
	}
	
	public ActionManager getActionManager() {
		return actionManager;
	}

	public SpellBar getSpellBar() {
		return spellBar;
	}
	
	public GameManager getGameManager() {
		return gameManager;
	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initialise();
		}
		return instance;
	}

	public Boolean getActiveLearning() {
		return activeLearning;
	}

	public void setActiveLearning(Boolean activeLearning) {
		this.activeLearning = activeLearning;
	}
	
	
}
