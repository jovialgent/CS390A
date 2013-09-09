package ex3;

import Triple.Triple;

public class Point {
	private RGB color;
	private Triple location;
	
	public Point(Triple location, RGB color){
		this.location = location;
		this.color = color;
	}
	
	public Triple getLocation(){
		return location;
	}
	
	public RGB getColor(){
		return color;
	}
}
