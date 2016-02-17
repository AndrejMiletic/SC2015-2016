package controller;

import gui.MainFrame;

import java.util.ArrayList;

import algorithm.NGramAlgorithm;
import dataProviders.FileDataProvider;
import model.Game;

/**
 * Klasa koja centralizuje upravljanje igrama.
 * @author Milos Maric
 */
public class GameManager 
{
	/**
	 * Kolekcija igara koje su do sada odigrane.
	 */
	private ArrayList<Game> previousGames;
	
	/**
	 * Trenutno aktivna igra.
	 */
	private Game currentGame;
	
	public GameManager() 
	{		
		currentGame = new Game();
		previousGames = new ArrayList<Game>();
		previousGames = FileDataProvider.readGamesFromFile();
	}
	
	/**
	 * Metoda koja simulira igru jedne runde unutar cele igre.
	 * @param computerSpell - magija koju je kompjuter odabrao.
	 * @param playerSpell - magija koju je igrac odabrao.
	 * @return log runde ako igra nije gotova ili {@code null} ako je gotova.
	 */
	public String playNewRound(String playerSpell, int maxN)
	{
		String retVal, computerSpell;
		int player = 1;
		retVal = null;		
		if(!currentGame.isOver())
		{
			computerSpell = NGramAlgorithm.getComputersSpell(currentGame.getPlayerSpells(), player, maxN);
			retVal = currentGame.playNewRound(computerSpell, playerSpell);
		}
		 
		return retVal;
	}
	
	/**
	 * Metoda koja zavrsava trenutno aktivnu igru dodajuci je u prethodne igre.
	 * @return rezultat igre.
	 */
	public void finishCurrentGame()
	{
		GameManager gm = MainFrame.getInstance().getGameManager();
		previousGames.add(currentGame);
		currentGame = new Game();
		NGramAlgorithm.Initialize(gm.getPreviousGames(), gm.getCurrentGame());
	}
	
	/**
	 * Metoda koja usled ukljucivanja aktivnog ucenja cuva u datoteku do sada odigrane partije
	 * i prazni listu prethodnih partija.
	 */
	public void activeLearningActivated() 
	{
		GameManager gm = MainFrame.getInstance().getGameManager();
		FileDataProvider.writeGamesInFile(previousGames);
		previousGames = new ArrayList<Game>();
		NGramAlgorithm.Initialize(gm.getPreviousGames(), gm.getCurrentGame());
	}

	public ArrayList<Game> getPreviousGames() {
		return previousGames;
	}

	public Game getCurrentGame() {
		return currentGame;
	}
	
	public void setPreviousGames(ArrayList<Game> previousGames) {
		this.previousGames = previousGames;
	}
}
