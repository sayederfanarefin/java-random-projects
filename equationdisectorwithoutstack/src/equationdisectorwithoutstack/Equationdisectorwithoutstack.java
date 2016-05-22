/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equationdisectorwithoutstack;

/**
 *
 * @author erfan
 */
public class Equationdisectorwithoutstack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String eq="1+3-34x234/222";
        String temp[] = new String [eq.length()];
        
        int j =0;
        int a = 0;
        while( j <eq.length()){
            StringBuilder sb = new StringBuilder();
            if(eq.charAt(j) == '+' || eq.charAt(j) == '-' || eq.charAt(j) == 'x' || eq.charAt(j) == '/'){
                temp[a] = String.valueOf(eq.charAt(j));
                a++;
                j++;
            }else{
                
                boolean d = true;
                while(d && j <eq.length()){
                    if(eq.charAt(j) == '+' || eq.charAt(j) == '-' || eq.charAt(j) == 'x' || eq.charAt(j) == '/'){
                        d = false;
                    }else{
                        sb.append(eq.charAt(j));
                        j++;
                    }
                }
                temp[a] = sb.toString();
                a++;
            }
            
        }
        int null_counter=0;
        String eq_parts[];// = [];
        for(int i =0; i <temp.length;i++){
            if(temp[i]==null){
                null_counter++;
            }
        }
        eq_parts = new String [temp.length - null_counter];
        for(int jj =0; jj < eq_parts.length;jj++){
            eq_parts[jj] = temp[jj];
        }
        
        for(int i =0; i<eq_parts.length;i++){
            System.out.println(eq_parts[i]);
        }
    }
}
