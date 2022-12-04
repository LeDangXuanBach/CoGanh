package com.nlu.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.nlu.view.Gui;

public class ShowCard implements ActionListener {
	private Gui gui;
	

	public ShowCard(Gui gui) {
		super();
		this.gui = gui;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout)gui.getContentPane().getLayout();
		switch (e.getActionCommand()) {
		case "Continue":
			cardLayout.show(gui.getContentPane(), "2");
			break;
		case "New Game":
			cardLayout.show(gui.getContentPane(), "2");
			break;
		case "Ranking":
			cardLayout.show(gui.getContentPane(), "3");

			break;
		case "Options":
			cardLayout.show(gui.getContentPane(), "4");
			break;
		case "Back":
			cardLayout.show(gui.getContentPane(), "1");
			break;

		default:
			break;
		}
		
	}

	

}
