import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


public class PlayerAddFrame extends JFrame
{
	JButton ok;
	JButton abort;
	JLabel nameLabel;
	JTextField nameField;
	JCheckBox bot;
	
	public PlayerAddFrame()
	{
		this.ok = new JButton("OK");
		this.ok.setEnabled(false);
		this.ok.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Settings.players.add(new Player(nameField.getText()));
				dispose();
			}
		});
		this.abort = new JButton("abort");
		this.abort.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		this.nameLabel = new JLabel("name:");
		this.nameField = new JTextField("");
		this.nameField.setColumns(16);
		this.nameField.addCaretListener(new CaretListener()
		{
			@Override
			public void caretUpdate(CaretEvent e)
			{
				String str = nameField.getText();
				if (!validName(str))
				{
					ok.setEnabled(false);
				}
				else
				{
					ok.setEnabled(true);
				}
			}
		});
		this.bot = new JCheckBox("bot");
		JPanel panel = new JPanel();
		panel.add(this.nameLabel);
		panel.add(this.nameField);
		panel.add(this.bot);
		panel.add(this.ok);
		panel.add(this.abort);
		add(panel);
		
		setTitle("Add Player");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/**
	 * Tests if player is valid name for a new player.
	 * @param player new name to test
	 * @return true if valid
	 */
	static boolean validName(String player)
	{
		if (player == null)
		{
			return false;
		}
		if (player.equals(""))
		{
			return false;
		}
		for (int i=0; i<Settings.players.size(); i++)
		{
			if (player.equals(Settings.players.get(i).getName()))
			{
				return false;
			}
		}
		return true;
	}
}
