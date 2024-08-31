import java.util.Arrays;
import java.util.Scanner;

public class MediaArray {
    private static Scanner scanner = new Scanner(System.in);
    public static int [] numerosDaArray (int [] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("digite o numero");
            int numero  = scanner.nextInt();
            array[i] = numero;
        }
        return array;
    }

    public static int mediaArray(int[] array, int n) {
        int soma = 0;
        int contador = 0;
        for (int i = 0; i < n; i++) {
            soma += array[i];
        }

        float media = (float) soma / n;

        for (int i = 0; i < n; i++) {
            if (array[i] > media) {
                contador++;
            }
        }

        return contador;
    }


    public static void main(String[] args) {

        int [] array = new int[100];
        System.out.println("digite a quantidade de elementos que voce quer na array");
        int n = scanner.nextInt();
        int [] arrayPronta = numerosDaArray(array, n);
        int media = mediaArray(arrayPronta, n);
        System.out.println("quantidade de elementos maior que a media " + media);
    }
}
