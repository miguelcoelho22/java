import java.util.Arrays;

public class UniaoDeVetor {

    public static void main(String[] args) {
        int[] arrayA = {1, 7, 9, 10, 4};
        int[] arrayB = {1, 5, 4, 3, 7};
        System.out.println(Arrays.toString(uniaoDeVetor(arrayA, arrayB)));
    }

    private static int[] uniaoDeVetor(int[] arrayA, int[] arrayB) {
        int contador = 0;
        int [] arrayC = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < arrayA.length; i++) {
            arrayC[contador++] = arrayA[i];
        }
        for (int i = 0; i < arrayB.length; i++) {
            if(!existe(arrayC, arrayB[i], contador)){
                arrayC[contador++] = arrayB[i];
            }
        }
        arrayC = Arrays.copyOf(arrayC, contador);
        return arrayC;
    }

    private static boolean existe(int[] arrayC, int arrayB, int contador) {

        for (int i = 0; i < contador; i++) {
            if(arrayC[i] == arrayB){
                return true;
            }
        }
        return false;
    }
}
