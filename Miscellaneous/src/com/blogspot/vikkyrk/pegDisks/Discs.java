package com.blogspot.vikkyrk.pegDisks;

public class Discs {
	public int radius;
	public int currentPegId;
	int destinationPegId;
	
	public Discs(int rad, int id, int dest) {
		radius = rad;
		currentPegId = id;
		destinationPegId = dest;
	}
	
	@Override
	public String toString() {
	/*	return "(Radius=" + radius + "-CurPeg=" + currentPegId 
				+ "-DestPeg=" + destinationPegId + ")";*/
		
		return "" + currentPegId+radius;
	}

}
