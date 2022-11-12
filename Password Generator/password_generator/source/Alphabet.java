package password_generator.source;
// import java.lang.foreign.SymbolLookup;
// generator.source;

public class Alphabet {
    public static final String UPPERCASE_LETTERS="QWERTYUIOPASDFGHJKLZXCVBNM";
    public static final String LOWERCASE_LETTERS="qwertyuiopasdfghjklzxcvbnm";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOL = "~!@#$%^&*()_+-=\\/?";

    private final StringBuilder pool;

    public Alphabet(boolean includeupperCase, boolean includelowerCase, boolean includenumbers, boolean includesym){
        //inititalising the pool 
        pool = new StringBuilder();
        
        //adding the string to pool 
        if(includeupperCase)pool.append(UPPERCASE_LETTERS);
        if(includelowerCase)pool.append(LOWERCASE_LETTERS);
        if(includenumbers)pool.append(NUMBERS);
        if(includesym)pool.append(SYMBOL);
    }

    public String getAlphabeString(){
        return pool.toString();
    }
}
