package com.nlu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.nlu.view.OptionsPanel;

public class ChooseLevel implements ActionListener {
	private OptionsPanel optionsPanel;
	
	public ChooseLevel(OptionsPanel optionsPanel) {
		super();
		this.optionsPanel = optionsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Auto":
			optionsPanel.level = 10;
			break;
		case "Level 0":
			optionsPanel.level = 0;
			break;
		case "Level 1":
			optionsPanel.level = 1;
			break;
		case "Level 2":
			optionsPanel.level = 2;
			break;
		case "Level 3":
			optionsPanel.level = 3;
			break;
		case "Level 4":
			optionsPanel.level = 4;
			break;
		case "Level 5":
			optionsPanel.level = 5;
			break;
		case "Level 6":
			optionsPanel.level = 6;
			break;
		case "Level 7":
			optionsPanel.level = 7;
			break;
		case "Level 8":
			optionsPanel.level = 8;
			break;
		case "Level 9":
			optionsPanel.level = 9;
			break;

		default:
			break;
		}
	}

}
