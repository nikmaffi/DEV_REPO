class Forest {
    private ArrayList<Tree> trees;
    
    public Forest(int numOfTrees, float minWidth, float maxWidth, float minHeight, float maxHeight, float screenWidth, float screenHeight) throws Exception {
        if(numOfTrees <= 0) {
            throw new Exception("Errore: Number of trees must be greater than 0!");
        }
        if(screenWidth <= 0) {
            throw new Exception("Error: Screen width must be greater than 0!");
        }
        if(screenHeight <= 0) {
            throw new Exception("Error: Screen height must be greater than 0!");
        }
        if(minWidth < 0 || minWidth > maxWidth) {
            throw new Exception("Error: Minimum width must be between 1 and" + (maxWidth - 1) + "!");
        }
        if(maxWidth <= 0) {
            throw new Exception("Error: Maximum width must be greater than 0 and " + minWidth + "!");
        }
        if(minHeight < 0 || minHeight > maxHeight) {
            throw new Exception("Error: Minimum height must be between 1 and" + (maxHeight - 1) + "!");
        }
        if(maxHeight <= 0) {
            throw new Exception("Error: Maximum height must be greater than 0 and " + minHeight + "!");
        }
        
        this.trees = new ArrayList<Tree>();        
        for(int i = 0; i < numOfTrees; i++) {
            this.trees.add(new Tree(random(minWidth, maxWidth), random(minHeight, maxHeight), random(maxWidth / 2, screenWidth - maxWidth / 2), screenHeight));
        }
    }
    
    public void drawForest() {
        for(Tree i : this.trees) {
            i.drawTree();
        }
    }
}
