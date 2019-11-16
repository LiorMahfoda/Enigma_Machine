package enigma.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Lior Mahfoda 
 */

public class Translator extends Substituror {
    HashMap<Integer, Integer> forward = new HashMap<>();
    HashMap<Integer, Integer> reverse = new HashMap<>();
    
    List<Integer> list = new ArrayList<>(table.values());
    ListIterator<Integer> iter = list.listIterator();
   // int index;
    String forwardKey, ReverseKey;
    Translator(){   
        forward.clear();
        forwardKey = "A";
        ReverseKey = "Z";
        mapping(list);
    }
    
    final void mapping(List lst){
        for (int i =0; i<N;i++)
            list.add(table.get(i));
    }
    
    @Override
    void forward_translate(HashMap origin) {
        int index = 0; 
        char c = ' ';  
        while(iter.hasNext()){
            c = forwardKey.charAt(0);
            forward.put(index, table.get(forwardKey));
         //   System.out.println("key = "+forwardKey);
            index+=1;
            c+=1;  //Next letter
            forwardKey = convert(c); // Uses method from Substitutior Class 
            if (index==26) // To prevent
                break;
        }    
    }
    
    @Override
    void reverse_translate(HashMap origin) {
        int index = 25; 
        char c = ' ';  
        ListIterator<Integer> it = list.listIterator();
        
        while(it.hasNext())
            it.next();
        
        while(it.hasPrevious()){
            c = this.ReverseKey.charAt(0);
            reverse.put(index, table.get(this.ReverseKey));
           // System.out.println("key = "+this.ReverseKey);
            index-=1;
            c-=1;  //Previous letter
            this.ReverseKey = convert(c); // Uses method from Substitutior Class 
            if (index==-1) // To prevent Exception 
                break;
        }
    }
}