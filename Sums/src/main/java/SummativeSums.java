/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author skylarsamperi
 */
public class SummativeSums {
    static void print(int[] array) {
        
        for (int i=0; i< array.length-1; i++){
                System.out.print(array[i] + ", ");
                System.out.println(array[array.length-1]+"}");  
        
        }
    } 
    static int addArray(int array[]){
                int sum=0;
                for(int i=0; i<array.length; i++) {
                        sum = sum+array[i];
                }
                
                return sum;
        }
    public static void main (String [] args ){
        int arr1[] = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int arr2[]= {999, -60, -77, 14, 160, 301};
        int arr3[]= {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
                     140, 150, 160, 170, 180, 190, 200, -99};
        
        System.out.println("#1 Array Sum: " + addArray(arr1));
        System.out.println("#2 Array Sum: " + addArray(arr2));
        System.out.println("#3 Array Sum: " + addArray(arr3));
    }
    
}
