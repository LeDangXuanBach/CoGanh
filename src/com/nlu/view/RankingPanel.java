package com.nlu.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.nlu.controller.ShowCard;
import com.nlu.model.ListPlayer;
import com.nlu.model.Player;

public class RankingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Gui gui;
	JButton bt_back;
	JTable ranking;
	public RankingPanel(Gui gui) {
		this.gui = gui;
		init();
		addCompos();
		addEvents();
	}

	private void init() {
		this.setBackground(Color.black);
		this.setLayout(null);
	}

	private void addCompos() {
		
		JPanel container = new JPanel();
		container.setBackground(Color.white);
		container.setSize(600,600);
		container.setLocation(600, 210);
		container.setLayout(null);
		
		
		JLabel title = new JLabel("Ranking", SwingConstants.CENTER);
		title.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 50));
		title.setBounds(0, 0, 600, 100);
		title.setBackground(Color.black);
		container.add(title);
		
	    String[] columnNames = {"Name", "Score", "Time"};
        Object[][] data = {{"-----", "-----", "-----"},{"-----", "-----", "-----"},{"-----", "-----", "-----"},{"-----", "-----", "-----"},
        		{"-----", "-----", "-----"},{"-----", "-----", "-----"},{"-----", "-----", "-----"},{"-----", "-----", "-----"},{"-----", "-----", "-----"},
        		{"-----", "-----", "-----"}};
        ranking = new JTable(data, columnNames);
        ranking.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(ranking);
        scrollPane.setBounds(50, 100, 500, 450);
		
		container.add(scrollPane);
		container.add(Box.createVerticalGlue());
		
		JPanel panel = new JPanel();
		bt_back = new JButton("Back");
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(Color.BLACK);
		panel.add(bt_back);
		panel.setBounds(0, 550, 600, 50);

		container.add(panel);
		this.add(container);
		
		
		
	}

	private void addEvents() {
		ActionListener ac = new ShowCard(gui);
		bt_back.addActionListener(ac);
	}
	
	public void updatRanking(ListPlayer listPlayer) {
		ArrayList<Player> list = (ArrayList<Player>) listPlayer.getListPlayer();
		int n = list.size();
		if(n > 10) n = 10;
		for(int i = 0; i < n; i++) {
			ranking.setValueAt(list.get(i).getName(), i, 0);
			ranking.setValueAt(list.get(i).getSocre(), i, 1);
			ranking.setValueAt(list.get(i).getTime(), i, 2);
		}
		
		
	}
}
