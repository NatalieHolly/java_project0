package Project.Exceptions;

public class HeightExceptions extends NumberFormatException{
    public HeightExceptions(String message){
        super(message);
    }

    public static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
