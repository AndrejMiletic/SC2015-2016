package controller;

import java.util.ArrayList;

import algorithm.NGramAlgorithm;
import model.Game;

public class GameManager 
{
	private ArrayList<Game> previousGames;
	private Game currentGame;
	
	public GameManager() 
	{
		previousGames = new ArrayList<Game>();
		currentGame = new Game();		
	}
	
	/**
	 * Metoda koja simulira igru jedne runde.
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
	}

	public ArrayList<Game> getPreviousGames() {
		return previousGames;
	}

	public Game getCurrentGame() {
		return currentGame;
	}
	
	
}
