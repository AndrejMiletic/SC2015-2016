package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import actions.ActionManager;

/**
 * Klasa koja predstavlja glavni prozor igre.
 * @author Milos Maric
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	/**
	 * Instanca koja obezbedjuje implementaciju {@code Singleton} sablona.
	 */
	private static MainFrame instance = null;
	
	/**
	 * Klasa koja centralizuje rukovanje akcijama GUI-ja.
	 */
	private ActionManager actionManager;
	
	/**
	 * Traka sa magijama igraca.
	 */
	private SpellBar spellBar;
	
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
		
		actionManager = new ActionManager();
		spellBar = new SpellBar();
		spellBar.setMinimumSize(new Dimension(400, 80));
		
		add(new JPanel(), BorderLayout.NORTH);
		add(new JPanel(), BorderLayout.CENTER);
		add(new JPanel(), BorderLayout.WEST);
		add(spellBar, BorderLayout.SOUTH);
	}
	
	public ActionManager getActionManager() {
		return actionManager;
	}

	public SpellBar getSpellBar() {
		return spellBar;
	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initialise();
		}
		return instance;
	}
}
