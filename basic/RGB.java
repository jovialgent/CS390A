package basic;

import org.lwjgl.opengl.GL11;

/**
 * This RGB class takes the integers values of Red, Green and Blue then converts
 * them to floats to use with GL11.glColor3f
 * 
 * @author George
 * 
 */
public class RGB {
	private float red, green, blue;
	private int r, g, b;

	/**
	 * This constructor will take three integers as RGB inputs and then convert
	 * them to a float value to use with the GL11.glColor3f.
	 * 
	 * @param r
	 *            - red value
	 * @param g
	 *            - green value
	 * @param b
	 *            - blue value
	 */
	public RGB(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.red = (float) (r / 255.0);
		this.green = (float) (g / 255.0);
		this.blue = (float) (b / 255);
	}

	/**
	 * Returns the red float variable
	 * 
	 * @return red value
	 */
	public float getRed() {
		return red;
	}

	/**
	 * Returns the green float variable
	 * 
	 * @return green value
	 */
	public float getGreen() {
		return green;
	}

	/**
	 * Returns the blue float variable
	 * 
	 * @return the blue float value
	 */
	public float getBlue() {
		return blue;
	}

	/**
	 * Returns the Red, Green and Blue value of this class
	 * 
	 * @return - a String containing the Red, Green Blue values of this class
	 */
	public String getRGB() {
		return r + " " + g + " " + b;
	}

	public static RGB RED = new RGB(255, 0, 0); // Returns the color Red which
												// is (255, 0, 0)
	public static RGB BLUE = new RGB(0, 0, 255); // Returns the color Blue which
													// is (0, 0, 255)

}
