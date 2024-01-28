/**
 * HeightService Class
 * - This class provides the following services:
 *      addEntry - Add a new height entry to the tracker
 *      maxHeight - Return the max height entry in the list
 *      getAllEntries - Get all entries in the height list
 *
 */
package Project.Service;
import Project.Exceptions.HeightExceptions;
import Project.Model.Height;
import Project.Main;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HeightService {
    List<Height> heightList; //declare new list to track growth entries
    public HeightService(){
        heightList = new ArrayList<>(); //Constructor to create an instance of the class
    }
    //Method to add new growth entry
    public void addEntry(String height) throws HeightExceptions{//get entry input from user & add it to the growthList
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        if (HeightExceptions.isNumber(height)) {
            Main.log.info("Attempting to add a new height entry." + height);
            double newHeightInput = Double.parseDouble(height);
            Height e = new Height(newHeightInput, currentTime); //create new object with current entry info
            heightList.add(e); //add entry info to growth list
        } else {
            Main.log.warn("Invalid height entered: " + height);
            throw new HeightExceptions("Invalid height entered.");

        }

    }

    public double maxHeight(List<Height> heightList){
        //assigns a new variable maxHeight as a MIN_VALUE and a casts it as a double;
        // a constant in the Integer class that represents the minimum or least integer value
        // that can be represented in 32 bits
        double maxHeight = Double.MIN_VALUE;

        //iterates for each entry in the heightList, if larger than the MIN_VALUE, then reassigns it as the maxHeight
        //until the largest entry in the list is assigned, making it the max height.
        for(Height entry : heightList){
            if (entry.getHeight() > maxHeight) {
                maxHeight = entry.getHeight();
            }
        }
        Main.log.info("Attempting to get the max height entry." + maxHeight);
        return maxHeight;
    }

    public List<Height> getAllEntries(){ //Getter to get entries list
        Main.log.info("Getting all height entries: " + heightList);
        return heightList;
    }

}
