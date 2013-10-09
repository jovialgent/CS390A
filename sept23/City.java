package sept23;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.glu.GLU;
import Triple.Triple;

public class City extends Basic {

	private double angle;
	private double x, y, dx, dy;
	private Triple camPos;
	private double camAzimuth;

	public static void main(String[] args) {
		City test = new City();
		test.start();
	}

	public City() {
		super("A First Open GL APP", 1000, 500, 30);
		angle = 0;
		y = 0.1;
		x = 0.1;
		dx = 0.1;
		dy = 0;
		camPos = new Triple(500, 500, 2);
		camAzimuth = 100;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init() {
		glEnable(GL_DEPTH_TEST);
		// set up projection once and for all:
		
		
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
		Keyboard.poll();
		double amount = 1;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			camPos.setX(amount + camPos.getX());
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			camPos.setX(camPos.getX() - amount);
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			camPos.setY(amount + camPos.getY());
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			camPos.setY(camPos.getY() - amount);
		}
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
			camPos.setZ(amount + camPos.getZ());
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_X)){
			camPos.setZ(camPos.getZ() - amount);
		}
		/*
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
			this.camAzimuth += 1;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			this.camAzimuth -= 1;
		}
		*/
		
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		angle += 3;
		//System.out.println(angle);
		dy = Math.random();

	}

	@Override
	protected void display() {
		// TODO Auto-generated method stub

		

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		
		glOrtho(-600, 600, -600, 600 ,-1000, 1000);
		glViewport(0, 0, 500, 500);
		// Switch to model view

		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		glTranslated(-500,-500,-550);
		//glRotated(270, 1, 0, 0);
		//glRotated(angle, 0, 0, 1);
		buildCity();
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glFrustum(-1, 1, -1, 1, 1, 1000);
		glViewport(500, 0, 500, 500);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		//glTranslated(-500,-500,-550);
		//glRotated(270, 1, 0, 0);
		//glRotated(angle, 0, 0, 1);
		GLU.gluLookAt((float) camPos.getX(), (float)  camPos.getY(), (float)  camPos.getZ(), 
				(float) camPos.getX() + (float)  Math.cos(Math.toRadians(this.camAzimuth)),
				(float)  camPos.getY() +(float)  Math.sin(Math.toRadians(this.camAzimuth)),
				(float)   camPos.getZ(),
				  0.0f,0.0f,1.0f);
		buildCity();

		
	}
	
	public void buildCity(){
		//glRotated(90, 1,0,0);
				glPushMatrix();
				//glTranslated(-500,-500,-550);
				glTranslated(500, 500,-1);
				glScaled(500,500,1);
				glRotated(180, 1,0,0);
				standardBox();
				glPopMatrix();
				
				
				this.building( 40, 40, 60, 500, 400, 0  );
				this.building(  40, 40, 60, 500, 600, 0);
				this.building(320, 80, 100, 700, 150, 45);
				this.building(30, 40, 50, 30, 920, -30);
				
	}
	
	public void building(double width, double length, double height, double centerX, double centerY, double angle){
		glPushMatrix();
		glTranslated(centerX, centerY, height/2);
		glRotated(angle, 0,0,1);
		glScaled(width/2, length/2, height/2);
		standardBox();
		glPopMatrix();
		
	}

	/**
	 * This method will create a standard 2x2x2 box that will be used 
	 * to create this City
	 */
	private void standardBox() {

		// Red
		glBegin(GL_POLYGON);
		glColor3f(1.0f, 0.0f, 0.0f);
		glVertex3d(-1, -1, -1);
		glVertex3d(1, -1, -1);
		glVertex3d(1, -1, 1);
		glVertex3d(-1, -1, 1);
		glEnd();

		// Green
		glBegin(GL_POLYGON);
		glColor3f(0.0f, 1.0f, 0.0f);
		glVertex3d(-1, 1, -1);
		glVertex3d(1, 1, -1);
		glVertex3d(1, 1, 1);
		glVertex3d(-1, 1, 1);
		glEnd();

		// Blue
		glBegin(GL_POLYGON);
		glColor3f(0, 0, 1.0f);
		glVertex3d(-1, -1, -1);
		glVertex3d(1, -1, -1);
		glVertex3d(1, 1, -1);
		glVertex3d(-1, 1, -1);
		glEnd();

		// Yellow
		glBegin(GL_POLYGON);
		glColor3f(1.0f, 1.0f, 0);
		glVertex3d(-1, -1, 1);
		glVertex3d(1, -1, 1);
		glVertex3d(1, 1, 1);
		glVertex3d(-1, 1, 1);
		glEnd();

		// Purple
		glBegin(GL_POLYGON);
		glColor3f(1.0f, 0.0f, 1.0f);
		glVertex3d(-1, -1, -1);
		glVertex3d(-1, -1, 1);
		glVertex3d(-1, 1, 1);
		glVertex3d(-1, 1, -1);
		glEnd();

		// Cyan
		glBegin(GL_POLYGON);
		glColor3f(0, 1.0f, 1.0f);
		glVertex3d(1, -1, -1);
		glVertex3d(1, -1, 1);
		glVertex3d(1, 1, 1);
		glVertex3d(1, 1, -1);
		glEnd();

	}

}
