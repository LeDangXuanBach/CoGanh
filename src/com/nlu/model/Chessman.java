package com.nlu.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Chessman {
	Integer value;
	Positon positon;
	private Ellipse2D.Double e;
	private int radius = 20;
	public Color color;
	public boolean isChoose = false;


//	Check checkMove;
	
	public Chessman(Integer value, Positon positon) {
		super();
		this.value = value;
		this.positon = positon;
		updateColor();
	}

	public Chessman(Integer value) {
		super();
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Positon getPositon() {
		return positon;
	}

	public void move(Positon positon) {
		this.positon = positon;
	}

	@Override
	public String toString() {
		return value + "";
	}
	public Chessman clone() {
		return new Chessman(value, getPositon());
	}
	
	public void updateColor() {
		if (value == 1) {
//			color = new Color(255,98,5);
			color = new Color(255,4,132);
		} else {
			color = new Color(60,121,233);
		}
	}
	
	public void draw(Graphics g) {
		Graphics2D graphics2d = (Graphics2D)g;
		e = new Ellipse2D.Double(positon.getCol() * 203 - radius + 43, positon.getRow() * 203 - radius + 43, radius * 2, radius * 2);
		graphics2d.setColor(color);
		graphics2d.fill(e);
		if(isChoose == true) {
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setPaint(new Color(111,253,194));
			graphics2d.drawOval(positon.getCol() * 203 - radius + 43, positon.getRow() * 203 - radius + 43, radius * 2 + 2, radius * 2 + 2);			
		}
		
		
	}
	
	public boolean isContainPoint(int x, int y) {
		return e.contains(new Point(x, y));
	}
	
	
	

}
