package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class is a Junit test class to test cases of the Property class
 * Due: 11/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public class PropertyTestStudent {
    private Property defaultProperty;
    private Property customProperty;
    private Property copiedProperty;

    @BeforeEach
    public void setUp() {
        defaultProperty = new Property();
        customProperty = new Property("House", "New York", 1500.0, "John Doe", 1, 1, 5, 5);
        copiedProperty = new Property(customProperty);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals("", defaultProperty.getOwner());
        assertEquals(0.0, defaultProperty.getRentAmount());
        assertNotNull(defaultProperty.getPlot());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals("House", customProperty.getPropertyName());
        assertEquals("New York", customProperty.getCity());
        assertEquals("John Doe", customProperty.getOwner());
        assertEquals(1500.0, customProperty.getRentAmount());
        assertEquals(1, customProperty.getPlot().getX());
        assertEquals(1, customProperty.getPlot().getY());
        assertEquals(5, customProperty.getPlot().getWidth());
        assertEquals(5, customProperty.getPlot().getDepth());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals("House", copiedProperty.getPropertyName());
        assertEquals("New York", copiedProperty.getCity());
        assertEquals("John Doe", copiedProperty.getOwner());
        assertEquals(1500.0, copiedProperty.getRentAmount());
        assertEquals(1, copiedProperty.getPlot().getX());
        assertEquals(1, copiedProperty.getPlot().getY());
    }

    @Test
    public void testSetCity() {
        customProperty.setCity("Los Angeles");
        assertEquals("Los Angeles", customProperty.getCity());
    }

    @Test
    public void testSetOwner() {
        customProperty.setOwner("Jane Doe");
        assertEquals("Jane Doe", customProperty.getOwner());
    }

    @Test
    public void testSetPropertyName() {
        customProperty.setPropertyName("Condo");
        assertEquals("Condo", customProperty.getPropertyName());
    }

    @Test
    public void testGetCity() {
        customProperty.setCity("Los Angeles");
        assertEquals("Los Angeles", customProperty.getCity());
    }

    @Test
    public void testGetOwner() {
        customProperty.setOwner("Jane Doe");
        assertEquals("Jane Doe", customProperty.getOwner());
    }

    @Test
    public void testGetPropertyName() {
        customProperty.setPropertyName("Condo");
        assertEquals("Condo", customProperty.getPropertyName());
    }

    @Test
    public void testToString() {
        String expected = "House,New York,John Doe,1500.0";
        assertEquals(expected, customProperty.toString());
    }
}