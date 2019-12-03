/*
 * Autora Rocio Soriano                            Alias: Leidisofwal
 * 
 * clase para crear la bola del juego
 * la mayor complejidad ha sido poner el color aleatorio
 *  y,entender la explicacion
 * 
 */
package codigo;

import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;  //clase madre de GOval y GRect
import acm.graphics.GOval;
import acm.util.RandomGenerator;

public class Bola extends GOval{


	private double vx= 1;
	private double vy= 1;

	RandomGenerator aleatorio = new RandomGenerator();
	boolean gameOver = false;

	GImage ball;

	public Bola (double width, double height) {

		super(width, height);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param ancho: el ancho de la bola sera igual al alto ya que es un circulo
	 * @param color: color de la bola
	 */
	public Bola(double ancho,Color color){

		super (ancho,ancho);//dibuja un circulo
		setFilled(false);
		setVisible(false);
		setFillColor(aleatorio.nextColor());

		ball = new GImage("Imagenes/bola.png");
		ball.setSize(ancho-5,ancho-5);

	}

	private void mueveBola(){
		move (vx,vy);
		ball.setLocation(getX(),getY());

	}
	public void chequeaRebote(Arkanoid arkanoid){
		mueveBola();
		if (getX()>=arkanoid.getWidth()||getX()< 0){
			vx=vx*-1; 
			//modo pro vx+=-1
			//invierto la velocidad en X
		}
		if ((getY() < 0)){  //eliminamos la segunda condicion paraque si el cursor no golpea la pelota
			//no vuelva, que gastemos vidas

			//invierto la velocidad en Y
			vy=vy*-1;
		}



		//chequeo si la bola ha chocado con el ladrillo, chequeamos las 4 esquinas de la bola
		if (chequeaColision(getX(), getY(), arkanoid)){  
			if (chequeaColision(getX()+getWidth(), getY(), arkanoid)){
				if (chequeaColision(getX()+getWidth(), getY()+ getHeight(), arkanoid)){
					if (chequeaColision(getX(), getY()+getHeight(), arkanoid)){
					}
				}
			}
		}
	}


	public boolean chequeaColision (double posX,double posY,Arkanoid arkanoid){
		boolean noHaChocado =true;
		// el auxiliar lo que hace es decirnos si debajo de la bola hay algo,

		GObject auxiliar = arkanoid.getElementAt(posX,posY+ getHeight());  //con getHeight() 
		//conseguimos que no solo chequee un punto de la bola

		if (auxiliar instanceof Cursor){
			//si entra aquí es porque el objeto está en la poscición posX,posY.
			//es de tipo cursor
			if (posX<auxiliar.getWidth()/3 + auxiliar.getX()){
			}
			vx=-0.5;
			if (posX>auxiliar.getWidth()*2/3+auxiliar.getX()){
				vx=0.5;
			}
			vy*=-1;	

			if (posX<auxiliar.getWidth()*2/4 + auxiliar.getX()){
				vx*=-2;
			}
			if (posX>auxiliar.getWidth()*3/5+auxiliar.getY()){
				vx*=-2.5;
			}
			if (posY<auxiliar.getWidth()*2/4 + auxiliar.getY()){
				vx*=-1;
			}
			if (posY<auxiliar.getWidth()*1/4 + auxiliar.getX()){
				vx*=-1.5;
			}
			if (posY>auxiliar.getWidth()*2/5+auxiliar.getY()){
				vx*=-2.5;
			}


			//conseguimos que si cae la bola sin ser golpeada por el cursor caiga al suelo
			noHaChocado=false;  
			if (auxiliar !=null){
				gameOver=true;
			}
			auxiliar = getElementAt(posX, posY + ball.getHeight());
			if (auxiliar !=null){ //
				gameOver=true;
			}
		}


		if (auxiliar instanceof Ladrillo){
			//si entra aquí es porque el objeto está en la poscición posX,posY.
			//es de tipo cursor
			vx*=-1;
			vy*=-1;	

			if (getX()<=auxiliar.getX()+auxiliar.getWidth()/8){
				vx*=-1;
			}else if  (getX()<=auxiliar.getX()+auxiliar.getWidth()*2/8&&getX()>=
					auxiliar.getX()+auxiliar.getWidth()/8){
				vx*=-0.75;
			}else if (getX()<=auxiliar.getX()+auxiliar.getWidth()*3/8
					&&getX()>=auxiliar.getX()+auxiliar.getWidth()*2/8){
				vx*=0.5;
			}else if (getX()<=auxiliar.getX()+auxiliar.getWidth()*4/8&&getX()>=auxiliar.getWidth()*3/8){
				vx*=-0.25;
			}
			if (getY()<=auxiliar.getX()+auxiliar.getWidth()/8){
				vx*=-1;
			}else if  (getY()<=auxiliar.getX()+auxiliar.getWidth()*2/8&&getX()>=
					auxiliar.getX()+auxiliar.getWidth()/8){
				vx*=-0.75;
			}else if (getY()<=auxiliar.getX()+auxiliar.getWidth()*3/8
					&&getX()>=auxiliar.getX()+auxiliar.getWidth()*2/8){
				vx*=0.5;
			}else if (getY()<=auxiliar.getX()+auxiliar.getWidth()*4/8&&getX()>=auxiliar.getWidth()*3/8){
				vx*=-0.25;
			}

			noHaChocado=false;
			arkanoid.remove(auxiliar);
			arkanoid.remove(((Ladrillo)auxiliar).freezer);

		}else if (auxiliar instanceof Cursor){
			vy*=-1;
			noHaChocado=false;
		}

		return noHaChocado;

	}


	private GObject getElementAt(double posX, double posY) {
		// TODO Auto-generated method stub
		return null;
	}

}


