package application;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class defines a class for a management company and its methods to be used in a javafx gui
 * Due: 11/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public class ManagementCompany {
    private String name;
    private String taxId;
    private double managementFeePercentage;
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    private static final int MGMT_DEPTH = 10;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    // Default constructor
    public ManagementCompany() {
        this.name = "";
        this.taxId = "";
        this.managementFeePercentage = 0.0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    // Constructor with parameters
    public ManagementCompany(String name, String taxId, double managementFeePercentage) {
        this.name = name;
        this.taxId = taxId;
        this.managementFeePercentage = managementFeePercentage;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }
    
    //Copy constructor
    public ManagementCompany(ManagementCompany other) {
        this.name = other.name;
        this.taxId = other.taxId;
        this.managementFeePercentage = other.managementFeePercentage;
        this.plot = other.plot;
        this.properties = other.properties;
        this.numberOfProperties = other.numberOfProperties;
    }
    
    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for taxId
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    // Getter and Setter for managementFeePercentage
    public double getManagementFeePercentage() {
        return managementFeePercentage;
    }

    public void setManagementFeePercentage(double managementFeePercentage) {
        this.managementFeePercentage = managementFeePercentage;
    }

    // Getter for MAX_PROPERTY (constant, so no setter)
    public int getMaxProperty() {
        return MAX_PROPERTY;
    }

    // Getter for MGMT_WIDTH (constant, so no setter)
    public int getMgmtWidth() {
        return MGMT_WIDTH;
    }

    // Getter for MGMT_DEPTH (constant, so no setter)
    public int getMgmtDepth() {
        return MGMT_DEPTH;
    }

    // Getter and Setter for properties
    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    // Getter and Setter for plot
    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    // Getter and Setter for numberOfProperties
    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    public void setNumberOfProperties(int numberOfProperties) {
        this.numberOfProperties = numberOfProperties;
    }
    
 // addProperty method with Property object
    public int addProperty(Property property) {
    	// Full properties
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }
        // Null property
        if (property == null) {
            return -2;
        }
        // Company plot does not encompass property
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        // Property overlaps with existing property
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        properties[numberOfProperties] = property;  // Add property
        numberOfProperties++;  // Increment property count
        return numberOfProperties - 1;  // Return index where property was added
    }

    public int addProperty(String name, String city, double rent, String owner) {
        Property newProperty = new Property(name, city, rent, owner);
        return addProperty(newProperty);
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(newProperty);
    }
    
    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                totalRent += properties[i].getRentAmount();
            }
        }
        return totalRent;
    }
    
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0)
        	return null;
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }
    
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;  // Nullify last property
            numberOfProperties--;  // Decrease property count
        }
    }
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }
    
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public boolean isManagementFeeValid() {
        return managementFeePercentage >= 0 && managementFeePercentage <= 100;
    }
    
    @Override
    public String toString() {
        String result = "List of the properties for " + name + ", taxID: " + taxId + "\n";
        result += "______________________________________________________\n";

        // Iterate over properties array and append each property's information
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                result += properties[i].getPropertyName() + "," +
                          properties[i].getCity() + "," +
                          properties[i].getOwner() + "," +
                          properties[i].getRentAmount() + "\n";
            }
        }

        result += "______________________________________________________\n";

        // Calculate and append the total management fee
        double totalManagementFee = getTotalRent() * (managementFeePercentage / 100);
        result += "\n total management Fee: " + String.format("%.2f", totalManagementFee);

        return result;
    }
}