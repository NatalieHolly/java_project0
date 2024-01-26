package Service;
import Model.Height;
import com.sun.tools.javac.Main;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HeightService {
    List<Height> heightList; //declare new list to track growth entries
    public HeightService(){
        heightList = new ArrayList<>(); //Constructor to create an instance of the class
    }
    //Method to add new growth entry
    public void addEntry(double height){//get entry input from user & add it to the growthList
//        Main.log.info("Attempting to add a new height entry." + height);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        Height e = new Height(height, currentTime); //create new object with current entry info
        heightList.add(e); //add entry info to growth list
    }

    public List<Height> getAllEntries(){ //Getter to get entries list
        return heightList;
    }

}
