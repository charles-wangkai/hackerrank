import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class cat2 {

    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
         String [] ar =new String[q];
        for(int a0 = 0; a0 < q; a0++){
             int xd=0;
            int yd=0;
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            
            
            if(x<z){
                xd=z-x;
            }
            else{xd=x-z;}
            if(y<z){
                yd=z-y;
            }
            else{yd=y-z;}
            if(xd<yd){
            ar[a0]="Cat A";
                    }
           else if(yd<xd){
            ar[a0]="Cat B";
                    }
           else{
              ar[a0]="Mouse C"; 
           }

        }
        
        for(int i=0;i<ar.length;i++){
            System.out.println(ar[i]);
        }
    }
}

