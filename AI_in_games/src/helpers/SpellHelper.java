package helpers;

import java.util.ArrayList;

/**
 * Klasa koja enkapsulira sve magije koje igrac moze koristiti.
 * @author Milos Maric
 *
 */
public class SpellHelper 
{	
	public static final String PHYSICAL_ATTACK = "Physical Attack";
	public static final String BLOCK = "Block";
	public static final String MAGICAL_ATTACK = "Magical Attack";
	public static final String SPELL_REFLECT = "Spell Reflect";
	public static final String RANGE_ATTACK = "Range Attack";
	public static final String ARMOR = "Armor";
	
	/**
	 * Metoda koja za prosledjeni naziv magije vraca onu koja joj kontrira.
	 * @param spellName - naziv magije za koju se trazi kontra.
	 * @return kontrirajucu magiju.
	 */
	public static String getCounter(String spellName)
	{
		String counter;
			
		switch (spellName) {
			case SpellHelper.PHYSICAL_ATTACK:
				counter = SpellHelper.BLOCK;
			break;

			case SpellHelper.BLOCK:
				counter = SpellHelper.RANGE_ATTACK;
			break;
			
			case SpellHelper.MAGICAL_ATTACK:
				counter = SpellHelper.SPELL_REFLECT;
			break;
			
			case SpellHelper.SPELL_REFLECT:
				counter = SpellHelper.PHYSICAL_ATTACK;
			break;
			
			case SpellHelper.RANGE_ATTACK:
				counter = SpellHelper.ARMOR;
			break;
			
			case SpellHelper.ARMOR:
				counter = SpellHelper.MAGICAL_ATTACK;
			break;
			default:
				counter = "";
			break;
		}
		
		return counter;
	}

	/**
	 * Metoda koja vraca sve nazive magija.
	 * @return listu svih naziva magija.
	 */
	public static ArrayList<String> getAllSpells()
	{
		ArrayList<String> spells;
		
		spells = new ArrayList<String>();
		
		spells.add(SpellHelper.PHYSICAL_ATTACK);
		spells.add(SpellHelper.BLOCK);
		spells.add(SpellHelper.MAGICAL_ATTACK);
		spells.add(SpellHelper.SPELL_REFLECT);
		spells.add(SpellHelper.RANGE_ATTACK);
		spells.add(SpellHelper.ARMOR);
		
		return spells;
	}
}
