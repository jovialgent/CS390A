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
    
    
}
