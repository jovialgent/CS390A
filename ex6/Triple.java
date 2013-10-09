/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6;

import java.util.Scanner;

/**
 *
 *@author George Petersen
 *
 */
public class Triple {
    
    private double x,y,z;
    
    public Triple(double a, double b, double c){
        x=a;
        y=b;
        z=c;
    }
    
    public Triple(double[] triple){
        x = triple[0];
        y = triple[1];
        z = triple[2];
    }
    
    public Triple(Scanner console){
        //System.out.println("X: ");
        x = console.nextDouble();
        //System.out.print("Y: ");
        y = console.nextDouble();
        //System.out.print("Z: ");
        z = console.nextDouble();
    }
    
    @Override
    public String toString(){
        return "[" + x + ", " + y + ", " + z + "]";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    
    
}
