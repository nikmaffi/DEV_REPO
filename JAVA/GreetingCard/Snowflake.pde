class Snowflake {
    private float radius;
    private float x;
    private float y;
    private float speedY;
    private float screenHeight;
    
    public Snowflake(float screenWidth, float screenHeight) throws Exception {
        if(screenWidth <= 0) {
            throw new Exception("Error: Screen width must be greater than 0!");
        }
        if(screenHeight <= 0) {
            throw new Exception("Error: Screen height must be greater than 0!");
        }
        
        this.screenHeight = screenHeight;
        this.radius = random(1, 2.5);
        this.x = random(this.radius, screenWidth - this.radius);
        this.y = random(this.radius, screenHeight - this.radius);
        this.speedY = random(1, 4);
    }
    
    public void fall() {
        strokeWeight(0);
        fill(color(255, 255, 255));
        circle(this.x, this.y, this.radius * 2);
        
        if(this.y >= this.screenHeight) {
            this.y = -1;
        }
        
        this.y += this.speedY;
    }
}
