import processing.core.*;

public class BersaglioGrafico extends Bersaglio {
	private static final int STRISCIA_1 = 0xff00ff00;
	private static final int STRISCIA_2 = 0xffff6600;
	private static final int STRISCIA_3 = 0xffffff00;
	private static final int STRISCIA_4 = 0xff0000ff;
	private static final int STRISCIA_5 = 0xffff0000;
	
	public BersaglioGrafico(PApplet g, float r, float x, float y, int punteggio) throws Exception {
		super(g, r, x, y, punteggio);
	}
	
	public void draw() {
		super.g.strokeWeight(0);
		
		super.g.fill(BersaglioGrafico.STRISCIA_1);
		super.g.circle(super.x, super.y, super.r*2);
		
		super.g.fill(BersaglioGrafico.STRISCIA_2);
		super.g.circle(super.x, super.y, super.r*2 - 2*super.r / 5);
		
		super.g.fill(BersaglioGrafico.STRISCIA_3);
		super.g.circle(super.x, super.y, super.r*2 - 4*super.r / 5);
		
		super.g.fill(BersaglioGrafico.STRISCIA_4);
		super.g.circle(super.x, super.y, super.r*2 - 6*super.r / 5);
		
		super.g.fill(BersaglioGrafico.STRISCIA_5);
		super.g.circle(super.x, super.y, super.r*2 - 8*super.r / 5);
	}
}