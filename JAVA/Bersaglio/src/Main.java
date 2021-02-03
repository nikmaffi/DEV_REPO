import processing.core.*;

public class Main extends PApplet {
	private static final int SCREEN_WIDTH = 1024;
	private static final int SCREEN_HEIGHT = 768;
	private static final int DIM_BERSAGLIO = 125;
	private ColpisciBersaglio cb;
	private Text punteggio;
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	public void settings() {
		this.size(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
	}
	
	public void setup() {
		try {
			this.cb = new ColpisciBersaglio(this);
			this.punteggio = new Text(this, "Pt: 0", createFont("Alien Encounters", 20), 20, 0xff00ff00, false, 40, 40, this.width, this.height);
			
			this.cb.aggiungiBersaglio(new BersaglioGrafico(this, Main.DIM_BERSAGLIO, Main.DIM_BERSAGLIO*2, Main.DIM_BERSAGLIO*2, (int)this.random(10, 100)));
			this.cb.aggiungiBersaglio(new BersaglioGrafico(this, Main.DIM_BERSAGLIO, Main.SCREEN_WIDTH - Main.DIM_BERSAGLIO*2, Main.SCREEN_HEIGHT - Main.DIM_BERSAGLIO*2, (int)this.random(10, 100)));
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}
	}
	
	public void draw() {
		this.background(0xff000000);
		this.punteggio.write();
		this.cb.draw();
	}
	
	public void mousePressed() {
		this.cb.spara(this.mouseX, this.mouseY);
		this.punteggio.setText("Pt: " + this.cb.getPunteggioTotale());
	}
}