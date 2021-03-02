/*
    Aufgabe 3) Rekursion mit eindimensionalen Arrays
*/
import java.util.Arrays;

public class Aufgabe3 {

    private static int getMaxPairSum(int[] workArray, int start, int end) { //start- prüft ab einem Index
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
       assert workArray != null && start <= end && start>=0 && end<workArray.length;


        if(start<end){
            return Math.max(workArray[start]+workArray[start+1],getMaxPairSum(workArray,start+1,end));
        }else {
            return 0;
        }
    }

    private static int countValuesWithSmallerNeighbors(int[] workArray, int index) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        assert workArray!= null && workArray.length>2 && index>0;
        if(index>=workArray.length){
            return 0;
        }else{
            if (workArray[index]>workArray[index-1] && workArray[index]>workArray[index+1]){
               return countValuesWithSmallerNeighbors(workArray,index+1) + 1;
           }
           else {
               return countValuesWithSmallerNeighbors(workArray,index+1);
           }
       }
    }


    private static int[] getArrayWithNegativeValues(int[] workArray, int index) {
        assert workArray!=null && workArray.length>0 && index>=0 && index<workArray.length;
        int[] clonedArray = workArray.clone(); //wir rechnen mit clonedArray, so bleibt workArray unverändert
        if (index<clonedArray.length-1){
            if (clonedArray[index]>0){
                clonedArray[index]=0;
                return getArrayWithNegativeValues(clonedArray,index+1);
            }
            else {
                return getArrayWithNegativeValues(clonedArray,index+1);
            }

        }else {
            return clonedArray;
        }

    }

    private static boolean containsValue(int[] workArray, int value) {


        if (workArray.length>0){

            if (workArray[workArray.length-1]==value){ //prüft immer die Hälfte

                return containsValue(Arrays.copyOfRange(workArray,0,(workArray.length-1)/2),value)|| containsValue(Arrays.copyOfRange(workArray,((workArray.length-1)/2),workArray.length-1),value)||true;

            }
            else {
                return containsValue(Arrays.copyOfRange(workArray,0,(workArray.length-1)/2),value)|| containsValue(Arrays.copyOfRange(workArray,((workArray.length-1)/2),workArray.length-1),value);

            }

        }
        else {
            return false;
        }

    }
    
    public static void main(String[] args) {
        int[] array1 = {3, 1, 7, 9, 4, 10, 5, 3};
        System.out.println(getMaxPairSum(array1, 0, array1.length - 1));
        System.out.println(getMaxPairSum(array1, 4, array1.length - 1));
        System.out.println(getMaxPairSum(array1, 1, 3));
        System.out.println(getMaxPairSum(array1, 0, 2));
        System.out.println(getMaxPairSum(array1, 0, 1));
        System.out.println();

        int[] array2 = {3, 9, 7, 19, 8, 10, 6, 3, 11, 5};
        System.out.println(countValuesWithSmallerNeighbors(array2, 1));
        System.out.println(countValuesWithSmallerNeighbors(array2, 4));
        System.out.println(countValuesWithSmallerNeighbors(array2, 6));
        System.out.println(countValuesWithSmallerNeighbors(array2, 8));
        System.out.println();

        int[] array3 = {5, -3, 7, -15, 20, -5, 0, 14, 3, -2, -8};
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 0)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 10)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 8)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 4)));
        System.out.println();

        int[] array4 = {2, 4, 7, 10, 11, -10, 4, 0, 0, 27, 11, 4, 6};

        System.out.println(containsValue(array4, 11));
        System.out.println(containsValue(array4, 2));
        System.out.println(containsValue(array4, 25));
        System.out.println(containsValue(array4, 0));
        System.out.println(containsValue(array4, 14));
        System.out.println(containsValue(array4, 6));


        assert(getMaxPairSum(array1, 0, array1.length - 1) == 16);
        assert(getMaxPairSum(array1, 4, array1.length - 1) == 15);
        assert(getMaxPairSum(array1, 1, 3) == 16);
        assert(getMaxPairSum(array1, 0, 2) == 8);
        assert(getMaxPairSum(array1, 0, 1) == 4);

        assert(countValuesWithSmallerNeighbors(array2, 1) == 4);
        assert(countValuesWithSmallerNeighbors(array2, 4) == 2);
        assert(countValuesWithSmallerNeighbors(array2, 6) == 1);
        assert(countValuesWithSmallerNeighbors(array2, 8) == 1);

        assert (Arrays.equals(getArrayWithNegativeValues(array3, 0), new int[]{0, -3, 0, -15, 0, -5, 0, 0, 0, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 10), new int[]{5, -3, 7, -15, 20, -5, 0, 14, 3, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 8), new int[]{5, -3, 7, -15, 20, -5, 0, 14, 0, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 4), new int[]{5, -3, 7, -15, 0, -5, 0, 0, 0, -2, -8}) == true);

        assert (containsValue(array4, 11) == true);
        assert (containsValue(array4, 2) == true);
        assert (containsValue(array4, 25) == false);
        assert (containsValue(array4, 0) == true);
        assert (containsValue(array4, 14) == false);
        assert (containsValue(array4, 6) == true);
  }
}


