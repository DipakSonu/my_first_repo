import java.util.*;
class KingWar {
   
    public static void main(String[] args) {
        
        //long[] arr={1,1,8,8,9};
        long[] arr={1,5};

        System.out.println("\n\t Response : "+soldierRequired(arr, arr.length));

    }

    public static long soldierRequired(long arr[], long n){
         // Your code goes here 
         Arrays.sort(arr);
         int bigB=Integer.MIN_VALUE;
         int tinyB=Integer.MAX_VALUE;
         int count=0;

         for(int i=0; i<n; i++){
            if(bigB<arr[i]){
                bigB=(int)arr[i];
            }
            if(tinyB>arr[i]){
                tinyB=(int)arr[i];
            }
         }
        
         for(int j=0; j<n; j++){

            if(bigB!=arr[j] && tinyB!=arr[j]){
              count++;
            }
         }
         return count;
    }
}