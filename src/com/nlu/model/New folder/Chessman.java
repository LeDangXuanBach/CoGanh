package model;

public class Chessman {
	Integer value;
	Positon positon;
	Check checkMove;
	
	public Chessman(Integer value, Positon positon) {
		super();
		this.value = value;
		this.positon = positon;
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

}
