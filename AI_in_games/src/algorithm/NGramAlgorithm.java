package algorithm;

import gui.MainFrame;
import helpers.SpellHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import model.Game;

/**
 * @author Andrej Miletic
 */
public class NGramAlgorithm {
	/**
	 * Predstavlja koliko prethodnih poteza uzima u obzir
	 */
	private static int maxN;
	private static Game currentGame;
	private static ArrayList<Game> previousGames;
	private static HashMap<String, Double> probability = new HashMap<String, Double>();
	public static Random r;

	public static void Initialize(ArrayList<Game> pg, Game g) {
		maxN = 5;
		currentGame = g;
		previousGames = pg;
		r = new Random();

	}

	public static String getComputersSpell(ArrayList<String> spells, int playerNumber, int maximumN) {
		maxN = maximumN;
		String result = null;
		ArrayList<String> allSpells = SpellHelper.getAllSpells();
		if (previousGames.size() == 0) {
			result = allSpells.get(r.nextInt(allSpells.size()));
		} else {
			ArrayList<String> moves;
			int round = currentGame.getCurrentRound();
			int min = Math.min(maxN, round);
			moves = new ArrayList<String>(spells.subList(round - min, round));
			result = nGram(min, moves, playerNumber);
		}

		return result;
	}

	private static String nGram(int n, ArrayList<String> moves, int playerNumber) {
		probability.put(SpellHelper.PHYSICAL_ATTACK, 0.0);
		probability.put(SpellHelper.BLOCK, 0.0);
		probability.put(SpellHelper.MAGICAL_ATTACK, 0.0);
		probability.put(SpellHelper.SPELL_REFLECT, 0.0);
		probability.put(SpellHelper.RANGE_ATTACK, 0.0);
		probability.put(SpellHelper.ARMOR, 0.0);
		ArrayList<String> playerSpells = new ArrayList<String>();
		String result = SpellHelper.MAGICAL_ATTACK;
		int gameNumber=0;
		switch (currentGame.getCurrentRound()) {
		case 0:
			for (Game game : previousGames) {
				gameNumber++;
				if (playerNumber == 1){
					playerSpells = game.getPlayerSpells();
				}else{
					playerSpells = game.getComputerSpells();
				}
				probability.put(playerSpells.get(0), (double)probability.get(playerSpells.get(0)) + ((double)gameNumber/previousGames.size()));
			}
			result = SpellHelper.getCounter(getMaxEntry(probability).getKey());
			break;
		default:
			for (Game game : previousGames) {
				gameNumber++;
				if (playerNumber == 1){
					playerSpells = game.getPlayerSpells();
				}else{
					playerSpells = game.getComputerSpells();
				}
				for (int i = 0; i < playerSpells.size() - n; i++) {
					if (playerSpells.get(i).equals(moves.get(0))) {
						boolean correctSequence = true;
						for (int temp = 1; temp < n; temp++){
							if (!playerSpells.get(i+temp).equals(moves.get(temp))){
								correctSequence = false;
								break;
							}
						}
						if (correctSequence){
							probability.put(playerSpells.get(i+n), (double)probability.get(playerSpells.get(i+n)) + ((double)gameNumber/previousGames.size()));
						}
					}
				}
			}
			if (getMaxEntry(probability).getValue()==0 && n>=1 && moves.size()>1){
				result = nGram(n-1, new ArrayList<String>(moves.subList(1, moves.size())), playerNumber);
			}else{
				result = SpellHelper.getCounter(getMaxEntry(probability).getKey());
			}
		}
		return result;
	}

	public static Entry<String, Double> getMaxEntry(Map<String, Double> map) {
		Entry<String, Double> maxEntry = null;
		Double max = Collections.max(map.values());

		for (Entry<String, Double> entry : map.entrySet()) {
			Double value = entry.getValue();

			if (null != value && max == value) {
				maxEntry = entry;
			}
		}

		return maxEntry;
	}
}
