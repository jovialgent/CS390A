package ex6;

import static org.lwjgl.opengl.GL11.*;

public class Block {
	
	public static void drawBlock(double x, double y, double z){
		glPushMatrix();
		glTranslated(x, y, z);
		Shape.make1by1Cube();
		glPopMatrix();
	}
	
	public static void drawPenBlock(double x, double y, double z){
		glPushMatrix();
		glTranslated(x, y, z);
		Shape.make2by2Cube();
		glPopMatrix();
	}

}
