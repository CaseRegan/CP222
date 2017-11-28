
public class IntPoint2D implements IIntPoint2D {

	private int x;
	private int y;
	
	public IntPoint2D(int xArg, int yArg) {
		x = xArg;
		y = yArg;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int manhattanDistance(IIntPoint2D other) {
		return Math.abs(x - other.getX()) + Math.abs(y - other.getY());
	}

	public double distance(IIntPoint2D other) {
		return Math.sqrt(Math.pow((x - other.getX()), 2) + Math.pow((y - other.getY()), 2));
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean equals(IntPoint2D other) {
		return x == other.x && y == other.y;
	}
	
	public int hashcode() {
		return (x << 16) + y;
	}

}
