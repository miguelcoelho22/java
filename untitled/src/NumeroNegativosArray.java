import java.sql.Array;

public class NumeroNegativosArray {


    private static int numerosNegativosArray(int[] array) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            int numero = array[i];
            if(numero < 0){
                contador++;
            }
        }
        return contador;
    }


    public static void main(String[] args) {
        int[] array = {1, -2, 4, -6, 2};

        System.out.println("a quantidade de elementos negativos é" + numerosNegativosArray(array));
    }
}
