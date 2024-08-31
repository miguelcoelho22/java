public class BuscaBinaria {

    private static int buscaBinaria (int [] array, int numero) {
        int inicio = 0;
        int fim = array.length - 1;

        while(inicio <= fim) {

            int media = (inicio + fim) / 2;
            if(array[media] == numero) {
                return numero;
            } else if (array[media] > numero) {
                fim = media - 1;
            }else if (array[media] < numero) {
                 inicio = media + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int [] array = {1, 7, 10, 20, 5};

        System.out.println(buscaBinaria(array, 10));
    }
}

