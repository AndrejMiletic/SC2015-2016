package gui;

import java.awt.FlowLayout;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class GameRulesToolBar extends JToolBar
{
	private static final long serialVersionUID = 7252736437793533610L;

	public GameRulesToolBar() 
	{
		super(SwingConstants.HORIZONTAL);		
		setLayout(new FlowLayout(FlowLayout.CENTER));		
		setFloatable(false);
		add(MainFrame.getInstance().getActionManager().getGameRulesAction());
	}
}
