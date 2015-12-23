package gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import actions.ActionManager;
import helpers.SpellHelper;

/**
 * Klasa koja predstavlja traku sa magijama koje igrac moze koristiti.
 * @author Milos Maric
 */
@SuppressWarnings("serial")
public class SpellBar extends JToolBar
{
	/**
	 * Mapa koja za kljuceve sadrzi nazive magija, a za vrednosti broj koriscenja te magije u 
	 * trenutnoj partiji, respektivno. 
	 */
	private HashMap<String, Integer> spellCounts;
	
	public SpellBar() 
	{		
		super(SwingConstants.HORIZONTAL);		
		setLayout(new GridLayout(1, 6));		
		setFloatable(false);
		
		ActionManager actionManager;
		
		actionManager = MainFrame.getInstance().getActionManager();
		
		add(actionManager.getPhysicalAttackAction());
		add(actionManager.getBlockAction());
		add(actionManager.getMagicAttackAction());
		add(actionManager.getSpellReflectAction());
		add(actionManager.getRangeAttackAction());
		add(actionManager.getArmorAction());
		
		resetCounts();
	}

	/**
	 * Metoda koja resetuje spell bar na pocetno stanje.
	 */
	public void resetSpellBar()
	{
		resetCounts();
		enableAllButtons();
	}
	
	/**
	 * Metoda koja ukljucuje sve dugmice na spell bar-u.
	 */
	private void enableAllButtons() 
	{
		ActionManager actionManager;
		
		actionManager = MainFrame.getInstance().getActionManager();
		
		actionManager.getPhysicalAttackAction().setEnabled(true);
		actionManager.getBlockAction().setEnabled(true);		
		actionManager.getMagicAttackAction().setEnabled(true);
		actionManager.getSpellReflectAction().setEnabled(true);
		actionManager.getRangeAttackAction().setEnabled(true);
		actionManager.getArmorAction().setEnabled(true);		
	}

	/**
	 * Metoda koja resetuje vrednosti u {@link #spellCounts mapi}.
	 */
 	public void resetCounts() 
	{
		ArrayList<String> spellNames;
		
		spellCounts = new HashMap<String, Integer>();
		spellNames = SpellHelper.getAllSpells();
		
		for (String spellName : spellNames) 
		{
			spellCounts.put(spellName, 0);
		}
	}

 	/**
 	 * Metoda koja za prosledjenu magiju povecava broj koriscenja magije.
 	 * @param spellName - naziv iskoriscene magije.
 	 */
 	public void increaseCount(String spellName)
 	{
 		int count;
 		
 		count = spellCounts.get(spellName);
 		count++;
 		spellCounts.put(spellName, count);
 		
 		if(count == SpellHelper.MAX_SPELL_COUNT)
 		{
 			disableSpell(spellName);
 		}
 	}
 	
 	/**
 	 * Metoda koja na osnovu prosledjenog naziva magije iskljucuje dugme te magije.
 	 * @param spellName - naziv magije cije dugme treba da se iskljuci.
 	 */
	private void disableSpell(String spellName) 
	{
		ActionManager actionManager;
		
		actionManager = MainFrame.getInstance().getActionManager();
		switch (spellName) {
			case SpellHelper.PHYSICAL_ATTACK:
				actionManager.getPhysicalAttackAction().setEnabled(false);
			break;
	
			case SpellHelper.BLOCK:
				actionManager.getBlockAction().setEnabled(false);
			break;
			
			case SpellHelper.MAGICAL_ATTACK:
				actionManager.getMagicAttackAction().setEnabled(false);
			break;
			
			case SpellHelper.SPELL_REFLECT:
				actionManager.getSpellReflectAction().setEnabled(false);
			break;
			
			case SpellHelper.RANGE_ATTACK:
				actionManager.getRangeAttackAction().setEnabled(false);
			break;
			
			case SpellHelper.ARMOR:
				actionManager.getArmorAction().setEnabled(false);
			break;
		}
	}	
}
