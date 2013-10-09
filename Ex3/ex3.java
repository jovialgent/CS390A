package ex3;

//import java.awt.DisplayMode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import basic.RGB;
import static org.lwjgl.opengl.GL11.*;

import Triple.*;

public class Ex3 extends Basic {
	private ArrayList<Point> points;
	private Triple e, a, b, c;
	private double[] abg;
	private Scanner console = new Scanner(System.in);

	public Ex3(String fileName) {
		super("Exercise 3", 500, 500, 40);

		this.e = new Triple(0, 0, 0);
		this.a = new Triple(0, 0, 0);
		this.b = new Triple(0, 0, 0);
		this.c = new Triple(0, 0, 0);

		this.points = new ArrayList<Point>();
		Scanner reader = null;
		try {
			reader = new Scanner(new BufferedReader(new FileReader(fileName)));

			int pointNum = Integer.parseInt(reader.nextLine());

			for (int i = 0; i < pointNum; i++) {
				String[] pointData = reader.nextLine().split(" ");

				// System.out.println(pointData[0]);

				double x = Double.parseDouble(pointData[0]);
				double y = Double.parseDouble(pointData[1]);
				double z = Double.parseDouble(pointData[2]);

				int r = Integer.parseInt(pointData[3]);
				int g = Integer.parseInt(pointData[4]);
				int b = Integer.parseInt(pointData[5]);
				Point temp = new Point(new Triple(x, y, z), new RGB(r, g, b));

				points.add(temp);

				// System.out.println("Point " + i + ": " + temp.toString() );

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reader.close();
		} 
		
		points.add(new Point(new Triple(.75,.75,-1.0), RGB.RED));

	}

	public static void main(String[] args) {

		Ex3 test = new Ex3(
				"C:\\Users\\George\\workspace\\CS390A_Fall_2013\\src\\ex3\\point_data1.txt");

		test.start();

	}

	@Override
	protected void init() {
		this.askUserInput();

		// set up projection once and for all:
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 10, 0, 10, 1, -1);
		// switch to model view from this point on:
		glMatrixMode(GL_MODELVIEW);

		// set the background color:
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

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

		glBegin(GL_TRIANGLES);
		// set the color of the quad (R,G,B,A)
		for (int i = 0; i < points.size(); i++) {
			Point temp = points.get(i);
			RGB color = temp.getColor();
			Triple p = temp.getLocation();
			Triple q = Triple_Calc.getIntersection(a, b, c, p, e);
			double[] abg = Triple_Calc.getAlphaBetaGamma(a, b, c, p, e);

			glColor3f(color.getRed(), color.getGreen(), color.getBlue());

			// draw quad

			glVertex3d(q.getX() * abg[0] * 10, q.getY() * abg[1] * 10, q.getZ()
					* abg[2] * 1);
			glVertex3d(q.getX() * abg[0] * 10, q.getY() * abg[1] * 10 + 1, q.getZ()
					* abg[2] * 1);
			glVertex3d(q.getX() * abg[0] * 10 + 1, q.getY() * abg[1] * 10, q.getZ()
					* abg[2] * 1);

		}

		glEnd();

	}

	public void addPoint(Point add) {
		this.points.add(add);

	}

	public Point getPoint(int index) {
		return this.points.get(index);
	}

	public int numPoints() {
		return points.size();
	}

	private void askUserInput() {
		e = this.askForViewPoint("Eye Point");
		a = this.askForViewPoint("Point A");
		b = this.askForViewPoint("Point B");
		c = this.askForViewPoint("Point C");
		console.close();

	}

	private Triple askForViewPoint(String point_name) {

		// The String coordinates inputed by the user
		String x = ""; // String value for X coordinate
		String y = ""; // String value for Y coordinate
		String z = ""; // String value for Z coordinate

		// The coordinates parsed to be double to make a Triple
		double x_parsed = 0.0; // Double value for X
		double y_parsed = 0.0; // Double value for Y
		double z_parsed = 0.0; // Double value for Z

		// Asks for the coordinates for the point
		System.out.println("What are the coordinates for " + point_name + "?");

		/*
		 * This section below will ask for the X coordinate from the user and
		 * then parses into a double.
		 */
		System.out.print("X= ");
		x = console.next();
		x_parsed = Double.parseDouble(x);
		System.out.print("Y= ");
		y = console.next();
		y_parsed = Double.parseDouble(y);
		System.out.print("Z= ");
		z = console.next();
		z_parsed = Double.parseDouble(z);

		System.out.println(createReadout(point_name, x, y, z));

		return new Triple(x_parsed, y_parsed, z_parsed);

	}

	private String createReadout(String point_name, String x, String y, String z) {
		StringBuilder reader = new StringBuilder();
		reader.append("For ");
		reader.append(point_name);
		reader.append(" your input was: (");
		reader.append(x);
		reader.append(", ");
		reader.append(y);
		reader.append(", ");
		reader.append(z);
		reader.append(")");

		return reader.toString();
	}

}
