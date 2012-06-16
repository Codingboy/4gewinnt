import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class SettingsMenuItem extends JMenuItem
{
	public SettingsMenuItem()
	{
		setText("Settings");
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null, "settings scull", "Settings", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
