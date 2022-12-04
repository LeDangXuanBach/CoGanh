package com.nlu.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	public StartPanel startPanel;
	public PlayPanel playPanel;
	public RankingPanel rankingPanel;
	public OptionsPanel optionsPanel;
	
	public Gui() {
		init();
		addCompos();
		addEvents();
		this.setVisible(true);
	}

	private void init() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new CardLayout());
	}

	private void addCompos() {
		startPanel = new StartPanel(this);
		playPanel = new PlayPanel(this);
		rankingPanel = new RankingPanel(this);
		optionsPanel = new OptionsPanel(this);
		
		
		this.add("1",startPanel);
		this.add("2", playPanel);
		this.add("3", rankingPanel);
		this.add("4", optionsPanel);
	}

	private void addEvents() {
		
	}

}
