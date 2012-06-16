import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class PlayerAddItem extends JMenuItem
{
	public PlayerAddItem()
	{
		setText("add");
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				new PlayerAddFrame();
			}
		});
	}
}
