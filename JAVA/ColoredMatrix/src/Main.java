import processing.core.*;

public class Main extends PApplet {
	private Matrix matrix;
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	public void settings() {
		this.size(500, 500);
	}
	
	public void setup() {
		try {
			this.matrix = new Matrix(this, 7, 10, this.width, this.height);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
	}
	
	public void draw() {
		this.background(0xff000000);
		
		this.matrix.drawMatrix();
		this.matrix.drawSquares();
	}
	
	public void mousePressed() {
		try {
			this.matrix.isPressed(this.mouseX, this.mouseY);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
	}
}