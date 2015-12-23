package algorithm;

import java.util.ArrayList;
import java.util.Random;

import helpers.SpellHelper;

/**
 * @author Andrej Miletic
 */
public class NGramAlgorithm 
{
	public static String getComputersSpell()
	{
		ArrayList<String> allSpells = SpellHelper.getAllSpells();
		Random r = new Random();
		return allSpells.get(r.nextInt(allSpells.size()));
	}
}
