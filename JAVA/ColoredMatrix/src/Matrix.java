import processing.core.*;

public class Matrix extends Graphics {
	private SquaresList squares;
	private int rows;
	private int cols;
	private float cellWidth;
	private float cellHeight;
	private float scrWidth;
	private float scrHeight;
	
	public Matrix(PApplet g, int rows, int cols, float scrWidth, float scrHeight) throws Exception {		
		super(g);
		
		if(rows <= 0) {
			throw new Exception("Error: Number of rows must be greater than 0!");
		}
		if(cols < 0) {
			throw new Exception("Error: Number of columns must be positive!");
		}
		if(scrWidth < 0) {
			throw new Exception("Error: Screen width must be positive!");
		}
		if(scrHeight < 0) {
			throw new Exception("Error: Screen height must be positive!");
		}
		
		this.squares = new SquaresList(g, rows * cols);
		this.rows = rows;
		this.cols = cols;
		this.cellWidth = scrWidth / cols;
		this.cellHeight = scrHeight / rows;
		this.scrWidth = scrWidth;
		this.scrHeight = scrHeight;
	}
	
	public void drawMatrix() {
		super.g.strokeWeight(1);
		super.g.stroke(0xffffffff);
		
		for(int r = 0; r <= this.rows; r++) {
			super.g.line(0, this.cellHeight * r, this.scrWidth, this.cellHeight * r);
		}
		
		for(int c = 0; c <= this.cols; c++) {
			super.g.line(this.cellWidth * c, 0, this.cellWidth * c, this.scrHeight);
		}
	}
	
	public void drawSquares() {
		this.squares.drawSquares();
	}
	
	public void isPressed(float mouseX, float mouseY) throws Exception {
		int row = (int)(this.rows * mouseY / this.scrHeight);
		int col = (int)(this.cols * mouseX / this.scrWidth);
		
		this.squares.addSquare(new Square(super.g, this.cellWidth, cellHeight, (int)super.g.random(0xff000000, 0xffffffff), row, col));
	}
}
