package com.nlu.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import com.nlu.model.Board;
import com.nlu.model.Check;
import com.nlu.model.Chessman;
import com.nlu.model.Positon;

public class BoardPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Board board = new Board();
	private int turn = 0;
	private ArrayList<Positon> continuePos = new ArrayList<>();
	private boolean isChoosedChessman = false;
	private ArrayList<Mark> arrlMark;
	public BoardPanel() {
		init();
		addComps();
		createListMark();
		addEvents();
	}

	private void init() {
//		this.setPreferredSize(new Dimension(814, 814));
	}

	private void addComps() {
		
	}

	private void addEvents() {
		MouseAdapter adapter = new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				moveChessman(e.getX(), e.getY());
				isPressedChessman(e.getX(), e.getY());
			}

		};
		
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
	}
	
	private void isPressedChessman(int x, int y) {
		allChessmainNotChoose();
		continuePos.clear();
		isChoosedChessman = false;
		for (Chessman chessman : board.chesses) {
			if (chessman.isContainPoint(x, y)) {
				allChessmainNotChoose();
				continuePos = Check.allPosCanGo(board, chessman);
				chessman.isChoose = true;
				isChoosedChessman = true;
				break;
			}

		}
		repaint();

	}
	
	private void moveChessman(int x, int y) {
		Chessman chessmanIsChoose = null;
		for (Chessman chessman : board.chesses) {
			if(chessman.isChoose == true) chessmanIsChoose = chessman;
		}
		if(chessmanIsChoose != null) {
			for (Mark mark : arrlMark) {
				if(mark.isContainPoint(x, y)) {
					board.chessMove(chessmanIsChoose, mark.getPositon());
					break;
				}
			}
		}
		repaint();
	}
	
	
	
	
	
	
	
	
	private void allChessmainNotChoose() {
		for (Chessman chessman : board.chesses) {
			chessman.isChoose = false;
		}
	}
	
	private Positon convertPos(int x, int y) {
		double a = (x -43) / 203;
		double b = (y -43) / 203;
		System.out.println(a +"fffff"+ b);
		Positon result = new Positon(x, y);
		return result;
	}
	
	private void drawContinuePos(Graphics2D g2D, Positon pos) {
		int y = pos.getRow() * 203 + 43;
		int x = pos.getCol() * 203 + 43;
		g2D.drawLine(x - 10, y + 5 , x - 4, y + 5);
		g2D.drawLine(x + 10, y + 5 , x + 5, y + 5);
		g2D.drawLine(x - 10, y -4 , x - 4, y - 4);
		g2D.drawLine(x + 10, y -4 , x + 5, y - 4);
		
		g2D.drawLine(x + 5, y + 10 , x + 5, y + 5);
		g2D.drawLine(x + 5, y - 4 , x + 5, y - 10);
		g2D.drawLine(x - 4, y + 5 , x - 4, y + 10);
		g2D.drawLine(x - 4, y - 4 , x - 4, y - 10);
	}
	
	private void createListMark() {
		arrlMark = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				arrlMark.add(new Mark(new Positon(i, j)));
			}
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(3));
		
		g2D.setPaint(new Color(34,17,4));
		g2D.fillRect(0, 0, 900, 900);
		g2D.setPaint(new Color(88,46,2));

		g2D.drawLine(44, 44, 44, 858);
		g2D.drawLine(247, 44, 247, 858);
		g2D.drawLine(450, 44, 450, 858);
		g2D.drawLine(653, 44, 653, 858);
		g2D.drawLine(856, 44, 856, 858);
		 
		g2D.drawLine(44, 44, 856, 44);
		g2D.drawLine(44, 247, 856, 247);
		g2D.drawLine(44, 450, 856, 450);
		g2D.drawLine(44, 653, 856, 653);
		g2D.drawLine(44, 858, 856, 858);
		
		g2D.drawLine(45, 45, 856, 858);
		g2D.drawLine(45, 858, 856, 44);
		
		g2D.drawLine(45, 450, 450, 44);
		g2D.drawLine(450, 858, 856, 450);
		
		g2D.drawLine(45, 450, 450, 858);
		g2D.drawLine(450, 44, 856, 450);
		
		
		ArrayList<Chessman> ss = board.chesses;
		for (Chessman chessman : ss) {
			chessman.draw(g);
		}
		for (Mark mark : arrlMark) {
			mark.draw(g);
		}
		g2D.setPaint(new Color(111,253,194));
		for (Positon pos : continuePos) {
			drawContinuePos(g2D, pos);
		}
	}

}
