package codigo;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Tablero extends GraphicsProgram{
	public void run(){
	tableroKrillin();
}


	public void tableroKrillin(){
		boolean casillaNegra= false;
		for (int i=0; i<30; i++){ 
			if (casillaNegra){
				casillaNegra= false;
			}else{
				casillaNegra= true;
			}

			for(int j=0; j<15;j++){
				GRect casilla= new GRect(20, 20);  
				casilla.setFilled(casillaNegra);
				//señalamos posicion
				if (casillaNegra){
					casillaNegra= false;
				}else{
					casillaNegra= true;
				}

				add (casilla,20*j,20*i);

			}
		}

	}
}




