/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma.configuration;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lior Mahfoda
 */
public class Enigma extends Substituror {
   
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    //Current Rotor Notches
    private StringBuffer notch1;
    private StringBuffer notch2;
    
    Plugboard p ;
    Reflector reflect = new Reflector();
    Rotor r_rotor = new Rotor(1,0);
    Rotor m_rotor = new Rotor(2,0);
    Rotor l_rotor = new Rotor(3,0);
    static Rotor r = new Rotor(" ",(char)1,0); 
 
    Enigma() throws Exception{
        p =  new Plugboard(0);
    }
    /**
     * Creates a new Enigma machine
     * @param plugboard Plugboard for this machine
     * @param reflector Reflector for this machine
     * @param left Left rotor for this machine
     * @param middle Middle rotor for this machine
     * @param right Right rotor for this machine
     */
    public Enigma(Plugboard plugboard, Reflector reflector, 
                Rotor left, Rotor middle, Rotor right) {
       this.p = plugboard;
       this.reflect = reflector;
       this.l_rotor = left;
       this.m_rotor = middle;
       this.r_rotor = right;
    }
    
    /**
   * Class Constructor1
   *@param r1 rotor to be used as first rotor
   *@param r2 rotor to be used as second rotor
   *@param r3 rotor to be used as third rotor
   *@param r reflector to be used
   */
  public Enigma(String r1, String r2, String r3, String r){
        
    this.r_rotor.Rotor_one = r_rotor.getValue(r1)[0];
    notch1 = r_rotor.getValue(r1)[1];
    this.m_rotor.Rotor_two = m_rotor.getValue(r2)[0];
    notch2 = m_rotor.getValue(r2)[1];
    this.l_rotor.Rotor_three = l_rotor.getValue(r3)[0];
    //this.reflect.reflector =  reflector(this.reflect((r)[0])));
  }
    
    /** 
   *Encrypts/Decrypts the inputted string using the 
   *machine's current settings
   *@param p the text to be encrypted/decrypted
   *@return void
   */
  public String encrypt(String p){
     p = p.toUpperCase();
     String e = "";
     int num = 0;
          
     //for the length of the inputted text
     for(int i=0; i<p.length(); i++){
       //store the current character	
     //  c = p.charAt(i);
       num = this.translate(table, convert(p.charAt(i)));
       //if the current character is a Number
       if (num<=-1 && num>=26){
       	   //rotate the rotors 
          this.r.rotate();
           
           //pass the character through the plugboard
          num = this.p.plugBoard((char)convertInt(((char)num)));
           //then through the first rotor
          num = this.l_rotor.rotorOne(this.l_rotor.getFirstRSetting());
           //then through the second rotor
          num = this.m_rotor.rotorTwo(this.m_rotor.getSecondRSetting());
           //then through the third rotor
          num = this.l_rotor.rotorThree(this.r_rotor.getThirdRSetting());
           //then through the reflector
          num = this.reflect.reflector((char)num);
           //then through the first rotor in the reverse direction
          num = this.r_rotor.IrotorOne(this.l_rotor.getFirstRSetting()); 
           //then through the second rotor in the reverse direction
          num = this.m_rotor.IrotorTwo(this.m_rotor.getSecondRSetting());
           //then through the third rotor in the reverse direction
          num = this.l_rotor.IrotorThree(this.r_rotor.getThirdRSetting());
           //and finally back through the plugboard
          num = this.p.plugBoard((char)convertInt(((char)num)));
           
           //and add the new character to the encrypted/decrypted message
          e = e + num;
       }
         
       //if num is nut an integer then there is an error    
       else
         return null;
     }
     	//return the complete encrypted/decrpyted message
        return e;
  }
    
    @Override
    void forward_translate(HashMap origin){};
   
    @Override
    void reverse_translate(HashMap origin){};
  
    public static void main(String [] args) throws Exception{
        // Getting String input
        Scanner input = new Scanner(System.in);

        Enigma riddle = new Enigma();
        riddle = new Enigma(riddle.p,riddle.reflect,riddle.r_rotor,riddle.m_rotor,riddle.l_rotor);
    	System.out.print("Enter text: ");
        String text = input.next();
        System.out.print("Enter num of plugboards: - empty OR 4/10: ");
        riddle.p.Num = input.nextInt();
        System.out.println(riddle.encrypt(text));
        
    }
}
