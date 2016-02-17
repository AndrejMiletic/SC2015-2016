package study;

import gui.MainFrame;
import helpers.SpellHelper;

import java.util.ArrayList;
import java.util.Random;

import algorithm.NGramAlgorithm;
import model.Game;
import controller.GameManager;

public class StudyHelperClass {

	private int alg1Wins;
	private int alg2Wins;
	private int draws;
	private int n1;
	private int n2;
	private GameManager gm;
	private int counter;
	private int algWinner;
	
	public int getAlgWinner(){
		return algWinner;
	}
	
	public StudyHelperClass(int n1, int n2, int counter){
		this.counter = counter;
		this.n1 = n1;
		this.n2 = n2;
		alg1Wins = 0;
		alg2Wins = 0;
		draws = 0;
		gm = MainFrame.getInstance().getGameManager();
		gm.setPreviousGames(new ArrayList<Game>());
	}
	
	public void beginStudy(){
		Game game = gm.getCurrentGame();
		ArrayList<Game> games = gm.getPreviousGames();
		Random r = new Random();
		ArrayList<String> allSpells = SpellHelper.getAllSpells();
		String spell1 = null;
		String spell2 = null;
		/*NGramAlgorithm.Initialize(games, game);
		for (int k=0; k<10; k++){
			for (int i=0; i<15; i++){
				spell1 = allSpells.get(r.nextInt(allSpells.size()));
				spell2 = allSpells.get(r.nextInt(allSpells.size()));
				game.getPlayerSpells().add(spell1);
				game.getComputerSpells().add(spell2);
			}
			games.add(game);
			game = new Game();
		}*/
		gm.setPreviousGames(games);
		for (int i=0; i<1000; i++){
			games = gm.getPreviousGames();
			game = gm.getCurrentGame();
			NGramAlgorithm.Initialize(games, game);
			while(!gm.getCurrentGame().isOver()){
				spell1 = NGramAlgorithm.getComputersSpell(game.getComputerSpells(), 2, n1);
				gm.playNewRound(spell1, n2);	
			}
			if (gm.getCurrentGame().getWinner() == 1){
				alg1Wins++;
			}else if(gm.getCurrentGame().getWinner() == 1){
				draws++;
			}else{
				alg2Wins++;
			}
			gm.finishCurrentGame();
		}
		if (alg1Wins>alg2Wins){
			algWinner=1;
		}else{
			algWinner=2;
		}
		System.out.println(counter + " First: " + alg1Wins + " draw: " + draws +" Second: "+ alg2Wins);
	}
}
