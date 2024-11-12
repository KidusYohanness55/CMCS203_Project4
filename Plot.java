package application;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class provides a plots on an x-y plane for properties and the management company
 * Due: 11/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public class Plot {
	private int x;
	private int y;
	private int depth;
	private int width;
	
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	public Plot(Plot plot) {
		x = plot.getX();
		y = plot.getY();
		width = plot.getWidth();
		depth = plot.getDepth();
	}
	
	public Plot(int x, int y, int w, int d) {
		this.x = x;
		this.y = y;
		depth = d;
		width = w;
	}
	
	public boolean overlaps(Plot otherPlot) {
	    // Define the corners of this plot
	    int thisLeft = x;
	    int thisBottom = y;
	    int thisRight = x + width;
	    int thisTop = y + depth;

	    // Define the corners of the other plot
	    int otherLeft = otherPlot.getX();
	    int otherBottom = otherPlot.getY();
	    int otherRight = otherPlot.getX() + otherPlot.getWidth();
	    int otherTop = otherPlot.getY() + otherPlot.getDepth();

	    // Check for overlap
	    boolean isOverlapping = thisLeft < otherRight && thisRight > otherLeft &&
	                            thisBottom < otherTop && thisTop > otherBottom;

	    return isOverlapping;
	}
	
	public boolean encompasses(Plot otherPlot) {
	    // Define the boundaries of this plot
	    int thisLeft = x;
	    int thisBottom = y;
	    int thisRight = x + width;
	    int thisTop = y + depth;

	    // Define the boundaries of the other plot
	    int otherLeft = otherPlot.getX();
	    int otherBottom = otherPlot.getY();
	    int otherRight = otherPlot.getX() + otherPlot.getWidth();
	    int otherTop = otherPlot.getY() + otherPlot.getDepth();

	    // Check if this plot fully encompasses the other plot
	    boolean isEncompassing = otherLeft >= thisLeft && otherBottom >= thisBottom &&
	                             otherRight <= thisRight && otherTop <= thisTop;

	    return isEncompassing;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWidth(int w) {
		width = w;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setDepth(int d) {
		depth = d;
	}
	
	public int getDepth() {
		return depth;
	}
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
		
	}
}