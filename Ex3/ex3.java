package ex3;

//import java.awt.DisplayMode;



import java.util.ArrayList;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;

import Triple.*;


public class Ex3 extends Basic {
		private ArrayList<Point> points = new ArrayList<Point>();
	
		public Ex3(String fileName){
			super("Exercise 3", 500, 500, 40);
		}

		public static void main(String[] args){
			Ex3 test = new Ex3("test.txt"); 
			
			
			
			
			
			test.start();
		}
		
		
		
		@Override
		protected void init() {
			// set up projection once and for all:
		    glMatrixMode(GL_PROJECTION);
		    glLoadIdentity();
		    glOrtho( 0, 10, 0, 10, 1, -1 );
		    // switch to model view from this point on:
		    glMatrixMode( GL_MODELVIEW );

		    // set the background color:
		    glClearColor( 1.0f, 1.0f, 1.0f, 1.0f );
		}

		@Override
		protected void processInputs() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void update() {
			// TODO Auto-generated method stub
			Display.update();
			
		}

		@Override
		protected void display() {
			// TODO Auto-generated method stub
			// Clear the screen and depth buffer
		    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		    
		    
		   
		    // set the color of the quad (R,G,B,A)
		    for(int i = 0; i < points.size(); i++){
		    	Point test = points.get(i);
		    	
		    glColor3f(test.getColor().getRed(),test.getColor().getGreen(),test.getColor().getBlue());
		    	
		    // draw quad
		    glBegin( GL_POINTS);
		       glVertex3d(test.getLocation().getX(), test.getLocation().getY(), test.getLocation().getZ());
		    glEnd();
		    }
			
		}
		
		public void addPoint(Point add){
			this.points.add(add);
			
		}
		
		public int numPoints(){
			return points.size();
		}
		
		
}
