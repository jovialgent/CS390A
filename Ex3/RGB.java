package ex3;

import org.lwjgl.opengl.GL11;

public class RGB {
	private float red, green, blue;
	
	/**
	 * This constructor will take three integers as RGB inputs and then convert them to
	 * a float value to use with the GL11.glColor3f.
	 * @param r - red value
	 * @param g - green value
	 * @param b - blue value
	 */
	public RGB(int r, int g, int b){
		this.red = (float) (r/255.0);
		this.green = (float) (g/255.0);
		this.blue = (float) (b/255);
	}
	
	/**
	 * Returns the red float variable
	 * @return red value
	 */
	public float getRed(){
		return red;
	}
	
	/**
	 * Returns the green float variable
	 * @return green value
	 */
	public float getGreen(){
		return green;
	}
	
	/**
	 * Returns the blue float variable
	 * @return the blue float value
	 */
	public float getBlue(){
		return blue;
	}
	
	public static RGB RED = new RGB(255,0,0);
	public static RGB BLUE = new RGB(0,0,255);

}
