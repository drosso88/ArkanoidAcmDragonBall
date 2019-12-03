/*
 * autor: Rocio Soriano                                       Alias: Leidisofwal
 * 
 * descripcion : la clase donde se cerea el cursor que rebotara la bola
 * */
package codigo;
import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GRect;
public class Cursor extends GRect {

	GImage nube;
	/**
	 * 	
	 * @param posicionY:posicion y del cursor, x siempre sera 0(aparecera a la izq de la pantalla)
	 * @param ancho:ancho del cursor
	 * @param alto:alto del cursor
	 * @param color:color del cursorS
	 */
	public Cursor(int posicionY,double ancho,double alto,Color color ){
		super (ancho, alto);
		//COLOR DEL RECUADRO DEL CURSOR INVISIBLE
		setVisible(false);

		//set location , pongo el cursor en la coordenada "Y" que me pasan
		setLocation(0, posicionY);
		nube = new GImage("Imagenes/nube.png");
		nube.setSize(ancho, alto);

	}

}
