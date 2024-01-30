/**
 * Height Class
 * This class contains entry definitions and getHeight getter
 */

package Project.Model;

import java.sql.Timestamp;

public class Height {
    //defines what an Entry consists of
    private String childName;
    private double height;
    private Timestamp dateAdded;

    //Constructor to create an instance of an Entry
    public Height(String childName, double height, Timestamp dateAdded){
        this.childName = childName;
        this.height = height;
        this.dateAdded = dateAdded;
    }

    public String getChildName() {
        return childName;
    }

    public Height(String childName, double height){
        this.childName = childName;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Height{" +
                "childName='" + childName + '\'' +
                ", height=" + height +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
