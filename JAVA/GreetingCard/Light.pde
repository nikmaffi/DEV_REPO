class Light {
    private static final color OFF_COLOR = #b8bfc2;
    
    private float radius;
    private float x;
    private float y;
    private color lightColor;
    private boolean isOn;
    
    public Light(float radius, float x, float y, color lightColor) throws Exception {
        if(radius <= 0) {
            throw new Exception("Error: Radius must be greater than 0!");
        }
        
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.lightColor = lightColor;
        this.isOn = false;
    }
    
    public boolean isPressed(float mousePosX, float mousePosY)  {
        float distanceX = mousePosX - this.x;
        float distanceY = mousePosY - this.y;
        
        if(distanceX * distanceX + distanceY * distanceY <= this.radius * this.radius) {
            this.isOn = !this.isOn;
            
            return true;
        }
        
        return false;
    }
    
    public void drawLight() {
        if(this.isOn) {
            fill(this.lightColor);
        } else {
            fill(Light.OFF_COLOR);
        }
        
        circle(x, y, this.radius * 2);
    }
}
