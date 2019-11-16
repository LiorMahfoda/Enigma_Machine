package enigma.configuration;
import java.util.*;
/**
 *
 * @author Lior Mahfoda
 */
public abstract class Substituror {
    
    char[] Letter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public char value = Letter[0]; // Letter is A
    int N = Letter.length; // Size = 26
    public HashMap<String,Integer> table = new HashMap<>();
    
    //Static Rotors
    public final static StringBuffer rotorI      = new StringBuffer("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
    public final static StringBuffer rotorII     = new StringBuffer("AJDKSIRUXBLHWTMCQGZNPYFVOE");
    public final static StringBuffer rotorIII    = new StringBuffer("BDFHJLCPRTXVZNYEIWGAKMUSQO");
    public final static StringBuffer rotorIV     = new StringBuffer("ESOVPZJAYQUIRHXLNFTGKDCMWB");
    public final static StringBuffer rotorV      = new StringBuffer("VZBRGITYUPSDNHLXAWMJQOFECK");
  
    //Static Reflectors
    public static final StringBuffer reflectorB  = new StringBuffer("YRUHQSLDPXNGOKMIEBFZCWVJAT");
    public static final StringBuffer reflectorC  = new StringBuffer("FVPJIAOYEDRZXWGCTKUQSBNMHL");
    public static final StringBuffer reflector0  = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    
    //Static "Nocthes"  - when each rotor rotates
    public final static StringBuffer[] notches = {new StringBuffer("Q"),new StringBuffer("E"),new StringBuffer("V"),new StringBuffer("J"),
                                                  new StringBuffer("Z"),new StringBuffer("Z"),new StringBuffer("Z"),new StringBuffer("Z")};
    
    Substituror() {
        this.table.clear();
        this.initializeMap(table);
    }
    
    /*
    **Simple convertion from char to String
    */
    public String convert(char c){
        return String.valueOf(c);
    }
    
    public int convertInt(char c){
        return Integer.parseInt(String.valueOf(c));
    }
    public final void initializeMap(HashMap table){
        String letter = convert(value);
        for(int i = 0; i<N ;i++){
            this.table.put(letter, i);
            value+=1;
            letter = convert(value);    
        }
    }
    
    abstract void forward_translate(HashMap origin);
    abstract void reverse_translate(HashMap origin);
    
    /*
    This func needs to convert a Key string to Integer value
    **
    @param Hashtable, String
    @return Integer
    */
    public int translate(HashMap table,String key){
        if (table.containsKey(key))
            return (int)table.get(key);
        return 0;            
    }
    
}