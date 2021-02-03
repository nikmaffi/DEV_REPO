import processing.core.*;

public class Bersaglio extends Graphics {
	protected float r;
	protected float x;
	protected float y;
	protected int punteggio;
	
	public Bersaglio(PApplet g, float r, float x, float y, int punteggio) throws Exception {
		super(g);
		
		if(r <= 0) {
			throw new Exception("Errore: Il raggio deve essere maggiore di 0!");
		}
		
		this.r = r;
		this.x = x;
		this.y = y;
		this.punteggio = punteggio;
	}
	
	public Bersaglio(PApplet g, float r, int punteggio, int color) throws Exception {
		this(g, r, 0, 0, punteggio);
	}
	
	public float getR() {
		return this.r;
	}
	
	public float getX() {
		return this.x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public int getPunteggio() {
		return this.punteggio;
	}
	
	@Override
	public String toString() {
		return this.r + " " + this.x + " " + this.y + " " + this.punteggio;
	}
	
	public boolean eColpito(float x, float y) {
		float dx = this.x - x;
		float dy = this.y - y;
		boolean colpito = false;
		
		if(dx*dx + dy*dy <= this.r*this.r) {
			colpito = true;
		}
		
		return colpito;
	}
}