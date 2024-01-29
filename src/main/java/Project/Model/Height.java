/**
 * Height Class
 * This class contains entry definitions and getHeight getter
 */

package Project.Model;

import java.sql.Timestamp;

public class Height {
    //defines what an Entry consists of
    private double height;
    private Timestamp dateAdded;

    //Constructor to create an instance of an Entry
    public Height(double height, Timestamp dateAdded){
        this.height = height;
        this.dateAdded = dateAdded;
    }

    public Height(double height){
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "height=" + height +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
