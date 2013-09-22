/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Triple;

import java.util.Scanner;

/**
 * This TripleMain class is a testing class for the Triple/Triple_Calc classes.
 * 
 * @author George
 */
public class TripleMain {

	/**
	 * This main method has all the testing methods to test each individual
	 * Triple_Calc/Triple methods
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		// TripleMain.exercise1(); //Tests the cross product
		// TripleMain.classExercise1(); //Tests getting an input
		// TripleMain.classNormCheck(); //Tests getting a norm
		// TripleMain.testGetN(); //Tests getting the normal vector
		// TripleMain.testGetLambda(); //Tests getting the lambda for a vectors
		// TripleMain.testGetIntersection(); //Tests getting the "q" or
		// intersection of a plane
		TripleMain.testGetABG(); // Tests getting the alpha, beta and gamma
	}

	/**
	 * Tests getting the cross product for the class assignment.
	 */
	public static void exercise1() {

		// Local variables to test this cross product/dotproduct
		Triple a = new Triple(2, 3, 7);
		Triple b = new Triple(-5, 1, 2);
		Triple c = new Triple(6, 1, 2);

		// Gets these vectors between two Triples
		Triple b_a = Triple_Calc.vectorTo(b, a);
		Triple c_a = Triple_Calc.vectorTo(c, a);

		// Gets the N vector between two points
		Triple n = Triple_Calc.crossProduct(b_a, c_a);

		// Gets the dot product between the vector N and vectors <B,A> <C,A>
		double b_a_n = Triple_Calc.dotProduct(n, b_a);
		double c_a_n = Triple_Calc.dotProduct(n, c_a);

		// Prints out the results of this test
		System.out.println("B - A: " + b_a);
		System.out.println("C - A: " + c_a);
		System.out.println("N: " + n);
		System.out.println("(B-A) X N: " + b_a_n);
		System.out.println("(C-A) X N: " + c_a_n);
	}

	/**
	 * Tests requesting an input for Triples
	 */
	public static void classExercise1() {
		// Creates a scanner to ask for user input
		Scanner console = new Scanner(System.in);

		// Asks this user for a Triple coordinate
		System.out.print("Give me a vector:");

		// Uses this Triple's constructor to create a Triple using the Scanner
		Triple one = new Triple(console);

		// Prints out the result of this test
		System.out.println(one);
	}

	/**
	 * Tests getting the norm of a vector
	 */
	public static void classNormCheck() {

		// Creates a test Triple to get the norm
		Triple test = new Triple(5, 6, 7);

		// Returns the result of this test
		System.out.println(Triple_Calc.norm(test));
	}

	/**
	 * Tests getting the N of two vectors or the perpendicular
	 */
	public static void testGetN() {

		// Creates a test plane of three Triples
		Triple a = new Triple(0, 0, 0);
		Triple b = new Triple(1, 0, 0);
		Triple c = new Triple(0, 1, 0);

		// Calculates the normal of the plane
		Triple n = Triple_Calc.getN(a, b, c);

		// Prints results
		System.out.println(n.toString());
	}

	/**
	 * Tests this lambda method from five basic points
	 */
	public static void testGetLambda() {

		// Creates a plane and a point and an eye point
		Triple a = new Triple(0, 0, 0);
		Triple b = new Triple(1, 0, 0);
		Triple c = new Triple(0, 1, 0);
		Triple p = new Triple(.75, .75, -1);
		Triple e = new Triple(.5, .5, 1);

		// Produces the lambda
		double answer = Triple_Calc.getLambda(a, b, c, p, e);

		// Prints out results
		System.out.println(answer);
	}

	/**
	 * Tests the intersection with a plane
	 */
	public static void testGetIntersection() {

		// Creates a view plane and the eye point with the point
		Triple a = new Triple(0, 0, 0);
		Triple b = new Triple(1, 0, 0);
		Triple c = new Triple(0, 1, 0);
		Triple p = new Triple(.75, .75, -1);
		Triple e = new Triple(.5, .5, 1);

		// Prints results
		System.out.println(Triple_Calc.getIntersection(a, b, c, p, e));
	}

	/**
	 * Tests this getAlphaBetaGamma value
	 */
	public static void testGetABG() {

		// Create a view plane and the eye point with the point
		Triple a = new Triple(0, 0, 0);
		Triple b = new Triple(1, 0, 0);
		Triple c = new Triple(0, 1, 0);
		Triple p = new Triple(.75, .75, -1);
		Triple e = new Triple(.5, .5, 1);

		// The alpha, beta and gamma
		double[] abg = Triple_Calc.getAlphaBetaGamma(a, b, c, p, e);

		// Prints results
		System.out.println("Alpha= " + abg[0] + "\n Beta= " + abg[1]
				+ "\n Gamma=" + abg[2]);

	}
}
