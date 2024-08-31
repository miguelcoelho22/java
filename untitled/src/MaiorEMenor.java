public class MaiorEMenor {

    static int posicao (int [] array) {
        int maior = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] > array[maior]) {
                maior = i;
            }
        }

        return maior;
    }


    public static void main(String[] args) {
        int[] array = {1, 5, 10};
        System.out.println(posicao(array));
    }
}
