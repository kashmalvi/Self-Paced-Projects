package password_generator.source;
public class Password {
    String Value;
    int Length;

    //constructor
    public Password(String s){
        this.Value = s;
        this.Length = s.length();
    }

    //here is check password function which check the strength of password
    public int CharType(char c){ 
        int val;
        
        //Char is Uppercase Letter
        if((int)c >= 65 && (int)c <= 90)
            val = 1;

        //char is Lowercase Letter
        else if((int)c >= 97 && (int)c <= 122)
            val = 2;
        
        //char is digit
        else if((int)c >= 48 && (int)c <= 57)
            val = 3;
        
        //char is symbol
        else 
            val = 4;
        
        return val;
    }

    //function to check the strength of password
    public int passwordStrength(){
        String s = this.Value;
        int score = 0;
        int type;

        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNumber = false;
        boolean UsedSymbol = false;

        for(int i=0; i < this.Length ; i++){
            char ch = s.charAt(i);
            type = CharType(ch);

            if(type == 1) UsedUpper = true;
            if(type == 2) UsedLower = true;
            if(type == 3) UsedNumber = true;
            if(type == 4) UsedSymbol = true;
        }

        if(UsedUpper) score += 1;
        if(UsedLower) score += 1;
        if(UsedNumber) score += 1;
        if(UsedSymbol) score += 1;

        if(s.length() >= 8) score += 1;
        if(s.length() >= 16) score += 1;

        return score;
    }

    //function to check calculate score of password
    public String calculateScore(){
        int score = this.passwordStrength();

        if(score >= 6)
            return "This is a Strong password ";
        else if(score >= 4)
            return "This is good password";
        else if(score >= 3)
            return "This is medium password";
        else if(score >= 2)
            return "This is weak password";
        else
            return "1 char password";
    }

    public String toString(){
        return this.Value;
    }
}
