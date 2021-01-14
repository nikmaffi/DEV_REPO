class Text {
    private String text;
    private PFont font;
    private float size;
    private color textColor;
    private boolean centerAlignment;
    private float x;
    private float y;
    private float screenWidth;
    private float screenHeight;
    
    public Text(String text, String fontName, float size, color textColor, boolean centerAlignment, float x, float y, float screenWidth, float screenHeight) throws Exception {
        if(size <= 0) {
            throw new Exception("Errore: Font size must be greater than 0!");
        }
        
        this.text = text;
        this.font = createFont(fontName, size);
        this.size = size;
        this.textColor = textColor;
        this.centerAlignment = centerAlignment;
        this.x = x;
        this.y = y;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    
    public void write() {
        if(this.centerAlignment) {
            textAlign(CENTER, CENTER);
            this.x = this.screenWidth / 2.0;
            this.y = this.screenHeight / 2.0;
        }
        
        textFont(this.font);
        textSize(this.size);
        fill(this.textColor);
        text(this.text, this.x, this.y);
    }
} //<>//
