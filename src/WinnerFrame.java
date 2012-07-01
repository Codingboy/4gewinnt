import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinnerFrame extends JFrame
{
	JLabel label;
	
	public WinnerFrame(Player player)
	{
		if (player == null)
		{
			label = new JLabel("Draw");
		}
		else
		{
			label = new JLabel("Winner: " + player.getName());
		}
		add(label);
		setTitle("Game Over");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
