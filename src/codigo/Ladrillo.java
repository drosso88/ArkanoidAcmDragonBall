package codigo;

import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GRect;

public class Ladrillo extends GRect{

	public int golpes = 0;
	GImage freezer;

	public Ladrillo (int posX, int posY,double ancho,double alto){
		super (posX,posY,ancho,alto);
		setVisible(false);
		freezer =new GImage("Imagenes/freezer.png");
		freezer.setSize (ancho-5,alto-5);
	}
	
}
