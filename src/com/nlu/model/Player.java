package com.nlu.model;

import java.io.Serializable;


public class Player implements Serializable, Comparable<Player> {
	private static final long serialVersionUID = 1L;
	private String name;
	private int socre;
	private String time;
	public Player(String name, int socre, String time) {
		super();
		this.name = name;
		this.socre = socre;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSocre() {
		return socre;
	}
	public void setSocre(int socre) {
		this.socre = socre;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String toString() {
		return this.name +" - "+ this.socre +" - "+ this.time;
	}
	public String[] toArray() {
		String[] result = {this.name, this.socre + "", this.time};
		return result;
	}
	@Override
	public int compareTo(Player other) {
		if(this.socre < other.getSocre()) return -1;
		if(this.socre > other.getSocre()) return 1;
		return 0;
	}

}
