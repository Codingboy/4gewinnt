
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StartGameFrame extends JFrame
{
	class PlayerPanel extends JPanel
	{
		JTextField player;
		JTextField team;
		
		public PlayerPanel(String player, int team)
		{
			this.player = new JTextField(player);
			this.player.setEditable(false);
			this.team = new JTextField(String.valueOf(team));
			add(this.player);
			add(this.team);
		}
	}
	
	GameLogik gameLogik;
	JComboBox players;
	JButton add;
	List<PlayerPanel> playerPanel;
	JButton start;
	JButton abort;
	int addCounter;
	JPanel panel;
	
	public StartGameFrame(final GameLogik gameLogik)
	{
		this.addCounter = 0;
		this.gameLogik = gameLogik;
		this.players = new JComboBox(Settings.players.toArray());
		this.add = new JButton("add");
		this.add.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				int index = players.getSelectedIndex();
				if (index == -1)
				{
					return;
				}
				Object obj = players.getSelectedItem();
				if (obj instanceof Player)
				{
					Player p = (Player) obj;
					PlayerPanel pp = new PlayerPanel(p.getName(), addCounter);
					playerPanel.add(pp);
					panel.add(pp);
					addCounter++;
					start.setEnabled(true);
					players.removeItemAt(index);
					if (players.getSelectedIndex() == -1)
					{
						add.setEnabled(false);
					}
					repaint();
				}
			}
		});
		this.playerPanel = new ArrayList<StartGameFrame.PlayerPanel>();
		this.start = new JButton("start");
		this.start.setEnabled(false);
		this.start.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Map<Player, Integer> map = new HashMap<Player, Integer>();
				for (int i=0; i<playerPanel.size(); i++)
				{
					Player p = null;
					for (int j=0; j<Settings.players.size(); j++)
					{
						if (Settings.players.get(j).getName().equals(playerPanel.get(i).player.getText()))
						{
							p = Settings.players.get(j);
						}
					}
					map.put(p, Integer.valueOf(playerPanel.get(i).team.getText()));
				}
				gameLogik.start(map, Settings.GameBoardWidth, Settings.GameBoardHeight);
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
		
		this.panel = new JPanel();
		panel.add(this.players);
		panel.add(this.add);
//		panel.add(this.playerPanel);
		panel.add(this.start);
		panel.add(this.abort);
		add(panel);

		setTitle("Start Game");
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
