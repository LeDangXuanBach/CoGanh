package com.nlu.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import com.nlu.model.Positon;

public class Mark {
	private Positon positon;
	private Ellipse2D.Double e;
	private int radius = 20;
	public Color color = new Color(69,205,25, 0);
	

	public Mark(Positon positon) {
		super();
		this.positon = positon;
	}
	
	public Positon getPositon() {
		return positon;
	}

	public void setPositon(Positon positon) {
		this.positon = positon;
	}


	public void draw(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		e = new Ellipse2D.Double(positon.getCol() * 203 - radius + 43, positon.getRow() * 203 - radius + 43, radius * 2,
				radius * 2);
		graphics2d.setColor(color);
		graphics2d.fill(e);

	}

	public boolean isContainPoint(int x, int y) {
		return e.contains(new Point(x, y));
	}

}
