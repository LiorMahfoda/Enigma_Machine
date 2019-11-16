package enigma.configuration;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Plugboard
 * Models the plugboard of the Enigma Machine
 * @author Lior Mahfoda
 */
public class Plugboard extends Translator{

    //Current Plugboard settings
    public char[] plugBoard = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    int Num = 0;
    Plugboard(int num)throws Exception{
        Num = num;
        switch (Num) {
            case 0:
                return;
            case 4:
                setPlugBoard("RY");
                setPlugBoard("BU");
                setPlugBoard("AS");
                setPlugBoard("FZ");
                break;
            case 10:
                setPlugBoard("SW");
                setPlugBoard("AQ");
                setPlugBoard("NP");
                setPlugBoard("fo");
                setPlugBoard("VY");
                setPlugBoard("UX");
                setPlugBoard("MK");
                setPlugBoard("CL");
                setPlugBoard("HT");
                setPlugBoard("ZK");
                break;
            default:
                throw new Exception("Wrong input!");
        }
    }
   /*
       
    */
       /**
     * Connects two letters on the plugboard
     * Should throw an exception if a equals b or either is already matched
     * @param a one uppercase letter to connect
     * @param b other uppercase letter to connect
     * @throws java.lang.Exception
     */
    public void addPlug(char a, char b) throws Exception{
        if (a==b) return;
        for(int i=0; i<plugBoard.length; i++){
            if(plugBoard[i] == a)
                plugBoard[i] = b;
            else if(plugBoard[i] == b)
                plugBoard[i] = a;
        }
    }
    
    /**
   *Sets the plug board settings
   *@param str plug board settings formatted in pairs, 
   *each pair seperated by a space
   *@return boolean if str entered was in correct format
   *and if the plugboard was set accordingly
   */
  public void setPlugBoard(String str) throws Exception{
    String s;
    StringTokenizer tokenCheck = new StringTokenizer(str, " ");
    
    if (!pbParser(str))
        throw new Exception("Repeated digits");
    
    while(tokenCheck.hasMoreTokens()){
      s = tokenCheck.nextToken();
      if (s.length() != 2)
        throw new Exception("not length of 2 ");
    }
    StringTokenizer token = new StringTokenizer(str, " ");
    System.out.println(token);
    while(token.hasMoreTokens()){
        try {
            s = token.nextToken();
            if(s.length()==2)
                addPlug(s.charAt(0), s.charAt(1));
            else
                throw new Exception("only length of 2 ");;
        } catch (Exception ex) {
            Logger.getLogger(Plugboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
  
    /** 
   *Returns the result of passing c through
   *the plugboard with its current settings
   *@param c the inputted character
   *@return char the result of passing c through
   *the plugboard with its current settings
   */	
   public char plugBoard(char c){
     int i = (int)(c) - 65;
     return plugBoard[i];
   }
   
   /**
   *Parses Plugboard input to check for repeated letters
   *as each letter can only be used once in the plugboard 
   *@param str the inputted plug board settings
   *@return void
   */
  public boolean pbParser(String str){
  	//if no plug board settings were input, then continue
    if(str.length()<=0 || str == null || str == null){
      return true;
    }
    
    //otherwise, check to make sure digits are not repeated
    for(int i=0; i<str.length()-1; i++){
      //if not a letter, continue	
      if(str.charAt(i)>00 || str.charAt(i)<26)
        i++;
      //if the current letter appears in the rest of the string
      else if(str.substring(i+1).indexOf(str.charAt(i)) != -1)
        return false;
    }
    
    //otherwise, return true
    return true;
  }
   
}
        

