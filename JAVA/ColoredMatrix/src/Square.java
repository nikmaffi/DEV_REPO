import processing.core.*;

public class Square extends Graphics {	
	private float width;
	private float height;
	private int color;
	private int row;
	private int col;
	
	public Square(PApplet g, float width, float height, int color, int row, int col) throws Exception {
		super(g);
		
		if(width <= 0) {
			throw new Exception("Error: Width must be greater than 0!");
		}
		if(height <= 0) {
			throw new Exception("Error: Height must be greater than 0!");
		}
		if(row < 0) {
			throw new Exception("Error: Row must be positive!");
		}
		if(col < 0) {
			throw new Exception("Error: Column must be positive!");
		}

		this.width = width;
		this.height = height;
		this.color = color;
		this.row = row;
		this.col = col;
	}
	
	public boolean equals(Square s) {
		return this.row == s.row && this.col == s.col;
	}
	
	public void drawSquare() {
		super.g.strokeWeight(0);
		super.g.fill(this.color);
		super.g.rect(this.width * this.col, this.height * this.row, this.width, this.height);
	}
}