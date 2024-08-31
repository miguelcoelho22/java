import java.util.Arrays;

public class InverterArray {


    static int[] inverterArray (int [] array) {
        int ultimo = array.length - 1;
        int primeiro = 0;
        while(primeiro < ultimo) {
            int temp = array[primeiro];
            array[primeiro] = array[ultimo];
            array[ultimo] = temp;

            primeiro++; ultimo--;


        }
        return array;
    }



    public static void main(String[] args) {
        int [] array = {1, 4, 3, 7, 6, 4};
        System.out.println(Arrays.toString(inverterArray(array)));

    }


}
