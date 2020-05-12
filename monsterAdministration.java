package administation;

import java.util.Random;
import java.util.Scanner;

public class monsterAdministration {
    public static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("How big is your array?");
        int arraySize = scan.nextInt();

        result(inputArray(arraySize),arraySize);
    }

    public static int[] inputArray(int arraySize) {

        int array[] = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.println("Input number for your array.");
            int number = scan.nextInt();
            array[i] = number;
        }

        return array;
    }

    public static int[] ascending(int[] array, int arraySize) {
        int element = 0;

        for (int i = 0; i < arraySize; i++) {
            for (int j = arraySize-1; j >= i; j--) {
                if (array[i] > array[j]) {
                    element = array[i];
                    array[i] = array[j];
                    array[j] = element;
                }
            }
        }

        return array;
    }

    public static int[] descending (int[] array, int arraySize) {
        int element = 0;

        for (int i = 0; i < arraySize; i++) {
            for (int j = i+1; j < arraySize; j++) {
                if (array[i] < array[j]) {
                    element = array[i];
                    array[i] = array[j];
                    array[j] = element;
                }
            }
        }

        return array;
    }

    public static void indexID (int[] array, int arraySize) {
        System.out.println("What number are you looking for?");
        int number = scan.nextInt();
        int count = 0;

        for (int i = 0; i < arraySize; i++) {
            if (array[i] == number) {

                System.out.println("Number " + number + " was found on ID " + count);
                break;
            }
            count++;
        }

        if (count >= arraySize) {
            System.out.println("Number " + number + " was not found");

        }
    }

    public static int[] shuffleArray(int[] array, int arraySize) {
        Random numb = new Random();

        int low = 0;
        int high = arraySize;
        int random = numb.nextInt(high - low) + low;
        int temp = 0;

        for (int i = 0; i < arraySize; i++) {

            temp = array[i];
            array[i] = array[random];
            array[random] = temp;
        }

        return array;
    }

    public static void sumArray(int[] array, int arraySize) {

        int sum = 0;
        for(int i = 0; i < arraySize; i++) {
            sum+= array[i];
        }
        System.out.println(sum);
    }

    public static void biggestNumberInArray (int[] array, int arraySize) {
        int max = array[0];
        for(int i = 1; i < arraySize; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println(max);
    }

    public static void smallestNumberInArray (int[] array, int arraySize) {
        int min = array[0];
        for(int i = 1; i < arraySize; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println(min);
    }

    public static void averageSumInArray (int[] array, int arraySize) {
        double average = 0;
        for(int i = 0; i < arraySize; i++) {
            average += array[i];
        }
        System.out.println(average / arraySize);
    }

    public static void isArraySymmetrical(int[] array, int arraySize){
        boolean symmetrical = false;

        for(int i = 0; i < arraySize / 2; i++) {
            if (array[i] == array[arraySize - 1 - i]) {
                symmetrical = true;
            } else {
                symmetrical = false;
                break;
            }
        }
        if(symmetrical) {
            System.out.println("Array is symmetrical");
        } else {
            System.out.println("Array is not symmetrical");
        }
    }

    public static int[] reverseArray (int[] array, int arraySize) {
        int temp = 0;
        for (int i = 0; i < arraySize / 2; i++) {
            temp = array[i];
            array[i] = array[arraySize - 1 - i];
            array[arraySize - 1 - i] = temp;
        }
        return array;
    }

    public static void arrayPrint(int array[]) {
        for (int element : array) {
            System.out.println(element + " ");
        }
    }

    public static void goBackOrExit(int[] array,int arraySize) {
        System.out.println("1.Go back to menu");
        System.out.println("2.Leave");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                result(array, arraySize);
                    break;
            case 2:
                System.exit(1);
                break;

        }
    }

    public static void result(int[] array, int arraySize) {
        System.out.println("Choose option");
        System.out.println("1.Make array numbers ascending");
        System.out.println("2.Make array numbers descending");
        System.out.println("3.Find number in the array");
        System.out.println("4.Shuffle the array numbers");
        System.out.println("5.Sum all numbers in the array");
        System.out.println("6.Find biggest number in the array");
        System.out.println("7.Find smallest number in the array");
        System.out.println("8.Find the average sum in the array");
        System.out.println("9.Find if array is symmetrical");
        System.out.println("10.Reverse the numbers in the array");
        System.out.println("11.Print all of the numbers in the array");
        System.out.println("12.Exit our program");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                ascending(array ,arraySize);
                arrayPrint(array);
                break;
            case 2:
                descending(array ,arraySize);
                arrayPrint(array);
                break;
            case 3:
                indexID(array ,arraySize);
                break;
            case 4:
                shuffleArray(array ,arraySize);
                arrayPrint(array);
                break;
            case 5:
                sumArray(array ,arraySize);
                break;
            case 6:
                biggestNumberInArray(array, arraySize);
                break;
            case 7:
                smallestNumberInArray(array, arraySize);
                break;
            case 8:
                averageSumInArray(array, arraySize);
                break;
            case 9:
                isArraySymmetrical(array, arraySize);
                break;
            case 10:
                reverseArray(array, arraySize);
                arrayPrint(array);
                    break;
            case 11:
                arrayPrint(array);
                break;
            case 12:
                System.out.println("Thanks for using our program");
                System.exit(1);
                break;
        }

        goBackOrExit(array, arraySize);
    }
}
