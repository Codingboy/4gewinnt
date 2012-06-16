import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PlayerDeleteFrame extends JFrame
{
	JButton delete;
	JButton abort;
	JComboBox players;
	
	public PlayerDeleteFrame()
	{
		this.delete = new JButton("delete");
		this.delete.setEnabled(false);
		this.delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Object obj = players.getSelectedItem();
				if (obj instanceof Player)
				{
					Player p = (Player) obj;
					Settings.players.remove(p);
				}
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
		this.players = new JComboBox(Settings.players.toArray());
		this.players.setSelectedIndex(-1);
		this.players.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (players.getSelectedIndex() == -1)
				{
					delete.setEnabled(false);
				}
				else
				{
					delete.setEnabled(true);
				}
			}
		});
		JPanel panel = new JPanel();
		panel.add(this.players);
		panel.add(this.delete);
		panel.add(this.abort);
		add(panel);
		
		setTitle("Delete Player");
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
