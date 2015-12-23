package actions;

/**
 * Klasa koja centralizuje rukovanje akcijama magija.
 * @author Milos Maric
 *
 */
public class ActionManager {

	private PhysicalAttackAction physicalAttackAction;
	private BlockAction blockAction;
	private MagicAttackAction magicAttackAction;
	private SpellReflectAction spellReflectAction;
	private RangeAttackAction rangeAttackAction;
	private ArmorAction armorAction;
	
	public ActionManager() 
	{
		physicalAttackAction = new PhysicalAttackAction();
		blockAction = new BlockAction();
		magicAttackAction = new MagicAttackAction();
		spellReflectAction = new SpellReflectAction();
		rangeAttackAction = new RangeAttackAction();
		armorAction = new ArmorAction();
	}
	
	public PhysicalAttackAction getPhysicalAttackAction() 
	{
		return physicalAttackAction;
	}
	
	public BlockAction getBlockAction() {
		return blockAction;
	}

	public MagicAttackAction getMagicAttackAction() {
		return magicAttackAction;
	}

	public SpellReflectAction getSpellReflectAction() {
		return spellReflectAction;
	}

	public RangeAttackAction getRangeAttackAction() {
		return rangeAttackAction;
	}

	public ArmorAction getArmorAction() {
		return armorAction;
	}
}
