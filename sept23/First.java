package sept23;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;

public class First extends Basic {

	private double angle;
	private double x, y, dx, dy;

	public static void main(String[] args) {
		First test = new First();
		test.start();
	}

	public First() {
		super("A First Open GL APP", 500, 500, 30);
		angle = 0;
		y = 0.1;
		x = 0.1;
		dx = 0.1;
		dy = 0.1;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init() {

		// set up projection once and for all:
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glFrustum(-1, 1, -1, 1, 1, 1000);
		// switch to model view from this point on:
		glMatrixMode(GL_MODELVIEW);

		// set the background color:
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

	}

	/**
	 * This method holds all these key input handlers.
	 */
	@Override
	protected void processInputs() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		angle += 12;
		
		

	}

	@Override
	protected void display() {
		// TODO Auto-generated method stub

		// glViewport(250,250, 250, 250);

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		// Switch to model view

		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();

		glPushMatrix();
		glRotated(angle, 0, 1, 0);
		drawTriangle();
		glPopMatrix();
		glPushMatrix();
		glRotated(-angle, 0, 1, 0);
		drawTriangle();
		glPopMatrix();

		
	}

	private void drawTriangle() {
		glBegin(GL_POLYGON);
		glColor3f(1.0f, 0.0f, 0.0f);
		glVertex3d(0, 0, -3);
		glColor3f(0.0f, 0.0f, 1.0f);
		glVertex3d(2, 0, -3);
		glColor3f(0.0f, 1.0f, 0.0f);
		glVertex3d(0, 3, -3);
		glEnd();

	}

}
