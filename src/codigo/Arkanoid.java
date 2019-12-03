package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.io.IOException;

import acm.graphics.GImage;
import acm.graphics.GLabel;

/*
 * Autora Rocio Soriano                            Alias: Leidisofwal
 */

import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Arkanoid extends GraphicsProgram{


	RandomGenerator aleatorio = new RandomGenerator();

	static int ANCHO_LADRILLO= 60;
	static int ALTO_LADRILLO= 60;


	Bola bola = new Bola (25,aleatorio.nextColor());
	Cursor cursor = new Cursor(600,100,50,Color.black);

	GImage kameHouse;

	GImage ball;

	GImage fondo;
	GImage muten;



	GLabel texto=new GLabel("");
	int golpe = 0;
	GLabel marcador = new GLabel ("0");

	int puntuacion = 0;

	boolean gameOver = false;


	public void init (){

		kameHouse = new GImage("Imagenes/kamehouse.png");
		add(kameHouse);

		setSize(1300,830);
		fondo = new GImage("Imagenes/kaito.jpg");
		add (fondo);

		inicio();	

		add (bola);
		add (bola.ball);
		add (cursor);
		add(cursor.nube);


		addMouseListeners();
		freezerColumnas();
		marcador.setColor(Color.white);
		add(marcador, 100, 100);


	}



	public void run (){

		while (!gameOver){
			pause (3);
			bola.chequeaRebote(this);


		}
	}



	public void mouseMoved(MouseEvent evento){
		cursor.setLocation(evento.getX(),cursor.getY());
		(cursor.nube).setLocation(evento.getX(), cursor.getY());

	}



	//metodo para nivel freezer (me siento orgullosa de haberlo puesto centradito 
	private void freezerColumnas(){
		int numeroLadrillos = 10;
		int desplazamientoInicial=(getWidth()-numeroLadrillos*ANCHO_LADRILLO)/2;

		for (int i=0; i<4;i++){
			int posicionX= desplazamientoInicial + ANCHO_LADRILLO*i - ANCHO_LADRILLO*i;
			int posicionY= ALTO_LADRILLO*i +ALTO_LADRILLO;
			Ladrillo miLadrillo = new Ladrillo(
					posicionX,
					posicionY,
					ANCHO_LADRILLO,ALTO_LADRILLO
					);

			add (miLadrillo.freezer,posicionX,posicionY);
			add (miLadrillo);

		}
		for (int i=0; i<5;i++){
			int posicionX= desplazamientoInicial+50+ ANCHO_LADRILLO*i - ANCHO_LADRILLO*i;
			int posicionY= ALTO_LADRILLO*i +ALTO_LADRILLO;
			Ladrillo miLadrillo = new Ladrillo(
					posicionX,
					posicionY,
					ANCHO_LADRILLO,ALTO_LADRILLO);

			add (miLadrillo.freezer,posicionX,posicionY);
			add (miLadrillo);


		}
		for (int i=0; i<6;i++){
			int posicionX= desplazamientoInicial+200+ ANCHO_LADRILLO*i - ANCHO_LADRILLO*i;
			int posicionY= ALTO_LADRILLO*i +ALTO_LADRILLO;
			Ladrillo miLadrillo = new Ladrillo(

					posicionX,
					posicionY,
					ANCHO_LADRILLO,ALTO_LADRILLO);

			add (miLadrillo.freezer,posicionX,posicionY);
			add (miLadrillo);

		}

		for (int i=0; i<7;i++){
			int posicionX= desplazamientoInicial+250+ ANCHO_LADRILLO*i - ANCHO_LADRILLO*i;
			int posicionY= ALTO_LADRILLO*i +ALTO_LADRILLO;
			Ladrillo miLadrillo = new Ladrillo(

					posicionX,
					posicionY,
					ANCHO_LADRILLO,ALTO_LADRILLO);

			add (miLadrillo.freezer,posicionX,posicionY);
			add (miLadrillo);

		}
		for (int i=0; i<8;i++){
			int posicionX= desplazamientoInicial+400+ ANCHO_LADRILLO*i - ANCHO_LADRILLO*i;
			int posicionY= ALTO_LADRILLO*i +ALTO_LADRILLO;
			Ladrillo miLadrillo = new Ladrillo(

					posicionX,
					posicionY,
					ANCHO_LADRILLO,ALTO_LADRILLO);

			add (miLadrillo.freezer,posicionX,posicionY);
			add (miLadrillo);

		}
		for (int i=0; i<9;i++){
			int posicionX= desplazamientoInicial+450+ ANCHO_LADRILLO*i - ANCHO_LADRILLO*i;
			int posicionY= ALTO_LADRILLO*i +ALTO_LADRILLO;
			Ladrillo miLadrillo = new Ladrillo(

					posicionX,
					posicionY,
					ANCHO_LADRILLO,ALTO_LADRILLO);

			add (miLadrillo.freezer,posicionX,posicionY);
			add (miLadrillo);

		}
	}


	private void inicio(){
		muten = new GImage("Imagenes/muten.gif");
		muten.setSize(250,150);
		add(kameHouse);
		add(muten,930,650);

		GLabel mensajeMuten = new GLabel("no me apetece entrenarte,quiero jugar con las bolas de dragon");
		GLabel mensajeMuten2 = new GLabel("si ganas te muestro el kamekameha");
		GLabel mensajeMuten3 = new GLabel("si pierdes paso de ti");
		GLabel mensajeMuten4 = new GLabel("pulsa click con el raton si te atreves");
		//fuente 
		Font fuente;

		//esto no se que hace, pero se importo solo y me gusto

		try {
			fuente = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/fuentes/Saiyan-Sans.ttf")).deriveFont(50.0f);
			mensajeMuten.setFont(fuente);
			mensajeMuten2.setFont(fuente);
			mensajeMuten3.setFont(fuente);
			mensajeMuten4.setFont(fuente);

		} catch (Exception e) {


		}

		mensajeMuten.setColor(Color.red);
		mensajeMuten3.setColor(Color.red);

		add(mensajeMuten, 50, 80);
		add(mensajeMuten2,100,120);
		add(mensajeMuten3,150,170);
		add(mensajeMuten4,200,220);

		waitForClick();

		//cambio a la segunda imagen

		remove (kameHouse);
		add(fondo);		
	}


	public String sumaPuntos (GImage miLadrillo, boolean golpe){
		if (miLadrillo.getX() == bola.getX()&& golpe){
			puntuacion+=15;
			marcador.setLabel(""+puntuacion);// convierto el int puntacion a string y lo sumo
		}	
		return (""+ puntuacion);
	}

}





















