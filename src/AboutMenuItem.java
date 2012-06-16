import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class AboutMenuItem extends JMenuItem
{
	public AboutMenuItem()
	{
		setText("About");
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null, "about scull", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
