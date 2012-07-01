import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;


public class ControlButton extends JButton
{
	int buttonNumber;
	GameLogik gameLogik;
	JLabel actualPlayer;
	JLabel actualTeam;
	ControlButtonType type;
	GamePanel gamePanel;
	
	List<ControlButton> buttons;
	UndoItem undoItem;
	VoteDrawItem voteDrawItem;
	StartGameItem startGameItem;
	
	public ControlButton(final GameLogik gameLogik, final int buttonNumber, final JLabel actualTeam, final JLabel actualPlayer, final ControlButtonType type, final GamePanel gamePanel, final VoteDrawItem voteDrawItem, final UndoItem undoItem, final StartGameItem startGameItem)
	{
		this.startGameItem = startGameItem;
		this.undoItem = undoItem;
		this.voteDrawItem = voteDrawItem;
		this.gameLogik = gameLogik;
		this.gamePanel = gamePanel;
		this.type = type;
		this.buttonNumber = buttonNumber;
		this.actualTeam = actualTeam;
		this.actualPlayer = actualPlayer;
		setText(String.valueOf(buttonNumber));//TODO replace with picture
		setPreferredSize(new Dimension(Settings.IconWidth, Settings.IconHeight));
		setEnabled(false);
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				switch (type)
				{
					case pushTop:
						gameLogik.pushTop(buttonNumber);
						break;
					case popBottom:
						gameLogik.popBottom(buttonNumber);
						break;
					default:
						System.err.println("operation not known");
				}
				actualPlayer.setText(gameLogik.getActualPlayer().getName());
				actualTeam.setText(String.valueOf(gameLogik.getActualTeam()));
				if (gameLogik.isFinish())
				{
					if (gameLogik.getWinner() == null)
					{
						System.err.println("no winner");
						new WinnerFrame(null);
					}
					else
					{
						System.out.println("winner is "+gameLogik.getWinner());
						new WinnerFrame(gameLogik.getWinner());
					}
					for (int i=0; i<buttons.size(); i++)
					{
						buttons.get(i).setEnabled(false);
					}
					undoItem.setEnabled(false);
					voteDrawItem.setEnabled(false);
					startGameItem.setEnabled(true);
				}
				gamePanel.repaint();
			}
		});
	}
}
