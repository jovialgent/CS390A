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
        TripleMain.exercise1();
       // TripleMain.classExercise1();
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
}
