package com.nlu.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListPlayer implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Player> listPlayer;

	public ListPlayer() {
		super();
		this.listPlayer = new ArrayList<>();
	}
	
	public void addPlayer(Player player) {
		listPlayer.add(player);
		Collections.sort(this.listPlayer, Comparator.reverseOrder());
	}
	
	
	public List<Player> getListPlayer() {
		return listPlayer;
	}

	public String toString() {
		String result = "";
		for (Player player : listPlayer) {
			result += player.toString() + "\n";
		}
		return result;
	}
	
	public void saveList() throws IOException {
		File file = new File("D:\\CoganhData");
		if(!file.exists()) file.mkdir();
		ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("D:\\CoganhData\\data.bat"));
		objectOutput.writeObject(this);
		objectOutput.close();
	}
	
	public static ListPlayer readList() throws IOException, Exception{
		ListPlayer result = null;
		File file = new File("D:\\CoganhData\\data.bat");
		if(!file.exists()) return null;
		try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file))) {
			result = (ListPlayer) objectInput.readObject();
			objectInput.close();
		}
		return result;
	}
	
//	public static void main(String[] args) throws IOException {
//		ListPlayer m = new ListPlayer();
//		m.addPlayer(new Player("Lê Đặng Xuân Bách", 5, "time"));
//		m.addPlayer(new Player("Nguyễn Văn Trường", 10, "time"));
//		m.addPlayer(new Player("Nguyễn Văn Trường", 4, "time"));
//		m.addPlayer(new Player("Lê Đặng Xuân Bách", 6, "time"));
//		
//		m.saveList();
//	}

	
}
