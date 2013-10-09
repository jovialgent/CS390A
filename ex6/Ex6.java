package ex6;

import static org.lwjgl.opengl.GL11.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.glu.GLU;

public class Ex6 extends Basic {

	private Triple camPos;
	private double camAzimuth;
	private double penX, penY, penZ;
	private int moveCube;
	private boolean moveMode, createMode, eraseMode;
	private String fileName;
	private ArrayList<Double[]> cubes;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("WHERE IS YOUR FILE WITH THE CUBES: ");
		String file = console.nextLine();
		console.close();
		System.out.println("NOW OPENING: " + file);
		Ex6 test = new Ex6(file);
		test.start();
	}

	public Ex6() {
		super("Exercise 6", 500, 500, 30);
		camPos = new Triple(0, 0, 2);
		penX = 0;
		penY = 0;
		penZ = 0;
		moveCube = -1;
		moveMode = false;
		cubes = new ArrayList<Double[]>();
		camAzimuth = 100;
		createMode = false;
		// TODO Auto-generated constructor stub
	}

	public Ex6(String fileName) {
		this();
		this.fileName = fileName;
		this.loadFile(fileName);
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

		if (Keyboard.isKeyDown(Keyboard.KEY_R)) {
			camPos.setX(amount + camPos.getX());
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_L)) {
			camPos.setX(camPos.getX() - amount);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_F)) {
			camPos.setY(amount + camPos.getY());
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_B)) {
			camPos.setY(camPos.getY() - amount);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_U)) {
			camPos.setZ(amount + camPos.getZ());
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			camPos.setZ(camPos.getZ() - amount);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_O)) {
			this.camAzimuth += 5;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_P)) {
			this.camAzimuth -= 5;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			penY += 2;

		}

		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			penY -= 2;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			penX += 2;

		}

		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			penX -= 2;

		}

		if (Keyboard.isKeyDown(Keyboard.KEY_EQUALS)) {
			penZ += 2;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_MINUS)) {
			penZ -= 2;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
			createMode = true;
			eraseMode = false;
			

		}

		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
			createMode = false;
			eraseMode = true;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_M)) {
			createMode = false;
			eraseMode = false;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			this.writeToFile(this.fileName);
		}

	}

	@Override
	protected void update() {

	}

	@Override
	protected void display() {
		// TODO Auto-generated method stub

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glFrustum(-1, 1, -1, 1, 1, 1000);
		glViewport(0, 0, 500, 500);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();

		// glTranslated(-500,-500,-550);
		// glRotated(270, 1, 0, 0);
		// glRotated(angle, 0, 0, 1);
		GLU.gluLookAt(
				(float) camPos.getX(),
				(float) camPos.getY(),
				(float) camPos.getZ(),
				(float) camPos.getX()
						+ (float) Math.cos(Math.toRadians(this.camAzimuth)),
				(float) camPos.getY()
						+ (float) Math.sin(Math.toRadians(this.camAzimuth)),
				(float) camPos.getZ(), 0.0f, 0.0f, 1.0f);
		createPen(penX, penY, penZ);

		this.createOrErase();
		for (int i = 0; i < cubes.size(); i++) {
			if (i == moveCube) {
				Block.drawBlock(penX, penY, penZ);
			} else {
				Double[] temp = cubes.get(i);
				Block.drawBlock(temp[0], temp[1], temp[2]);
			}

		}

	}
	
	private void createOrErase() {

		if (createMode) {
			Double[] points = new Double[] { penX, penY, penZ };
			boolean add = true;
			for (int i = 0; i < cubes.size(); i++) {
				add = !this.checkPoint(points, cubes.get(i));
				if (!add) {
					break;
				}

			}

			if (add) {
				cubes.add(points);
			}
		}
		
		if (eraseMode) {
			Double[] points = new Double[] { penX, penY, penZ };
			for (int i = 0; i < cubes.size(); i++) {
				if (this.checkPoint(points, cubes.get(i))) {
					cubes.remove(i);
				}
			}
		}
	}

	private void loadFile(String file) {
		try {
			Scanner reader = new Scanner(new File(file));
			int cubeNum = Integer.parseInt(reader.nextLine());
			for (int i = 0; i < cubeNum; i++) {
				String[] pointValues = reader.nextLine().split(" ");
				double pointX = Double.parseDouble(pointValues[0]);
				double pointY = Double.parseDouble(pointValues[1]);
				double pointZ = Double.parseDouble(pointValues[2]);
				cubes.add(new Double[] { pointX, pointY, pointZ });
			}

			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeToFile(String file) {
		String tempFile = file;
		try {
			File cubeFile = new File(tempFile);
			if (!cubeFile.exists()) {
				cubeFile.createNewFile();
			}

			FileWriter fw = new FileWriter(cubeFile);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("" + cubes.size() + "\n");
			for (int i = 0; i < cubes.size(); i++) {
				String point = cubes.get(i)[0] + " " + cubes.get(i)[1] + " "
						+ cubes.get(i)[2] + "\n";
				bw.write(point);
			}
			bw.close();
			System.out.println("FILE SAVED:" + tempFile);
		} catch (FileNotFoundException err) {
			err.printStackTrace();
		} catch (IOException ioErr) {
			ioErr.printStackTrace();
		}
	}

	private void createPen(double x, double y, double z) {
		Block.drawPenBlock(x, y, z);
	}

	private boolean checkPoint(Double[] pen, Double[] block) {
		return pen[0].doubleValue() == block[0].doubleValue()
				&& pen[1].doubleValue() == block[1].doubleValue()
				&& pen[2].doubleValue() == block[2].doubleValue();
	}

}
