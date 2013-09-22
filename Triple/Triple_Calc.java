/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Triple;

/**
 * This Triple_Calc class does different matrix calculations on the class
 * Triple.
 * 
 * @author George Petersen
 * 
 */
public class Triple_Calc {

	/**
	 * This scalar multiply method multiplies
	 * 
	 * @param a
	 *            - this Triple to multiply by the scalar
	 * @param scalar
	 *            - the scalar to apply to all components of this Triple
	 * @return
	 */
	public static Triple scalarMultiply(Triple a, double scalar) {
		double x = a.getX();
		double y = a.getY();
		double z = a.getZ();
		return new Triple(x * scalar, y * scalar, z * scalar);
	}

	/**
	 * This static method applies the dot product to a Triple. It takes a
	 * transposed Triple and a Triple to multiply with the transposed Triple.
	 * 
	 * @param trans_temp
	 *            - transposed Triple
	 * @param product
	 *            - the second Triple to apply the dot product to the Triple
	 * @return - the dot product of the two vectors
	 */
	public static double dotProduct(Triple trans_temp, Triple product) {

		// Local Variables
		Triple transpose = trans_temp; // Holds this transposed triple
		Triple regular = product; // Holds this product triple

		double a = transpose.getX(); // Holds the value (a) or x value of this
										// transposed Triple
		double b = transpose.getY(); // Holds the value (b) or y value of this
										// transposed Triple
		double c = transpose.getZ(); // Holds the value (c) or z value of this
										// transposed Triple

		double d = regular.getX(); // Holds the value (d) or x value of this
									// product Triple
		double e = regular.getY(); // Holds the value (e) or y value of this
									// product Triple
		double f = regular.getZ(); // Holds the value (f) of z value of this
									// product Triple

		/*
		 * Multiplies the values of the triples and returns a double holding the
		 * dot product
		 */
		return (a * d) + (b * e) + (c * f);
	}

	/**
	 * This applies a cross product function to do Triples
	 * 
	 * @param first
	 *            - first Triple of the cross product
	 * @param second
	 *            - second Triple of the Cross product
	 * @return - the triple that is the cross product of the two triples
	 */
	public static Triple crossProduct(Triple first, Triple second) {

		double a = first.getX(); // Value A
		double b = first.getY(); // Value B
		double c = first.getZ(); // Value C

		double d = second.getX(); // Value D
		double e = second.getY(); // Value E
		double f = second.getZ(); // Value F

		/*
		 * This performs the operation to the two Triples. It should a return an
		 * instance of this Triple class that is represented like this:
		 * 
		 * [ (a*b) - (c*3), (c*d) - (a*f), (a*e) - (b*d) ]
		 */
		return new Triple(((b * f) - (c * e)), ((c * d) - (a * f)),
				((a * e) - (b * d)));
	}

	/**
	 * This static method adds all the corresponding values of two Triples
	 * together.
	 * 
	 * @param first
	 *            - First Triple to add
	 * @param second
	 *            - Second Triple to add
	 * @return - the sum of the two Triples
	 * 
	 */
	public static Triple add(Triple first, Triple second) {
		
		double a = first.getX(); //Value A
		double b = first.getY(); //Value B
		double c = first.getZ(); //Value C

		double d = second.getX(); //Value D
		double e = second.getY(); //Value E
		double f = second.getZ(); //Value F

		/*
		 * This does the function of adding the values of the 
		 * Triple together that correspond to their X, Y and Z values
		 */
		return new Triple((a + d), (b + e), (c + f));
	}

	/**
	 * This static method returns a Triple representing the Vector
	 * between two Triples
	 * @param first
	 * @param second
	 * @return
	 */
	public static Triple vectorTo(Triple first, Triple second) {

		double a = first.getX();
		double b = first.getY();
		double c = first.getZ();

		double d = second.getX();
		double e = second.getY();
		double f = second.getZ();

		return new Triple((a - d), (b - e), (c - f));
	}

	public static double norm(Triple v) {
		return Math.sqrt(Triple_Calc.dotProduct(v, v));
	}

	public static Triple getN(Triple a, Triple b, Triple c) {
		Triple b_a = Triple_Calc.vectorTo(b, a);
		Triple c_a = Triple_Calc.vectorTo(c, a);
		return Triple_Calc.crossProduct(b_a, c_a);
	}

	public static double getLambda(Triple a, Triple b, Triple c, Triple p,
			Triple e) {
		Triple n = Triple_Calc.getN(a, b, c);
		Triple a_e = Triple_Calc.vectorTo(a, e);
		Triple p_e = Triple_Calc.vectorTo(p, e);
		double nom = Triple_Calc.dotProduct(n, a_e);
		double dem = Triple_Calc.dotProduct(n, p_e);
		return nom / dem;
	}

	public static Triple getIntersection(Triple a, Triple b, Triple c,
			Triple p, Triple e) {
		double lambda = Triple_Calc.getLambda(a, b, c, p, e);
		Triple PE = Triple_Calc.vectorTo(p, e);
		Triple lambdaPE = Triple_Calc.scalarMultiply(PE, lambda);
		return Triple_Calc.add(e, lambdaPE);

	}

	public static double[] getAlphaBetaGamma(Triple a, Triple b, Triple c,
			Triple p, Triple e) {
		Triple q = Triple_Calc.getIntersection(a, b, c, p, e);
		Triple r = Triple_Calc.vectorTo(b, a);
		Triple u = Triple_Calc.vectorTo(c, a);
		Triple n = Triple_Calc.crossProduct(r, u);
		Triple q_a = Triple_Calc.vectorTo(q, a);
		double alpha = Triple_Calc.dotProduct(r, q_a);
		double beta = Triple_Calc.dotProduct(u, q_a);
		double gamma = Triple_Calc.dotProduct(n, q_a);

		return new double[] { alpha, beta, gamma };
	}

}
