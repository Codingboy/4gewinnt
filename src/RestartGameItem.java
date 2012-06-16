import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class RestartGameItem extends JMenuItem
{
	GameLogik gameLogik;
	VoteDrawItem voteDrawItem;
	
	public RestartGameItem(GameLogik gameLogik)
	{
		this.gameLogik = gameLogik;
		setText("restart");
		setEnabled(false);
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				voteDrawItem.setEnabled(true);
				//TODO
			}
		});
	}
}
