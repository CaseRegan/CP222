public class IntGrid2D implements IIntGrid2D {
	
	private char[][] grid;
	
	private int xOffset;
	private int yOffset;
	
	private int width;
	private int height;
	
	public IntGrid2D(int ulX, int ulY, int lrX, int lrY, char fill) {
		xOffset = ulX;
		yOffset = ulY;
		
		width = lrX - ulX + 1;
		height = ulY - lrY + 1;
		
		grid = new char[width][height];
		
		for(int x = 0; x < width; x++)
			for(int y = 0; y < height; y++)
				grid[x][y] = fill;
	}

	public void setPoint(IIntPoint2D p, char v) {
		grid[p.getX() - xOffset][p.getY() + yOffset] = v;
	}
	
	public char getPoint(IIntPoint2D p) {
		return grid[p.getX() - xOffset][p.getY() + yOffset];
	}
	
	public IIntPoint2D getUpperLeftCorner() {
		return new IntPoint2D(xOffset, yOffset);
	}
	
	public IIntPoint2D getLowerRightCorner() {
		return new IntPoint2D(xOffset + (width - 1), yOffset - (height - 1));
	}
}
