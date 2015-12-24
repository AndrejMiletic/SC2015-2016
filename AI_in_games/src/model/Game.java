package model;

import java.io.Serializable;
import java.util.ArrayList;

import helpers.SpellHelper;

/**
 * Klasa koja predstavlja jednu igru.
 * @author Milos Maric
 *
 */
public class Game implements Serializable
{
	private static final long serialVersionUID = 5932841429637107108L;
	
	/**
	 * Nazivi magija koje je igrac iskoristio u igri.
	 */
	private ArrayList<String> playerSpells;
	
	/**
	 * Nazivi magija koje je racunar iskoristio u igri.
	 */
	private ArrayList<String> computerSpells;
	
	/**
	 * Informacija o pobedniku igre:
	 * 		-1 : racunar
	 * 		0  : nereseno
	 * 		1  : igrac
	 */
	private int winner;

	/**
	 * Trenutna kolicina zivotnih poena koje poseduje igrac.
	 */
	private transient int playersHP;
	
	/**
	 * Trenutna kolicina zivotnih poena koje poseduje racunar.
	 */
	private transient int computersHP;
	
	/**
	 * Trenutni broj runde.
	 */
	private transient int currentRound;
	
	/**
	 * Kolicina stete koja se nanosi bilo kojim napadom.
	 */
	public static final transient int attackDamage = 30;
	
	/**
	 * Kolicina stete koju napadac prima ako mu je fizicki napad blokiran.
	 */
	public static final transient int blockDamage = 10;
	
	/**
	 * Kolicina stete koju napadac prima ako mu je magicni napad reflektovan.
	 */
	public static final transient int reflectDamage = 15;
	
	/**
	 * Maksimalan broj rundi u jednoj igri.
	 */
	public static final transient int maxRounds = 10;
	
	public Game() 
	{
		playerSpells = new ArrayList<String>();
		computerSpells = new ArrayList<String>();
		currentRound = 0;
		playersHP = 100;
		computersHP = 100;
		winner = 0;
	}
	
	/**
	 * Metoda koja simulira igranje jedne runde.
	 * @param computerSpell - magija koju je kompjuter iskoristio.
	 * @param playerSpell - magija koju je igrac iskoristio.
	 * @return log runde.
	 */
	public String playNewRound(String computerSpell, String playerSpell)
	{
		StringBuilder roundLog;
		
		roundLog = new StringBuilder();
		
		currentRound++;
		playerSpells.add(playerSpell);
		computerSpells.add(computerSpell);
		roundLog.append("\nRound " + currentRound + ":");
		roundLog.append("\nPlayers spell: ");
		roundLog.append(playerSpell);
		roundLog.append("\nComputers spell: ");
		roundLog.append(computerSpell);		
		roundLog.append("\n" + executeRound(computerSpell, playerSpell));		
		
		return roundLog.toString();
	}
	
	/**
	 * Metoda koja vraca tekstualni rezultat igre.
	 * @return tekstualni rezultat igre.
	 */
	public String getGameResult()
	{
		String winnerLog;
		
		if(winner == -1)
		{
			winnerLog = "Computer won!";
		}else if(winner == 1)
		{
			winnerLog = "Player won!";
		}else
		{
			winnerLog = "It's a tie! ";
		}
		
		return winnerLog;
	}	
	
	/**
	 * Metoda koja vraca informaciju da li je igra gotova.
	 * @return True ili False u zavisnosti da li je igra gotova.
	 */
	public boolean isOver()
	{
		return playersHP == 0 || computersHP == 0 || currentRound == Game.maxRounds;
	}

	/**
	 * Metoda koja vraca recima ispisana pravila igre.
	 * @return pravila igre.
	 */
	public static String getGameRules() 
	{
		StringBuilder rules;
		
		rules = new StringBuilder();
		
		rules.append("\n***************************************************Game rules***************************************************");
		rules.append("\nAt the start of a game, both player and computer have 100 health points.");
		rules.append("\nEach round both choose a spell without knowing which spell the other one chose.");
		rules.append("\nOnce the spells are chosen, they collide and the result affects both players and computers"
				+ "healts points.");
		rules.append("\n\nEvery spell has its counter:");
		rules.append("\nPhysical Attack - Block");
		rules.append("\nMagical Attack - Spell Reflect");
		rules.append("\nRange Attack - Armor\n");
		rules.append("\nSpell collision results: ");
		rules.append("\nAny kind of attack deals " + Game.attackDamage + " damage.");
		rules.append("\nIf a Physical Attack is Blocked, the attacker gets " + Game.blockDamage + " damage.");
		rules.append("\nIf a Magic Attack is Spell Reflected, the attacker gets " + Game.reflectDamage + " damage.");
		rules.append("\nIf a Range Attack and Armor are used, the damage is fully mitigated.\n");
		rules.append("\nMaximum number of rounds is " + Game.maxRounds + ".");
		rules.append("\nSame spell can be used only " + SpellHelper.MAX_SPELL_COUNT + " times in the same game.");
		rules.append("\nGame ends if Player or Computer (or both) lose all health points, or if the maximum "
				+ "number of rounds is played.");
		rules.append("\n***************************************************Enjoy!***************************************************");
		
		
		return rules.toString();
	}

