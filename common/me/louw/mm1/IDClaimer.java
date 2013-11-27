package me.louw.mm1;

public class IDClaimer {
	private int currentID = 500;

	public IDClaimer(int startID) {
		currentID = startID;
	}

	public int get() {
		int id = currentID;
		currentID++;
		return id;
	}
}
