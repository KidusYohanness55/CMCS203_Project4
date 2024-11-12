package application;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class provides properties to be used in the ManagementCompany class
 * Due: 11/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public class Property {
    private String property;
    private String city;
    private double rent;
    private String owner;
    private Plot plot;

    public Property() {
        city = "";
        owner = "";
        property = "";
        rent = 0;
        plot = new Plot();
    }

    public Property(Property other) {
        this.city = other.city;
        this.owner = other.owner;
        this.property = other.property;
        this.rent = other.rent;
        this.plot = other.plot;
    }

    public Property(String property, String city, double rent, String owner) {
        this.city = city;
        this.owner = owner;
        this.property = property;
        this.rent = rent;
        this.plot = new Plot();
    }

    public Property(String property, String city, double rent, String owner, int x, int y, int width, int depth) {
        this.city = city;
        this.owner = owner;
        this.property = property;
        this.rent = rent;
        this.plot = new Plot(x, y, width, depth);
    }

    public String getCity() {
        return city;
    }

    public String getOwner() {
        return owner;
    }

    public String getPropertyName() {
        return property;
    }

    public double getRentAmount() {
        return rent;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPropertyName(String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return property + ","
                + city + ","
                + owner + ","
                + rent;
    }

    public Plot getPlot() {
        return this.plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }
}