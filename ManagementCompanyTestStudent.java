package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class is a Junit test class to test cases of the ManagementCompany class
 * Due: 11/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

class ManagementCompanyTestStudent {
    private ManagementCompany mgmtCompany;
    private Property property1, property2, property3;

    @BeforeEach
    void setUp() {
        mgmtCompany = new ManagementCompany("MyCompany", "1234", 10.0);
        property1 = new Property("Property1", "CityA", 1000, "OwnerA", 1, 1, 3, 3);
        property2 = new Property("Property2", "CityB", 2000, "OwnerB", 4, 4, 3, 3);
        property3 = new Property("Property3", "CityC", 1500, "OwnerC", 2, 2, 2, 2);
    }
    
    @AfterEach
    public void tearDown() throws Exception {
		mgmtCompany=null;
	}

    // Test the default constructor
    @Test
    void testDefaultConstructor() {
        ManagementCompany defaultMgmt = new ManagementCompany();
        assertEquals("", defaultMgmt.getName());
        assertEquals("", defaultMgmt.getTaxId());
        assertEquals(0.0, defaultMgmt.getManagementFeePercentage());
        assertEquals(ManagementCompany.MAX_PROPERTY, defaultMgmt.getProperties().length);
    }

    // Test parameterized constructor
    @Test
    void testParameterizedConstructor() {
        assertEquals("MyCompany", mgmtCompany.getName());
        assertEquals("1234", mgmtCompany.getTaxId());
        assertEquals(10.0, mgmtCompany.getManagementFeePercentage());
    }

    // Test copy constructor
    @Test
    void testCopyConstructor() {
        ManagementCompany copiedMgmt = new ManagementCompany(mgmtCompany);
        assertEquals(mgmtCompany.getName(), copiedMgmt.getName());
        assertEquals(mgmtCompany.getTaxId(), copiedMgmt.getTaxId());
        assertEquals(mgmtCompany.getManagementFeePercentage(), copiedMgmt.getManagementFeePercentage());
    }

    // Test addProperty with Property object
    @Test
    void testAddPropertyObject() {
        assertEquals(0, mgmtCompany.addProperty(property1));
        assertEquals(1, mgmtCompany.getPropertiesCount());
    }

    // Test addProperty with overlapping property
    @Test
    void testAddPropertyOverlap() {
        mgmtCompany.addProperty(property1);
        assertEquals(-4, mgmtCompany.addProperty(property3));  // Overlaps with property1
        assertEquals(1, mgmtCompany.getPropertiesCount()); // Count remains the same
    }

    // Test overloaded addProperty with property details (name, city, rent, owner)
    @Test
    void testAddPropertyWithDetails() {
        assertEquals(0, mgmtCompany.addProperty("Property2", "CityB", 2000, "OwnerB"));
        assertEquals(1, mgmtCompany.getPropertiesCount());
    }

    // Test overloaded addProperty with full property details and plot
    @Test
    void testAddPropertyWithFullDetails() {
        assertEquals(0, mgmtCompany.addProperty("Property3", "CityC", 1500, "OwnerC", 4, 4, 3, 3));
        assertEquals(1, mgmtCompany.getPropertiesCount());
    }

    // Test getter and setter for name
    @Test
    void testGetName() {
        assertEquals("MyCompany", mgmtCompany.getName());
    }

    @Test
    void testSetName() {
        mgmtCompany.setName("NewCompany");
        assertEquals("NewCompany", mgmtCompany.getName());
    }

    // Test getter and setter for taxId
    @Test
    void testGetTaxId() {
        assertEquals("1234", mgmtCompany.getTaxId());
    }

    @Test
    void testSetTaxId() {
        mgmtCompany.setTaxId("5678");
        assertEquals("5678", mgmtCompany.getTaxId());
    }

    // Test getter and setter for managementFeePercentage
    @Test
    void testGetManagementFeePercentage() {
        assertEquals(10.0, mgmtCompany.getManagementFeePercentage());
    }

    @Test
    void testSetManagementFeePercentage() {
        mgmtCompany.setManagementFeePercentage(15.0);
        assertEquals(15.0, mgmtCompany.getManagementFeePercentage());
    }

    // Test getTotalRent
    @Test
    void testGetTotalRent() {
        mgmtCompany.addProperty(property1);
        mgmtCompany.addProperty(property2);
        assertEquals(3000.0, mgmtCompany.getTotalRent());
    }

    // Test getHighestRentProperty
    @Test
    void testGetHighestRentProperty() {
        mgmtCompany.addProperty(property1);
        mgmtCompany.addProperty(property2);
        assertEquals(property2, mgmtCompany.getHighestRentProperty());
    }

    // Test removeLastProperty
    @Test
    void testRemoveLastProperty() {
        mgmtCompany.addProperty(property1);
        mgmtCompany.addProperty(property2);
        mgmtCompany.removeLastProperty();
        assertEquals(1, mgmtCompany.getPropertiesCount());
    }

    // Test isPropertiesFull
    @Test
    void testIsPropertiesFull() {
        // Property 1
        Property property1 = new Property("Property1", "City1", 1000, "Owner1", 0, 0, 2, 2); 
        int index1 = mgmtCompany.addProperty(property1);
        assertEquals(0, index1); // First property should be added at index 0
        
        // Property 2
        Property property2 = new Property("Property2", "City2", 1500, "Owner2", 2, 0, 2, 2); 
        int index2 = mgmtCompany.addProperty(property2);
        assertEquals(1, index2); // Second property should be added at index 1
        
        // Property 3
        Property property3 = new Property("Property3", "City3", 1200, "Owner3", 0, 2, 2, 2); 
        int index3 = mgmtCompany.addProperty(property3);
        assertEquals(2, index3); // Third property should be added at index 2
        
        // Property 4
        Property property4 = new Property("Property4", "City4", 1800, "Owner4", 2, 2, 2, 2); 
        int index4 = mgmtCompany.addProperty(property4);
        assertEquals(3, index4); // Fourth property should be added at index 3
        
        // Property 5
        Property property5 = new Property("Property5", "City5", 2000, "Owner5", 4, 0, 2, 2); 
        int index5 = mgmtCompany.addProperty(property5);
        assertEquals(4, index5); // Fifth property should be added at index 4

        // Property 6 (max properties reached, invalid)
        Property property6 = new Property("Property6", "City6", 2500, "Owner6", 8, 0, 2, 2);
        int index6 = mgmtCompany.addProperty(property6);
        assertEquals(-1, index6);
        
        // Verifying the properties list is full and count is still 5
        assertTrue(mgmtCompany.isPropertiesFull()); // Should return true
        assertEquals(5, mgmtCompany.getPropertiesCount()); // Should still be 5
    }
    // Test getPropertiesCount
    @Test
    void testGetPropertiesCount() {
        mgmtCompany.addProperty(property1);
        mgmtCompany.addProperty(property2);
        assertEquals(2, mgmtCompany.getPropertiesCount());
    }

    // Test isManagementFeeValid
    @Test
    void testIsManagementFeeValid() {
        assertTrue(mgmtCompany.isManagementFeeValid());
    }

    // Test toString
    @Test
    void testToString() {
        mgmtCompany.addProperty(property1);
        String output = mgmtCompany.toString();
        assertEquals(output, "List of the properties for MyCompany, taxID: 1234\n"
        		+ "______________________________________________________\n"
        		+ "Property1,CityA,OwnerA,1000.0\n"
        		+ "______________________________________________________\n"
        		+ "\n total management Fee: 100.00");
        
    }
}