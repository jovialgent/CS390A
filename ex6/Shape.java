package ex6;

import static org.lwjgl.opengl.GL11.*;

public class Shape {

	public static void make2by2Cube() {
		// Red
		glBegin(GL_LINE_LOOP);
		glColor3f(1.0f, 0.0f, 0.0f);
		glVertex3d(-1.2, -1.2, -1.2);
		glVertex3d(1.2, -1.2, -1.2);
		glVertex3d(1.2, -1.2, 1.2);
		glVertex3d(-1.2, -1.2, 1.2);
		glEnd();

		// Green
		glBegin(GL_LINE_LOOP);
		glColor3f(0.0f, 1.0f, 0.0f);
		glVertex3d(-1.2, 1.2, -1.2);
		glVertex3d(1.2, 1.2, -1.2);
		glVertex3d(1.2, 1.2, 1.2);
		glVertex3d(-1.2, 1.2, 1.2);
		glEnd();

		// Blue
		glBegin(GL_LINE_LOOP);
		glColor3f(0, 0, 1.0f);
		glVertex3d(-1.2, -1.2, -1.2);
		glVertex3d(1.2, -1.2, -1.2);
		glVertex3d(1.2, 1.2, -1.2);
		glVertex3d(-1.2, 1.2, -1.2);
		glEnd();

		// Yellow
		glBegin(GL_LINE_LOOP);
		glColor3f(1.0f, 1.0f, 0);
		glVertex3d(-1.2, -1.2, 1.2);
		glVertex3d(1.2, -1.2, 1.2);
		glVertex3d(1.2, 1.2, 1.2);
		glVertex3d(-1.2, 1.2, 1.2);
		glEnd();

		// Purple
		glBegin(GL_LINE_LOOP);
		glColor3f(1.0f, 0.0f, 1.0f);
		glVertex3d(-1.2, -1.2, -1.2);
		glVertex3d(-1.2, -1.2, 1.2);
		glVertex3d(-1.2, 1.2, 1.2);
		glVertex3d(-1.2, 1.2, -1.2);
		glEnd();

		// Cyan
		glBegin(GL_LINE_LOOP);
		glColor3f(0, 1.0f, 1.0f);
		glVertex3d(1.2, -1.2, -1.2);
		glVertex3d(1.2, -1.2, 1.2);
		glVertex3d(1.2, 1.2, 1.2);
		glVertex3d(1.2, 1.2, -1.2);
		glEnd();
	}

	public static void make1by1Cube() {
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
