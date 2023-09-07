package com.codingblackfemales;

import java.util.Arrays;
import java.util.HashMap;

public class QuicksortCodes {
    protected void quicksort(HashMap<String, Double> hashMap, int startIndex, int endIndex){
        
    if(startIndex >= endIndex){
        return;
    }

    String pivot = hashMap[endIndex];
    // creates pivot variable and assignes it to the high index position.
    int leftPointer = startIndex;
    // leftpointer is assigned to lowest index.
    int rightPointer = endIndex;
    // right pointer is assinged to highest index 

    while(leftPointer < rightPointer){

        while(hashMap[leftPointer] <= pivot && leftPointer < rightPointer){
            leftPointer++;
        }

        System.out.println(Arrays.toString(hashMap));
        while(hashMap[rightPointer] >= pivot && leftPointer < rightPointer){
            rightPointer--;
        }
            System.out.println("the left pointer is "  + hashMap[leftPointer]);
            System.out.println("the right pointer is " + hashMap[rightPointer]);
            System.out.println("THE PIVOT IS " + pivot);
        System.out.println("in the while loop");
        
        swap(hashMap, leftPointer, rightPointer);
    }

    swap(hashMap, leftPointer, endIndex);
    quicksort(hashMap, startIndex, leftPointer-1);
    quicksort(hashMap, leftPointer+1, endIndex);
   }

   private static void swap(int[] array, int index1, int index2){
    // create a method called swap taking in paramterers of an array, interger called index1, interger called index2.
    int temp = array[index1];
    // create empty temporar variable and assign it to the first index of the array. 
    array[index1] = array[index2];
    // reassigns index 1 of the array to index 2, 
    array[index2] = temp;
    // assigns array 2 to the temporary variable and completing the swap 
   System.out.println("Swap is taking place" +Arrays.toString(array));
}
           

//    close the method 
}
// close the class

    
    

