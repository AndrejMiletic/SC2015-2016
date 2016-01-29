package gui;

import java.awt.FlowLayout;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class UtilitiesToolBar extends JToolBar
{
	private static final long serialVersionUID = 7252736437793533610L;

	public UtilitiesToolBar() 
	{
		super(SwingConstants.HORIZONTAL);		
		setLayout(new FlowLayout(FlowLayout.CENTER));		
		setFloatable(false);
		add(MainFrame.getInstance().getActionManager().getGameRulesAction());
		add(MainFrame.getInstance().getActionManager().getActiveLearningAction());
		add(MainFrame.getInstance().getActionManager().getEmptyFileAction());
	}
}
