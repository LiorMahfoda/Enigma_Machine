/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma.configuration;

import java.util.HashMap;

/**
 *
 * @author Lior Mahfoda
 */
public class Rotor extends Substituror{

    public StringBuffer Rotor_one;
    public StringBuffer Rotor_one_T = new StringBuffer(reflector0.toString());
    public StringBuffer Rotor_two;
    public StringBuffer Rotor_two_T = new StringBuffer(reflector0.toString());
    public StringBuffer Rotor_three;
    public StringBuffer Rotor_three_T = new StringBuffer(reflector0.toString());
   
    //Current Rotor Notches
    private StringBuffer notch1;
    private StringBuffer notch2;
    
    private String mapping;
    private char notch;
    private final int ringSetting;
    
    @Override
    void forward_translate(HashMap origin){}
    @Override
    void reverse_translate(HashMap origin){}
    
    /**
   *Sets the intial settings of the rotors.
   *@param s1 initial setting for first rotor
   *@param s2 initial setting for second rotor
   *@param s3 initial setting for third rotor
   *@return void
   */
  public void initialSettings(String s1, String s2, String s3){
    int p;
	//First Rotor
    p = Rotor_one_T.toString().indexOf(s1);
    Rotor_one_T.append(Rotor_one_T.substring(0,p));
    Rotor_one_T.delete(0,p);
    
        //Second Rotor
    p = Rotor_two_T.toString().indexOf(s2);
    Rotor_two_T.append(Rotor_two_T.substring(0,p));
    Rotor_two_T.delete(0,p);
    
    //Third Rotor
    p = Rotor_three_T.toString().indexOf(s3);
    Rotor_three_T.append(Rotor_three_T.substring(0,p));
    Rotor_three_T.delete(0,p);
  }
    
    /**
     * Creates a new rotor with the n-th letter of the alphabet
     * translating into the n-th letter in mapping with a notch that
     * causes the next rotor to advance when this rotor steps from it
     * @param mapping string that maps to and from alphabet
     * @param notch letter at which the next rotor advances
     * @param ringSetting setting to base internal wiring on
     */
    public Rotor(String mapping, char notch, int ringSetting) {
        this.mapping = mapping;
        this.notch = notch;
        this.ringSetting = ringSetting;
    }
    
    /**
     * Creates a new rotor based on one of the actual rotors 
     * used by the German Army and Air Force in World War II.
     * @param type which rotor (1-5) to use
     * @param ringSetting setting to base internal wiring on
     */
    public Rotor(int type, int ringSetting) {
        if (type == 1) {
            mapping = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
            notch = 'Q';
        } else if (type == 2) {
            mapping = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
            notch = 'E';
        } else if (type == 3) {
            mapping = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
            notch = 'V';
        } else if (type == 4) {
            mapping = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
            notch = 'J';
        } else if (type == 5) {
            mapping = "VZBRGITYUPSDNHLXAWMJQOFECK";
            notch = 'Z';
        } else {
            throw new IllegalArgumentException("Invalid rotor type " + type);
        }
        this.ringSetting = ringSetting;
    }
    
/**
   *Returns the value of the specified Rotor.
   *@param v name or number of rotor
   *@return StringBuffer[] correct rotor
   */
  public StringBuffer[] getValue(String v){
    StringBuffer[] result = new StringBuffer[2];
    if (v.equals("RotorI") || v.equals("1")){
    	result[0] = rotorI;
    	result[1] = notches[0];
    	return result;
    	} 
    if (v.equals("RotorII")|| v.equals("2")){
    	result[0] = rotorII;
    	result[1] = notches[1];
    	return result;
    	} 
    if (v.equals("RotorIII")|| v.equals("3")){
    	result[0] = rotorIII;
    	result[1] = notches[2];
    	return result;
    	} 
    if (v.equals("RotorIV")|| v.equals("4")){
    	result[0] = rotorIV;
    	result[1] = notches[3];
    	return result;
    	} 
    if (v.equals("RotorV")|| v.equals("5")){
    	result[0] = rotorV;
    	result[1] = notches[4];
    	return result;
   		 } 
    if (v.equals("ReflectorB")){
    	result[0] = reflectorB;
    	result[1] = new StringBuffer("");
    	return result;
    } 
    if (v.equals("ReflectorC")){
    	result[0] = reflectorC;
    	result[1] = new StringBuffer("");
    	return result;
    } 
    if (v.equals("No Reflector")){
    	result[0] = reflector0;
    	result[1] = new StringBuffer("");
    	return result;
    } 
    return new StringBuffer[]{new StringBuffer("ERROR"), new StringBuffer("")};
  }

