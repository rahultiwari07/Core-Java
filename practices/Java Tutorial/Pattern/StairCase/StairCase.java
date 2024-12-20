package StairCase;

public class StairCase{

    public static void main(String arg[]){

        int n = 6 ;

        for(int i =n ;i>0;i--){
            for(int j = 0;j<n;j++){
                if(i==j){
                    System.out.print("#");
                }else if(j>i){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
              
    }
}