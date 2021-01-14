class Tree {
    private static final color TRUNK_COLOR = #59351f;
    private static final color LEAVES_COLOR = #005221;
    
    private float w;
    private float h;
    private float x;
    private float y;
    private float trunkWidth;
    private float trunkHeight;
    
    public Tree(float w, float h, float x, float y) throws Exception {
        if(w <= 0) {
            throw new Exception("Error: Width must be greater than 0!");
        }
        if(h <= 0) {
            throw new Exception("Error: Height must be greater than 0!");
        }
        
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.trunkWidth = 10 * this.w / 100;
        this.trunkHeight = 20 * this.h / 100;
    }
    
    public void drawTree() {
        strokeWeight(0);
        fill(Tree.TRUNK_COLOR);
        rect(this.x - this.trunkWidth / 2, this.y - this.trunkHeight, this.trunkWidth, this.trunkHeight);
        
        fill(Tree.LEAVES_COLOR);
        triangle(this.x - this.w / 2, this.y - this.trunkHeight, this.x, this.y - this.h, this.x + this.w / 2, this.y - this.trunkHeight);
    }
}
