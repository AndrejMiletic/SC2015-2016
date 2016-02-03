package controller;

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
	public String playNewRound(String playerSpell)
	{
		String retVal, computerSpell;
		
		retVal = null;		
		if(!currentGame.isOver())
		{
			computerSpell = NGramAlgorithm.getComputersSpell();
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
		previousGames.add(currentGame);
		currentGame = new Game();
		NGramAlgorithm.Initialize();
	}
	
	/**
	 * Metoda koja usled ukljucivanja aktivnog ucenja cuva u datoteku do sada odigrane partije
	 * i prazni listu prethodnih partija.
	 */
	public void activeLearningActivated() 
	{
		FileDataProvider.writeGamesInFile(previousGames);
		previousGames = new ArrayList<Game>();
		NGramAlgorithm.Initialize();
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
