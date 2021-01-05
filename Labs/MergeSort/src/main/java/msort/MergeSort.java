/**
 * Lab 1: Java Basics, Merge Sort and Maven <br />
 * The {@code MergeSort} class
 * @author: Hamzah Abdullahi
 * The MergeSort class provides an implementation for the divide-and-conquer, comparison based
 * Merge Sort algorithm. It returns the sorted array in O(n*log*n) time.
 */
package msort;
public class MergeSort {

    /*
    merge: compares two sub arrays and joins the sorted total
    */
    public static int[] merge(int[] Left, int[] Right, int[] A) {
        int leftSize = Left.length;
        int rightSize = Right.length;

        // left, right and original array current indices (in that order)
        int i = 0;int j = 0;int k = 0;

        // compare elements of each sub array:take smaller or equivalent
        while(i<leftSize && j<rightSize){
            if (Left[i] <= Right[j]){
                A[k] = Left[i];
                i++;
            }
            else{
                A[k] = Right[j];
                j++;
            }
            k++;
        }
       
        // One of two below loops will be executed
        while(i<leftSize){
            A[k] = Left[i];
            i++;
            k++;
            }
        while(j<rightSize){
            A[k] = Right[j];
            j++;
            k++;
        }
        return A;               // return sorted array
    }

    /*
    mergeSort: uses divide and conquer approach to sort array
    into sub arrays. Applies recursion for this effect
    */
    /**
     * The merge sort procedure
     * @param numbers   {@code int[]} The integer array to be sorted
     */
    public static int[] sort(int[] numbers) {
        int arraySize = numbers.length;
        
        //reached end of traversal (1 element remaining)
        if (arraySize < 2){
            return numbers;
        }
        //get midpoint
        int mid = arraySize/2;
        
        // sub arrays
        int[] Left = new int[mid];
        int[] Right = new int[arraySize - mid];

        //Divide
        for (int i = 0;i < arraySize;i++){
            if (i < mid)
                Left[i] = numbers[i];
            else{
                Right[i-mid] = numbers[i];
            }
        }
        // Conquer: recursivly sorts into more sub-arrays, then merges organized form of sub-arrays
        sort(Left);
        sort(Right);
        merge(Left, Right, numbers);

	    return numbers;
    }

    /**
     * Main entry: test the MergeSort
     * @param args      {@code String[]} Command line arguments
     */
    //  public static void main(String[] args) {
    //      int[] numbers = new int[10];
    //      for (int i = 0; i < numbers.length; i++) {
    //          numbers[i] = (int) (Math.random() * 200);
    //          System.out.print(numbers[i] + " ");
    //      }
    //      System.out.println();

    //      numbers = sort(numbers);

    //      for (int n: numbers)
    //          System.out.print(n + " ");
    //      System.out.println();
    //  }

}
