class MovingImage {
    private static final float TIMER_STEP = 0.02;
    
    private PImage image;
    private int w;
    private int h;
    private float x;
    private float y;
    private float initPosX;
    private float initPosY;
    private float speedX;
    private float speedY;
    private float screenWidth;
    private float screenHeight;
    private float timer;
    private float delay;
    
    public MovingImage(String imagePath, int w, int h, float x, float y, float speedX, float speedY, float screenWidth, float screenHeight, float delay) throws Exception {
        if((this.image = loadImage(imagePath)) == null) {
            throw new Exception("Error: <" + imagePath + "> not found!");
        }
        if(w <= 0) {
            throw new Exception("Error: Width must be greater than 0!");
        }
        if(h <= 0) {
            throw new Exception("Error: Height must be greater than 0!");
        }
        if(screenWidth <= 0) {
            throw new Exception("Error: Screen width must be greater than 0!");
        }
        if(screenHeight <= 0) {
            throw new Exception("Error: Screen height must be greater than 0!");
        }
        if(timer < 0) {
            throw new Exception("Error: Time timer must be positive!");
        }
        
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.initPosX = x;
        this.initPosY = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.timer = 0;
        this.delay = delay;
    }
    
    public void changePosition() {
        if(this.x > this.screenWidth) {
            this.x = this.initPosX;
        }
        
        if(this.y > this.screenHeight) {
            this.y = this.initPosY;
        }
        
        this.image.resize(this.w, this.h);
        image(this.image, this.x += this.speedX, this.y += this.speedY);
    }
    
    public void move() {
        if(this.timer > this.delay) {
            this.changePosition();
            
            if(this.x > this.screenWidth) {
                this.timer = 0;
            }
        } else {
            this.timer += MovingImage.TIMER_STEP;
        }
    }
}
