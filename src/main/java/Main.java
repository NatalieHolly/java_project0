import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Model.Height;
import Service.HeightService;

public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Growth Tracker App");
        System.out.println();
        System.out.println("Type 'add' to enter a new height entry or 'view' to see all the entries:");
        HeightService heightService = new HeightService();

        //create menu
        while(true){
            System.out.println("add | view");  //user enters "add" or "view" from menu
            String input = sc.nextLine();
            if(input.equals("add")){  //get entry info then add growth entry to list
                System.out.println("Enter your child's new height: ");
//                double heightInput = sc.nextDouble();
                String heightInput = sc.nextLine();
                double newHeightInput = Double.parseDouble(heightInput);
                heightService.addEntry(newHeightInput);
                System.out.println("Entry added!");

            } else if(input.equals("view")){
            //view list of growth entries
                List<Height> heightList = heightService.getAllEntries();
                System.out.println(heightList);
            } else {
                System.out.println();
            }
        }
    }
}
