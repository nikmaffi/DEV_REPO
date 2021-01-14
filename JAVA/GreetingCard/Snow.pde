class Snow {
    private ArrayList<Snowflake> snowflakes;
    private float snowHeight;
    private float maxSnowHeight;
    private float growthCoeff;
    private float screenWidth;
    private float screenHeight;
    
    public Snow(int maxSnowflakes, float maxSnowHeight, float growthCoeff, float screenWidth, float screenHeight) throws Exception {
        if(maxSnowflakes <= 0) {
            throw new Exception("Error: Th number of maximum snowflakes must be greater than 0!");
        }
        if(maxSnowHeight <= 0) {
            throw new Exception("Error: Snow height must be greater than 0!");
        }
        if(growthCoeff < 0) {
            throw new Exception("Error: Growth coefficient must be positive!");
        }
        
        this.snowflakes = new ArrayList<Snowflake>();
        this.snowHeight = 0;
        this.maxSnowHeight = maxSnowHeight;
        this.growthCoeff = growthCoeff;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        
        for(int i = 0; i < maxSnowflakes; i++) {
            this.snowflakes.add(i, new Snowflake(screenWidth, screenHeight));
        }
    }
    
    public void itsSnowing() {
        for(Snowflake i : this.snowflakes) {
            i.fall();
        }
    }
    
    public void growth() {
        strokeWeight(0);
        fill(color(255, 255, 255));
        rect(0, this.screenHeight - this.snowHeight, this.screenWidth, this.snowHeight += (this.snowHeight >= this.maxSnowHeight) ? -this.snowHeight : this.growthCoeff);
    }
}
