import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class PlayerDeleteItem extends JMenuItem
{
	public PlayerDeleteItem()
	{
		setText("delete");
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				new PlayerDeleteFrame();
			}
		});
	}
}
