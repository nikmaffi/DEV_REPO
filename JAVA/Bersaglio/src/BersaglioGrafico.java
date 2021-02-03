import processing.core.*;

public class BersaglioGrafico extends Bersaglio {
	private PApplet g;
	private static final int STRISCIA_1 = 0xff0000ff;
	private static final int STRISCIA_2 = 0xff00ff00;
	private static final int STRISCIA_3 = 0xffffff00;
	private static final int STRISCIA_4 = 0xffff6600;
	private static final int STRISCIA_5 = 0xffff0000;
	
	public BersaglioGrafico(PApplet g, float r, float x, float y, int punteggio) throws Exception {
		super(r, x, y, punteggio);
		
		this.g = g;
	}
	
	public void draw() {
		this.g.strokeWeight(0);
		
		this.g.fill(BersaglioGrafico.STRISCIA_1);
		this.g.circle(super.x, super.y, super.r*2);
		
		this.g.fill(BersaglioGrafico.STRISCIA_2);
		this.g.circle(super.x, super.y, super.r*2 - 2*super.r / 5);
		
		this.g.fill(BersaglioGrafico.STRISCIA_3);
		this.g.circle(super.x, super.y, super.r*2 - 4*super.r / 5);
		
		this.g.fill(BersaglioGrafico.STRISCIA_4);
		this.g.circle(super.x, super.y, super.r*2 - 6*super.r / 5);
		
		this.g.fill(BersaglioGrafico.STRISCIA_5);
		this.g.circle(super.x, super.y, super.r*2 - 8*super.r / 5);
	}
}