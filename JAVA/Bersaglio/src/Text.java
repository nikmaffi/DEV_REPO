import processing.core.*;

class Text extends Graphics {
    private String text;
    private PFont font;
    private float size;
    private int textColor;
    private boolean centerAlignment;
    private float x;
    private float y;
    private float screenWidth;
    private float screenHeight;
    
    public Text(PApplet g, String text, PFont font, float size, int textColor, boolean centerAlignment, float x, float y, float screenWidth, float screenHeight) throws Exception {
        super(g);
    	
    	if(size <= 0) {
            throw new Exception("Errore: Font size must be greater than 0!");
        }
        
        this.text = text;
        this.font = font;
        this.size = size;
        this.textColor = textColor;
        this.centerAlignment = centerAlignment;
        this.x = x;
        this.y = y;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void write() {
        if(this.centerAlignment) {
            textAlign(CENTER, CENTER);
            this.x = (float)(this.screenWidth / 2.0);
            this.y = (float)(this.screenHeight / 2.0);
        }
        
        super.g.textFont(this.font);
        super.g.textSize(this.size);
        super.g.fill(this.textColor);
        super.g.text(this.text, this.x, this.y);
    }
}