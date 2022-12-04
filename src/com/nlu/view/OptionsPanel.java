package com.nlu.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import com.nlu.controller.ChooseLevel;
import com.nlu.controller.ChoosePlay;
import com.nlu.controller.ShowCard;

public class OptionsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Gui gui;
	JButton bt_back;
	public int level = 10;
	public boolean isPlayPeople = false;
	
	JRadioButton level_zero, level_one, level_tow, level_three, level_four, level_five, level_six, level_seven, level_eight, level_nine,level_auto, play_people, play_machine;
	JRadioButton[] arrRadioLevel = {level_zero,level_one, level_tow, level_three, level_four, level_five, level_six, level_seven, level_eight, level_nine,level_auto};

	public OptionsPanel(Gui gui) {
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
		
		Font font_radio = new Font("Tahoma", Font.BOLD, 18);
		// container
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setSize(600,600);
		container.setLocation(600, 210);
		container.setLayout(null);
		
		// title
		JLabel title = new JLabel("Options", SwingConstants.CENTER);
		title.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 50));
		title.setBounds(0, 0, 600, 100);
		container.add(title);
		
		// panel choose play with
		
		JPanel panelPlayWith = new JPanel();
		panelPlayWith.setBounds(50, 125, 500, 100);
		panelPlayWith.setBackground(new Color(213,153,86));
		panelPlayWith.setLayout(null);
		
		JLabel jLabel_PlayWith = new JLabel("Play With", SwingConstants.LEFT);
		jLabel_PlayWith.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 20));
		jLabel_PlayWith.setBounds(0, 0, 500, 50);
		panelPlayWith.add(jLabel_PlayWith);
		
		
		JPanel panel_chosePlay = new JPanel();
		panel_chosePlay.setBounds(0,50,500,50);
		panel_chosePlay.setLayout(new FlowLayout(0));
		
		play_people = new JRadioButton("Play With People");
		play_people.setFont(font_radio);
		play_machine = new JRadioButton("Play With Machine");
		play_machine.setFont(font_radio);
		play_machine.setSelected(true);
		
		ButtonGroup playGroup = new ButtonGroup();
		playGroup.add(play_machine);
		playGroup.add(play_people);
		
		panel_chosePlay.add(play_machine);
		panel_chosePlay.add(play_people);
		panelPlayWith.add(panel_chosePlay);
		container.add(panelPlayWith);
		
		
		// panel choose level
		
		JPanel panelLevel = new JPanel();
		panelLevel.setBounds(50, 250, 500, 250);
		panelLevel.setBackground(new Color(213,153,86));
		panelLevel.setLayout(null);
		
		JLabel jLabel_Level = new JLabel("Chose Level", SwingConstants.LEFT);
		jLabel_Level.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 20));
		jLabel_Level.setBounds(0, 0, 500, 50);
		panelLevel.add(jLabel_Level);
		
		
		JPanel panel_choseLevel = new JPanel();
		panel_choseLevel.setBounds(0,50,500,200);
		panel_choseLevel.setLayout(new GridLayout(3, 4, 20, 20));
		
		

		ButtonGroup levelGroup = new ButtonGroup();
		level_auto = new JRadioButton("Auto");
		level_auto.setFont(font_radio);
		level_auto.setSelected(true);
		levelGroup.add(level_auto);
		panel_choseLevel.add(level_auto);
		for(int i = 0; i < arrRadioLevel.length - 1; i++) {
			arrRadioLevel[i] = new JRadioButton("Level " + i);
			arrRadioLevel[i].setFont(font_radio);
			levelGroup.add(arrRadioLevel[i]);
			panel_choseLevel.add(arrRadioLevel[i]);
		}
	
		

		panelLevel.add(panel_choseLevel);
		container.add(panelLevel);

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
		
		ActionListener choosePlay = new ChoosePlay(this);
		play_machine.addActionListener(choosePlay);
		play_people.addActionListener(choosePlay);
		
		
		ActionListener chooseLevel = new ChooseLevel(this);
		level_auto.addActionListener(chooseLevel);
		for(int i = 0; i < arrRadioLevel.length - 1; i++) {
			arrRadioLevel[i].addActionListener(chooseLevel);
		}
		
	}

	public void enableAllBtLevel() {
		level_auto.setEnabled(false);
		for (int i = 0; i < arrRadioLevel.length - 1; i++) {
			arrRadioLevel[i].setEnabled(false);
		}
	}

	public void disableAllBtLevel() {
		level_auto.setSelected(true);
		level_auto.setEnabled(true);
		for (int i = 0; i < arrRadioLevel.length - 1; i++) {
			arrRadioLevel[i].setEnabled(true);
		}
	}
}
