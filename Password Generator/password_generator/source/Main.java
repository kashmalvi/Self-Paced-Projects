package password_generator.source;
import java.util.*;


public class Main {
    public static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Generator generator = new Generator(keyboard);
        System.out.println("Welcome to Password Services :");
        generator.mainLoop();
        keyboard.close(); 
    }
}