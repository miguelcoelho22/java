import java.util.Arrays;

public class MultiplicarPeloMaior {


    static int[] maiorElemento (int [] array) {
        int maior = Integer.MIN_VALUE;
       ;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > maior) {
                maior = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = maior * array[i];
        }
        return array;
    }


    public static void main(String[] args) {
        int [] array = {1, 2, 4, 5, 10};
        System.out.println(Arrays.toString(maiorElemento(array)));
    }
}
