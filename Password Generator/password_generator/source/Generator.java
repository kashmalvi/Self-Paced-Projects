package password_generator.source;
import java.util.*;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;
    
    public Generator(Scanner scanner){
        keyboard = scanner;
    }

    public Generator (boolean includeUpper, boolean includeLower, boolean includeNumber,boolean includeSymbol){
        alphabet = new Alphabet(includeUpper, includeLower, includeNumber, includeSymbol);
    }

    /**********************************************Generatepassword*************************************************/
    public Password Generatepassword(int length){
        final StringBuilder pass = new StringBuilder(""); //to build the string and store it in pass
        final int alphabetLength = alphabet.getAlphabeString().length();//to calculate the length of alphabets
        int max = alphabetLength - 1;
        int min = 0;
        int range = max-min+1;

        for(int i=0; i<length; i++){
            int index = (int)(Math.random() * range)+min;
            pass.append(alphabet.getAlphabeString().charAt(index));
        }
        return new Password(pass.toString());
    }

    /*********************************************USEFUL INFO******************************************************/
    public void printUsefulInfo(){
        System.out.println("Use a minimum password length of 8 or more character if permitted");
        System.out.println("Include lowercase and uppercase alphabet character, number and symbols if permitted");
        System.out.println("Generate password randomly where feasible");
        System.out.println("Avoid using the same password twice, (eg., across multiple account and/or software");
        System.out.println("Avoid character repetition, keyboard patter, dictionary words, letter or number sequences,"+
                            "\n username, relative or pet name, romantic links(current or past)"+
                            "\n biographical information (e.g, Id number, ancestor's name or dates ...");
        System.out.println("Avoid using information that the user's colleagues and/or "+
                            "\n acquintances might know to be associated with the user");
        System.out.println("Do not use password which consist wholly of any simple combination ");
    }

    /*******************************************************CHECK PASSWORD*******************************************************/
    public void checkPassword(){
        String input ;
    
        System.out.println("\nEnter your password:");
        input = keyboard.nextLine();
        input = keyboard.nextLine();
        Password p = new Password(input);
        String strength = p.calculateScore();
        System.out.println(strength);//to check the strength of your password
    }
    
    /*******************************************Print Quitting Message***********************************************************/
    private void printQuitMessage(){
        System.out.println("Closing the program !!BYE BYE!!!");
    }

    private void PasswordrequestError(){
        System.out.println("You have entered something wrong let's go over it again \n");
    }
    
    /***************************************************REQUEST PASSWORD****************************************************/
    private void requestPassword(){
        boolean Includelower = false;
        boolean Includeupper = false;
        boolean Includenumber = false;
        boolean Includesymbol = false;

        boolean correctParams = false;

        System.out.println();
        System.out.println("Hello, welcome to the password Generator : "
                            +" answer the following questions by  (yes or no) \n");

        do{
            String input;
            System.out.println("Do you want lowercase letters \"abcd...\"to be used? ");
            input = keyboard.nextLine(); //this line is not executing 
            input = keyboard.nextLine();
            if(isInclude(input))
                Includelower = true;

            System.out.println("Do you want uppercase letter \"ABCD...\" to be used? ");
            input = keyboard.nextLine();
            if(isInclude(input))
                Includeupper = true;

            System.out.println("Do you want numbers \"1 2 3 4 ....\" to be used? ");
            input = keyboard.nextLine();
            if(isInclude(input))
                Includenumber = true;

            System.out.println("Do you want symbols \"! @ # $ ....\" to be used? ");
            input = keyboard.nextLine();
            if(isInclude(input))
                Includesymbol = true;

            //no pool selected or base case
            if(!Includelower && !Includeupper && !Includenumber && !Includesymbol){
                System.out.println("You have opted 'NO' for all questions above to generate "+
                                    "your password, Please opt 'YES' from any one above to generate password");
                correctParams = true;
            }

            System.out.println("Great! Now enter the length of password");
            int length = keyboard.nextInt();

            final Generator generator = new Generator(Includeupper, Includelower, Includenumber, Includesymbol);
            final Password password = generator.Generatepassword(length); //password is the object of class
            
            System.err.println("Your Generated Password :"+password);//highlighting the statement in red colour
        }while(correctParams);
    }

    private boolean isInclude(String Input){
        if(Input.equalsIgnoreCase("yes")){
            return true;
        }
        else {
            // if(Input.equalsIgnoreCase("no")){
                PasswordrequestError();
            // }
            return false;
        }
    }

    /*******************************************************Main Menu*********************************************************/
    private void printMenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator ");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.println("Choice : ");
    }

    public void mainLoop(){
        printMenu();
        int userOption = -1;

        while(userOption != 4){
            userOption = keyboard.nextInt();

            switch(userOption){
                case 1:
                    requestPassword();
                    printMenu();
                    continue;
                
                case 2:
                    checkPassword();
                    printMenu();
                    continue;
                
                case 3:
                    printUsefulInfo();
                    printMenu();
                    continue;

                case 4:
                    printQuitMessage();
                    continue;

                default:
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                    continue;
            }
        }
    }

    
}
