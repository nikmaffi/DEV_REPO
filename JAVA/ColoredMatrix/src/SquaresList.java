import processing.core.*;

public class SquaresList extends Graphics {
	private Square[] squares;
	private int numOfSquares;
	
	public SquaresList(PApplet g, int dim) throws Exception {
		super(g);
		
		if(dim <= 0) {
			throw new Exception("Error: Dimension must be greater than 0!");
		}
		
		this.squares = new Square[dim];
		this.numOfSquares = 0;
	}
	
	public void addSquare(Square s) {
		int pos = 0;
		
		if(s == null) {
			return;
		}
		
		if((pos = this.search(s)) >= 0) {
			this.shiftArray(pos);
			this.numOfSquares--;
		} else {
			this.squares[this.numOfSquares++] = s;
		}
	}
	
	private int search(Square s) {
		int pos = -1;
		int idx = 0;
		
		while(pos == -1 && idx < this.numOfSquares) {
			if(this.squares[idx].equals(s)) {
				pos = idx;
			}
			
			idx++;
		}
		
		return pos;
	}
	
	private void shiftArray(int pos) {
		for(int i = pos; i < this.squares.length - 1; i++) {
			this.squares[i] = this.squares[i + 1];
		}
	}
	
	public void drawSquares() {
		for(int i = 0; i < this.numOfSquares; i++) {
			this.squares[i].drawSquare();
		}
	}
}