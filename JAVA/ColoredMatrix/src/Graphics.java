import processing.core.*;

/*
 * Link dove mi sono informato sulle classi astratte:
 * https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 */

public abstract class Graphics extends PApplet {
	public PApplet g;
	
	public Graphics(PApplet g) {
		this.g = g;
	}
}