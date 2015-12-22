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
	private HealAction healAction;
	private SilenceAction silenceAction;
	
	public ActionManager() 
	{
		physicalAttackAction = new PhysicalAttackAction();
		blockAction = new BlockAction();
		magicAttackAction = new MagicAttackAction();
		spellReflectAction = new SpellReflectAction();
		healAction = new HealAction();
		silenceAction = new SilenceAction();
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

	public HealAction getHealAction() {
		return healAction;
	}

	public SilenceAction getSilenceAction() {
		return silenceAction;
	}
	
	
}
