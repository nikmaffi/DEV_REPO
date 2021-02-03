import processing.core.*;

class Text {
	private PApplet g;
    private String text;
    private PFont font;
    private float size;
    private int textColor;
    private boolean centerAlignment;
    private float x;
    private float y;
    
    public Text(PApplet g, String text, PFont font, float size, int textColor, boolean centerAlignment, float x, float y) throws Exception {    	
    	if(size <= 0) {
            throw new Exception("Errore: Font size must be greater than 0!");
        }
        
    	this.g = g;
        this.text = text;
        this.font = font;
        this.size = size;
        this.textColor = textColor;
        this.centerAlignment = centerAlignment;
        this.x = x;
        this.y = y;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void write() {
        if(this.centerAlignment) {
            this.g.textAlign(PApplet.CENTER, PApplet.CENTER);
            this.x = (float)(this.g.width / 2.0);
            this.y = (float)(this.g.height / 2.0);
        }
        
        this.g.textFont(this.font);
        this.g.textSize(this.size);
        this.g.fill(this.textColor);
        this.g.text(this.text, this.x, this.y);
    }
}