package helpers;

import model.Game;

public class GameLogic {

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
	
	public static String computerUsedArmor(String playerSpell, Game currentGame) 
	{
		String result;
		
		switch (playerSpell) 
		{	
			case SpellHelper.RANGE_ATTACK:
				result = "Noone took any damage.";
			break;
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.MAGICAL_ATTACK:
				result = "Computer took " + GameLogic.attackDamage + " damage.";
				currentGame.decreaseComputersHP(GameLogic.attackDamage);
			break;
			default:
				result = "Noone took any damage.";
			break;
		}
		
		return result;
	}

	public static String computerDidRA(String playerSpell, Game currentGame) 
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
				result = "Both took " + GameLogic.attackDamage + " damage.";
				currentGame.decreaseComputersHP(GameLogic.attackDamage);
				currentGame.decreasePlayersHP(GameLogic.attackDamage);
			break;			
			default:
				result = "Player took " + GameLogic.attackDamage + " damage.";
				currentGame.decreasePlayersHP(GameLogic.attackDamage);
			break;
		}
		
		return result;
	}

	public static String computerReflected(String playerSpell, Game currentGame) 
	{
		String result;
		
		switch (playerSpell) 
		{	
			case SpellHelper.MAGICAL_ATTACK:
				result = "Player took " + GameLogic.reflectDamage + " damage.";
				currentGame.decreasePlayersHP(GameLogic.reflectDamage);
			break;
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Computer took " + GameLogic.attackDamage + " damage.";
				currentGame.decreaseComputersHP(GameLogic.attackDamage);
			break;
			default:
				result = "Noone took any damage.";
			break;
		}
		
		return result;
	}

	public static String computerDidMA(String playerSpell, Game currentGame) 
	{
		String result;
		
		switch (playerSpell) 
		{
			case SpellHelper.SPELL_REFLECT:
				result = "Computer took " + GameLogic.reflectDamage + " damage from reflection.";
				currentGame.decreaseComputersHP(GameLogic.reflectDamage);
			break;
	
			case SpellHelper.MAGICAL_ATTACK:
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Both took " + GameLogic.attackDamage + " damage.";
				currentGame.decreaseComputersHP(GameLogic.attackDamage);
				currentGame.decreasePlayersHP(GameLogic.attackDamage);
			break;			
			default:
				result = "Player took " + GameLogic.attackDamage + " damage.";
				currentGame.decreasePlayersHP(GameLogic.attackDamage);
			break;
		}
		
		return result;
	}

	public static String computerBlocked(String playerSpell, Game currentGame) 
	{
		String result;
		
		switch (playerSpell) 
		{	
			case SpellHelper.PHYSICAL_ATTACK:
				result = "Player took " + GameLogic.blockDamage + " damage.";
				currentGame.decreasePlayersHP(GameLogic.blockDamage);
			break;
			case SpellHelper.MAGICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Computer took " + GameLogic.attackDamage + " damage.";
				currentGame.decreaseComputersHP(GameLogic.attackDamage);
			break;
			default:
				result = "Noone took any damage.";
			break;
		}
		
		return result;
	}

	public static String computerDidPA(String playerSpell, Game currentGame) 
	{
		String result;
		
		switch (playerSpell) 
		{
			case SpellHelper.BLOCK:
				result = "Computer took " + GameLogic.blockDamage + " damage from block.";
				currentGame.decreaseComputersHP(GameLogic.blockDamage);
			break;
	
			case SpellHelper.MAGICAL_ATTACK:
			case SpellHelper.PHYSICAL_ATTACK:
			case SpellHelper.RANGE_ATTACK:
				result = "Both took " + GameLogic.attackDamage + " damage.";
				currentGame.decreaseComputersHP(GameLogic.attackDamage) ;
				currentGame.decreasePlayersHP(GameLogic.attackDamage);
			break;			
			default:
				result = "Player took " + GameLogic.attackDamage + " damage.";
				currentGame.decreasePlayersHP(GameLogic.attackDamage);
			break;
		}
		
		return result;
	}

}
