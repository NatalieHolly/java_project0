package Project;
import java.util.List;
import java.util.Scanner;

import Project.Exceptions.HeightExceptions;
import Project.Exceptions.MenuExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Project.Model.Height;
import Project.Service.HeightService;

public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws MenuExceptions {

        Scanner sc = new Scanner(System.in);

        System.out.println("Growth Tracker App");
        System.out.println();
        System.out.println("Type 'add' to enter a new height entry, 'view' to see all the entries, or 'max' to see the your child's tallest height:");
        HeightService heightService = new HeightService();
        List<Height> heightList = heightService.getAllEntries();

        //create menu
        while(true){

            try {
                System.out.println("add | view | max");  //user enters "add" or "view" from menu
                String input = sc.nextLine().toLowerCase();
                if(!input.equals("add") && !input.equals("view") && !input.equals("max")){
                    log.warn("Invalid menu option entered: " + input);
                    throw new MenuExceptions("Entered an invalid menu option.");
                }
                if (input.equals("add")) {  //get entry info then add growth entry to list
                    System.out.println("Enter your child's name: ");
                    String childName = sc.nextLine();
                    System.out.println("Enter your child's new height: ");
                    String heightInput = sc.nextLine();
//                    double newHeightInput = Double.parseDouble(heightInput);
                    heightService.addEntry(childName, heightInput);
                    System.out.println("Entry added!");
                } else if (input.equals("view")) {
                    //view list of growth entries
                    List<Height> getHeightList = heightService.getAllEntries();
                    System.out.println(getHeightList.toString());
                } else if (input.equals("max")) {
                    if (heightList.isEmpty()) {
                        System.out.println("Your tracker is currently empty. You can view your child's tallest height once you've made at least one entry.");
                    } else {
                        System.out.println("Which child are you searching for: ");
                        String childSearch = sc.nextLine();
                        double maxHeight = heightService.getMaxHeightByName(childSearch, heightList);
                        System.out.println("Your child has grown to " + maxHeight + " inches!");
                    }
                } else {
                    System.out.println();
                }
            } catch (MenuExceptions exception) {
                System.out.println("You've caused an exception, likely do to an input error.");
                exception.printStackTrace();
            } catch (HeightExceptions exception) {
                System.out.println("You've caused an exception, likely do to an input error.");
                exception.printStackTrace();
//            } catch (ChildNameException exception) {
//                System.out.println("You've caused an exception, likely do to an input error.");
//                exception.printStackTrace();
            }
        }
    }
}
