package com.nlu.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.nlu.controller.ShowCard;

public class PlayPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Gui gui;
	JButton bt_back;
	
	public PlayPanel(Gui gui) {
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
		container.setSize(900,900);
		container.setLocation(525, 50);
		container.setLayout( new GridLayout());
		JPanel j = new BoardPanel();
		container.add(j);
		
		

		
		
		bt_back = new JButton("Back");
		bt_back.setBounds(400, 50, 75, 30);
		
		
		this.add(container);
		this.add(bt_back);
	
		
	}

	private void addEvents() {
		ActionListener ac = new ShowCard(gui);
		bt_back.addActionListener(ac);
		
	}
}