  /**
   *Returns the character obtained after passing l through
   *the current first rotor
   *@param l character input
   *@return char obtained after passing l through the current first rotor
   */
  public char rotorOne(char l){
    int position = Rotor_one_T.toString().indexOf(l);
    return Rotor_one.charAt(position);
    
  }

  /**
   *Returns the character obtained after passing l through
   *the current second rotor
   *@param l character input
   *@return char obtained after passing l through the current second rotor
   */
  public char rotorTwo(char l){
    int position = Rotor_two_T.toString().indexOf(l);
    return Rotor_two.charAt(position);
  }

  /**
   *Returns the character obtained after passing l through
   *the current third rotor
   *@param l character input
   *@return char obtained after passing l through the current third rotor
   */
  public char rotorThree(char l){
    int position = Rotor_three_T.toString().indexOf(l);
    return Rotor_three.charAt(position);
  }

  /**
   *Returns the character obtained after passing l through
   *the current first rotor in the reverse direction
   *@param l character input
   *@return char obtained after passing l through the current
   *first rotor in the reverse direction
   */
  public char IrotorOne(char l){
    int position = Rotor_one.toString().indexOf(l);
    return Rotor_one_T.charAt(position);
  }

  /**
   *Returns the character obtained after passing l through
   * the current second rotor in the reverse direction
   *@param l character input
   *@return char obtained after passing l through the current
   *second rotor in the reverse direction
   */
  public char IrotorTwo(char l){
    int position = Rotor_two.toString().indexOf(l);
    return Rotor_two_T.charAt(position);
  }

  /**
   *Returns the character obtained after passing l through
   *the current third rotor in the reverse direction
   *@param l character input
   *@return char obtained after passing l through the current
   *third rotor in the reverse direction
   */
  public char IrotorThree(char l){
    int position = Rotor_three.toString().indexOf(l);
    return Rotor_three_T.charAt(position);
  }

   /** 
   *Returns the current setting of the first rotor.
   *@param void
   *@return char that is the current setting of the first rotor
   */
   public char getFirstRSetting(){
     return Rotor_one_T.charAt(0);
   }

  /** 
   *Returns the current setting of the second rotor.
   *@param void
   *@return char that is the current setting of the second rotor
   */
   public char getSecondRSetting(){
     return Rotor_two_T.charAt(0);
   }

  /** 
   *Returns the current setting of the third rotor.
   *@param void
   *@return char that is the current setting of the third rotor
   */
   public char getThirdRSetting(){
     return Rotor_three_T.charAt(0);
   }
   
       /**
   * Rotates the rotors according to their current settings
   *@param void
   *@return void
   */
    public void rotate(){
        String currentR1 = Rotor_one_T.charAt(0)+"";
        String currentR2 = Rotor_two_T.charAt(0)+"";
   
   	//Rotate first rotor
        Rotor_one_T.append(Rotor_one_T.charAt(0));
        Rotor_one_T.delete(0, 1);

        //if first rotor is at notch
        if (currentR1.equals(notch1.toString())){
    	//then also rotate second rotor
            Rotor_two_T.append(Rotor_two_T.charAt(0));
            Rotor_two_T.delete(0, 1);
     	
     	//if second rotor is at notch
            if(currentR2.equals(notch2.toString())){
               //then also rotate the third rotor
                Rotor_three_T.append(Rotor_three_T.charAt(0));
                Rotor_three_T.delete(0, 1);
     	}
     }
   }
}
