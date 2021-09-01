/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evennumbers;

/**
 *
 * @author A. Mjeks
 */
public class EvenNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = {5, 8, 9, 10, 7, 3, 9, 6};
        System.out.println("Sum of Array Even Numbers is: " + sumOfEvenNumbers(numbers));
    }
    
    public static int sumOfEvenNumbers(int[] numbers){
        int sum = 0;
        //looping through numbers array elements and placing each on evenNumber integer 
        for(int evenNumber: numbers){
            //determining if current number is an even number using modulus operator to find a remainder
            //if there is a remainder the code will not add the current array number
            if(evenNumber%2 == 0){
                sum += evenNumber;
            }
        }
        return sum;
    }
}
