import java.util.Scanner;
public class l002{
    public static Scanner scn = new Scanner(System.in);
    public static void pattern1(int row){
        int nst = 1 ;
        for(int r = 1 ; r <= row; r++){
            for(int cst = 1; cst <= r;cst++ ){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
     public static void pattern2(int row){
        int nst = row ;
        for(int r = 1 ; r <= row; r++){
            for(int cst = nst; cst >= r;cst--){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
    public static void pattern3(int row){
        int nst = 1 ;
        int nsp = row - 1;
        for(int r = 1 ; r <= row; r++){
            for(int csp = 1; csp<=nsp;csp++){
                System.out.print("\t");
            }
            for(int cst = 1; cst <= r;cst++ ){
                System.out.print("*\t");
            }
            nst ++;
            nsp --;
            System.out.println();
        }
    }    
     public static void pattern4(int row){
        int nst = row ;
        int nsp = 0;
        for(int r = 1 ; r <= row; r++){
            for(int csp = 1; csp<=nsp;csp++){
                System.out.print("\t");
            }
            for(int cst = nst; cst >= r;cst-- ){
                System.out.print("*\t");
            }
            
            // nst --;
            nsp ++;
            System.out.println();
        }
    }
    public static void pattern7(int row){
        // int nst = row ;
        int nsp = 0;
        for(int r = 1 ; r <= row; r++){
            for(int csp = 1; csp<=nsp;csp++){
                System.out.print("\t");
            }
                System.out.print("*\t");
            // nst --;
            nsp ++;
            System.out.println();
        }
    }
    public static void pattern8(int row) {

        int nsp = row - 1;
        for (int r = 1; r <= row; r++) {
            for (int csp = nsp; csp >= r; csp--) {
                System.out.print("\t");
            }
            System.out.print("*\t");


            System.out.println();
        }
    }

    public static void pattern9(int row){
        for(int i = 1 ; i <= row; i++){
            for(int j = 1; j<=row;j++){
                if(i == j || i + j == row + 1  ) System.out.print("*\t");
                else System.out.print("\t");
            }            
            System.out.println();
        }
    }
     public static void pattern5(int row){
        int nst = 1; 
        int nsp = row / 2;
        for(int r = 1;r <= row; r++){
            for(int csp = 1;csp <= nsp;csp++){
                System.out.print("\t");
            }
    
            for(int cst = 1;cst <= nst;cst++){
                System.out.print("*\t");
            }
    
            if(r <= row / 2){
                nsp--;
                nst+=2;
            }else{
                nsp++;
                nst-=2;
            }
    
            System.out.println();
        }
    }
    public static void pattern6(int row){
        int nsp = 1; 
        int nst = (row + 1) / 2;
        for(int r = 1;r <= row; r++){
            for(int cst = 1;cst <= nst;cst++){
                System.out.print("*\t");
            }
    
            for(int csp = 1;csp <= nsp;csp++){
                System.out.print("\t");
            }
            for(int cst = 1;cst <= nst;cst++){
                System.out.print("*\t");
            }
    
            if(r <= row / 2){
                nst--;
                nsp+=2;
            }else{
                nst++;
                nsp-=2;
            }
    
            System.out.println();
        }
    }
    public static void pattern15(int row){
        int nst = 1; 
        int nsp = row / 2;
        int val = 1 ;
        for(int r = 1;r <= row; r++){
            for(int csp = 1;csp <= nsp;csp++){
                System.out.print("\t");
            }
            
            for(int cst = 1;cst <= nst;cst++){
                System.out.print(val + "\t");
                if(cst<=nst/2) val++;
                else val--;
            }
    
            if(r <= row / 2){
                nsp--;
                nst+=2;
                val = r + 1;
            }else{
                nsp++;
                nst-=2;
                val = row - r;
            }
    
            System.out.println();
        }
    } 
           
    public static void main(String[] args){
        int r = scn.nextInt();
        // pattern1(r);
        // pattern2(r);
        // pattern3(r);
        // pattern4(r);
        // pattern7(r);
        // pattern8(r);
        pattern5(r);
        pattern6(r);

    }
}