package com.nlu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.nlu.view.OptionsPanel;

public class ChoosePlay implements ActionListener {
	private OptionsPanel optionsPanel;
	
	public ChoosePlay(OptionsPanel optionsPanel) {
		super();
		this.optionsPanel = optionsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Play With People")) {
			optionsPanel.isPlayPeople = true;
			optionsPanel.enableAllBtLevel();
		}else {
			optionsPanel.isPlayPeople = false;
			optionsPanel.level = 10;
			optionsPanel.disableAllBtLevel();
		}
	}

}
