package helpers;

import java.util.ArrayList;

/**
 * Klasa koja enkapsulira sve magije koje igrac moze koristiti.
 * @author Milos Maric
 */
public class SpellHelper 
{	
	/**
	 * Naziv magije finickog napada.
	 */
	public static final String PHYSICAL_ATTACK = "Physical Attack";
	
	/**
	 * Naziv magije blokiranja.
	 */
	public static final String BLOCK = "Block";
	
	/**
	 * Naziv magije magicnog napada.
	 */
	public static final String MAGICAL_ATTACK = "Magical Attack";
	
	/**
	 * Naziv magije refleksije magije.
	 */
	public static final String SPELL_REFLECT = "Spell Reflect";
	
	/**
	 * Naziv magije napada lukom i strelom iz daljine.
	 */
	public static final String RANGE_ATTACK = "Range Attack";
	
	/**
	 * Naziv magije ocvrscavanja oklopa.
	 */
	public static final String ARMOR = "Armor";
	
	/**
	 * Maksimalan broj koriscenja iste magije u jednoj igri.
	 */
	public static final int MAX_SPELL_COUNT = 5;
	
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
