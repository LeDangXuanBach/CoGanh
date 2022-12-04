package com.nlu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nlu.controller.ShowCard;
import com.nlu.controller.UpdateRanking;

public class StartPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Gui gui;
	JButton bt_continue, bt_newgame, bt_options, bt_ranking, bt_quit;
	public StartPanel(Gui gui) {
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
		
		Font font_bt = new Font("Tahoma", Font.BOLD, 20);
		// container
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setSize(600,600);
		container.setLocation(600, 210);
		container.setLayout(null);
		
		// title
		JLabel title = new JLabel("Co Ganh", SwingConstants.CENTER);
		title.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 50));
		title.setBounds(0, 0, 600, 150);
		container.add(title);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(100, 150, 400, 400);
		panel.setLayout(new GridLayout(5,1,0,30));
		
		
		bt_continue = new JButton("Continue");
		bt_continue.setFont(font_bt);
		bt_newgame = new JButton("New Game");
		bt_newgame.setFont(font_bt);
		bt_options = new JButton("Options");
		bt_options.setFont(font_bt);
		bt_ranking = new JButton("Ranking");
		bt_ranking.setFont(font_bt);
		bt_quit = new JButton("Quit");
		bt_quit.setFont(font_bt);
		
		
		panel.add(bt_continue);
		panel.add(bt_newgame);
		panel.add(bt_options);
		panel.add(bt_ranking);
		panel.add(bt_quit);
		container.add(panel);

	
		

	
		this.add(container);
		
	}

	private void addEvents() {
		bt_quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		ActionListener ac = new ShowCard(gui);
		bt_continue.addActionListener(ac);
		bt_newgame.addActionListener(ac);
		bt_options.addActionListener(ac);
		bt_ranking.addActionListener(ac);
		
		ActionListener updateRanking = new UpdateRanking(gui);
		bt_ranking.addActionListener(updateRanking);
	}
}
