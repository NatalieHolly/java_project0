package Project;

import java.util.List;
import java.util.Scanner;

import Project.Exceptions.MenuExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Project.Model.Height;
import Project.Service.HeightService;

public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        System.out.println("Growth Tracker App");
        System.out.println();
        System.out.println("Type 'add' to enter a new height entry, 'view' to see all the entries, or 'max' to see the current height:");
        HeightService heightService = new HeightService();
        List<Height> heightList = heightService.getAllEntries();

        //create menu
        while(true){

            try {
                System.out.println("add | view | max");  //user enters "add" or "view" from menu
                String input = sc.nextLine().toLowerCase();
                if(!input.equals("add") && !input.equals("view") && !input.equals("max")){
                    throw new MenuExceptions("Entered an invalid menu option.");
                }
                if (input.equals("add")) {  //get entry info then add growth entry to list
                    System.out.println("Enter your child's new height: ");
                    String heightInput = sc.nextLine();
//                    double newHeightInput = Double.parseDouble(heightInput);
                    heightService.addEntry(heightInput);
                    System.out.println("Entry added!");
                } else if (input.equals("view")) {
                    //view list of growth entries
                    List<Height> getHeightList = heightService.getAllEntries();
                    System.out.println(getHeightList.toString());
                } else if (input.equals("max")) {
                    double maxHeight = heightService.maxHeight(heightList);
                    System.out.println("Your child has grown to " + maxHeight + " inches!");
                } else {
                    System.out.println();
                }
            } catch (MenuExceptions exception) {
                System.out.println("You've caused an exception, likely do to an input error.");
                exception.printStackTrace();
            }
        }
    }
}
