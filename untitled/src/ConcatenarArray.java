import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConcatenarArray {




    static int [] concatenar(int [] a, int [] b) {
        int tamanho = a.length + b.length;
        int [] c = new int[tamanho];
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            c[contador++] = a[i];

        }
        for (int i = 0; i < b.length; i++) {
            c[contador++] = b[i];
        }

        return c;
    }

    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4};
        int [] b = {1, 5, 8, 10, 22};
        System.out.println(Arrays.toString(concatenar(a, b)));


    }
}
