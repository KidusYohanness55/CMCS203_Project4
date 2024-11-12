package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class is a Junit test class to test cases of the Plot class
 * Due: 11/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public class PlotTestStudent {
	private Plot defaultPlot;
    private Plot plot1;
    private Plot copiedPlot;

    @BeforeEach
    public void setUp() {
        defaultPlot = new Plot();  // Uses default constructor
        plot1 = new Plot(2, 2, 4, 4);  // Custom plot with specified x, y, width, and depth
        copiedPlot = new Plot(plot1);  // Copy constructor
    }

    @AfterEach
    public void tearDown() {
        defaultPlot = null;
        plot1 = null;
        copiedPlot = null;
    }
    
    @Test
    public void testDefaultConstructor() {
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals(2, plot1.getX());
        assertEquals(2, plot1.getY());
        assertEquals(4, plot1.getWidth());
        assertEquals(4, plot1.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(plot1.getX(), copiedPlot.getX());
        assertEquals(plot1.getY(), copiedPlot.getY());
        assertEquals(plot1.getWidth(), copiedPlot.getWidth());
        assertEquals(plot1.getDepth(), copiedPlot.getDepth());
    }

    @Test
    public void testSetX() {
        defaultPlot.setX(3);
        assertEquals(3, defaultPlot.getX());
    }

    @Test
    public void testGetX() {
        defaultPlot.setX(3);
        assertEquals(3, defaultPlot.getX());
    }

    @Test
    public void testSetY() {
        defaultPlot.setY(4);
        assertEquals(4, defaultPlot.getY());
    }

    @Test
    public void testGetY() {
        defaultPlot.setY(4);
        assertEquals(4, defaultPlot.getY());
    }

    @Test
    public void testSetWidth() {
        defaultPlot.setWidth(2);
        assertEquals(2, defaultPlot.getWidth());
    }

    @Test
    public void testGetWidth() {
        defaultPlot.setWidth(2);
        assertEquals(2, defaultPlot.getWidth());
    }

    @Test
    public void testSetDepth() {
        defaultPlot.setDepth(3);
        assertEquals(3, defaultPlot.getDepth());
    }

    @Test
    public void testGetDepth() {
        defaultPlot.setDepth(3);
        assertEquals(3, defaultPlot.getDepth());
    }

    @Test
    public void testOverlaps() {
        // Overlapping case
        Plot overlappingPlot = new Plot(3, 4, 3, 3);  // Overlaps with customPlot
        assertTrue(plot1.overlaps(overlappingPlot));

        // Non-overlapping case
        Plot nonOverlappingPlot = new Plot(7, 7, 2, 2);  // Does not overlap with customPlot
        assertFalse(plot1.overlaps(nonOverlappingPlot));
    }

    @Test
    public void testEncompasses() {
        // Case where customPlot fully encompasses a smaller plot
        Plot innerPlot = new Plot(3, 4, 2, 2);
        assertTrue(plot1.encompasses(innerPlot));

        // Case where customPlot does not encompass a larger or offset plot
        Plot outerPlot = new Plot(1, 1, 8, 8);  // Larger than customPlot
        assertFalse(plot1.encompasses(outerPlot));
    }

    @Test
    public void testToString() {
        // Format: "x,y,width,depth"
        assertEquals("0,0,1,1", defaultPlot.toString());
        assertEquals("2,2,4,4", plot1.toString());
    }
}
