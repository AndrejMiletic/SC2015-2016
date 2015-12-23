package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import dataProviders.FileDataProvider;
import gui.MainFrame;
import model.Game;

/**
 * Osluskivac dogadjaja nad glavnim prozorom aplikacije.
 * @author Milos Maric
 */
public class MainFrameWindowListener implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {}

	/**
	 * Metoda koja pri zatvaranju prozora snima odigrane igre u datoteku.
	 */
	@Override
	public void windowClosing(WindowEvent e) 
	{
		ArrayList<Game> games;
		
		games = MainFrame.getInstance().getGameManager().getPreviousGames();
		FileDataProvider.writeGamesInFile(games);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
