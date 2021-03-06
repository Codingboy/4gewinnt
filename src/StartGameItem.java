import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;


public class StartGameItem extends JMenuItem
{
	GameLogik gameLogik;
	RestartGameItem restartGameItem;
	QuitGameItem quitGameItem;
	UndoItem undoItem;
	VoteDrawItem voteDrawItem;
	List<ControlButton> buttons;
	StartGameItem thiss;//FIXME workaround
	
	public StartGameItem(final GameLogik gameLogik)
	{
		this.thiss = this;
		this.gameLogik = gameLogik;
		setText("start");
		setEnabled(true);
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				new StartGameFrame(gameLogik, buttons, restartGameItem, quitGameItem, undoItem, voteDrawItem, thiss);
			}
		});
	}
}
