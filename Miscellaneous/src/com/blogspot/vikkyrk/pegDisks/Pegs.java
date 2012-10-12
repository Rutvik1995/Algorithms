package com.blogspot.vikkyrk.pegDisks;



public class Pegs extends myArrayStack<Discs>{
	public int myId;
	public Pegs(int size, int id) {
		super(size);
		myId = id;
	}
}