	private String executeRound(String computerSpell, String playerSpell) 
	{		
		String retVal;
		
		
		retVal = "";
			
		switch (computerSpell) 
		{
			case SpellHelper.PHYSICAL_ATTACK:
				retVal += computerDidPA(playerSpell);
			break;
	
			case SpellHelper.BLOCK:
				retVal += computerBlocked(playerSpell);
			break;
			
			case SpellHelper.MAGICAL_ATTACK:
				retVal += computerDidMA(playerSpell);
			break;
			
			case SpellHelper.SPELL_REFLECT:
				retVal += computerReflected(playerSpell);
			break;
			
			case SpellHelper.RANGE_ATTACK:
				retVal += computerDidRA(playerSpell);
			break;
			
			case SpellHelper.ARMOR:
				retVal += computerUsedArmor(playerSpell);
			break;
		}
		
		playersHP = Math.max(0, playersHP);
		computersHP = Math.max(0, computersHP);	
				
		if(isOver())
		{
			pronounceTheWinner();
		}
		
		retVal += "\n";
		return retVal;
	}

	private void pronounceTheWinner() 
	{
		if(playersHP > computersHP)
		{
			winner = 1;
		} 
		else if(computersHP > playersHP)
		{
			winner = -1;
		}
		else
		{
			winner = 0;
		}
	}

	private String computerUsedArmor(String playerSpell) 
	{
		String result;
		
		switch (playerSpell) 
		{	
			case SpellHelper.RANGE_ATTACK:
				result = "Noone took any damage.";
			break;
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.MAGICAL_ATTACK:
				result = "Computer took " + Game.attackDamage + " damage.";
				computersHP -= Game.attackDamage;
			break;
			default:
				result = "Noone took any damage.";
			break;
		}
		
		return result;
	}

	private String computerDidRA(String playerSpell) 
	{
		String result;
		
		switch (playerSpell) 
		{
			case SpellHelper.ARMOR:
				result = "Noone took any damage.";
			break;
	
			case SpellHelper.MAGICAL_ATTACK:
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Both took " + Game.attackDamage + " damage.";
				computersHP -= Game.attackDamage;
				playersHP -= Game.attackDamage;
			break;			
			default:
				result = "Player took " + Game.attackDamage + " damage.";
				playersHP -= Game.attackDamage;
			break;
		}
		
		return result;
	}

	private String computerReflected(String playerSpell) 
	{
		String result;
		
		switch (playerSpell) 
		{	
			case SpellHelper.MAGICAL_ATTACK:
				result = "Player took " + Game.reflectDamage + " damage.";
				playersHP -= Game.reflectDamage;
			break;
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Computer took " + Game.attackDamage + " damage.";
				computersHP -= Game.attackDamage;
			break;
			default:
				result = "Noone took any damage.";
			break;
		}
		
		return result;
	}

	private String computerDidMA(String playerSpell) 
	{
		String result;
		
		switch (playerSpell) 
		{
			case SpellHelper.SPELL_REFLECT:
				result = "Computer took " + Game.reflectDamage + " damage from reflection.";
				computersHP -= Game.reflectDamage;
			break;
	
			case SpellHelper.MAGICAL_ATTACK:
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Both took " + Game.attackDamage + " damage.";
				computersHP -= Game.attackDamage;
				playersHP -= Game.attackDamage;
			break;			
			default:
				result = "Player took " + Game.attackDamage + " damage.";
				playersHP -= Game.attackDamage;
			break;
		}
		
		return result;
	}

	private String computerBlocked(String playerSpell) 
	{
		String result;
		
		switch (playerSpell) 
		{	
			case SpellHelper.PHYSICAL_ATTACK:
				result = "Player took " + Game.blockDamage + " damage.";
				playersHP -= Game.blockDamage;
			break;
			case SpellHelper.MAGICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Computer took " + Game.attackDamage + " damage.";
				computersHP -= Game.attackDamage;
			break;
			default:
				result = "Noone took any damage.";
			break;
		}
		
		return result;
	}

	private String computerDidPA(String playerSpell) 
	{
		String result;
		
		switch (playerSpell) 
		{
			case SpellHelper.BLOCK:
				result = "Computer took " + Game.blockDamage + " damage from block.";
				computersHP -= Game.blockDamage;
			break;
	
			case SpellHelper.MAGICAL_ATTACK:
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Both took " + Game.attackDamage + " damage.";
				computersHP -= Game.attackDamage;
				playersHP -= Game.attackDamage;
			break;			
			default:
				result = "Player took " + Game.attackDamage + " damage.";
				playersHP -= Game.attackDamage;
			break;
		}
		
		return result;
	}

	@Override
	public String toString() 
	{
		StringBuilder gameLog;
		
		gameLog = new StringBuilder();
		
		gameLog.append("\n**********Game starts**********\n");
		gameLog.append("\nPlayer spell VS Computer spell\n");
		for (int i = 0; i < playerSpells.size(); i++) 
		{
			gameLog.append("Round " + (i+1) + ": ");
			gameLog.append(playerSpells.get(i) + " VS " + computerSpells.get(i) + "\n");
			
		}
		gameLog.append("\n"+ getGameResult() +"\n");
		gameLog.append("\n**********Game ends**********\n");
		
		return gameLog.toString();
	}
	
	public ArrayList<String> getPlayerSpells() {
		return playerSpells;
	}
	
	public ArrayList<String> getComputerSpells() {
		return computerSpells;
	}

	
	public int getPlayersHP() {
		return playersHP;
	}


	public int getComputersHP() {
		return computersHP;
	}
}
