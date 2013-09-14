package ex3;

import Triple.Triple;

public class Point {
	private RGB color;
	private Triple location;
	
	public Point(Triple location, RGB color){
		this.location = location;
		this.color = color;
	}
	
	public Point(double[] location, int[] rgb){
		this.location = new Triple(location[0], location[1], location[2]);
		this.color = new RGB(rgb[0], rgb[1], rgb[2]);
	}
	
	public Triple getLocation(){
		return location;
	}
	
	public RGB getColor(){
		return color;
	}
	
	public String toString(){
		return location.getX() + " " + location.getY() + " " + location.getZ() + " " + color.getRGB();
	}
}
