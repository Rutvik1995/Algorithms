package com.blogspot.vikkyrk;


public class Pegs extends myArrayStack<Discs>{
	public int myId;
	public Pegs(int size, int id) {
		super(size);
		myId = id;
	}
}
