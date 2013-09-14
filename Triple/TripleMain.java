/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Triple;

import java.util.Scanner;

/**
 *
 * @author George
 */
public class TripleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //TripleMain.exercise1();
        //TripleMain.classExercise1();
    	//TripleMain.classNormCheck();
    	//TripleMain.testGetN();
    	//TripleMain.testGetLamda();
    	//TripleMain.testGetIntersection();
    	TripleMain.testGetABG();
    }
    
    public static void exercise1(){
        Triple a = new Triple(2,3,7);
        Triple b = new Triple(-5,1,2);
        Triple c = new Triple(6,1,2);
        
        Triple b_a = Triple_Calc.vectorTo(b, a);
        Triple c_a = Triple_Calc.vectorTo(c, a);
        
        Triple n = Triple_Calc.crossProduct(b_a, c_a);
        
        double b_a_n = Triple_Calc.dotProduct(n, c_a);
        double c_a_n = Triple_Calc.dotProduct(n, c_a);
        
        System.out.println("B - A: " + b_a);
        System.out.println("C - A: " + c_a);
        System.out.println("N: " + n);
        System.out.println("(B-A) X N: " + b_a_n);
        System.out.println("(C-A) X N: " + c_a_n);
    }
    
    public static void classExercise1(){
        Scanner console = new Scanner(System.in);
        System.out.print("Give me a vector:");
        Triple one = new Triple(console);
        System.out.println(one);
    }
    
    public static void classExercise2(){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a line:");
        Triple a = new Triple( console );
        System.out.println("Enter another line");
    }
    
    public static void classNormCheck(){
    	Triple test = new Triple(5,6,7);
    	System.out.println(Triple_Calc.norm(test));
    }
    
    public static void testGetN(){
    	Triple a = new Triple(0,0,0);
    	Triple b = new Triple(1,0,0);
    	Triple c = new Triple(0,1,0);
    	
    	Triple n = Triple_Calc.getN(a, b, c);
    	
    	System.out.println(n.toString());
    }
    
    public static void testGetLamda(){
    	Triple a = new Triple(0,0,0);
    	Triple b = new Triple(1,0,0);
    	Triple c = new Triple(0,1,0);
    	Triple p = new Triple(.75, .75, -1);
    	Triple e = new Triple(.5, .5, 1);
    	
    	double answer = Triple_Calc.getLambda(a, b, c, p, e);
    	
    	System.out.println(answer);
    }
    
    public static void testGetIntersection(){
    	Triple a = new Triple(0,0,0);
    	Triple b = new Triple(1,0,0);
    	Triple c = new Triple(0,1,0);
    	Triple p = new Triple(.75, .75, -1);
    	Triple e = new Triple(.5, .5, 1);
    	
    	System.out.println(Triple_Calc.getIntersection(a, b, c, p, e));
    }
    
    public static void testGetABG(){
    	Triple a = new Triple(0,0,0);
    	Triple b = new Triple(1,0,0);
    	Triple c = new Triple(0,1,0);
    	Triple p = new Triple(.75, .75, -1);
    	Triple e = new Triple(.5, .5, 1);
    	
    	double[] abg = Triple_Calc.getAlphaBetaGamma(a, b, c, p, e);
    	
    	System.out.println("Alpha= " + abg[0] + "\n Beta= " + abg[1] + "\n Gamma=" + abg[2]);
    	
    }
}
