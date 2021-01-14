class LightsSeries {
    private final color[] LIGHTS_COLORS = {         //Error with static
        #ff0000, #00ff00, #4877f4, #ffff00, #ff00ff
    };
    
    private ArrayList<Light> lights;
    
    public LightsSeries(int numOfLights, float radius, float y, float screenWidth) throws Exception {
        if(numOfLights <= 0) {
            throw new Exception("Errore: Number of lights must be greater than 0!");
        }
        if(screenWidth <= 0) {
            throw new Exception("Error: Screen width must be greater than 0!");
        }       
        if(radius <= 0 || radius > radius) {
            throw new Exception("Error: Minimum Radius must be greater than 0!");
        }
        
        this.lights = new ArrayList<Light>();
        
        for(int i = 0; i < numOfLights / 2; i++) {      
            this.lights.add(new Light(radius,  screenWidth / 2 + (i + 1) * radius + (radius * i), y - i * 3, this.LIGHTS_COLORS[(int)random(0, this.LIGHTS_COLORS.length)]));
            this.lights.add(new Light(radius,  screenWidth / 2 - ((i + 1) * radius + (radius * i)), y - i * 3, this.LIGHTS_COLORS[(int)random(0, this.LIGHTS_COLORS.length)]));
        }
    }
    
    public void drawLightsSeries() {
        for(Light i : this.lights) {
            i.drawLight();
        }
    }
    
    public void isPressed(float mousePosX, float mousePosY) {
        for(int i = 0; i < this.lights.size() && !this.lights.get(i).isPressed(mousePosX, mousePosY); i++);
    }
}
