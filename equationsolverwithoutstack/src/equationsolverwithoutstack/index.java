/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equationsolverwithoutstack;

/**
 *
 * @author erfan
 */
public class index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String eq="8/4+4/2x2-2";
        String eq_parts [] = disector(eq);
        prin(eq_parts);
        
        
        symbl_based_solve(eq_parts,'/');
        prin(eq_parts);
        eq_parts = null_remover(eq_parts);
        prin(eq_parts);
        
        
        symbl_based_solve(eq_parts,'x');
        prin(eq_parts);
        eq_parts = null_remover(eq_parts);
        prin(eq_parts);
        
        
        symbl_based_solve(eq_parts,'+');
        prin(eq_parts);
        eq_parts = null_remover(eq_parts);
        prin(eq_parts);
        
        
        symbl_based_solve(eq_parts,'-');
        prin(eq_parts);
        eq_parts = null_remover(eq_parts);
        prin(eq_parts);
         //printer
        for(int i =0; i<eq_parts.length;i++){
            System.out.println(eq_parts[0]);
        }
    }
    public static void prin(String[] c){
        for(int i =0; i <c.length;i++){
            System.out.print(c[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static String[] null_remover(String[] the_eq_parts){
        int null_counter=0;
        for(int i =0; i < the_eq_parts.length;i++){
            if(the_eq_parts[i] == null){
                null_counter++;
            }
        }
        String new_eq[] = new String[the_eq_parts.length - null_counter];
        
        int idx_new = 0;
        for(int k =0; k <the_eq_parts.length;k++){
            if(the_eq_parts[k] != null){
                new_eq[idx_new] = the_eq_parts[k];
                idx_new++;
            }
            
        }
        return new_eq;
    }
    public static void symbl_based_solve(String eq_parts[], char symb){
        for(int k =0;k <eq_parts.length;k++){
            if(eq_parts[k]!=null && eq_parts[k].equals(String.valueOf(symb))){
                String partial_equation[] = partial_solver_prep(k,symb, eq_parts);
                String solved = partial_solver(partial_equation);
                eq_parts[k] = solved;
                eq_parts[k+1] = null;
                eq_parts[k-1] = null;
            }
        }
    }
    public static String partial_solver(String partial_eq[]){
        int i1 = Integer.parseInt(partial_eq[0]);
        int i2 = Integer.parseInt(partial_eq[2]);
        int out_put = 0;
        if(partial_eq[1].equals("/")){
            out_put = i1 / i2;
        }else if(partial_eq[1].equals("x")){
            out_put = i1 * i2;
        }else if(partial_eq[1].equals("+")){
            out_put = i1 + i2;
        }else if(partial_eq[1].equals("-")){
            out_put = i1 - i2;
        }
        return String.valueOf(out_put);
    }
    public static String[]  partial_solver_prep(int idx, char symb, String [] main_eq){
        String partial_eq [] = new String [3];
        partial_eq[0] = main_eq[idx-1];
        partial_eq[1]=String.valueOf(symb);
        partial_eq[2] = main_eq[idx+1];
        return partial_eq;
    }
    public static String[] disector(String eq){
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
        return eq_parts;
    }
}
