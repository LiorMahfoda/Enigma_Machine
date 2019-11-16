package enigma.configuration;

/**
 * A Translator with a simple permutation
 * @author Lior Mahfoda
 */
public class Reflector extends Translator{
  
    Reflector(){
        reverse.clear();
        this.reflector = B;
    }
   
    // The three most common reflectors used in the M3 machine
    public static final StringBuffer A = new StringBuffer("EJMZALYXVBWFCRQUONTSPIKHGD");
    public static final StringBuffer B = new StringBuffer("YRUHQSLDPXNGOKMIEBFZCWVJAT");
    public static final StringBuffer C = new StringBuffer("FVPJIAOYEDRZXWGCTKUQSBNMHL");
    
    public StringBuffer reflector;
     
    /**
   *Returns the character obtained after passing l through
   *the current reflector
   *@param l character input
   *@return char obtained after passing l through the current reflector
   */
  public char reflector(char l){
    int position = (int)l - 65;
    l = reflector.charAt(position);
    return l;
  }
    
}

