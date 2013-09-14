/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Triple;

/**
 *
 *@author George Petersen
 *
 */
public class Triple_Calc {
	public static Triple scalarMultiply(Triple a, double scalar){
		double x = a.getX();
		double y = a.getY();
		double z = a.getZ();
		return new Triple(x*scalar, y*scalar, z*scalar);
	}
	
    public static double dotProduct(Triple trans_temp, Triple product){
        Triple transpose = trans_temp;
        Triple regular = product;
        
        double a = transpose.getX();
        double b = transpose.getY();
        double c = transpose.getZ();
        
        double d = regular.getX();
        double e = regular.getY();
        double f = regular.getZ();
        
        return (a*d) + (b*e) + (c*f);
    }
    
    public static Triple crossProduct(Triple first, Triple second){
        Triple one = first;
        Triple two = second;
        
        double a = first.getX();
        double b = first.getY();
        double c = first.getZ();
        
        double d = second.getX();
        double e = second.getY();
        double f = second.getZ();
        
        return new Triple(((b*f) - (c*e)), ((c*d) - (a*f)), ((a*e) - (b*d)) );
    }
    
    public static Triple add(Triple first, Triple second){
        Triple one = first;
        Triple two = second;
        
        double a = first.getX();
        double b = first.getY();
        double c = first.getZ();
        
        double d = second.getX();
        double e = second.getY();
        double f = second.getZ();
        
        return new Triple((a+d), (b+e), (c+f));
    }
    
    public static Triple vectorTo(Triple first, Triple second){
        Triple one = first;
        Triple two = second;
        
        double a = first.getX();
        double b = first.getY();
        double c = first.getZ();
        
        double d = second.getX();
        double e = second.getY();
        double f = second.getZ();
        
        return new Triple((a-d), (b-e), (c-f));
    }
    
    public static double norm(Triple v){
    	return Math.sqrt(Triple_Calc.dotProduct(v,v));
    }
    
    public static Triple getN(Triple a, Triple b, Triple c){
    	Triple b_a = Triple_Calc.vectorTo(b, a);
    	Triple c_a = Triple_Calc.vectorTo(c, a);
    	return Triple_Calc.crossProduct(b_a, c_a);
    }
    
    public static double getLambda(Triple a, Triple b, Triple c, Triple p, Triple e){
    	Triple n = Triple_Calc.getN(a, b, c);
    	Triple a_e = Triple_Calc.vectorTo(a, e);
    	Triple p_e = Triple_Calc.vectorTo(p, e);
    	double nom = Triple_Calc.dotProduct(n, a_e);
    	double dem = Triple_Calc.dotProduct(n, p_e);
    	return nom/dem;
    }
    
    public static Triple getIntersection(Triple a, Triple b, Triple c, Triple p, Triple e){
    	double lambda = Triple_Calc.getLambda(a, b, c, p, e);
    	Triple PE = Triple_Calc.vectorTo(p,e);
    	Triple lambdaPE = Triple_Calc.scalarMultiply(PE, lambda);
    	return Triple_Calc.add(e, lambdaPE);
    	
    }
    
    public static double[] getAlphaBetaGamma(Triple a, Triple b, Triple c, Triple p, Triple e){
    	Triple q = Triple_Calc.getIntersection(a, b, c, p, e);
    	Triple r = Triple_Calc.vectorTo(b, a);
    	Triple u = Triple_Calc.vectorTo(c, a);
    	Triple n = Triple_Calc.crossProduct(r, u);
    	Triple q_a = Triple_Calc.vectorTo(q, a);
    	double alpha = Triple_Calc.dotProduct(r, q_a);
    	double beta = Triple_Calc.dotProduct(u, q_a);
    	double gamma = Triple_Calc.dotProduct(n, q_a);
    	
    	return new double[] {alpha, beta, gamma};
    }
    
    
    
    
}
