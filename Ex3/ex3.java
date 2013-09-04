package Ex3;

//import java.awt.DisplayMode;



import org.lwjgl.*;
import org.lwjgl.opengl.*;

import Triple.*;


public class ex3 {

		public static void main(String[] args){
			Triple x = new Triple(4,5,6);
			System.out.println(x);
			try {
				Display.setDisplayMode(new DisplayMode(800,600));
				Display.create();
			} catch (LWJGLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(!Display.isCloseRequested()){
				Display.update();
			}
			
			Display.destroy();
		}
}
