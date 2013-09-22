package ex3;

import Triple.Triple;

/**
 * This Point class stores a color and a location of a point to be rendered on
 * the view point of an OpenGL screen.
 * 
 * @author George
 * 
 */
public class Point {

	// Global Variables
	private RGB color; // The color of the point
	private Triple location; // The Location of the point

	/**
	 * This constructor takes a Triple and an RGB of the point to be made
	 * 
	 * @param location
	 *            - A triple that stores the location of the point
	 * @param color
	 *            - The color of the point
	 */
	public Point(Triple location, RGB color) {
		this.location = location; // Sets the point to the location of the
									// triple
		this.color = color; // Sets the color of the point
	}

	/**
	 * This constructor takes a double array and an int array that creates the
	 * Point using primitives and creates the location and point using the
	 * arrays
	 * 
	 * @param location
	 *            - a double array detailing the location of a point
	 * @param rgb
	 *            - an int array detailing the Red, Green and Blue of the point
	 */
	public Point(double[] location, int[] rgb) {
		this.location = new Triple(location[0], location[1], location[2]); // Location
																			// of
																			// the
																			// point
		this.color = new RGB(rgb[0], rgb[1], rgb[2]); // The color of the point
	}

	/**
	 * Returns the Location of this point in a Triple
	 * 
	 * @return - the Triple storing the location of this Point
	 */
	public Triple getLocation() {
		return location; // Returns a triple of this location
	}

	/**
	 * Returns the Color of this point in a RGB variable
	 * 
	 * @return - the RGB storing the color of this point
	 */
	public RGB getColor() {
		return color; // This point's color
	}

	/**
	 * This is the toString for this class it returns the details of this point
	 * in the following syntax:
	 * 
	 * X value [Space] Y value [Space] Z value [Space] Red value [Space] Green
	 * value [Space] Blue value [Space]
	 */
	public String toString() {
		return location.getX() + " " + location.getY() + " " + location.getZ()
				+ " " + color.getRGB();
	}
}
