package com.nlu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.nlu.model.ListPlayer;
import com.nlu.view.Gui;

public class UpdateRanking implements ActionListener {
	private Gui gui;
	private ListPlayer ranking;

	public UpdateRanking(Gui gui) {
		super();
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			try {
				ranking = ListPlayer.readList();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(ranking != null) this.gui.rankingPanel.updatRanking(ranking);
	
	}

}
